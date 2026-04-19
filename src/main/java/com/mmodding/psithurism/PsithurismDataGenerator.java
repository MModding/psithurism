package com.mmodding.psithurism;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.datagen.api.ExtendedDataGeneratorEntrypoint;
import com.mmodding.library.datagen.api.lang.DefaultLangProcessors;
import com.mmodding.library.datagen.api.management.DataManager;
import com.mmodding.library.datagen.api.management.DefaultDataHandlers;
import com.mmodding.library.datagen.api.model.block.DefaultBlockModelProcessing;
import com.mmodding.library.datagen.api.provider.MModdingLanguageProvider;
import com.mmodding.psithurism.block.StoneLanternBlock;
import com.mmodding.psithurism.data.PsithurismDataProcessors;
import com.mmodding.psithurism.init.PsithurismBlocks;
import com.mmodding.psithurism.init.PsithurismItems;
import com.mmodding.psithurism.init.PsithurismWoodSets;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;

import java.util.concurrent.CompletableFuture;

public class PsithurismDataGenerator implements ExtendedDataGeneratorEntrypoint {

	@Override
	public void setupManager(DataManager manager) {
		manager.chain(PsithurismBlocks.class, DefaultDataHandlers.BLOCK_MODELS)
			.chain(block -> block instanceof IronBarsBlock, PsithurismDataProcessors::createPaperWall)
			.chain(block -> block instanceof ChainBlock, DefaultBlockModelProcessing::createChain)
			.chain(block -> block instanceof StoneLanternBlock, PsithurismDataProcessors::createStoneLantern)
			.chain(BlockModelGenerators::createTrivialCube);
		manager.task(PsithurismWoodSets.class, DefaultDataHandlers.WOOD_SETS);
		manager.task(PsithurismBlocks.class, DefaultDataHandlers.getTranslationHandler(Registries.BLOCK, Block.class), DefaultLangProcessors.CLASSIC);
		manager.task(PsithurismItems.class, DefaultDataHandlers.ITEM_MODELS, (generator, item) -> generator.generateFlatItem(item, ModelTemplates.FLAT_ITEM));
		manager.task(PsithurismItems.class, DefaultDataHandlers.getTranslationHandler(Registries.ITEM, Item.class), DefaultLangProcessors.CLASSIC);
	}

	@Override
	public void onInitializeDataGenerator(AdvancedContainer advancedContainer, FabricDataGenerator generator, FabricDataGenerator.Pack pack) {
		pack.addProvider(DelicateSipLanguageProvider::new);
	}

	private static class DelicateSipLanguageProvider extends MModdingLanguageProvider {

		protected DelicateSipLanguageProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> future) {
			super(dataOutput, future);
		}

		@Override
		public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
			translationBuilder.add("itemGroup.psithurism.tab", "Psithurism");
		}
	}
}
