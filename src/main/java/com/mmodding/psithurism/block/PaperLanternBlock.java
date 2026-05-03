package com.mmodding.psithurism.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PaperLanternBlock extends Block {

	private static final VoxelShape SHAPE = Shapes.or(
		column(6.0, 0.0, 2.0),
		column(10.0, 2.0, 14.0),
		column(6.0, 14.0, 16.0)
	);

	public PaperLanternBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}
}
