package com.mmodding.psithurism;

import com.mmodding.library.core.api.registry.IdentifierUtil;
import com.mmodding.psithurism.init.*;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.core.api.ExtendedModInitializer;
import com.mmodding.library.core.api.management.ElementsManager;
import com.mmodding.psithurism.resource.PsithurismFeaturePacks;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;

public class Psithurism implements ExtendedModInitializer {

	@SuppressWarnings({"deprecation", "Convert2MethodRef"})
	public static final CreativeModeTab TAB = FabricCreativeModeTab.builder()
		.title(Component.translatable("itemGroup.psithurism.tab"))
		.icon(() -> PsithurismItems.ONI_MASK.getDefaultInstance()) // do not simplify!!! PsithurismItems.ONI_MASK::getDefaultInstance causes early classload of PsithurismItems, it fucks the registry order, and by such the tab order!
		.displayItems((parameters, output) -> BuiltInRegistries.ITEM.stream()
			.filter(item -> item.builtInRegistryHolder().key().identifier().getNamespace().equals(Psithurism.namespace()))
			.forEach(output::accept))
		.build();

	@Override
	public void setupManager(ElementsManager manager) {
		manager.content(PsithurismDecoratedPotPatterns::register);
		manager.content(PsithurismDataComponents::register);
		manager.content(PsithurismParticleTypes::register);
		manager.content(PsithurismWoodSets::register);
		manager.content(PsithurismBlocks::register);
		manager.content(PsithurismItems::register);
		manager.content(PsithurismPlacedFeatures::register);
		manager.resource(Registries.CONFIGURED_FEATURE, PsithurismFeaturePacks::registerConfigs);
		manager.resource(Registries.PLACED_FEATURE, PsithurismFeaturePacks::registerPlacements);
	}

	@Override
	public void onInitialize(AdvancedContainer mod) {
		mod.logger().info("Minecraft, Japan. 💐");
		mod.register(BuiltInRegistries.CREATIVE_MODE_TAB, "tab", Psithurism.TAB);
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
