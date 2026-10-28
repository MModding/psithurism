package com.mmodding.psithurism.resource;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.psithurism.init.PsithurismDecoratedPotPatterns;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

public class PsithurismDecoratedPotPatternResources {

	private static void configureWithDefaultAsset(final BootstrapContext<DecoratedPotPattern> registry, final ResourceKey<DecoratedPotPattern> key) {
		registry.register(key, new DecoratedPotPattern(key.identifier().withSuffix("_pottery_pattern")));
	}

	public static void configure(AdvancedContainer mod, BootstrapContext<DecoratedPotPattern> context) {
		configureWithDefaultAsset(context, PsithurismDecoratedPotPatterns.FAN);
		configureWithDefaultAsset(context, PsithurismDecoratedPotPatterns.TORII);
		configureWithDefaultAsset(context, PsithurismDecoratedPotPatterns.YIN_YANG);
		configureWithDefaultAsset(context, PsithurismDecoratedPotPatterns.KITSUNE);

		configureWithDefaultAsset(context, PsithurismDecoratedPotPatterns.SPRING);
		configureWithDefaultAsset(context, PsithurismDecoratedPotPatterns.SUMMER);
		configureWithDefaultAsset(context, PsithurismDecoratedPotPatterns.AUTUMN);
		configureWithDefaultAsset(context, PsithurismDecoratedPotPatterns.WINTER);
	}
}
