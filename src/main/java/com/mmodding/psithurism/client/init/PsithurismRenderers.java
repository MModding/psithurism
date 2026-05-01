package com.mmodding.psithurism.client.init;

import com.mmodding.library.rendering.api.cosmetic.renderer.CosmeticRendererRegistry;
import com.mmodding.library.rendering.api.cosmetic.renderer.HeadAnchor;
import com.mmodding.psithurism.client.renderer.KoiRenderer;
import com.mmodding.psithurism.init.PsithurismEntityTypes;
import com.mmodding.psithurism.init.PsithurismItems;
import com.mmodding.psithurism.init.PsithurismWoodSets;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class PsithurismRenderers {

	public static void register() {
		CosmeticRendererRegistry.registerCapRenderer(PsithurismCosmetics.KITSUNE_MASK, HeadAnchor.HEAD_CENTER, PsithurismItems.KITSUNE_MASK);
		CosmeticRendererRegistry.registerCapRenderer(PsithurismCosmetics.ONI_MASK, HeadAnchor.HEAD_CENTER, PsithurismItems.ONI_MASK);
		CosmeticRendererRegistry.registerCapRenderer(PsithurismCosmetics.FOX_EARS, HeadAnchor.HEAD_CENTER, PsithurismItems.FOX_EARS);
		CosmeticRendererRegistry.registerCapRenderer(PsithurismCosmetics.STRAW_HAT, HeadAnchor.HEAD_CENTER, PsithurismItems.STRAW_HAT);
		CosmeticRendererRegistry.registerPantsRenderer(PsithurismCosmetics.KITSUNE_TAIL, PsithurismItems.KITSUNE_TAIL);
		CosmeticRendererRegistry.registerPantsRenderer(PsithurismCosmetics.FOX_TAIL, PsithurismItems.FOX_TAIL);
		EntityRenderers.register(PsithurismEntityTypes.KOI, KoiRenderer::new);
		EntityRenderers.register(PsithurismWoodSets.DARK_CHERRY.getBoatEntityType(), context -> new BoatRenderer(context, PsithurismModelLayers.DARK_CHERRY_BOAT));
		EntityRenderers.register(PsithurismWoodSets.DARK_CHERRY.getChestBoatEntityType(), context -> new BoatRenderer(context, PsithurismModelLayers.DARK_CHERRY_CHEST_BOAT));
	}
}
