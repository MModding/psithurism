package com.mmodding.psithurism.init;

import com.mmodding.library.block.api.util.BlockFactory;
import com.mmodding.library.block.api.wrapper.BlockRelatives;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.psithurism.Psithurism;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;

public class PsithurismBlocks {

	public static final Block DARK_CHERRY_LOG = register("dark_cherry_log", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LOG)).registerItem();
	public static final Block DARK_CHERRY_WOOD = register("dark_cherry_wood", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WOOD)).registerItem();
	public static final BlockRelatives DARK_CHERRY = BlockRelatives.createWood(Psithurism.createId("dark_cherry"), WoodType.CHERRY);
	public static final Block PAPER_WALL = register("paper_wall", BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
	public static final Block HORIZONTAL_PAPER_WALL = register("horizontal_paper_wall", BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
	public static final Block VERTICAL_PAPER_WALL = register("vertical_paper_wall", BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));

	private static Block register(String path, BlockBehaviour.Properties properties) {
		return register(path, Block::new, properties);
	}

	private static <T extends Block>Block register(String path, BlockFactory<T> factory, BlockBehaviour.Properties properties) {
		return Blocks.register(ResourceKey.create(Registries.BLOCK, Psithurism.createId(path)), factory::make, properties);
	}

	public static void register(AdvancedContainer mod) {}
}
