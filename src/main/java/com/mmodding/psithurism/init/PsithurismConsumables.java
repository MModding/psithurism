package com.mmodding.psithurism.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ClearAllStatusEffectsConsumeEffect;

public class PsithurismConsumables {

	public static final Consumable RICE = Consumables.defaultFood().consumeSeconds(0.4f).build();
	public static final Consumable MAKI = Consumables.defaultFood().consumeSeconds(1.0f).build();
	public static final Consumable SOYBEANS = Consumables.defaultFood().consumeSeconds(0.8f).build();
	public static final Consumable FUGU = Consumables.defaultFood().consumeSeconds(1.0f).build();
	public static final Consumable MOCHI = Consumables.defaultFood().consumeSeconds(1.2f).build();
	public static final Consumable CHOCOLATE_MOCHI = Consumables.defaultFood().consumeSeconds(1.2f).onConsume(new ApplyStatusEffectsConsumeEffect(
		new MobEffectInstance(MobEffects.HASTE, 100))
	).build();
	public static final Consumable HONEY_MOCHI = Consumables.defaultFood().consumeSeconds(1.2f).onConsume(new ApplyStatusEffectsConsumeEffect(
		new MobEffectInstance(MobEffects.GLOWING, 100)
	)).build();
	public static final Consumable SWEET_BERRY_MOCHI = Consumables.defaultFood().consumeSeconds(1.2f).onConsume(new ApplyStatusEffectsConsumeEffect(
		new MobEffectInstance(MobEffects.JUMP_BOOST, 100)
	)).consumeSeconds(1.2f).build();
	public static final Consumable MATCHA_CUP = Consumables.defaultDrink().onConsume(new ClearAllStatusEffectsConsumeEffect()).onConsume(new ApplyStatusEffectsConsumeEffect(
		new MobEffectInstance(MobEffects.LUCK, 400)
	)).build();
}
