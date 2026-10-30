package com.mmodding.psithurism.block;

import com.mmodding.library.java.api.container.Unit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

public class LargeTatamiMatBlock extends LargeTatamiBlock {

	private static final VoxelShape SHAPE = Block.column(16.0, 0.0, 1.0);

	public LargeTatamiMatBlock(Properties settings) {
		super(settings);
	}

	@Override
	protected VoxelShape getShape(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
		return SHAPE;
	}

	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState candidate = super.getStateForPlacement(context);
		return candidate != null && this.canSurvive(candidate, context.getLevel(), context.getClickedPos()) ? candidate : null;
	}

	@Override
	protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
		return this.canSurvive(state, level, pos) ? super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random) : Blocks.AIR.defaultBlockState();
	}

	@Override
	public boolean canSurvive(BlockState blockState, LevelReader level, BlockPos blockPos) {
		Unit.Mutable<Boolean> doesNotFloatEvenIfDefyingPhysics = Unit.mutable(false);
		this.forEach(level, blockPos, blockState, (pos, state, _) -> {
			doesNotFloatEvenIfDefyingPhysics.mutateValue(doesNotFloatEvenIfDefyingPhysics.value() || !level.isEmptyBlock(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())));
		});
		return doesNotFloatEvenIfDefyingPhysics.value();
	}
}
