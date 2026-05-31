package com.mmodding.psithurism.client.cosmetic;

import com.mmodding.library.resource.api.client.cosmetic.Cosmetic;
import com.mmodding.library.resource.api.client.model.EntityModelFactory;
import com.mmodding.psithurism.Psithurism;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;

import java.util.Map;

public record TailCosmetic(String name, EntityModel<HumanoidRenderState> model) implements Cosmetic {

	@Override
	public Map<String, EntityModelFactory<HumanoidRenderState>> getModelFactories() {
		return Map.of("main", _ -> this.model);
	}

	@Override
	public String getModel(ItemStack stack, boolean isSlim) {
		return "main";
	}

	@Override
	public Identifier getTexture(ItemStack stack, boolean isSlim) {
		return Psithurism.createTexture("tail/" + this.name());
	}
}
