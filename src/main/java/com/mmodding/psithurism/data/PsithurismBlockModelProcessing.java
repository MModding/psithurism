package com.mmodding.psithurism.data;

import com.mmodding.library.block.api.catalog.SimpleBedBlock;
import com.mmodding.library.datagen.api.model.block.DefaultBlockModelProcessing;
import com.mmodding.library.datagen.api.model.block.MModdingModelTemplates;
import com.mmodding.library.datagen.api.model.block.MModdingTextureMappings;
import com.mmodding.library.java.api.function.AutoMapper;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.block.*;
import com.mmodding.psithurism.init.PsithurismBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.Map;

import static net.minecraft.client.data.models.BlockModelGenerators.*;

public class PsithurismBlockModelProcessing {

	public static void createPaperWall(BlockModelGenerators generator, Block block) {
		AutoMapper<String> wallToWallBlock = paperWall -> paperWall + "_block";
		Material paneTopMaterial = TextureMapping.getBlockTexture(PsithurismBlocks.PAPER_WALL, "_top");
		DefaultBlockModelProcessing.createPaneLike(generator, block, wallToWallBlock, paneTopMaterial);
	}

	public static void createCherryBonsai(BlockModelGenerators generator, Block block) {
		PsithurismBlockModelProcessing.createBonsai(generator, block, PsithurismTexturedModels.CHERRY_BONSAI);
	}

	public static void createDarkCherryBonsai(BlockModelGenerators generator, Block block) {
		PsithurismBlockModelProcessing.createBonsai(generator, block, PsithurismTexturedModels.DARK_CHERRY_BONSAI);
	}

	public static void createBonsai(BlockModelGenerators generator, Block block, TexturedModel.Provider bonsaiProvider) {
		generator.registerSimpleFlatItemModel(block.asItem());
		generator.createHorizontallyRotatedBlock(block, bonsaiProvider);
	}

	public static void createAshinoStonePedestal(BlockModelGenerators generator, Block block) {
		generator.registerSimpleFlatItemModel(block.asItem());
		generator.blockStateOutput.accept(
			MultiVariantGenerator.dispatch(block, plainVariant(ModelLocationUtils.getModelLocation(block)))
				.with(createRotatedPillar())
		);
	}

	public static void createDarkCherryGlassPane(BlockModelGenerators generator, Block block) {
		DefaultBlockModelProcessing.createPaneLike(generator, block, new Material(Psithurism.createId("block/dark_cherry_glass_pane_top")));
	}

	public static void createFuton(BlockModelGenerators generator, Block block) {
		Block wool = BuiltInRegistries.BLOCK.getValueOrThrow(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace(block.builtInRegistryHolder().key().identifier().getPath().replace("_futon", "_wool"))));
		Identifier model = PsithurismModelTemplates.FUTON.create(block, MModdingTextureMappings.specificParticle(block, wool), generator.modelOutput);
		Identifier empty = ModelTemplates.PARTICLE_ONLY.create(ModelLocationUtils.getModelLocation(block, "_empty"), TextureMapping.particle(wool), generator.modelOutput);
		generator.blockStateOutput.accept(
			MultiVariantGenerator.dispatch(block)
				.with(
					PropertyDispatch.initial(SimpleBedBlock.PART)
						.select(BedPart.HEAD, plainVariant(model))
						.select(BedPart.FOOT, plainVariant(empty))
				)
				.with(ROTATION_HORIZONTAL_FACING)
		);
	}

	public static void createRiceCrop(BlockModelGenerators generator, Block block) {
		generator.registerSimpleFlatItemModel(block.asItem());
		generator.blockStateOutput.accept(
			MultiVariantGenerator.dispatch(block).with(
				PropertyDispatch.initial(((RiceCropBlock) block).getAgeProperty(), BlockStateProperties.DOUBLE_BLOCK_HALF)
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

	public static void createSoyaCrop(BlockModelGenerators generator, Block block) {
		generator.registerSimpleFlatItemModel(block.asItem());
		generator.blockStateOutput.accept(
			MultiVariantGenerator.dispatch(block).with(
				PropertyDispatch.initial(((SoyaCropBlock) block).getAgeProperty())
					.generate(age -> {
						String prefix = age == 1 ? "sprouted_" : "";
						Identifier model = Psithurism.createId("block/" + prefix + "soya");
						ModelTemplates.CROP.create(model, TextureMapping.crop(new Material(model)), generator.modelOutput);
						return plainVariant(model);
					})
			)
		);
	}

	public static void createSmallTatamiMat(BlockModelGenerators generator, Block block) {
		generator.registerSimpleFlatItemModel(block.asItem());
		String tatamiPath = block.builtInRegistryHolder().key().identifier().getPath().replace("_mat", "");
		Identifier model = ModelTemplates.CARPET.create(ModelLocationUtils.getModelLocation(block), new TextureMapping().put(TextureSlot.WOOL, new Material(Psithurism.createId("block/" + tatamiPath))), generator.modelOutput);
		generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, plainVariant(model)).with(ROTATION_HORIZONTAL_FACING));
	}

	public static void createSmallTatami(BlockModelGenerators generator, Block block) {
		generator.registerSimpleFlatItemModel(block.asItem());
		Identifier model = TexturedModel.CUBE.create(block, generator.modelOutput);
		generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, plainVariant(model)).with(ROTATION_HORIZONTAL_FACING));
	}

	public static void createMediumTatamiMat(BlockModelGenerators generator, Block block) {
		generator.registerSimpleFlatItemModel(block.asItem());
		String tatamiPath = block.builtInRegistryHolder().key().identifier().getPath().replace("_mat", "");
		Material left = new Material(Psithurism.createId("block/" + tatamiPath + "_left_side"));
		Material right = new Material(Psithurism.createId("block/" + tatamiPath + "_right_side"));
		Identifier leftSide = ModelTemplates.CARPET.createWithSuffix(
			block, "_left_side", new TextureMapping().put(TextureSlot.WOOL, left), generator.modelOutput
		);
		Identifier rightSide = ModelTemplates.CARPET.createWithSuffix(
			block, "_right_side", new TextureMapping().put(TextureSlot.WOOL, right), generator.modelOutput
		);
		generator.blockStateOutput.accept(
			MultiVariantGenerator.dispatch(block)
				.with(
					PropertyDispatch.initial(MediumTatamiBlock.X)
						.select(0, plainVariant(leftSide))
						.select(1, plainVariant(rightSide))
				)
				.with(ROTATION_HORIZONTAL_FACING)
		);
	}

	public static void createMediumTatami(BlockModelGenerators generator, Block block) {
		generator.registerSimpleFlatItemModel(block.asItem());
		String tatamiPath = block.builtInRegistryHolder().key().identifier().getPath();
		Material single = new Material(Psithurism.createId("block/" + tatamiPath.replace("medium_", "small_")));
		Material left = new Material(Psithurism.createId("block/" + tatamiPath + "_left_side"));
		Material right = new Material(Psithurism.createId("block/" + tatamiPath + "_right_side"));
		Identifier leftSide = MModdingModelTemplates.CUBE_ROLL.createWithSuffix(
			block, "_left_side",
			new TextureMapping().put(TextureSlot.SIDE, left).put(TextureSlot.END, single),
			generator.modelOutput
		);
		Identifier rightSide = MModdingModelTemplates.CUBE_ROLL.createWithSuffix(
			block, "_right_side",
			new TextureMapping().put(TextureSlot.SIDE, right).put(TextureSlot.END, single),
			generator.modelOutput
		);
		generator.blockStateOutput.accept(
			MultiVariantGenerator.dispatch(block)
				.with(
					PropertyDispatch.initial(MediumTatamiBlock.X)
						.select(0, plainVariant(leftSide))
						.select(1, plainVariant(rightSide))
				)
				.with(ROTATION_HORIZONTAL_FACING)
		);
	}

	public static void createLargeTatamiMat(BlockModelGenerators generator, Block block) {
		generator.registerSimpleFlatItemModel(block.asItem());
		String tatamiPath = block.builtInRegistryHolder().key().identifier().getPath().replace("_mat", "");
		Material topLeft = new Material(Psithurism.createId("block/" + tatamiPath + "_top_left_corner"));
		Material bottomLeft = new Material(Psithurism.createId("block/" + tatamiPath + "_bottom_left_corner"));
		Material topRight = new Material(Psithurism.createId("block/" + tatamiPath + "_top_right_corner"));
		Material bottomRight = new Material(Psithurism.createId("block/" + tatamiPath + "_bottom_right_corner"));
		Identifier topLeftCorner = ModelTemplates.CARPET.createWithSuffix(
			block, "_top_left_corner", new TextureMapping().put(TextureSlot.WOOL, topLeft), generator.modelOutput
		);
		Identifier bottomLeftCorner = ModelTemplates.CARPET.createWithSuffix(
			block, "_bottom_left_corner", new TextureMapping().put(TextureSlot.WOOL, bottomLeft), generator.modelOutput
		);
		Identifier topRightCorner = ModelTemplates.CARPET.createWithSuffix(
			block, "_top_right_corner", new TextureMapping().put(TextureSlot.WOOL, topRight), generator.modelOutput
		);
		Identifier bottomRightCorner = ModelTemplates.CARPET.createWithSuffix(
			block, "_bottom_right_corner", new TextureMapping().put(TextureSlot.WOOL, bottomRight), generator.modelOutput
		);
		generator.blockStateOutput.accept(
			MultiVariantGenerator.dispatch(block)
				.with(
					PropertyDispatch.initial(LargeTatamiBlock.X, LargeTatamiBlock.Z)
						.select(0, 0, plainVariant(topLeftCorner))
						.select(0, 1, plainVariant(bottomLeftCorner))
						.select(1, 0, plainVariant(topRightCorner))
						.select(1, 1, plainVariant(bottomRightCorner))
				)
				.with(ROTATION_HORIZONTAL_FACING)
		);
	}

	public static void createLargeTatami(BlockModelGenerators generator, Block block) {
		generator.registerSimpleFlatItemModel(block.asItem());
		String tatamiPath = block.builtInRegistryHolder().key().identifier().getPath().replace("_mat", "");
		Material singleMaterial = new Material(Psithurism.createId("block/" + tatamiPath.replace("large_", "small_")));
		Material leftSideMaterial = new Material(Psithurism.createId("block/" + tatamiPath.replace("large_", "medium_") + "_left_side"));
		Material rightSideMaterial = new Material(Psithurism.createId("block/" + tatamiPath.replace("large_", "medium_") + "_right_side"));
		Material topLeftMaterial = new Material(Psithurism.createId("block/" + tatamiPath + "_top_left_corner"));
		Material bottomLeftMaterial = new Material(Psithurism.createId("block/" + tatamiPath + "_bottom_left_corner"));
		Material topRightMaterial = new Material(Psithurism.createId("block/" + tatamiPath + "_top_right_corner"));
		Material bottomRightMaterial = new Material(Psithurism.createId("block/" + tatamiPath + "_bottom_right_corner"));
		Identifier topLeftCorner = MModdingModelTemplates.CUBE_NORTH_INVERTED.createWithSuffix(
			block,
			"_top_left_corner",
			new TextureMapping()
				.put(TextureSlot.NORTH, leftSideMaterial)
				.put(TextureSlot.SOUTH, leftSideMaterial)
				.put(TextureSlot.EAST, leftSideMaterial)
				.put(TextureSlot.WEST, leftSideMaterial)
				.put(TextureSlot.UP, topLeftMaterial)
				.put(TextureSlot.DOWN, bottomLeftMaterial)
				.put(TextureSlot.PARTICLE, singleMaterial),
			generator.modelOutput
		);
		Identifier bottomLeftCorner = MModdingModelTemplates.CUBE_NORTH_INVERTED.createWithSuffix(
			block,
			"_bottom_left_corner",
			new TextureMapping()
				.put(TextureSlot.NORTH, leftSideMaterial)
				.put(TextureSlot.SOUTH, leftSideMaterial)
				.put(TextureSlot.EAST, rightSideMaterial)
				.put(TextureSlot.WEST, rightSideMaterial)
				.put(TextureSlot.UP, bottomLeftMaterial)
				.put(TextureSlot.DOWN, topLeftMaterial)
				.put(TextureSlot.PARTICLE, singleMaterial),
			generator.modelOutput
		);
		Identifier topRightCorner = MModdingModelTemplates.CUBE_NORTH_INVERTED.createWithSuffix(
			block,
			"_top_right_corner",
			new TextureMapping()
				.put(TextureSlot.NORTH, rightSideMaterial)
				.put(TextureSlot.SOUTH, rightSideMaterial)
				.put(TextureSlot.EAST, rightSideMaterial)
				.put(TextureSlot.WEST, rightSideMaterial)
				.put(TextureSlot.UP, topRightMaterial)
				.put(TextureSlot.DOWN, bottomRightMaterial)
				.put(TextureSlot.PARTICLE, singleMaterial),
			generator.modelOutput
		);
		Identifier bottomRightCorner = MModdingModelTemplates.CUBE_NORTH_INVERTED.createWithSuffix(
			block,
			"_bottom_right_corner",
			new TextureMapping()
				.put(TextureSlot.NORTH, rightSideMaterial)
				.put(TextureSlot.SOUTH, rightSideMaterial)
				.put(TextureSlot.EAST, leftSideMaterial)
				.put(TextureSlot.WEST, leftSideMaterial)
				.put(TextureSlot.UP, bottomRightMaterial)
				.put(TextureSlot.DOWN, topRightMaterial)
				.put(TextureSlot.PARTICLE, singleMaterial),
			generator.modelOutput
		);
		generator.blockStateOutput.accept(
			MultiVariantGenerator.dispatch(block)
				.with(
					PropertyDispatch.initial(LargeTatamiBlock.X, LargeTatamiBlock.Z)
						.select(0, 0, plainVariant(topLeftCorner))
						.select(0, 1, plainVariant(bottomLeftCorner))
						.select(1, 0, plainVariant(topRightCorner))
						.select(1, 1, plainVariant(bottomRightCorner))
				)
				.with(ROTATION_HORIZONTAL_FACING)
		);
	}

	public static void createOnsenWater(BlockModelGenerators generator, Block block) {
		Identifier model = ModelTemplates.PARTICLE_ONLY.create(block, TextureMapping.particle(block), generator.modelOutput);
		generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, plainVariant(model)));
	}

	public static void createTeruTeruBozu(BlockModelGenerators generator, Block block) {
		ItemModel.Unbaked itemDefault = ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(block, "_necklace_red"));
		ItemModel.Unbaked itemUnbaked = ItemModelUtils.selectBlockItemProperty(TeruTeruBozuBlock.NECKLACE, itemDefault, Map.of(
			0, ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(block, "_necklace_blue")),
			1, ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(block, "_necklace_indigo")),
			2, ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(block, "_necklace_purple")),
			3, ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(block, "_necklace_fuchsia")),
			4, itemDefault
		));
		generator.itemModelOutput.accept(block.asItem(), itemUnbaked);
		Identifier blue = PsithurismModelTemplates.TERU_TERU_BOZU.createWithSuffix(block, "_necklace_blue", new TextureMapping().put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(block, "_necklace_blue")).put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(Blocks.WHITE_WOOL)), generator.modelOutput);
		Identifier indigo = PsithurismModelTemplates.TERU_TERU_BOZU.createWithSuffix(block, "_necklace_indigo", new TextureMapping().put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(block, "_necklace_indigo")).put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(Blocks.WHITE_WOOL)), generator.modelOutput);
		Identifier purple = PsithurismModelTemplates.TERU_TERU_BOZU.createWithSuffix(block, "_necklace_purple", new TextureMapping().put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(block, "_necklace_purple")).put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(Blocks.WHITE_WOOL)), generator.modelOutput);
		Identifier fuchsia = PsithurismModelTemplates.TERU_TERU_BOZU.createWithSuffix(block, "_necklace_fuchsia", new TextureMapping().put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(block, "_necklace_fuchsia")).put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(Blocks.WHITE_WOOL)), generator.modelOutput);
		Identifier red = PsithurismModelTemplates.TERU_TERU_BOZU.createWithSuffix(block, "_necklace_red", new TextureMapping().put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(block, "_necklace_red")).put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(Blocks.WHITE_WOOL)), generator.modelOutput);
		generator.blockStateOutput.accept(
			MultiVariantGenerator.dispatch(block)
				.with(
					PropertyDispatch.initial(TeruTeruBozuBlock.NECKLACE)
						.select(0, plainVariant(blue))
						.select(1, plainVariant(indigo))
						.select(2, plainVariant(purple))
						.select(3, plainVariant(fuchsia))
						.select(4, plainVariant(red))
				)
				.with(ROTATION_HORIZONTAL_FACING)
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
