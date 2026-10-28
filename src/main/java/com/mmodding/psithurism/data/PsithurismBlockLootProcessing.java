package com.mmodding.psithurism.data;

import com.mmodding.psithurism.block.RiceCropBlock;
import com.mmodding.psithurism.block.SoyaCropBlock;
import com.mmodding.psithurism.init.PsithurismBlocks;
import com.mmodding.psithurism.init.PsithurismItems;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchBlock;

public class PsithurismBlockLootProcessing {

	public static void createRiceLoot(BlockLootSubProvider provider, Block block) {
		/* LootItemCondition.Builder isMaxAge = MatchBlock.blockMatches(
			provider.blocks, PsithurismBlocks.RICE, StatePropertiesPredicate.Builder.properties().hasProperty(((RiceCropBlock) PsithurismBlocks.RICE).getAgeProperty(), 1)
		);
		provider.add(block, provider.createCropDrops(block, PsithurismItems.RICE, PsithurismItems.RICE_PLANT, isMaxAge)); */
	}

	public static void createSoyaLoot(BlockLootSubProvider provider, Block block) {
		/* LootItemCondition.Builder isMaxAge = MatchBlock.blockMatches(
			provider.blocks, PsithurismBlocks.SOYA, StatePropertiesPredicate.Builder.properties().hasProperty(((SoyaCropBlock) PsithurismBlocks.SOYA).getAgeProperty(), 1)
		);
		provider.add(block, provider.createCropDrops(block, PsithurismItems.SOYA_GROWTHS, PsithurismItems.SOYBEANS, isMaxAge)); */
	}
}
