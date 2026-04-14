package com.mmodding.psithurism;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.datagen.api.ExtendedDataGeneratorEntrypoint;
import com.mmodding.library.datagen.api.family.BlockFamilyProcessor;
import com.mmodding.library.datagen.api.lang.DefaultLangProcessors;
import com.mmodding.library.datagen.api.management.DataManager;
import com.mmodding.library.datagen.api.management.DefaultContentTypes;
import com.mmodding.library.datagen.api.provider.MModdingLanguageProvider;
import com.mmodding.psithurism.data.PsithurismDataProcessors;
import com.mmodding.psithurism.init.PsithurismBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;

import java.util.concurrent.CompletableFuture;

public class PsithurismDataGenerator implements ExtendedDataGeneratorEntrypoint {

	@Override
	public void setupManager(DataManager manager) {
		manager.chain(PsithurismBlocks.class, Block.class, DefaultContentTypes.BLOCK_MODELS, block -> block instanceof RotatedPillarBlock, PsithurismDataProcessors::createRotatedPillar)
			.chain(block -> block instanceof IronBarsBlock, PsithurismDataProcessors::createPaperWall)
			.chain(BlockModelGenerators::createTrivialCube);
		manager.task(PsithurismBlocks.class, BlockFamily.class, DefaultContentTypes.BLOCK_FAMILIES, new BlockFamilyProcessor());
		manager.task(PsithurismBlocks.class, Block.class, DefaultContentTypes.getTranslationHandler(Registries.BLOCK), DefaultLangProcessors.getClassic());
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
