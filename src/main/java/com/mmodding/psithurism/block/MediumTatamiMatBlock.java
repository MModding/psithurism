package com.mmodding.psithurism.block;

import com.mmodding.library.java.api.container.Unit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MediumTatamiMatBlock extends MediumTatamiBlock {

	private static final VoxelShape SHAPE = Block.column(16.0, 0.0, 1.0);

	public MediumTatamiMatBlock(Properties settings) {
		super(settings);
	}

	@Override
	protected VoxelShape getShape(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
		return SHAPE;
	}

	@Override
	protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
		return !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
	}

	@Override
	public boolean canSurvive(final BlockState state, final LevelReader level, final BlockPos pos) {
		Unit.Mutable<Boolean> canSurvive = Unit.mutable(false);
		this.forEach(level, pos, state, (blockPos, _, _) -> {
			if (!level.isEmptyBlock(new BlockPos(blockPos).below())) {
				canSurvive.mutateValue(true);
			}
		});
		return canSurvive.value();
	}
}
