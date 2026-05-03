package com.mmodding.psithurism.block;

import com.mmodding.library.block.api.catalog.LootingPropertiesEntityBlock;
import com.mmodding.psithurism.block.entity.TeruTeruBozuBlockEntity;
import com.mmodding.psithurism.init.PsithurismBlockEntityTypes;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

public class TeruTeruBozuBlock extends LootingPropertiesEntityBlock {

	public static final IntegerProperty NECKLACE = IntegerProperty.create("necklace", 0, 4);
	public static final Property<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE = Block.column(14.0, 0.0, 16.0);

	public static final MapCodec<TeruTeruBozuBlock> CODEC = simpleCodec(TeruTeruBozuBlock::new);

	public TeruTeruBozuBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(NECKLACE, 4));
	}

	@Override
	protected MapCodec<? extends BaseEntityBlock> codec() {
		return CODEC;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(NECKLACE);
		builder.add(FACING);
	}

	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
		if (level.isClientSide()) {
			return InteractionResult.SUCCESS_SERVER;
		}
		else {
			if (level.getBlockEntity(pos) instanceof TeruTeruBozuBlockEntity blockEntity) {
				if (level.getServer() != null && level.isRaining()) {
					if (blockEntity.canConsumeLevel()) {
						blockEntity.consumeLevel(level, pos, state);
						level.getServer().setWeatherParameters(ServerLevel.RAIN_DELAY.sample(level.getRandom()), 0, false, false);
					}
					else {
						player.sendOverlayMessage(Component.translatable("block.psithurism.teru_teru_bozu.insufficient_will_power"));
					}
				}
				else {
					player.sendOverlayMessage(Component.translatable("block.psithurism.teru_teru_bozu.nothing_to_do"));
				}
				return InteractionResult.SUCCESS_SERVER;
			}
			else {
				return InteractionResult.CONSUME;
			}
		}
	}

	@Override
	public @Nullable BlockEntity newBlockEntity(BlockPos worldPosition, BlockState blockState) {
		return new TeruTeruBozuBlockEntity(worldPosition, blockState);
	}

	@Override
	public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> type) {
		return createTickerHelper(type, PsithurismBlockEntityTypes.TERU_TERU_BOZU, TeruTeruBozuBlockEntity::tick);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext ctx) {
		return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
	}

	@Override
	protected BlockState rotate(final BlockState state, final Rotation rotation) {
		return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
	}

	@Override
	protected BlockState mirror(final BlockState state, final Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(FACING)));
	}
}
