package com.mmodding.psithurism.block;

import com.mmodding.library.block.api.catalog.DoubleCropBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RiceCrop extends DoubleCropBlock {

	private static final IntegerProperty AGE = IntegerProperty.create("age", 0, 1);

	public static final VoxelShape TOP_SHAPE = Block.column(12, 0, 4);
	public static final VoxelShape BOTTOM_SHAPE = Block.column(12, 0, 16);

	public RiceCrop(Properties settings) {
		super(settings);
	}

	@Override
	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	@Override
	public int getMaxAge() {
		return 1;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return switch (state.getValue(HALF)) {
			case UPPER -> TOP_SHAPE;
			case LOWER -> BOTTOM_SHAPE;
		};
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return Shapes.empty();
	}

	@Override
	public boolean isDoubleBlock(int age) {
		return true;
	}

	@Override
	protected int getNaturalAgeIncrease(Level level) {
		return 1;
	}

	@Override
	protected int getBonemealAgeIncrease(Level level) {
		return 1;
	}
}
