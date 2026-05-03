package com.mmodding.psithurism.block;

import com.mmodding.library.block.api.catalog.SimpleBedBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FutonBlock extends SimpleBedBlock {

	private static final VoxelShape SHAPE = column(16.0, 0.0, 4.0);

	public FutonBlock(Properties settings) {
		super(settings);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}
}
