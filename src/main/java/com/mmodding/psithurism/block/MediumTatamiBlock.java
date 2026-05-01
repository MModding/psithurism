package com.mmodding.psithurism.block;

import com.mmodding.library.block.api.catalog.sized.FacingSizedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;

public class MediumTatamiBlock extends FacingSizedBlock {

	public static final Property<Integer> X = FacingSizedBlock.makeOfSize(SizeAxis.LENGTH, 2);

	@Override
	protected BlockState setInnerX(BlockState state, int x) {
		return state.setValue(X, x);
	}

	@Override
	protected BlockState setInnerY(BlockState state, int y) {
		return state;
	}

	@Override
	protected BlockState setInnerZ(BlockState state, int z) {
		return state;
	}

	@Override
	protected int getInnerX(BlockState state) {
		return state.getValue(X);
	}

	@Override
	protected int getInnerY(BlockState state) {
		return 0;
	}

	@Override
	protected int getInnerZ(BlockState state) {
		return 0;
	}

	@Override
	protected int getLength() {
		return 2;
	}

	@Override
	protected int getHeight() {
		return 1;
	}

	@Override
	protected int getWidth() {
		return 1;
	}

	public MediumTatamiBlock(Properties settings) {
		super(true, settings);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(X);
	}
}
