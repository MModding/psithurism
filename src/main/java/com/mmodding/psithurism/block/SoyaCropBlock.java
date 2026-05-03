package com.mmodding.psithurism.block;

import com.mmodding.psithurism.init.PsithurismItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SoyaCropBlock extends CropBlock {

	public static final IntegerProperty AGE = BlockStateProperties.AGE_1;
	private static final VoxelShape[] SHAPES = Block.boxes(1, age -> Block.column(11.0 + age * 3.0, 0.0, 7.0 + age * 2.0));

	public SoyaCropBlock(Properties properties) {
		super(properties);
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
	protected ItemLike getBaseSeedId() {
		return PsithurismItems.SOYBEANS;
	}

	@Override
	protected void randomTick(final BlockState state, final ServerLevel level, final BlockPos pos, final RandomSource random) {
		if (random.nextInt(3) != 0) {
			super.randomTick(state, level, pos, random);
		}
	}

	@Override
	protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}

	@Override
	protected VoxelShape getShape(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
		return SHAPES[this.getAge(state)];
	}
}
