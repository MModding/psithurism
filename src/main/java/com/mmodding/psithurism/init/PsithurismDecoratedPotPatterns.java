package com.mmodding.psithurism.init;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.psithurism.Psithurism;
import net.fabricmc.fabric.api.registry.DecoratedPotPatternRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

public class PsithurismDecoratedPotPatterns {

	public static final ResourceKey<DecoratedPotPattern> FAN = register("fan");
	public static final ResourceKey<DecoratedPotPattern> TORII = register("torii");
	public static final ResourceKey<DecoratedPotPattern> YIN_YANG = register("yin_yang");
	public static final ResourceKey<DecoratedPotPattern> KITSUNE = register("kitsune");

	public static ResourceKey<DecoratedPotPattern> register(String path) {
		ResourceKey<DecoratedPotPattern> key = ResourceKey.create(Registries.DECORATED_POT_PATTERN, Psithurism.createId(path));
		Registry.register(BuiltInRegistries.DECORATED_POT_PATTERN, key, new DecoratedPotPattern(Psithurism.createId(path + "_pottery_pattern")));
		return key;
	}

	public static void register(AdvancedContainer mod) {
		DecoratedPotPatternRegistry.registerPattern(BuiltInRegistries.ITEM.getResourceKey(PsithurismItems.FAN_POTTERY_SHERD).orElseThrow(), FAN);
		DecoratedPotPatternRegistry.registerPattern(BuiltInRegistries.ITEM.getResourceKey(PsithurismItems.TORII_POTTERY_SHERD).orElseThrow(), TORII);
		DecoratedPotPatternRegistry.registerPattern(BuiltInRegistries.ITEM.getResourceKey(PsithurismItems.YIN_YANG_POTTERY_SHERD).orElseThrow(), YIN_YANG);
		DecoratedPotPatternRegistry.registerPattern(BuiltInRegistries.ITEM.getResourceKey(PsithurismItems.KITSUNE_SHERD).orElseThrow(), KITSUNE);
	}
}
