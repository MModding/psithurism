package com.mmodding.psithurism.client.init;

import com.mmodding.library.rendering.api.cosmetic.renderer.CapCosmeticRenderer;
import com.mmodding.library.rendering.api.cosmetic.renderer.PantsCosmeticRenderer;
import com.mmodding.psithurism.init.PsithurismItems;
import com.mmodding.psithurism.init.PsithurismWoodSets;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class PsithurismRenderers {

	public static void register() {
		ArmorRenderer.register(context -> new CapCosmeticRenderer(PsithurismCosmetics.KITSUNE_MASK, CapCosmeticRenderer.Anchor.HEAD_CENTER, context), PsithurismItems.KITSUNE_MASK);
		ArmorRenderer.register(context -> new CapCosmeticRenderer(PsithurismCosmetics.ONI_MASK, CapCosmeticRenderer.Anchor.HEAD_CENTER, context), PsithurismItems.ONI_MASK);
		ArmorRenderer.register(context -> new CapCosmeticRenderer(PsithurismCosmetics.FOX_EARS, CapCosmeticRenderer.Anchor.HEAD_CENTER, context), PsithurismItems.FOX_EARS);
		ArmorRenderer.register(context -> new PantsCosmeticRenderer(PsithurismCosmetics.KITSUNE_TAIL, context), PsithurismItems.KITSUNE_TAIL);
		ArmorRenderer.register(context -> new PantsCosmeticRenderer(PsithurismCosmetics.FOX_TAIL, context), PsithurismItems.FOX_TAIL);
		EntityRenderers.register(PsithurismWoodSets.DARK_CHERRY.getBoatEntityType(), context -> new BoatRenderer(context, PsithurismModelLayers.DARK_CHERRY_BOAT));
		EntityRenderers.register(PsithurismWoodSets.DARK_CHERRY.getChestBoatEntityType(), context -> new BoatRenderer(context, PsithurismModelLayers.DARK_CHERRY_CHEST_BOAT));
	}
}
