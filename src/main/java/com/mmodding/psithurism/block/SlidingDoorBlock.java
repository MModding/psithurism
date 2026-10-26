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

	private static final Map<Direction, VoxelShape> CLOSED_SHAPES = Shapes.rotateHorizontal(Block.boxZ(16.0, 7.0, 10.0));
	// private static final Map<Direction, VoxelShape> OPEN_SHAPES = Shapes.rotateHorizontal(Block.box(14.0, 0.0, 10.0, 30.0, 16.0, 13.0));

	public SlidingDoorBlock(Properties properties) {
		super(BlockSetType.CHERRY, properties);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(FACING);
		return state.getValue(OPEN) ? Shapes.empty() : CLOSED_SHAPES.get(direction);
	}

	@Override
	protected VoxelShape getInteractionShape(BlockState state, BlockGetter level, BlockPos pos) {
		Direction direction = state.getValue(FACING);
		return CLOSED_SHAPES.get(direction);
	}
}
