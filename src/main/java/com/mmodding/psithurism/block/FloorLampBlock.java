package com.mmodding.psithurism.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

import java.util.Map;

public class FloorLampBlock extends Block {

	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
	public static final BooleanProperty LIT = BlockStateProperties.LIT;

	private static final Map<DoubleBlockHalf, VoxelShape> SHAPES = Map.of(
		DoubleBlockHalf.UPPER, Shapes.or(
			Block.column(12.0, 13.0, 16.0),
			Block.column(10.0, 0.0, 13.0)
		),
		DoubleBlockHalf.LOWER, Shapes.or(
			Block.column(10.0, 7.0, 16.0),
			Block.column(12.0, 4.0, 7.0),
			Shapes.or(
				Block.box(3.0, 0.0, 3.0, 6.0, 4.0, 6.0),
				Block.box(3.0, 0.0, 10.0, 6.0, 4.0, 13.0),
				Block.box(10.0, 0.0, 3.0, 13.0, 4.0, 6.0),
				Block.box(10.0, 0.0, 10.0, 13.0, 4.0, 13.0)
			)
		)
	);

	public FloorLampBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER).setValue(LIT, false));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(HALF);
		builder.add(LIT);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPES.get(state.getValue(HALF));
	}

	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
		if (!level.isClientSide()) {
			player.playSound(SoundEvents.LEVER_CLICK);
			BlockPos origin = state.getValue(HALF) == DoubleBlockHalf.LOWER ? pos : pos.below();
			BlockState lowerState = level.getBlockState(origin);
			BlockState upperState = level.getBlockState(origin.above());
			level.setBlock(origin, lowerState.setValue(BlockStateProperties.LIT, !lowerState.getValue(BlockStateProperties.LIT)), 3);
			level.setBlock(origin.above(), upperState.setValue(BlockStateProperties.LIT, !upperState.getValue(BlockStateProperties.LIT)), 3);
		}
		return InteractionResult.SUCCESS;
	}

	public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity by, ItemStack itemStack) {
		level.setBlockAndUpdate(pos.above(), state.setValue(HALF, DoubleBlockHalf.UPPER));
	}

	public @Nullable BlockState getStateForPlacement(final BlockPlaceContext context) {
		BlockPos pos = context.getClickedPos();
		Level level = context.getLevel();
		return pos.getY() < level.getMaxY() && level.getBlockState(pos.above()).canBeReplaced(context) ? super.getStateForPlacement(context) : null;
	}

	// behavior from door block
	@Override
	public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
		if (!level.isClientSide() && (player.preventsBlockDrops() || !player.hasCorrectToolForDrops(state))) {
			DoubleBlockHalf part = state.getValue(HALF);
			if (part == DoubleBlockHalf.UPPER) {
				BlockPos bottomPos = pos.below();
				BlockState bottomState = level.getBlockState(bottomPos);
				if (bottomState.is(state.getBlock()) && bottomState.getValue(HALF) == DoubleBlockHalf.LOWER) {
					BlockState blockState = bottomState.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
					level.setBlock(bottomPos, blockState, 35);
					level.levelEvent(player, 2001, bottomPos, Block.getId(bottomState));
				}
			}
		}
		return super.playerWillDestroy(level, pos, state, player);
	}

	protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
		DoubleBlockHalf half = state.getValue(HALF);
		if (directionToNeighbour.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (directionToNeighbour == Direction.UP)) {
			return neighbourState.getBlock() instanceof FloorLampBlock && neighbourState.getValue(HALF) != half ? neighbourState.setValue(HALF, half) : Blocks.AIR.defaultBlockState();
		}
		else {
			return half == DoubleBlockHalf.LOWER && directionToNeighbour == Direction.DOWN && !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
		}
	}

	public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		BlockPos below = pos.below();
		BlockState belowState = level.getBlockState(below);
		return state.getValue(HALF) == DoubleBlockHalf.LOWER ? belowState.isFaceSturdy(level, below, Direction.UP) : belowState.is(this);
	}
}
