package com.mmodding.psithurism.init;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;

public class PsithurismDataComponents {

	public static final DataComponentType<Boolean> WORN_MASK = DataComponentType.<Boolean>builder()
		.persistent(Codec.BOOL)
		.networkSynchronized(ByteBufCodecs.BOOL)
		.build();

	public static void register(AdvancedContainer mod) {
		mod.register(BuiltInRegistries.DATA_COMPONENT_TYPE, "worn_mask", WORN_MASK);
	}
}
