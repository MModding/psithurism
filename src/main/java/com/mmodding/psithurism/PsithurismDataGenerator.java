package com.mmodding.psithurism;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.datagen.api.ExtendedDataGeneratorEntrypoint;
import com.mmodding.library.datagen.api.lang.DefaultLangProcessors;
import com.mmodding.library.datagen.api.management.DataManager;
import com.mmodding.library.datagen.api.management.DefaultDataHandlers;
import com.mmodding.library.datagen.api.model.block.DefaultBlockModelProcessing;
import com.mmodding.library.datagen.api.provider.MModdingLanguageProvider;
import com.mmodding.library.datagen.api.provider.MModdingRecipeProvider;
import com.mmodding.library.datagen.api.recipe.RecipeGenerator;
import com.mmodding.psithurism.block.StoneLanternBlock;
import com.mmodding.psithurism.data.PsithurismDataProcessors;
import com.mmodding.psithurism.init.PsithurismBlocks;
import com.mmodding.psithurism.init.PsithurismItems;
import com.mmodding.psithurism.init.PsithurismWoodSets;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class PsithurismDataGenerator implements ExtendedDataGeneratorEntrypoint {

	@Override
	public void setupManager(DataManager manager) {
		manager.chain(PsithurismBlocks.class, DefaultDataHandlers.BLOCK_MODELS)
			.chain(block -> block instanceof FlowerBedBlock, BlockModelGenerators::createFlowerBed)
			.chain(block -> block instanceof IronBarsBlock, PsithurismDataProcessors::createPaperWall)
			.chain(block -> block instanceof ChainBlock, DefaultBlockModelProcessing::createChain)
			.chain(block -> block instanceof StoneLanternBlock, PsithurismDataProcessors::createStoneLantern)
			.chain(Set.of(PsithurismBlocks.RICE), PsithurismDataProcessors::createRiceCrop)
			.chain(Set.of(PsithurismBlocks.CHERRY_BONSAI), PsithurismDataProcessors::createCherryBonsai)
			.chain(Set.of(PsithurismBlocks.DARK_CHERRY_BONSAI), PsithurismDataProcessors::createDarkCherryBonsai)
			.chain(BlockModelGenerators::createTrivialCube);
		manager.chain(PsithurismBlocks.class, DefaultDataHandlers.BLOCK_LOOTS)
			.chain(BlockLootSubProvider::dropSelf);
		manager.task(PsithurismBlocks.class, DefaultDataHandlers.BLOCK_TAGS, Set.of(PsithurismBlocks.RICE), (getter, block) -> getter.apply(BlockTags.MAINTAINS_FARMLAND).add(block));
		manager.task(PsithurismWoodSets.class, DefaultDataHandlers.WOOD_SETS);
		manager.task(PsithurismBlocks.class, DefaultDataHandlers.getTranslationHandler(Registries.BLOCK, Block.class), DefaultLangProcessors.CLASSIC);
		manager.task(PsithurismBlocks.class, DefaultDataHandlers.BLOCK_RELATIVES);
		manager.task(PsithurismItems.class, DefaultDataHandlers.ITEM_MODELS, item -> !item.equals(PsithurismItems.RICE_PLANT), (generator, item) -> generator.generateFlatItem(item, ModelTemplates.FLAT_ITEM));
		manager.task(PsithurismItems.class, DefaultDataHandlers.ITEM_TAGS, Set.of(PsithurismItems.FAN_POTTERY_SHERD, PsithurismItems.TORII_POTTERY_SHERD), (getter, item) -> getter.apply(ItemTags.DECORATED_POT_SHERDS).add(item));
		manager.task(PsithurismItems.class, DefaultDataHandlers.getTranslationHandler(Registries.ITEM, Item.class), DefaultLangProcessors.CLASSIC);
	}

	@Override
	public void onInitializeDataGenerator(AdvancedContainer advancedContainer, FabricDataGenerator generator, FabricDataGenerator.Pack pack) {
		pack.addProvider(PsithurismLanguageProvider::new);
		pack.addProvider(PsithurismRecipes::new);
		pack.addProvider(PsithurismBlockTags::new);
	}

	private static class PsithurismLanguageProvider extends MModdingLanguageProvider {

		protected PsithurismLanguageProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> future) {
			super(dataOutput, future);
		}

		@Override
		public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
			translationBuilder.add("itemGroup.psithurism.tab", "Psithurism");
		}
	}

	private static class PsithurismRecipes extends MModdingRecipeProvider {

		public PsithurismRecipes(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> future) {
			super(output, future);
		}

		@Override
		public void createRecipes(RecipeGenerator generator) {
			generator.forItem(PsithurismBlocks.ASHINO_STONE.getMain())
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("AB", "BA")
						.key('A', Blocks.ANDESITE)
						.key('B', Blocks.SMOOTH_BASALT)
				)
				.provide((provider, target) -> provider.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, target, Blocks.STONE));
			generator.forItem(PsithurismBlocks.ASHINO_BRICKS.getMain())
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("##", "##")
						.key('#', PsithurismBlocks.ASHINO_STONE.getMain())
				)
				.provide((provider, target) -> provider.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, target, PsithurismBlocks.ASHINO_STONE.getMain()));
			generator.forItem(PsithurismItems.MISO_PASTE)
				.smoking(PsithurismItems.SOJA_SEED, RecipeCategory.FOOD, 2, 20);
		}

		@Override
		public String getName() {
			return "Psithurism Recipes";
		}
	}

	private static class PsithurismBlockTags extends FabricTagsProvider.BlockTagsProvider {

		public PsithurismBlockTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> future) {
			super(output, future);
		}

		@Override
		protected void addTags(HolderLookup.Provider registries) {
			this.valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
				.forceAddTag(PsithurismBlocks.ASHINO_STONE.getBlockTagKey())
				.forceAddTag(PsithurismBlocks.ASHINO_BRICKS.getBlockTagKey())
				.forceAddTag(PsithurismBlocks.MOSSY_ASHINO_BRICKS.getBlockTagKey());
		}
	}
}
