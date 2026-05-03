package com.mmodding.psithurism;

import com.mmodding.library.core.api.registry.IdentifierUtil;
import com.mmodding.psithurism.init.*;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.core.api.ExtendedModInitializer;
import com.mmodding.library.core.api.management.ElementsManager;
import com.mmodding.psithurism.resource.PsithurismFeaturePacks;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;

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

		LootTableEvents.MODIFY.register((key, builder, source, holder) -> {
			if (key.identifier().equals(Identifier.withDefaultNamespace("archaeology/trail_ruins_common"))) {
				builder.pool(LootPool.lootPool().add(LootItem.lootTableItem(PsithurismItems.FAN_POTTERY_SHERD).setWeight(2)).build());
			}
			else if (key.identifier().equals(Identifier.withDefaultNamespace("archaeology/trail_ruins_rare"))) {
				builder.pool(LootPool.lootPool().add(LootItem.lootTableItem(PsithurismItems.TORII_POTTERY_SHERD)).build());
			}
			else if (key.identifier().equals(Identifier.withDefaultNamespace("pots/trial_chambers/corridor"))) {
				builder.pool(LootPool.lootPool().add(LootItem.lootTableItem(PsithurismItems.KITSUNE_MASK).setWeight(50)).build());
				builder.pool(LootPool.lootPool().add(LootItem.lootTableItem(PsithurismItems.ONI_MASK).setWeight(50)).build());
			}
		});
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
