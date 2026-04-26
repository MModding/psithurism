package com.mmodding.psithurism.init;

import com.mmodding.library.block.api.catalog.SimpleHorizontalFacingBlock;
import com.mmodding.library.block.api.util.BlockFactory;
import com.mmodding.library.block.api.wrapper.BlockRelatives;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.java.api.function.AutoMapper;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.block.RiceCrop;
import com.mmodding.psithurism.block.StoneLanternBlock;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.PushReaction;

public class PsithurismBlocks {

	public static final Block WHITE_PETALS = register("white_petals", FlowerBedBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_PETALS)).registerItem();

	public static final Block CHERRY_BONSAI = register("cherry_bonsai", SimpleHorizontalFacingBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WOOD).noOcclusion()).registerItem();
	public static final Block DARK_CHERRY_BONSAI = register("dark_cherry_bonsai", SimpleHorizontalFacingBlock::new, BlockBehaviour.Properties.ofFullCopy(PsithurismWoodSets.DARK_CHERRY.getWood()).noOcclusion()).registerItem();

	public static final Block GOLDEN_CHAIN = register("golden_chain", ChainBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_CHAIN)).registerItem();

	public static final Block PAPER_WALL_BLOCK = register("paper_wall_block", BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();
	public static final Block LARGE_PAPER_WALL_BLOCK = register("large_paper_wall_block", BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();
	public static final Block HORIZONTAL_PAPER_WALL_BLOCk = register("horizontal_paper_wall_block", BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();
	public static final Block VERTICAL_PAPER_WALL_BLOCk = register("vertical_paper_wall_block", BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();
	public static final Block PAPER_WALL = register("paper_wall", IronBarsBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();
	public static final Block LARGE_PAPER_WALL = register("large_paper_wall", IronBarsBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();
	public static final Block HORIZONTAL_PAPER_WALL = register("horizontal_paper_wall", IronBarsBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();
	public static final Block VERTICAL_PAPER_WALL = register("vertical_paper_wall", IronBarsBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();

	public static final Block STONE_LANTERN = register("stone_lantern", StoneLanternBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).sound(SoundType.STONE).lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 15 : 0)).registerItem();

	public static final BlockRelatives ASHINO_STONE = BlockRelatives.registerStone(Psithurism.createId("ashino_stone"), AutoMapper.identity(), false, false);
	public static final BlockRelatives ASHINO_BRICKS = BlockRelatives.registerStone(Psithurism.createId("ashino_brick"), true, AutoMapper.identity(), false, false);
	public static final BlockRelatives MOSSY_ASHINO_BRICKS = BlockRelatives.registerStone(Psithurism.createId("mossy_ashino_brick"), true, AutoMapper.identity(), false, false);

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

	public static final Block BLACK_ZABUTON = register("black_zabuton", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)).registerItem();
	public static final Block BLUE_ZABUTON = register("blue_zabuton", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)).registerItem();
	public static final Block BROWN_ZABUTON = register("brown_zabuton", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)).registerItem();
	public static final Block CYAN_ZABUTON = register("cyan_zabuton", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)).registerItem();
	public static final Block GRAY_ZABUTON = register("gray_zabuton", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)).registerItem();
	public static final Block GREEN_ZABUTON = register("green_zabuton", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)).registerItem();
	public static final Block LIGHT_BLUE_ZABUTON = register("light_blue_zabuton", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)).registerItem();
	public static final Block LIGHT_GRAY_ZABUTON = register("light_gray_zabuton", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)).registerItem();
	public static final Block LIME_ZABUTON = register("lime_zabuton", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)).registerItem();
	public static final Block MAGENTA_ZABUTON = register("magenta_zabuton", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)).registerItem();
	public static final Block ORANGE_ZABUTON = register("orange_zabuton", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)).registerItem();
	public static final Block PINK_ZABUTON = register("pink_zabuton", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)).registerItem();
	public static final Block PURPLE_ZABUTON = register("purple_zabuton", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)).registerItem();
	public static final Block RED_ZABUTON = register("red_zabuton", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)).registerItem();
	public static final Block WHITE_ZABUTON = register("white_zabuton", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)).registerItem();
	public static final Block YELLOW_ZABUTON = register("yellow_zabuton", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)).registerItem();

	private static Block register(String path, BlockBehaviour.Properties properties) {
		return register(path, Block::new, properties);
	}

	private static <T extends Block>Block register(String path, BlockFactory<T> factory, BlockBehaviour.Properties properties) {
		return Blocks.register(ResourceKey.create(Registries.BLOCK, Psithurism.createId(path)), factory::make, properties);
	}

	public static void register(AdvancedContainer mod) {
		OxidizableBlocksRegistry.registerWeatheringCopperBlocks(new WeatheringCopperBlocks(
			COPPER_MANHOLE, EXPOSED_COPPER_MANHOLE, WEATHERED_COPPER_MANHOLE, OXIDIZED_COPPER_MANHOLE,
			WAXED_COPPER_MANHOLE, WAXED_EXPOSED_COPPER_MANHOLE, WAXED_WEATHERED_COPPER_MANHOLE, WAXED_OXIDIZED_COPPER_MANHOLE
		));
	}
}
