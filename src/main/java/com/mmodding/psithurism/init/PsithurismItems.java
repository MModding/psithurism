package com.mmodding.psithurism.init;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.item.MaskItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Function;

public class PsithurismItems {

	public static final Item KITSUNE_MASK = register("kitsune_mask", MaskItem::new, new Item.Properties().stacksTo(1).equippable(EquipmentSlot.HEAD).component(PsithurismDataComponents.WORN_MASK, false));
	public static final Item ONI_MASK = register("oni_mask", MaskItem::new, new Item.Properties().stacksTo(1).equippable(EquipmentSlot.HEAD).component(PsithurismDataComponents.WORN_MASK, false));
	public static final Item FOX_EARS = register("fox_ears", new Item.Properties().stacksTo(1).equippable(EquipmentSlot.HEAD));

	private static Item register(String path, Item.Properties properties) {
		return register(path, Item::new, properties);
	}

	private static Item register(String path, Function<Item.Properties, Item> factory, Item.Properties properties) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Psithurism.createId(path));
		return Items.registerItem(key, factory, properties);
	}

	public static void register(AdvancedContainer mod) {}
}
