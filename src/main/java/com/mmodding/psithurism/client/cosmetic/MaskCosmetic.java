package com.mmodding.psithurism.client.cosmetic;

import com.mmodding.library.rendering.api.cosmetic.Cosmetic;
import com.mmodding.library.rendering.api.model.EntityModelFactory;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.init.PsithurismDataComponents;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;

import java.util.Map;

public record MaskCosmetic(String name, ModelLayerLocation normal, ModelLayerLocation worn) implements Cosmetic {

	@Override
	public Map<String, EntityModelFactory<HumanoidRenderState>> getModelFactories() {
		return Map.of(
			"normal", EntityModelFactory.of(this.normal()),
			"worn", EntityModelFactory.of(this.worn())
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
