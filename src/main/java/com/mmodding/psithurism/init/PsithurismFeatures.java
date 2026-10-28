package com.mmodding.psithurism.init;

import com.mmodding.psithurism.Psithurism;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.Feature;

public class PsithurismFeatures {

	public static final ResourceKey<Feature> DARK_CHERRY = create("dark_cherry");
	public static final ResourceKey<Feature> DARK_CHERRY_BEES_005 = create("dark_cherry_bees_005");
	public static final ResourceKey<Feature> FLOWER_DARK_CHERRY = create("flower_dark_cherry");
	public static final ResourceKey<Feature> ONSEN_WATER_LAKE = create("onsen_water_lake");

	private static ResourceKey<Feature> create(String path) {
		return ResourceKey.create(Registries.FEATURE, Psithurism.createId(path));
	}
}
