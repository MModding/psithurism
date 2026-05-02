package com.mmodding.psithurism.block;

import com.mmodding.library.block.api.catalog.SimpleHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ManekiNekoBlock extends SimpleHorizontalFacingBlock {

	private static final VoxelShape SHAPE = Block.column(13.0, 0.0, 14.0);

	public ManekiNekoBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	protected boolean isPathfindable(final BlockState state, final PathComputationType type) {
		return false;
	}
}
