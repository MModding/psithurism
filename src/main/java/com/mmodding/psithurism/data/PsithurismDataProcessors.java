package com.mmodding.psithurism.data;

import com.mmodding.library.datagen.api.model.block.BlockModelProcessor;
import com.mmodding.library.datagen.api.model.block.DefaultBlockModelProcessing;
import com.mmodding.library.datagen.api.model.block.MModdingModelTemplates;
import com.mmodding.library.java.api.function.AutoMapper;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.block.LargeTatamiBlock;
import com.mmodding.psithurism.block.MediumTatamiBlock;
import com.mmodding.psithurism.block.RiceCrop;
import com.mmodding.psithurism.init.PsithurismBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.dispatch.Variant;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.function.Function;

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

	public static BlockModelProcessor createLargeTatami(ModelTemplate template, Function<Material, TextureMapping> mapping) {
		return (generator, block) -> {
			generator.registerSimpleFlatItemModel(block.asItem());
			Block tatami = BuiltInRegistries.BLOCK.getValueOrThrow(block.builtInRegistryHolder().key().mapIdentifier(id -> id.withPath(s -> s.replace("_mat", ""))));
			Identifier topLeftCorner = template.createWithSuffix(block, "_top_left_corner", mapping.apply(TextureMapping.getBlockTexture(tatami, "_top_left_corner")), generator.modelOutput);
			Identifier bottomLeftCorner = template.createWithSuffix(block, "_bottom_left_corner", mapping.apply(TextureMapping.getBlockTexture(tatami, "_bottom_left_corner")), generator.modelOutput);
			Identifier topRightCorner = template.createWithSuffix(block, "_top_right_corner", mapping.apply(TextureMapping.getBlockTexture(tatami, "_top_right_corner")), generator.modelOutput);
			Identifier bottomRightCorner = template.createWithSuffix(block, "_bottom_right_corner", mapping.apply(TextureMapping.getBlockTexture(tatami, "_bottom_right_corner")), generator.modelOutput);
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
		};
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
