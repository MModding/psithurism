package com.mmodding.psithurism.init;

import net.minecraft.world.food.FoodProperties;

public class PsithurismFoods {

	public static final FoodProperties RICE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).build();
	public static final FoodProperties RICE_BOWL = new FoodProperties.Builder().nutrition(4).saturationModifier(0.5f).build();
	public static final FoodProperties NIGIRI = new FoodProperties.Builder().nutrition(6).saturationModifier(0.7f).build();
	public static final FoodProperties MAKI = new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).build();
	public static final FoodProperties YAKITORI = new FoodProperties.Builder().nutrition(8).saturationModifier(0.8f).build();
	public static final FoodProperties SOYBEANS = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build();
	public static final FoodProperties SOYA_GROWTHS = new FoodProperties.Builder().nutrition(4).saturationModifier(0.3f).build();
	public static final FoodProperties TOFU = new FoodProperties.Builder().nutrition(3).saturationModifier(0.2f).build();
	public static final FoodProperties MISO_SOUP = new FoodProperties.Builder().nutrition(8).saturationModifier(0.8f).build();
	public static final FoodProperties FUGU = new FoodProperties.Builder().nutrition(3).saturationModifier(0.2f).build();
	public static final FoodProperties TAKOYAKI = new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).build();
	public static final FoodProperties MOCHI = new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build();
	public static final FoodProperties CHOCOLATE_MOCHI = new FoodProperties.Builder().nutrition(5).saturationModifier(0.9f).alwaysEdible().build();
	public static final FoodProperties HONEY_MOCHI = new FoodProperties.Builder().nutrition(5).saturationModifier(0.9f).alwaysEdible().build();
	public static final FoodProperties SWEET_BERRY_MOCHI = new FoodProperties.Builder().nutrition(5).saturationModifier(0.9f).alwaysEdible().build();
	public static final FoodProperties MATCHA_CUP = new FoodProperties.Builder().nutrition(4).saturationModifier(0.7f).build();
}
