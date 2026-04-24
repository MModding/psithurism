package com.mmodding.psithurism.init;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.item.MaskItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.equipment.*;

import java.util.function.Function;

public class PsithurismItems {

	public static final Item FAN_POTTERY_SHERD = register("fan_pottery_sherd", new Item.Properties().rarity(Rarity.UNCOMMON).decoratedPotPattern(PsithurismDecoratedPotPatterns.FAN));
	public static final Item TORII_POTTERY_SHERD = register("torii_pottery_sherd", new Item.Properties().rarity(Rarity.UNCOMMON).decoratedPotPattern(PsithurismDecoratedPotPatterns.TORII));

	public static final Item KITSUNE_MASK = register("kitsune_mask", MaskItem::new, new Item.Properties().stacksTo(1).equippable(EquipmentSlot.HEAD).component(PsithurismDataComponents.WORN_MASK, false));
	public static final Item ONI_MASK = register("oni_mask", MaskItem::new, new Item.Properties().stacksTo(1).equippable(EquipmentSlot.HEAD).component(PsithurismDataComponents.WORN_MASK, false));
	public static final Item FOX_EARS = register("fox_ears", new Item.Properties().stacksTo(1).equippable(EquipmentSlot.HEAD));
	public static final Item KITSUNE_TAIL = register("kitsune_tail", new Item.Properties().stacksTo(1).equippable(EquipmentSlot.LEGS));
	public static final Item FOX_TAIL = register("fox_tail", new Item.Properties().stacksTo(1).equippable(EquipmentSlot.LEGS));

	public static final Item FLOWER_CROWN = register(
		"cherry_flower_crown",
		new Item.Properties().component(
			DataComponents.EQUIPPABLE,
			Equippable.builder(EquipmentSlot.HEAD)
				.setAsset(ResourceKey.create(EquipmentAssets.ROOT_ID, Psithurism.createId("cherry_flower_crown")))
				.build()
		)
	);

	public static final Item RICE_PLANT = register("rice_plant", Items.createBlockItemWithCustomItemName(PsithurismBlocks.RICE), new Item.Properties());
	public static final Item RICE = register("rice", new Item.Properties());
	public static final Item RICE_FLOUR = register("rice_flour", new Item.Properties());
	public static final Item RICE_BOWL = register("rice_bowl", new Item.Properties());
	public static final Item NIGIRI = register("nigiri", new Item.Properties());
	public static final Item NORI_ALGAE = register("nori_algae", new Item.Properties());
	public static final Item MAKI = register("maki", new Item.Properties());
	public static final Item YAKITORI = register("yakitori", new Item.Properties());
	public static final Item SOJA_SEED = register("soja_seeds", new Item.Properties());
	public static final Item SOJA_GROWTHS = register("soja_growths", new Item.Properties());
	public static final Item TOFU = register("tofu", new Item.Properties());
	public static final Item MISO_PASTE = register("miso_paste", new Item.Properties());
	public static final Item MISO_SOUP = register("miso_soup", new Item.Properties());

	private static Item register(String path, Item.Properties properties) {
		return register(path, Item::new, properties);
	}

	private static Item register(String path, Function<Item.Properties, Item> factory, Item.Properties properties) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Psithurism.createId(path));
		return Items.registerItem(key, factory, properties);
	}

	public static void register(AdvancedContainer mod) {}
}
