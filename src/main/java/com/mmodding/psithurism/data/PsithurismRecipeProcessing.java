package com.mmodding.psithurism.data;

import com.mmodding.library.datagen.api.recipe.RecipeHelper;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.init.PsithurismBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class PsithurismRecipeProcessing {

	public static void createZabuton(RecipeHelper helper, ItemLike like) {
		String color = like.asItem().builtInRegistryHolder().key().identifier().getPath().replace("_zabuton", "");
		Block wool = BuiltInRegistries.BLOCK.getValueOrThrow(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace(color + "_wool")));
		helper.shaped(
			4, RecipeCategory.BUILDING_BLOCKS,
			recipe -> recipe.pattern("TWT", "TWT")
				.key('T', PsithurismBlocks.THREAD)
				.key('W', wool)
		);
	}

	public static void createFuton(RecipeHelper helper, ItemLike like) {
		String color = like.asItem().builtInRegistryHolder().key().identifier().getPath().replace("_futon", "");
		Block zabuton = BuiltInRegistries.BLOCK.getValueOrThrow(ResourceKey.create(Registries.BLOCK, Psithurism.createId(color + "_zabuton")));
		helper.shaped(
			4, RecipeCategory.BUILDING_BLOCKS,
			recipe -> recipe.pattern("ZZW")
				.key('Z', zabuton)
				.key('W', Blocks.WHITE_WOOL)
		);
	}
}
