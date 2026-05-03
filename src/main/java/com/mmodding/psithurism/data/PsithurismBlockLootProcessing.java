package com.mmodding.psithurism.data;

import com.mmodding.psithurism.init.PsithurismItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;

public class PsithurismBlockLootProcessing {

	public static void createRiceLoot(BlockLootSubProvider provider, Block block) {
		provider.add(block, provider.createCropDrops(block, PsithurismItems.RICE, PsithurismItems.RICE_PLANT, LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)));
	}

	public static void createSoyaLoot(BlockLootSubProvider provider, Block block) {
		provider.add(block, provider.createCropDrops(block, PsithurismItems.SOYA_GROWTHS, PsithurismItems.SOYBEANS, LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)));
	}
}
