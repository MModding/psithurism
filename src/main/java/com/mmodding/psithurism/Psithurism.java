package com.mmodding.psithurism;

import com.mmodding.library.core.api.registry.IdentifierUtil;
import com.mmodding.psithurism.init.PsithurismBlockEntities;
import com.mmodding.psithurism.init.PsithurismBlocks;
import com.mmodding.psithurism.init.PsithurismItems;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.core.api.ExtendedModInitializer;
import com.mmodding.library.core.api.management.ElementsManager;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;

public class Psithurism implements ExtendedModInitializer {

	@SuppressWarnings("deprecation")
	public static final CreativeModeTab TAB = FabricCreativeModeTab.builder()
		.title(Component.translatable("itemGroup.psithurism.tab"))
		.icon(() -> PsithurismBlocks.DARK_CHERRY_LOG.asItem().getDefaultInstance())
		.displayItems((parameters, output) -> BuiltInRegistries.ITEM.stream()
			.filter(item -> item.builtInRegistryHolder().key().identifier().getNamespace().equals(Psithurism.namespace()))
			.forEach(output::accept))
		.build();

	@Override
	public void setupManager(ElementsManager manager) {
		manager.content(PsithurismBlocks::register);
		manager.content(PsithurismItems::register);
		manager.content(PsithurismBlockEntities::register);
	}

	@Override
	public void onInitialize(AdvancedContainer mod) {
		mod.logger().info("Shaping the world with a Delicate Sip of your imagination!");
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
