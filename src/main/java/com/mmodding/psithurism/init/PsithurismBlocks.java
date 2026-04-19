package com.mmodding.psithurism.init;

import com.mmodding.library.block.api.util.BlockFactory;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.block.StoneLanternBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;

public class PsithurismBlocks {

	public static final BlockSetType DARK_CHERRY_SET = BlockSetTypeBuilder.copyOf(BlockSetType.CHERRY).register(Psithurism.createId("dark_cherry"));
	public static final WoodType DARK_CHERRY_TYPE = WoodTypeBuilder.copyOf(WoodType.CHERRY).register(Psithurism.createId("dark_cherry"), DARK_CHERRY_SET);

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

	private static Block register(String path, BlockBehaviour.Properties properties) {
		return register(path, Block::new, properties);
	}

	private static <T extends Block>Block register(String path, BlockFactory<T> factory, BlockBehaviour.Properties properties) {
		return Blocks.register(ResourceKey.create(Registries.BLOCK, Psithurism.createId(path)), factory::make, properties);
	}

	public static void register(AdvancedContainer mod) {}
}
