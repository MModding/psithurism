package com.mmodding.psithurism.init;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.psithurism.Psithurism;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class PsithurismPlacedFeatures {

	public static final ResourceKey<PlacedFeature> DARK_CHERRY_CHECKED = create("dark_cherry_checked");
	public static final ResourceKey<PlacedFeature> DARK_CHERRY_BEES_005 = create("dark_cherry_bees_005");
	public static final ResourceKey<PlacedFeature> CHERRY_GROOVE_DARK_CHERRY = create("chery_groove_dark_cherry");
	public static final ResourceKey<PlacedFeature> FLOWER_DARK_CHERRY = create("flower_dark_cherry");

	private static ResourceKey<PlacedFeature> create(String path) {
		return ResourceKey.create(Registries.PLACED_FEATURE, Psithurism.createId(path));
	}

	public static void register(AdvancedContainer mod) {
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.CHERRY_GROVE), GenerationStep.Decoration.VEGETAL_DECORATION, CHERRY_GROOVE_DARK_CHERRY);
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.CHERRY_GROVE), GenerationStep.Decoration.VEGETAL_DECORATION, FLOWER_DARK_CHERRY);
	}
}
