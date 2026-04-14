package com.mmodding.psithurism.data;

import com.mmodding.library.datagen.api.model.block.DefaultBlockModelProcessing;
import com.mmodding.library.java.api.function.AutoMapper;
import com.mmodding.psithurism.init.PsithurismBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;

public class PsithurismDataProcessors {

	public static void createRotatedPillar(BlockModelGenerators generator, Block block) {
		if (block.equals(PsithurismBlocks.DARK_CHERRY_LOG)) {
			Identifier model = ModelTemplates.CUBE_COLUMN.create(block, PsithurismTextureMappings.DARK_CHERRY_LOG, generator.modelOutput);
			MultiVariant horizontalModel = BlockModelGenerators.plainVariant(ModelTemplates.CUBE_COLUMN_HORIZONTAL.create(block, PsithurismTextureMappings.DARK_CHERRY_LOG, generator.modelOutput));
			generator.blockStateOutput.accept(BlockModelGenerators.createRotatedPillarWithHorizontalVariant(block, BlockModelGenerators.plainVariant(model), horizontalModel));
			generator.registerSimpleItemModel(block, model);
		}
		else if (block.equals(PsithurismBlocks.DARK_CHERRY_WOOD)) {
			TextureMapping woodMapping = PsithurismTextureMappings.DARK_CHERRY_LOG.copyAndUpdate(TextureSlot.END, PsithurismTextureMappings.DARK_CHERRY_LOG.get(TextureSlot.SIDE));
			Identifier model = ModelTemplates.CUBE_COLUMN.create(block, woodMapping, generator.modelOutput);
			generator.blockStateOutput.accept(BlockModelGenerators.createAxisAlignedPillarBlock(block, BlockModelGenerators.plainVariant(model)));
			generator.registerSimpleItemModel(block, model);
		}
	}

	public static void createPaperWall(BlockModelGenerators generator, Block block) {
		AutoMapper<String> wallToWallBlock = paperWall -> paperWall + "_block";
		Material paneTopMaterial = TextureMapping.getBlockTexture(PsithurismBlocks.PAPER_WALL, "_top");
		DefaultBlockModelProcessing.createPaneLike(generator, block, wallToWallBlock, paneTopMaterial);
	}
}
