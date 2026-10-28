package com.mmodding.psithurism.init;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.psithurism.Psithurism;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

public class PsithurismDecoratedPotPatterns {

	public static final ResourceKey<DecoratedPotPattern> FAN = Psithurism.createKey(Registries.DECORATED_POT_PATTERN, "fan");
	public static final ResourceKey<DecoratedPotPattern> TORII = Psithurism.createKey(Registries.DECORATED_POT_PATTERN, "torii");
	public static final ResourceKey<DecoratedPotPattern> YIN_YANG = Psithurism.createKey(Registries.DECORATED_POT_PATTERN, "yin_yang");
	public static final ResourceKey<DecoratedPotPattern> KITSUNE = Psithurism.createKey(Registries.DECORATED_POT_PATTERN, "kitsune");

	public static final ResourceKey<DecoratedPotPattern> SPRING = Psithurism.createKey(Registries.DECORATED_POT_PATTERN, "spring");
	public static final ResourceKey<DecoratedPotPattern> SUMMER = Psithurism.createKey(Registries.DECORATED_POT_PATTERN, "summer");
	public static final ResourceKey<DecoratedPotPattern> AUTUMN = Psithurism.createKey(Registries.DECORATED_POT_PATTERN, "autumn");
	public static final ResourceKey<DecoratedPotPattern> WINTER = Psithurism.createKey(Registries.DECORATED_POT_PATTERN, "winter");
}
