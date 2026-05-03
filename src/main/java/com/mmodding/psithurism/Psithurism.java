package com.mmodding.psithurism;

import com.mmodding.library.core.api.registry.IdentifierUtil;
import com.mmodding.psithurism.init.*;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.core.api.ExtendedModInitializer;
import com.mmodding.library.core.api.management.ElementsManager;
import com.mmodding.psithurism.resource.PsithurismFeaturePacks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;

public class Psithurism implements ExtendedModInitializer {

	@Override
	public void setupManager(ElementsManager manager) {
		manager.content(PsithurismDecoratedPotPatterns::register);
		manager.content(PsithurismDataComponents::register);
		manager.content(PsithurismParticleTypes::register);
		manager.content(PsithurismEntityTypes::register);
		manager.content(PsithurismWoodSets::register);
		manager.content(PsithurismFluids::register);
		manager.content(PsithurismBlocks::register);
		manager.content(PsithurismBlockEntityTypes::register);
		manager.content(PsithurismItems::register);
		manager.content(PsithurismItemCreativeTabs::register);
		manager.content(PsithurismPlacedFeatures::register);
		manager.resource(Registries.CONFIGURED_FEATURE, PsithurismFeaturePacks::registerConfigs);
		manager.resource(Registries.PLACED_FEATURE, PsithurismFeaturePacks::registerPlacements);
	}

	@Override
	public void onInitialize(AdvancedContainer mod) {
		mod.logger().info("Minecraft, Japan. 💐");
	}

	public static Identifier createTexture(String path) {
		return IdentifierUtil.texture(Psithurism.namespace(), path);
	}

	public static Identifier createId(String path) {
		return Identifier.fromNamespaceAndPath(Psithurism.namespace(), path);
	}

	public static String namespace() {
		return "psithurism";
	}
}
