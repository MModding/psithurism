package com.mmodding.psithurism.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class SlidingDoorBlock extends DoorBlock {

	private static final Map<Direction, VoxelShape> SHAPES = Shapes.rotateHorizontal(Block.boxZ(16.0, 7.0, 9.0));

	public SlidingDoorBlock(Properties properties) {
		super(BlockSetType.CHERRY, properties);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(FACING);
		return SHAPES.get(direction);
	}

	@Override
	protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(FACING);
		return state.getValue(OPEN) ? Shapes.empty() : SHAPES.get(direction);
	}
}
