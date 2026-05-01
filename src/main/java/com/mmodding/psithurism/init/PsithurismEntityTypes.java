package com.mmodding.psithurism.init;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.entity.Koi;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.fish.AbstractFish;

public class PsithurismEntityTypes {

	public static final EntityType<Koi> KOI = register("koi", EntityType.Builder.of(Koi::new, MobCategory.WATER_AMBIENT)
		.sized(0.7f, 0.4f)
		.eyeHeight(0.26f)
		.clientTrackingRange(4));

	private static <T extends Entity> EntityType<T> register(String path, EntityType.Builder<T> builder) {
		ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, Psithurism.createId(path));
		return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
	}

	public static void register(AdvancedContainer mod) {
		FabricDefaultAttributeRegistry.register(KOI, AbstractFish.createAttributes());
	}
}
