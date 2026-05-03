package com.mmodding.psithurism;

import com.mmodding.library.block.api.catalog.SimpleBedBlock;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.datagen.api.ExtendedDataGeneratorEntrypoint;
import com.mmodding.library.datagen.api.lang.DefaultLangProcessors;
import com.mmodding.library.datagen.api.management.DataManager;
import com.mmodding.library.datagen.api.management.DefaultDataHandlers;
import com.mmodding.library.datagen.api.model.block.DefaultBlockModelProcessing;
import com.mmodding.library.datagen.api.provider.MModdingLanguageProvider;
import com.mmodding.library.datagen.api.provider.MModdingRecipeProvider;
import com.mmodding.library.datagen.api.recipe.RecipeGenerator;
import com.mmodding.psithurism.block.*;
import com.mmodding.psithurism.data.PsithurismDataProcessors;
import com.mmodding.psithurism.data.PsithurismTexturedModels;
import com.mmodding.psithurism.init.PsithurismBlocks;
import com.mmodding.psithurism.init.PsithurismFluids;
import com.mmodding.psithurism.init.PsithurismItems;
import com.mmodding.psithurism.init.PsithurismWoodSets;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BedPart;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class PsithurismDataGenerator implements ExtendedDataGeneratorEntrypoint {

	@Override
	public void setupManager(DataManager manager) {
		manager.chain(PsithurismBlocks.class, DefaultDataHandlers.BLOCK_MODELS)
			.chain(block -> block instanceof FlowerBedBlock, BlockModelGenerators::createFlowerBed)
			.chain(block -> block instanceof IronBarsBlock && block.builtInRegistryHolder().key().identifier().getPath().contains("wall"), PsithurismDataProcessors::createPaperWall)
			.chain(block -> block instanceof IronBarsBlock, PsithurismDataProcessors::createDarkCherryGlassPane)
			.chain(block -> block instanceof ChainBlock, DefaultBlockModelProcessing::createChain)
			.chain(block -> block instanceof StoneLanternBlock, PsithurismDataProcessors::createStoneLantern)
			.chain(block -> block.builtInRegistryHolder().key().identifier().getPath().contains("waxed"), DefaultBlockModelProcessing::createWaxedTrapdoor)
			.chain(block -> block instanceof TrapDoorBlock, BlockModelGenerators::createTrapdoor)
			.chain(block -> block instanceof PaperLanternBlock, DefaultBlockModelProcessing.createWithProvider(PsithurismTexturedModels.PAPER_LANTERN))
			.chain(block -> block instanceof SimpleBedBlock, PsithurismDataProcessors::createFuton)
			.chain(block -> block instanceof SlabBlock, DefaultBlockModelProcessing::createStandaloneSlab)
			.chain(Set.of(PsithurismBlocks.SMALL_TATAMI, PsithurismBlocks.SMALL_PLAITED_TATAMI), PsithurismDataProcessors::createSmallTatami)
			.chain(block -> block instanceof CarpetBlock, PsithurismDataProcessors::createSmallTatamiMat)
			.chain(block -> block instanceof MediumTatamiMatBlock, PsithurismDataProcessors::createMediumTatamiMat)
			.chain(block -> block instanceof MediumTatamiBlock, PsithurismDataProcessors::createMediumTatami)
			.chain(block -> block instanceof LargeTatamiMatBlock, PsithurismDataProcessors::createLargeTatamiMat)
			.chain(block -> block instanceof LargeTatamiBlock, PsithurismDataProcessors.createLargeTatami(ModelTemplates.CUBE_ALL, TextureMapping::cube))
			.chain(block -> block instanceof LiquidBlock, PsithurismDataProcessors::createOnsenWater)
			.chain(Set.of(PsithurismBlocks.ASHINO_STONE_PEDESTAL), PsithurismDataProcessors::createAshinoStonePedestal)
			.chain(Set.of(PsithurismBlocks.RICE), PsithurismDataProcessors::createRiceCrop)
			.chain(Set.of(PsithurismBlocks.CHERRY_BONSAI), PsithurismDataProcessors::createCherryBonsai)
			.chain(Set.of(PsithurismBlocks.DARK_CHERRY_BONSAI), PsithurismDataProcessors::createDarkCherryBonsai)
			.chain(Set.of(PsithurismBlocks.TERU_TERU_BOZU), PsithurismDataProcessors::createTeruTeruBozu)
			.chain(Set.of(PsithurismBlocks.MANEKI_NEKO), DefaultBlockModelProcessing::createDefinedModelHorizontalVariants)
			.chain(BlockModelGenerators::createTrivialCube);
		manager.chain(PsithurismBlocks.class, DefaultDataHandlers.BLOCK_LOOTS)
			.chain(block -> block instanceof BedBlock, (provider, block) -> provider.add(block, provider.createSinglePropConditionTable(block, BedBlock.PART, BedPart.HEAD)))
			.chain(block -> !(block instanceof LiquidBlock) && !block.equals(PsithurismBlocks.TERU_TERU_BOZU), BlockLootSubProvider::dropSelf);
		manager.task(PsithurismBlocks.class, DefaultDataHandlers.BLOCK_TAGS, Set.of(PsithurismBlocks.RICE), (getter, block) -> getter.apply(BlockTags.MAINTAINS_FARMLAND).add(block));
		manager.chain(PsithurismBlocks.class, DefaultDataHandlers.getTranslationHandler(Registries.BLOCK, Block.class))
			.chain(Set.of(PsithurismBlocks.TERU_TERU_BOZU), _ -> "Teru Teru Bozū")
			.chain(DefaultLangProcessors.CLASSIC);
		manager.task(PsithurismBlocks.class, DefaultDataHandlers.BLOCK_RELATIVES);
		manager.task(PsithurismWoodSets.class, DefaultDataHandlers.WOOD_SETS);
		manager.task(PsithurismItems.class, DefaultDataHandlers.ITEM_MODELS, item -> !item.equals(PsithurismItems.RICE_PLANT), (generator, item) -> generator.generateFlatItem(item, ModelTemplates.FLAT_ITEM));
		manager.task(PsithurismItems.class, DefaultDataHandlers.ITEM_TAGS, Set.of(PsithurismItems.FAN_POTTERY_SHERD, PsithurismItems.TORII_POTTERY_SHERD), (getter, item) -> getter.apply(ItemTags.DECORATED_POT_SHERDS).add(item));
		manager.task(PsithurismItems.class, DefaultDataHandlers.getTranslationHandler(Registries.ITEM, Item.class), DefaultLangProcessors.CLASSIC);
	}

	@Override
	public void onInitializeDataGenerator(AdvancedContainer advancedContainer, FabricDataGenerator generator, FabricDataGenerator.Pack pack) {
		pack.addProvider(PsithurismLanguageProvider::new);
		pack.addProvider(PsithurismRecipes::new);
		pack.addProvider(PsithurismBlockTags::new);
		pack.addProvider(PsithurismFluidTags::new);
	}

	private static class PsithurismLanguageProvider extends MModdingLanguageProvider {

		protected PsithurismLanguageProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> future) {
			super(dataOutput, future);
		}

		@Override
		public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translations) {
			translations.add("block.psithurism.teru_teru_bozu.insufficient_will_power", "Insufficient Will Power!");
			translations.add("block.psithurism.teru_teru_bozu.nothing_to_do", "I have nothing to do!");
			translations.add("itemGroup.psithurism.building_blocks", "Psithurism - Building Blocks");
			translations.add("itemGroup.psithurism.organic_products", "Psithurism - Organic Products");
			translations.add("itemGroup.psithurism.cosmetics", "Psithurism - Cosmetics");
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
				.cutting(Blocks.STONE, RecipeCategory.BUILDING_BLOCKS, 1);
			generator.forItem(PsithurismBlocks.ASHINO_BRICKS.getMain())
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("##", "##")
						.key('#', PsithurismBlocks.ASHINO_STONE.getMain())
				)
				.cutting(PsithurismBlocks.ASHINO_STONE.getMain(), RecipeCategory.BUILDING_BLOCKS, 1);
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
				.forceAddTag(PsithurismBlocks.POLISHED_ASHINO_STONE.getBlockTagKey())
				.forceAddTag(PsithurismBlocks.ASHINO_BRICKS.getBlockTagKey())
				.forceAddTag(PsithurismBlocks.MOSSY_ASHINO_BRICKS.getBlockTagKey())
				.forceAddTag(PsithurismBlocks.CRACKED_ASHINO_STONE_BRICKS.getBlockTagKey())
				.forceAddTag(PsithurismBlocks.STONE_KAWARA_TILES.getBlockTagKey())
				.forceAddTag(PsithurismBlocks.DEEPSLATE_KAWARA_TILES.getBlockTagKey())
				.forceAddTag(PsithurismBlocks.BLACKSTONE_KAWARA_TILES.getBlockTagKey())
				.forceAddTag(PsithurismBlocks.ASHINO_KAWARA_TILES.getBlockTagKey())
				.add(PsithurismBlocks.STONE_LANTERN)
				.add(PsithurismBlocks.CHISELED_ASHINO_STONE_BRICKS)
				.add(PsithurismBlocks.IRON_MANHOLE)
				.add(PsithurismBlocks.COPPER_MANHOLE)
				.add(PsithurismBlocks.EXPOSED_COPPER_MANHOLE)
				.add(PsithurismBlocks.WEATHERED_COPPER_MANHOLE)
				.add(PsithurismBlocks.OXIDIZED_COPPER_MANHOLE)
				.add(PsithurismBlocks.WAXED_COPPER_MANHOLE)
				.add(PsithurismBlocks.WAXED_EXPOSED_COPPER_MANHOLE)
				.add(PsithurismBlocks.WAXED_WEATHERED_COPPER_MANHOLE)
				.add(PsithurismBlocks.WAXED_OXIDIZED_COPPER_MANHOLE);
		}
	}

	private static class PsithurismFluidTags extends FabricTagsProvider.FluidTagsProvider {

		public PsithurismFluidTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> future) {
			super(output, future);
		}

		@Override
		protected void addTags(HolderLookup.Provider registries) {
			this.valueLookupBuilder(FluidTags.WATER)
				.add(PsithurismFluids.FLOWING_ONSEN_WATER)
				.add(PsithurismFluids.ONSEN_WATER);
		}
	}
}
