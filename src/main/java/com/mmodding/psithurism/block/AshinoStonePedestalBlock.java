package com.mmodding.psithurism.block;

import com.mojang.math.OctahedralGroup;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AshinoStonePedestalBlock extends RotatedPillarBlock {

	private static final VoxelShape SHAPE_Y_AXIS = Block.column(6.0, 0.0, 16.0);
	private static final VoxelShape SHAPE_X_AXIS = Shapes.rotate(SHAPE_Y_AXIS, OctahedralGroup.BLOCK_ROT_Z_90);
	private static final VoxelShape SHAPE_Z_AXIS = Shapes.rotate(SHAPE_Y_AXIS, OctahedralGroup.BLOCK_ROT_X_90);

	public AshinoStonePedestalBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(BlockStateProperties.AXIS)) {
			case X -> SHAPE_X_AXIS;
			case Y -> SHAPE_Y_AXIS;
			case Z -> SHAPE_Z_AXIS;
		};
	}
}
