package com.mmodding.psithurism.block;

import com.mmodding.library.block.api.catalog.DoubleCropBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Collections;
import java.util.List;

public class RiceCropBlock extends DoubleCropBlock {

	private static final IntegerProperty AGE = IntegerProperty.create("age", 0, 1);

	public static final VoxelShape TOP_SHAPE = Block.column(12, 0, 4);
	public static final VoxelShape BOTTOM_SHAPE = Block.column(12, 0, 16);

	public RiceCropBlock(Properties settings) {
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
	protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
		if (state.getValue(HALF).equals(DoubleBlockHalf.LOWER)) {
			return super.getDrops(state, params);
		}
		else {
			return Collections.emptyList();
		}
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
