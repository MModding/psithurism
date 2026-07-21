package com.mmodding.psithurism.client.cosmetic;

import com.mmodding.library.resource.api.client.cosmetic.Cosmetic;
import com.mmodding.library.resource.api.client.model.EntityModelFactory;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.init.PsithurismDataComponents;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;

import java.util.Map;

public record MaskCosmetic(String name, Identifier normal, Identifier worn) implements Cosmetic {

	@Override
	public Map<String, EntityModelFactory<HumanoidRenderState>> getModelFactories() {
		return Map.of(
			"normal", context -> context.getDataDrivenModel(this.normal),
			"worn", context -> context.getDataDrivenModel(this.worn)
		);
	}

	@Override
	public String getModel(ItemStack stack, boolean isSlim) {
		return stack.getOrDefault(PsithurismDataComponents.WORN_MASK, false) ? "worn" : "normal";
	}

	@Override
	public Identifier getTexture(ItemStack stack, boolean isSlim) {
		return Psithurism.createTexture("mask/" + this.name());
	}
}
