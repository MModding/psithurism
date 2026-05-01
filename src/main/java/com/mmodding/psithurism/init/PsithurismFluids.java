package com.mmodding.psithurism.init;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.psithurism.fluid.OnsenWaterFluid;
import net.minecraft.core.registries.BuiltInRegistries;

public class PsithurismFluids {

	public static final OnsenWaterFluid FLOWING_ONSEN_WATER = new OnsenWaterFluid(false);
	public static final OnsenWaterFluid ONSEN_WATER = new OnsenWaterFluid(true);

	public static void register(AdvancedContainer mod) {
		mod.register(BuiltInRegistries.FLUID, factory -> {
			factory.register("flowing_onsen_water", FLOWING_ONSEN_WATER);
			factory.register("onsen_water", ONSEN_WATER);
		});
	}
}
