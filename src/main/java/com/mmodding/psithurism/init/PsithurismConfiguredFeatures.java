package com.mmodding.psithurism.init;

import com.mmodding.psithurism.Psithurism;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class PsithurismConfiguredFeatures {

	public static final ResourceKey<ConfiguredFeature<?, ?>> DARK_CHERRY = create("dark_cherry");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DARK_CHERRY_BEES_005 = create("dark_cherry_bees_005");
	public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_DARK_CHERRY = create("flower_dark_cherry");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ONSEN_WATER_LAKE = create("onsen_water_lake");

	private static ResourceKey<ConfiguredFeature<?, ?>> create(String path) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, Psithurism.createId(path));
	}
}
