package com.mmodding.psithurism.data;

import com.mmodding.library.datagen.api.model.block.DefaultBlockModelProcessing;
import com.mmodding.library.java.api.function.AutoMapper;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.block.RiceCrop;
import com.mmodding.psithurism.init.PsithurismBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import static net.minecraft.client.data.models.BlockModelGenerators.*;

public class PsithurismDataProcessors {

	public static void createPaperWall(BlockModelGenerators generator, Block block) {
		AutoMapper<String> wallToWallBlock = paperWall -> paperWall + "_block";
		Material paneTopMaterial = TextureMapping.getBlockTexture(PsithurismBlocks.PAPER_WALL, "_top");
		DefaultBlockModelProcessing.createPaneLike(generator, block, wallToWallBlock, paneTopMaterial);
	}

	public static void createCherryBonsai(BlockModelGenerators generator, Block block) {
		PsithurismDataProcessors.createBonsai(generator, block, PsithurismTextureModels.CHERRY_BONSAI);
	}

	public static void createDarkCherryBonsai(BlockModelGenerators generator, Block block) {
		PsithurismDataProcessors.createBonsai(generator, block, PsithurismTextureModels.DARK_CHERRY_BONSAI);
	}

	public static void createBonsai(BlockModelGenerators generator, Block block, TexturedModel.Provider bonsaiProvider) {
		generator.registerSimpleFlatItemModel(block.asItem());
		generator.createHorizontallyRotatedBlock(block, bonsaiProvider);
	}

	public static void createDarkCherryGlassPane(BlockModelGenerators generator, Block block) {
		DefaultBlockModelProcessing.createPaneLike(generator, block, new Material(Psithurism.createId("block/dark_cherry_glass_pane_top")));
	}

	public static void createRiceCrop(BlockModelGenerators generator, Block block) {
		generator.registerSimpleFlatItemModel(block.asItem());
		generator.blockStateOutput.accept(
			MultiVariantGenerator.dispatch(block).with(
				PropertyDispatch.initial(((RiceCrop) block).getAgeProperty(), BlockStateProperties.DOUBLE_BLOCK_HALF)
					.generate((age, shape) -> {
						String prefix = age == 1 ? "sprouted_" : "";
						String suffix = switch (shape) {
							case UPPER -> "top";
							case LOWER -> "bottom";
						};
						Identifier model = Psithurism.createId("block/" + prefix + "rice_" + suffix);
						ModelTemplates.CROP.create(model, TextureMapping.crop(new Material(model)), generator.modelOutput);
						return plainVariant(model);
					})
			)
		);
	}

	public static void createStoneLantern(BlockModelGenerators generator, Block block) {
		generator.registerSimpleFlatItemModel(block.asItem());
		Identifier unlit = PsithurismModelTemplates.STONE_LANTERN.create(
			block,
			new TextureMapping()
				.put(TextureSlot.ALL, TextureMapping.getBlockTexture(block))
				.put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(Blocks.STONE_BRICKS)),
			generator.modelOutput
		);
		Identifier lit = PsithurismModelTemplates.STONE_LANTERN.create(
			ModelLocationUtils.getModelLocation(block, "_lit"),
			new TextureMapping()
				.put(TextureSlot.ALL, TextureMapping.getBlockTexture(block, "_lit"))
				.put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(Blocks.STONE_BRICKS)),
			generator.modelOutput
		);
		generator.blockStateOutput.accept(
			MultiVariantGenerator.dispatch(block)
				.with(
					PropertyDispatch.initial(BlockStateProperties.LIT)
						.select(false, plainVariant(unlit))
						.select(true, plainVariant(lit))
				)
				.with(ROTATION_HORIZONTAL_FACING)
		);
	}
}
