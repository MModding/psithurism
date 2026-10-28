package com.mmodding.psithurism.block;

import com.mmodding.library.block.api.catalog.sized.FacingSizedBlock;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import java.util.Collections;
import java.util.List;

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

	@Override
	protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
		if (this.drops.isEmpty()) {
			return Collections.emptyList();
		}

		LootParams lootParams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
		ServerLevel level = lootParams.getLevel();
		LootTable table = level.getServer().reloadableRegistries().getLootTable(this.drops.get());
		return table.getRandomItems(lootParams);
	}
}
