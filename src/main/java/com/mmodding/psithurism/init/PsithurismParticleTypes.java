package com.mmodding.psithurism.init;

import com.mmodding.library.core.api.AdvancedContainer;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;

public class PsithurismParticleTypes {

	public static final SimpleParticleType DARK_CHERRY_LEAVES = FabricParticleTypes.simple();
	public static final SimpleParticleType ONSEN_STEAM = FabricParticleTypes.simple();

	public static void register(AdvancedContainer mod) {
		mod.register(BuiltInRegistries.PARTICLE_TYPE, factory -> {
			factory.register("dark_cherry_leaves", DARK_CHERRY_LEAVES);
			factory.register("onsen_steam", ONSEN_STEAM);
		});
	}
}
