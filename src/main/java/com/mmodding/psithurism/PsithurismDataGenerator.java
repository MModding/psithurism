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
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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
			.chain(block -> block instanceof LargeTatamiBlock, PsithurismDataProcessors::createLargeTatami)
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
			generator.forItem(PsithurismBlocks.CHERRY_BONSAI)
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("LL", "SS")
						.key('L', Blocks.CHERRY_LEAVES)
						.key('S', Blocks.CHERRY_SAPLING)
				);
			generator.forItem(PsithurismBlocks.DARK_CHERRY_BONSAI)
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("LL", "SS")
						.key('L', PsithurismWoodSets.DARK_CHERRY.getLeaves())
						.key('S', PsithurismWoodSets.DARK_CHERRY.getSapling())
				);
			generator.forItem(PsithurismBlocks.GOLDEN_CHAIN)
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("N", "I", "N")
						.key('N', Items.GOLD_NUGGET)
						.key('I', Items.GOLD_INGOT)
				);
			generator.forItem(PsithurismBlocks.DARK_CHERRY_LAMINATE)
				.shaped(
					2, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("SS", "SS")
						.key('S', PsithurismWoodSets.DARK_CHERRY.getPlankRelatives().get(BlockFamily.Variant.SLAB))
				);
			generator.forItem(PsithurismBlocks.DARK_CHERRY_MOLDING)
				.shaped(
					4, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("LL", "LL")
						.key('L', PsithurismBlocks.DARK_CHERRY_LAMINATE)
				);
			generator.forItem(PsithurismBlocks.LARGE_PAPER_WALL_BLOCK)
				.shaped(
					4, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("PPP", "PAP", "PPP")
						.key('P', PsithurismWoodSets.DARK_CHERRY.getPlankRelatives().getMain())
						.key('A', Items.PAPER)
				);
			generator.forItem(PsithurismBlocks.PAPER_WALL_BLOCK)
				.shaped(
					4, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("LL", "LL")
						.key('L', PsithurismBlocks.LARGE_PAPER_WALL_BLOCK)
				);
			generator.forItem(PsithurismBlocks.HORIZONTAL_PAPER_WALL_BLOCK)
				.shaped(
					"_from_large", 3, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("PPP")
						.key('P', PsithurismBlocks.LARGE_PAPER_WALL_BLOCK)
				)
				.shaped(
					3, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("PPP")
						.key('P', PsithurismBlocks.PAPER_WALL_BLOCK)
				);
			generator.forItem(PsithurismBlocks.VERTICAL_PAPER_WALL_BLOCK)
				.shaped(
					"_from_large", 3, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("P", "P", "P")
						.key('P', PsithurismBlocks.LARGE_PAPER_WALL_BLOCK)
				)
				.shaped(
					3, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("P", "P", "P")
						.key('P', PsithurismBlocks.PAPER_WALL_BLOCK)
				);
			generator.forItem(PsithurismBlocks.LARGE_PAPER_WALL)
				.shaped(
					16, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("PPP", "PPP")
						.key('P', PsithurismBlocks.LARGE_PAPER_WALL_BLOCK)
				);
			generator.forItem(PsithurismBlocks.PAPER_WALL)
				.shaped(
					16, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("PPP", "PPP")
						.key('P', PsithurismBlocks.PAPER_WALL_BLOCK)
				);
			generator.forItem(PsithurismBlocks.HORIZONTAL_PAPER_WALL)
				.shaped(
					16, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("PPP", "PPP")
						.key('P', PsithurismBlocks.HORIZONTAL_PAPER_WALL_BLOCK)
				);
			generator.forItem(PsithurismBlocks.VERTICAL_PAPER_WALL)
				.shaped(
					16, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("PPP", "PPP")
						.key('P', PsithurismBlocks.VERTICAL_PAPER_WALL_BLOCK)
				);
			generator.forItem(PsithurismBlocks.DARK_CHERRY_GLASS)
				.shaped(
					4, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("PPP", "PGP", "PPP")
						.key('P', PsithurismWoodSets.DARK_CHERRY.getPlankRelatives().getMain())
						.key('G', Blocks.GLASS)
				);
			generator.forItem(PsithurismBlocks.TILED_DARK_CHERRY_GLASS)
				.shaped(
					4, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("GG", "GG")
						.key('G', PsithurismBlocks.DARK_CHERRY_GLASS)
				);
			generator.forItem(PsithurismBlocks.HORIZONTAL_DARK_CHERRY_GLASS)
				.shaped(
					3, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("GGG")
						.key('G', PsithurismBlocks.DARK_CHERRY_GLASS)
				)
				.shaped(
					"_from_tiled", 3, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("GGG")
						.key('G', PsithurismBlocks.TILED_DARK_CHERRY_GLASS)
				);
			generator.forItem(PsithurismBlocks.VERTICAL_DARK_CHERRY_GLASS)
				.shaped(
					3, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("G", "G", "G")
						.key('G', PsithurismBlocks.DARK_CHERRY_GLASS)
				)
				.shaped(
					"_from_tiled", 3, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("G", "G", "G")
						.key('G', PsithurismBlocks.TILED_DARK_CHERRY_GLASS)
				);
			generator.forItem(PsithurismBlocks.DARK_CHERRY_GLASS_PANE)
				.shaped(
					16, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("GGG", "GGG")
						.key('G', PsithurismBlocks.DARK_CHERRY_GLASS)
				);
			generator.forItem(PsithurismBlocks.TILED_DARK_CHERRY_GLASS_PANE)
				.shaped(
					16, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("GGG", "GGG")
						.key('G', PsithurismBlocks.TILED_DARK_CHERRY_GLASS)
				);
			generator.forItem(PsithurismBlocks.HORIZONTAL_DARK_CHERRY_GLASS_PANE)
				.shaped(
					16, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("GGG", "GGG")
						.key('G', PsithurismBlocks.HORIZONTAL_DARK_CHERRY_GLASS)
				);
			generator.forItem(PsithurismBlocks.VERTICAL_DARK_CHERRY_GLASS_PANE)
				.shaped(
					16, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("GGG", "GGG")
						.key('G', PsithurismBlocks.VERTICAL_DARK_CHERRY_GLASS)
				);
			generator.forItem(PsithurismBlocks.SMALL_TATAMI)
				.shaped(
					2, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("TST", "SLS", "TST")
						.key('T', Items.STRING)
						.key('S', Items.STICK)
						.key('L', Items.LEATHER)
				);
			generator.forItem(PsithurismBlocks.MEDIUM_TATAMI)
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("SS")
						.key('S', PsithurismBlocks.SMALL_TATAMI)
				);
			generator.forItem(PsithurismBlocks.LARGE_TATAMI)
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("SS", "SS")
						.key('S', PsithurismBlocks.SMALL_TATAMI)
				)
				.shaped(
					"_from_medium", RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("MM")
						.key('M', PsithurismBlocks.MEDIUM_TATAMI)
				);
			generator.forItem(PsithurismBlocks.SMALL_TATAMI_MAT)
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("T", "T")
						.key('T', PsithurismBlocks.SMALL_TATAMI)
				);
			generator.forItem(PsithurismBlocks.MEDIUM_TATAMI_MAT)
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("T", "T")
						.key('T', PsithurismBlocks.MEDIUM_TATAMI)
				);
			generator.forItem(PsithurismBlocks.LARGE_TATAMI_MAT)
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("T", "T")
						.key('T', PsithurismBlocks.LARGE_TATAMI)
				);
			generator.forItem(PsithurismBlocks.SMALL_PLAITED_TATAMI)
				.shaped(
					2, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("TRT", "RWR", "TRT")
						.key('T', Items.STRING)
						.key('R', PsithurismItems.RICE_PLANT)
						.key('W', Blocks.WHITE_WOOL)
				);
			generator.forItem(PsithurismBlocks.MEDIUM_PLAITED_TATAMI)
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("SS")
						.key('S', PsithurismBlocks.SMALL_PLAITED_TATAMI)
				);
			generator.forItem(PsithurismBlocks.LARGE_PLAITED_TATAMI)
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("SS", "SS")
						.key('S', PsithurismBlocks.SMALL_PLAITED_TATAMI)
				)
				.shaped(
					"_from_medium", RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("MM")
						.key('M', PsithurismBlocks.MEDIUM_TATAMI)
				);
			generator.forItem(PsithurismBlocks.SMALL_PLAITED_TATAMI_MAT)
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("T", "T")
						.key('T', PsithurismBlocks.SMALL_PLAITED_TATAMI)
				);
			generator.forItem(PsithurismBlocks.MEDIUM_PLAITED_TATAMI_MAT)
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("T", "T")
						.key('T', PsithurismBlocks.MEDIUM_PLAITED_TATAMI)
				);
			generator.forItem(PsithurismBlocks.LARGE_PLAITED_TATAMI_MAT)
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("T", "T")
						.key('T', PsithurismBlocks.LARGE_PLAITED_TATAMI)
				);
			generator.forItem(PsithurismBlocks.STONE_LANTERN)
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("SSS", "STS", "SSS")
						.key('S', Blocks.STONE)
						.key('T', Blocks.TORCH)
				);
			generator.forItem(PsithurismBlocks.NAMAKO_KABE)
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("DA", "AD")
						.key('D', Blocks.DIORITE)
						.key('A', PsithurismBlocks.ASHINO_STONE.getMain())
				);
			generator.forItem(PsithurismBlocks.THREAD)
				.shaped(
					6, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("S", "F", "S")
						.key('S', Items.STRING)
						.key('F', Items.FEATHER)
				);
			generator.forItem(PsithurismBlocks.TERU_TERU_BOZU)
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern(" C ", " T ", "TWT")
						.key('C', PsithurismItems.WHITE_PETAL_CROWN)
						.key('T', PsithurismBlocks.THREAD)
						.key('W', Blocks.WHITE_WOOL)
				);
			generator.forItem(PsithurismBlocks.MANEKI_NEKO)
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("RTQ", "TAT")
						.key('R', Items.REDSTONE)
						.key('T', Blocks.WHITE_TERRACOTTA)
						.key('Q', Items.QUARTZ)
						.key('A', PsithurismBlocks.ASHINO_STONE.getMain())
				);
			generator.forItem(PsithurismBlocks.ASHINO_STONE.getMain())
				.shaped(
					4, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("AB", "BA")
						.key('A', Blocks.ANDESITE)
						.key('B', Blocks.SMOOTH_BASALT)
				)
				.cutting(Blocks.STONE, RecipeCategory.BUILDING_BLOCKS, 1);
			generator.forItem(PsithurismBlocks.ASHINO_BRICKS.getMain())
				.shaped(
					4, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("##", "##")
						.key('#', PsithurismBlocks.ASHINO_STONE.getMain())
				)
				.cutting(PsithurismBlocks.ASHINO_STONE.getMain(), RecipeCategory.BUILDING_BLOCKS, 1);
			generator.forItem(PsithurismBlocks.MOSSY_ASHINO_BRICKS.getMain())
				.shapeless(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.with(PsithurismBlocks.ASHINO_BRICKS.getMain(), Blocks.VINE)
				)
				.shapeless(
					"_with_moss", RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.with(PsithurismBlocks.ASHINO_BRICKS.getMain(), Blocks.MOSS_BLOCK)
				);
			generator.forItem(PsithurismBlocks.CHISELED_ASHINO_STONE_BRICKS)
				.shaped(
					RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("S", "S")
						.key('S', PsithurismBlocks.ASHINO_STONE.get(BlockFamily.Variant.SLAB))
				);
			generator.forItem(PsithurismBlocks.POLISHED_ASHINO_STONE.getMain())
				.shaped(
					4, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("##", "##")
						.key('#', PsithurismBlocks.ASHINO_BRICKS.getMain())
				);
			generator.forItem(PsithurismBlocks.ASHINO_STONE_PEDESTAL)
				.shaped(
					4, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("B", "B")
						.key('B', PsithurismBlocks.ASHINO_BRICKS.getMain())
				);
			generator.forItem(PsithurismBlocks.STONE_KAWARA_TILES.getMain())
				.shaped(
					4, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("SB", "BS")
						.key('S', Blocks.STONE)
						.key('B', Blocks.STONE_BRICKS)
				);
			generator.forItem(PsithurismBlocks.DEEPSLATE_KAWARA_TILES.getMain())
				.shaped(
					4, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("SB", "BS")
						.key('S', Blocks.DEEPSLATE)
						.key('B', Blocks.DEEPSLATE_BRICKS)
				);
			generator.forItem(PsithurismBlocks.BLACKSTONE_KAWARA_TILES.getMain())
				.shaped(
					4, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("SB", "BS")
						.key('S', Blocks.BLACKSTONE)
						.key('B', Blocks.POLISHED_BLACKSTONE_BRICKS)
				);
			generator.forItem(PsithurismBlocks.ASHINO_KAWARA_TILES.getMain())
				.shaped(
					4, RecipeCategory.BUILDING_BLOCKS,
					recipe -> recipe.pattern("SB", "BS")
						.key('S', PsithurismBlocks.ASHINO_STONE.getMain())
						.key('B', PsithurismBlocks.ASHINO_BRICKS.getMain())
				);
			generator.forItem(PsithurismItems.MISO_PASTE)
				.smoking(PsithurismItems.SOYBEANS, RecipeCategory.FOOD, 2, 20);
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
