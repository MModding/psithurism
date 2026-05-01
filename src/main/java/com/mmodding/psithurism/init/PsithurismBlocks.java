package com.mmodding.psithurism.init;

import com.mmodding.library.block.api.catalog.SimpleHorizontalFacingBlock;
import com.mmodding.library.block.api.util.BlockFactory;
import com.mmodding.library.block.api.util.BlockHeapUtil;
import com.mmodding.library.block.api.wrapper.BlockHeap;
import com.mmodding.library.block.api.wrapper.BlockRelatives;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.java.api.function.AutoMapper;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.block.*;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.PushReaction;

public class PsithurismBlocks {

	public static final Block ONSEN_WATER = register("onsen_water", properties -> new LiquidBlock(PsithurismFluids.FLOWING_ONSEN_WATER, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER));

	public static final Block WHITE_PETALS = register("white_petals", FlowerBedBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_PETALS)).registerItem();

	public static final Block CHERRY_BONSAI = register("cherry_bonsai", SimpleHorizontalFacingBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WOOD).noOcclusion()).registerItem();
	public static final Block DARK_CHERRY_BONSAI = register("dark_cherry_bonsai", SimpleHorizontalFacingBlock::new, BlockBehaviour.Properties.ofFullCopy(PsithurismWoodSets.DARK_CHERRY.getWood()).noOcclusion()).registerItem();

	public static final Block GOLDEN_CHAIN = register("golden_chain", ChainBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_CHAIN)).registerItem();

	public static final Block DARK_CHERRY_LAMINATE = register("dark_cherry_laminate", BlockBehaviour.Properties.ofFullCopy(PsithurismWoodSets.DARK_CHERRY.getWood())).registerItem();
	public static final Block DARK_CHERRY_MOLDING = register("dark_cherry_molding", BlockBehaviour.Properties.ofFullCopy(PsithurismWoodSets.DARK_CHERRY.getWood())).registerItem();

	public static final Block PAPER_WALL_BLOCK = register("paper_wall_block", BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();
	public static final Block LARGE_PAPER_WALL_BLOCK = register("large_paper_wall_block", BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();
	public static final Block HORIZONTAL_PAPER_WALL_BLOCk = register("horizontal_paper_wall_block", BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();
	public static final Block VERTICAL_PAPER_WALL_BLOCk = register("vertical_paper_wall_block", BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();
	public static final Block PAPER_WALL = register("paper_wall", IronBarsBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();
	public static final Block LARGE_PAPER_WALL = register("large_paper_wall", IronBarsBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();
	public static final Block HORIZONTAL_PAPER_WALL = register("horizontal_paper_wall", IronBarsBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();
	public static final Block VERTICAL_PAPER_WALL = register("vertical_paper_wall", IronBarsBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();

	public static final Block DARK_CHERRY_GLASS = register("dark_cherry_glass", TransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(PsithurismWoodSets.DARK_CHERRY.getWood()).noOcclusion()).registerItem();
	public static final Block HORIZONTAL_DARK_CHERRY_GLASS = register("horizontal_dark_cherry_glass", TransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(PsithurismWoodSets.DARK_CHERRY.getWood()).noOcclusion()).registerItem();
	public static final Block VERTICAL_DARK_CHERRY_GLASS = register("vertical_dark_cherry_glass", TransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(PsithurismWoodSets.DARK_CHERRY.getWood()).noOcclusion()).registerItem();
	public static final Block TILED_DARK_CHERRY_GLASS = register("tiled_dark_cherry_glass", TransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(PsithurismWoodSets.DARK_CHERRY.getWood()).noOcclusion()).registerItem();
	public static final Block DARK_CHERRY_GLASS_PANE = register("dark_cherry_glass_pane", IronBarsBlock::new, BlockBehaviour.Properties.ofFullCopy(PsithurismWoodSets.DARK_CHERRY.getWood()).noOcclusion()).registerItem();
	public static final Block HORIZONTAL_DARK_CHERRY_GLASS_PANE = register("horizontal_dark_cherry_glass_pane", IronBarsBlock::new, BlockBehaviour.Properties.ofFullCopy(PsithurismWoodSets.DARK_CHERRY.getWood()).noOcclusion()).registerItem();
	public static final Block VERTICAL_DARK_CHERRY_GLASS_PANE = register("vertical_dark_cherry_glass_pane", IronBarsBlock::new, BlockBehaviour.Properties.ofFullCopy(PsithurismWoodSets.DARK_CHERRY.getWood()).noOcclusion()).registerItem();
	public static final Block TILED_DARK_CHERRY_GLASS_PANE = register("tiled_dark_cherry_glass_pane", IronBarsBlock::new, BlockBehaviour.Properties.ofFullCopy(PsithurismWoodSets.DARK_CHERRY.getWood()).noOcclusion()).registerItem();

	public static final Block SMALL_TATAMI = register("small_tatami", BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CARPET)).registerItem();
	public static final Block MEDIUM_TATAMI = register("medium_tatami", MediumTatamiBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CARPET)).registerItem();
	public static final Block LARGE_TATAMI = register("large_tatami", LargeTatamiBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CARPET)).registerItem();
	public static final Block SMALL_TATAMI_MAT = register("small_tatami_mat", CarpetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CARPET)).registerItem();
	public static final Block MEDIUM_TATAMI_MAT = register("medium_tatami_mat", MediumTatamiMatBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CARPET)).registerItem();
	public static final Block LARGE_TATAMI_MAT = register("large_tatami_mat", LargeTatamiMatBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CARPET)).registerItem();

	public static final Block STONE_LANTERN = register("stone_lantern", StoneLanternBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).sound(SoundType.STONE).lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 15 : 0)).registerItem();
	public static final Block NAMAKO_KABE = register("namako_kabe", BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();
	public static final Block THREAD = register("thread", ChainBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();

	public static final BlockRelatives ASHINO_STONE = BlockRelatives.registerStone(Psithurism.createId("ashino_stone"), AutoMapper.identity(), false, false);
	public static final BlockRelatives ASHINO_BRICKS = BlockRelatives.registerStone(Psithurism.createId("ashino_brick"), true, AutoMapper.identity(), false, false);
	public static final BlockRelatives MOSSY_ASHINO_BRICKS = BlockRelatives.registerStone(Psithurism.createId("mossy_ashino_brick"), true, AutoMapper.identity(), false, false);
	public static final BlockRelatives CRACKED_ASHINO_STONE_BRICKS = BlockRelatives.registerStone(Psithurism.createId("cracked_ashino_stone_brick"), true, AutoMapper.identity(), false, false);
	public static final Block CHISELED_ASHINO_STONE_BRICKS = register("chiseled_ashino_stone_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_STONE_BRICKS)).registerItem();

	public static final Block ASHINO_STONE_PEDESTAL = register("ashino_stone_pedestal", AshinoStonePedestalBlock::new, BlockBehaviour.Properties.ofFullCopy(ASHINO_STONE.getMain())).registerItem();

	public static final BlockRelatives STONE_KAWARA_TILES = BlockRelatives.registerStone(Psithurism.createId("stone_kawara_tile"), true, AutoMapper.identity(), false, false);
	public static final BlockRelatives DEEPSLATE_KAWARA_TILES = BlockRelatives.registerStone(Psithurism.createId("deepslate_kawara_tile"), true, AutoMapper.identity(), false, false);
	public static final BlockRelatives BLACKSTONE_KAWARA_TILES = BlockRelatives.registerStone(Psithurism.createId("blackstone_kawara_tile"), true, AutoMapper.identity(), false, false);
	public static final BlockRelatives ASHINO_KAWARA_TILES = BlockRelatives.registerStone(Psithurism.createId("ashino_kawara_tile"), true, AutoMapper.identity(), false, false);

	public static final Block RICE = register("rice", RiceCrop::new, BlockBehaviour.Properties.of().noCollision().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY));

	public static final Block IRON_MANHOLE = register("iron_manhole", properties -> new TrapDoorBlock(BlockSetType.IRON, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_TRAPDOOR)).registerItem();
	public static final Block COPPER_MANHOLE = register("copper_manhole", properties -> new WeatheringCopperTrapDoorBlock(BlockSetType.COPPER, WeatheringCopper.WeatherState.UNAFFECTED, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_TRAPDOOR)).registerItem();
	public static final Block EXPOSED_COPPER_MANHOLE = register("exposed_copper_manhole", properties -> new WeatheringCopperTrapDoorBlock(BlockSetType.COPPER, WeatheringCopper.WeatherState.EXPOSED, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_COPPER_TRAPDOOR)).registerItem();
	public static final Block WEATHERED_COPPER_MANHOLE = register("weathered_copper_manhole", properties -> new WeatheringCopperTrapDoorBlock(BlockSetType.COPPER, WeatheringCopper.WeatherState.WEATHERED, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_COPPER_TRAPDOOR)).registerItem();
	public static final Block OXIDIZED_COPPER_MANHOLE = register("oxidized_copper_manhole", properties -> new WeatheringCopperTrapDoorBlock(BlockSetType.COPPER, WeatheringCopper.WeatherState.OXIDIZED, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_COPPER_TRAPDOOR)).registerItem();
	public static final Block WAXED_COPPER_MANHOLE = register("waxed_copper_manhole", properties -> new TrapDoorBlock(BlockSetType.COPPER, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.WAXED_COPPER_TRAPDOOR)).registerItem();
	public static final Block WAXED_EXPOSED_COPPER_MANHOLE = register("waxed_exposed_copper_manhole", properties -> new TrapDoorBlock(BlockSetType.COPPER, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.WAXED_EXPOSED_COPPER_TRAPDOOR)).registerItem();
	public static final Block WAXED_WEATHERED_COPPER_MANHOLE = register("waxed_weathered_copper_manhole", properties -> new TrapDoorBlock(BlockSetType.COPPER, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.WAXED_WEATHERED_COPPER_TRAPDOOR)).registerItem();
	public static final Block WAXED_OXIDIZED_COPPER_MANHOLE = register("waxed_oxidized_copper_manhole", properties -> new TrapDoorBlock(BlockSetType.COPPER, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.WAXED_OXIDIZED_COPPER_TRAPDOOR)).registerItem();

	public static final BlockHeap ZABUTONS = BlockHeap.register(SlabBlock::new, constructor -> constructor + "_zabuton", BlockHeapUtil.mapForColors(() -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)), Psithurism.namespace(), BlockHeapUtil.COLORS).registerBlockItems();

	private static Block register(String path, BlockBehaviour.Properties properties) {
		return register(path, Block::new, properties);
	}

	private static <T extends Block> Block register(String path, BlockFactory<T> factory, BlockBehaviour.Properties properties) {
		return Blocks.register(ResourceKey.create(Registries.BLOCK, Psithurism.createId(path)), factory::make, properties);
	}

	public static void register(AdvancedContainer mod) {
		OxidizableBlocksRegistry.registerWeatheringCopperBlocks(new WeatheringCopperBlocks(
			COPPER_MANHOLE, EXPOSED_COPPER_MANHOLE, WEATHERED_COPPER_MANHOLE, OXIDIZED_COPPER_MANHOLE,
			WAXED_COPPER_MANHOLE, WAXED_EXPOSED_COPPER_MANHOLE, WAXED_WEATHERED_COPPER_MANHOLE, WAXED_OXIDIZED_COPPER_MANHOLE
		));
	}
}
