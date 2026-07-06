package com.mmodding.psithurism;

import com.mmodding.library.core.api.registry.IdentifierUtil;
import com.mmodding.psithurism.init.*;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.core.api.ExtendedModInitializer;
import com.mmodding.library.core.api.management.ElementsManager;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class Psithurism implements ExtendedModInitializer {

	@Override
	public void setupManager(ElementsManager manager) {
		manager.content(PsithurismDataComponents::register);
		manager.content(PsithurismParticleTypes::register);
		manager.content(PsithurismSoundEvents::register);
		manager.content(PsithurismEntityTypes::register);
		manager.content(PsithurismWoodSets::register);
		manager.content(PsithurismFluids::register);
		manager.content(PsithurismBlocks::register);
		manager.content(PsithurismBlockEntityTypes::register);
		manager.content(PsithurismItems::register);
		manager.content(PsithurismDecoratedPotPatterns::register);
		manager.content(PsithurismItemCreativeTabs::register);
		manager.content(PsithurismPlacedFeatures::register);
	}

	@Override
	public void onInitialize(AdvancedContainer mod) {
		mod.logger().info("Minecraft, Japan. 💐");

		LootTableEvents.MODIFY.register((key, builder, source, holder) -> {
			if (key.equals(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON)) {
				builder.pool(LootPool.lootPool().add(LootItem.lootTableItem(PsithurismItems.FAN_POTTERY_SHERD).setWeight(2)).build());
			}
			else if (key.equals(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE)) {
				builder.pool(LootPool.lootPool().add(LootItem.lootTableItem(PsithurismItems.TORII_POTTERY_SHERD)).build());
				builder.pool(LootPool.lootPool().add(LootItem.lootTableItem(PsithurismItems.YIN_YANG_POTTERY_SHERD)).build());
			}
			else if (key.equals(BuiltInLootTables.TRIAL_CHAMBERS_CORRIDOR_POT)) {
				builder.pool(LootPool.lootPool().add(LootItem.lootTableItem(PsithurismItems.KITSUNE_MASK).setWeight(50)).build());
				builder.pool(LootPool.lootPool().add(LootItem.lootTableItem(PsithurismItems.ONI_MASK).setWeight(50)).build());
			}
			else if (key.equals(BuiltInLootTables.ABANDONED_MINESHAFT)) {
				builder.pool(LootPool.lootPool().add(LootItem.lootTableItem(PsithurismItems.RICE_PLANT).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 4.0f))).setWeight(10)).build());
				builder.pool(LootPool.lootPool().add(LootItem.lootTableItem(PsithurismItems.SOYBEANS).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 4.0f))).setWeight(10)).build());
			}
		});
	}

	public static Identifier createTexture(String path) {
		return IdentifierUtil.texture(Psithurism.namespace(), path);
	}

	public static Identifier createId(String path) {
		return Identifier.fromNamespaceAndPath(Psithurism.namespace(), path);
	}

	public static <T> ResourceKey<T> createKey(ResourceKey<? extends Registry<T>> registry, String path) {
		return ResourceKey.create(registry, createId(path));
	}

	public static String namespace() {
		return "psithurism";
	}
}
