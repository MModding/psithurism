package com.mmodding.psithurism.init;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.psithurism.Psithurism;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.util.Set;
import java.util.function.BiPredicate;

public class PsithurismItemCreativeTabs {

	private static final BiPredicate<ResourceKey<Item>, Item> COSMETICS_PREDICATE = (_, item) -> Set.of(
		PsithurismItems.KITSUNE_MASK,
		PsithurismItems.ONI_MASK,
		PsithurismItems.FOX_EARS,
		PsithurismItems.STRAW_HAT,
		PsithurismItems.KITSUNE_TAIL,
		PsithurismItems.FOX_TAIL,
		PsithurismItems.PINK_PETAL_CROWN,
		PsithurismItems.WHITE_PETAL_CROWN,
		PsithurismItems.WINTER_GAKURAN_SHIRT,
		PsithurismItems.WINTER_GAKURAN_PANTS,
		PsithurismItems.WINTER_FUKU_DRESS,
		PsithurismItems.WINTER_FUKU_SKIRT,
		PsithurismItems.WINTER_SCHOOL_BAG,
		PsithurismItems.WINTER_UNIFORM_BOOTS,
		PsithurismItems.SUMMER_GAKURAN_SHIRT,
		PsithurismItems.SUMMER_GAKURAN_PANTS,
		PsithurismItems.SUMMER_FUKU_DRESS,
		PsithurismItems.SUMMER_FUKU_SKIRT,
		PsithurismItems.SUMMER_SCHOOL_BAG,
		PsithurismItems.SUMMER_UNIFORM_BOOTS
	).contains(item);

	private static final BiPredicate<ResourceKey<Item>, Item> ORGANICS_PREDICATE = (_, item) -> Set.of(
		PsithurismItems.KOI_SPAWN_EGG,
		PsithurismItems.KOI_WATER_BUCKET,
		PsithurismItems.RICE_PLANT,
		PsithurismItems.RICE,
		PsithurismItems.RICE_FLOUR,
		PsithurismItems.RICE_BOWL,
		PsithurismItems.NIGIRI,
		PsithurismItems.NORI_ALGAE,
		PsithurismItems.MAKI,
		PsithurismItems.YAKITORI,
		PsithurismItems.SOYBEANS,
		PsithurismItems.SOYA_GROWTHS,
		PsithurismItems.TOFU,
		PsithurismItems.MISO_PASTE,
		PsithurismItems.MISO_SOUP,
		PsithurismItems.FUGU,
		PsithurismItems.TAKOYAKI,
		PsithurismItems.MOCHI,
		PsithurismItems.CHOCOLATE_MOCHI,
		PsithurismItems.HONEY_MOCHI,
		PsithurismItems.SWEET_BERRY_MOCHI,
		PsithurismItems.CUP,
		PsithurismItems.MATCHA_CUP
	).contains(item);

	private static final BiPredicate<ResourceKey<Item>, Item> BUILDING_BLOCKS_PREDICATE = (key, item) -> !ORGANICS_PREDICATE.test(key, item) && !COSMETICS_PREDICATE.test(key, item);

	public static final CreativeModeTab BUILDING_BLOCKS = create("building_blocks", PsithurismBlocks.STONE_LANTERN.asItem(), BUILDING_BLOCKS_PREDICATE);
	public static final CreativeModeTab ORGANIC_PRODUCTS = create("organic_products", PsithurismItems.MAKI, ORGANICS_PREDICATE);
	public static final CreativeModeTab COSMETICS = create("cosmetics", PsithurismItems.ONI_MASK, COSMETICS_PREDICATE);

	public static CreativeModeTab create(String translation, Item icon, BiPredicate<ResourceKey<Item>, Item> filter) {
		return FabricCreativeModeTab.builder()
			.title(Component.translatable("itemGroup.psithurism." + translation))
			.icon(icon::getDefaultInstance)
			.displayItems(
				(_, output) -> BuiltInRegistries.ITEM.stream()
					.filter(
						item -> item.builtInRegistryHolder().key().identifier().getNamespace().equals(Psithurism.namespace())
							&& filter.test(item.builtInRegistryHolder().key(), item)
					)
					.forEach(output::accept)
			)
			.build();
	}

	public static void register(AdvancedContainer mod) {
		mod.register(BuiltInRegistries.CREATIVE_MODE_TAB, "building_blocks", PsithurismItemCreativeTabs.BUILDING_BLOCKS);
		mod.register(BuiltInRegistries.CREATIVE_MODE_TAB, "organic_products", PsithurismItemCreativeTabs.ORGANIC_PRODUCTS);
		mod.register(BuiltInRegistries.CREATIVE_MODE_TAB, "cosmetics", PsithurismItemCreativeTabs.COSMETICS);
	}
}
