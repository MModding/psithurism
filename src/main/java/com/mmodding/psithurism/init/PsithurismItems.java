package com.mmodding.psithurism.init;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.item.MaskItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.*;

import java.util.List;
import java.util.function.Function;

public class PsithurismItems {

	public static final Item FAN_POTTERY_SHERD = register("fan_pottery_sherd", new Item.Properties().rarity(Rarity.UNCOMMON).decoratedPotPattern(PsithurismDecoratedPotPatterns.FAN));
	public static final Item TORII_POTTERY_SHERD = register("torii_pottery_sherd", new Item.Properties().rarity(Rarity.UNCOMMON).decoratedPotPattern(PsithurismDecoratedPotPatterns.TORII));

	public static final Item KITSUNE_MASK = register("kitsune_mask", MaskItem::new, new Item.Properties().stacksTo(1).equippable(EquipmentSlot.HEAD).component(PsithurismDataComponents.WORN_MASK, false).trinketSlots(List.of("head/face")));
	public static final Item ONI_MASK = register("oni_mask", MaskItem::new, new Item.Properties().stacksTo(1).equippable(EquipmentSlot.HEAD).component(PsithurismDataComponents.WORN_MASK, false).trinketSlots(List.of("head/face")));
	public static final Item FOX_EARS = register("fox_ears", new Item.Properties().stacksTo(1).equippable(EquipmentSlot.HEAD).trinketSlots(List.of("head/cap")));
	public static final Item STRAW_HAT = register("straw_hat", new Item.Properties().stacksTo(1).equippable(EquipmentSlot.HEAD).trinketSlots(List.of("head/cap")));
	public static final Item KITSUNE_TAIL = register("kitsune_tail", new Item.Properties().stacksTo(1).equippable(EquipmentSlot.LEGS).trinketSlots(List.of("legs/belt")));
	public static final Item FOX_TAIL = register("fox_tail", new Item.Properties().stacksTo(1).equippable(EquipmentSlot.LEGS).trinketSlots(List.of("legs/belt")));

	public static final Item PINK_PETAL_CROWN = registerEquippableItem("pink_petal_crown", EquipmentSlot.HEAD, new Item.Properties().stacksTo(1));
	public static final Item WHITE_PETAL_CROWN = registerEquippableItem("white_petal_crown", EquipmentSlot.HEAD, new Item.Properties().stacksTo(1));

	public static final Item WINTER_GAKURAN_SHIRT = registerEquippableItem("winter_gakuran_shirt", "winter_gakuran", EquipmentSlot.CHEST, new Item.Properties().stacksTo(1));
	public static final Item WINTER_GAKURAN_PANTS = registerEquippableItem("winter_gakuran_pants", "winter_gakuran", EquipmentSlot.LEGS, new Item.Properties().stacksTo(1));
	public static final Item WINTER_FUKU_DRESS = registerEquippableItem("winter_fuku_dress", "winter_fuku", EquipmentSlot.CHEST, new Item.Properties().stacksTo(1));
	public static final Item WINTER_FUKU_SKIRT = registerEquippableItem("winter_fuku_skirt", "winter_fuku", EquipmentSlot.LEGS, new Item.Properties().stacksTo(1));
	public static final Item WINTER_SCHOOL_BAG = register("winter_school_bag", new Item.Properties().stacksTo(1).equippable(EquipmentSlot.CHEST).trinketSlots(List.of("chest/back")));
	public static final Item WINTER_UNIFORM_BOOTS = registerEquippableItem("winter_uniform_boots", "winter_fuku", EquipmentSlot.FEET, new Item.Properties().stacksTo(1));

	public static final Item SUMMER_GAKURAN_SHIRT = registerEquippableItem("summer_gakuran_shirt", "summer_gakuran", EquipmentSlot.CHEST, new Item.Properties().stacksTo(1));
	public static final Item SUMMER_GAKURAN_PANTS = registerEquippableItem("summer_gakuran_pants", "summer_gakuran", EquipmentSlot.LEGS, new Item.Properties().stacksTo(1));
	public static final Item SUMMER_FUKU_DRESS = registerEquippableItem("summer_fuku_dress", "summer_fuku", EquipmentSlot.CHEST, new Item.Properties().stacksTo(1));
	public static final Item SUMMER_FUKU_SKIRT = registerEquippableItem("summer_fuku_skirt", "summer_fuku", EquipmentSlot.LEGS, new Item.Properties().stacksTo(1));
	public static final Item SUMMER_SCHOOL_BAG = register("summer_school_bag", new Item.Properties().stacksTo(1).equippable(EquipmentSlot.CHEST).trinketSlots(List.of("chest/back")));
	public static final Item SUMMER_UNIFORM_BOOTS = registerEquippableItem("summer_uniform_boots", "summer_fuku", EquipmentSlot.FEET, new Item.Properties().stacksTo(1));

	public static final Item ONSEN_WATER_BUCKET = register("onsen_water_bucket", properties -> new BucketItem(PsithurismFluids.ONSEN_WATER, properties), new Item.Properties().stacksTo(1));
	public static final Item KOI_SPAWN_EGG = Items.registerSpawnEgg(PsithurismEntityTypes.KOI);
	public static final Item KOI_WATER_BUCKET = register("koi_water_bucket", properties -> new MobBucketItem(PsithurismEntityTypes.KOI, PsithurismFluids.ONSEN_WATER, SoundEvents.BUCKET_EMPTY_FISH, properties), new Item.Properties().stacksTo(1));

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
	public static final Item FUGU = register("fugu", new Item.Properties());
	public static final Item TAKOYAKI = register("takoyaki", new Item.Properties());
	public static final Item MOCHI = register("mochi", new Item.Properties());
	public static final Item CHOCOLATE_MOCHI = register("chocolate_mochi", new Item.Properties());
	public static final Item HONEY_MOCHI = register("honey_mochi", new Item.Properties());
	public static final Item SWEET_BERRY_MOCHI = register("sweet_berry_mochi", new Item.Properties());
	public static final Item CUP = register("cup", new Item.Properties());
	public static final Item MATCHA_CUP = register("matcha_cup", new Item.Properties());

	private static Item registerEquippableItem(String path, EquipmentSlot slot, Item.Properties properties) {
		return registerEquippableItem(path, path, slot, properties);
	}

	private static Item registerEquippableItem(String path, String asset, EquipmentSlot slot, Item.Properties properties) {
		return register(path, properties.component(
			DataComponents.EQUIPPABLE,
			Equippable.builder(slot)
				.setAsset(ResourceKey.create(EquipmentAssets.ROOT_ID, Psithurism.createId(asset)))
				.build()
		));
	}

	private static Item register(String path, Item.Properties properties) {
		return register(path, Item::new, properties);
	}

	private static Item register(String path, Function<Item.Properties, Item> factory, Item.Properties properties) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Psithurism.createId(path));
		return Items.registerItem(key, factory, properties);
	}

	public static void register(AdvancedContainer mod) {}
}
