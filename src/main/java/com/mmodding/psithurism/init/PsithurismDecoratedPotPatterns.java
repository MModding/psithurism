package com.mmodding.psithurism.init;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.psithurism.Psithurism;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

public class PsithurismDecoratedPotPatterns {

	public static final ResourceKey<DecoratedPotPattern> FAN = register("fan");
	public static final ResourceKey<DecoratedPotPattern> TORII = register("torii");

	public static ResourceKey<DecoratedPotPattern> register(String path) {
		ResourceKey<DecoratedPotPattern> key = ResourceKey.create(Registries.DECORATED_POT_PATTERN, Psithurism.createId(path));
		Registry.register(BuiltInRegistries.DECORATED_POT_PATTERN, key, new DecoratedPotPattern(Psithurism.createId(path + "_pottery_pattern")));
		return key;
	}

	public static void register(AdvancedContainer mod) {}
}
