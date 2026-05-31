package com.mmodding.psithurism.client.init;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.resource.api.client.cosmetic.renderer.CosmeticRendererRegistry;
import com.mmodding.library.resource.api.client.cosmetic.renderer.HeadAnchor;
import com.mmodding.library.resource.api.client.model.data.DataDrivenModelEvents;
import com.mmodding.psithurism.client.renderer.KoiRenderer;
import com.mmodding.psithurism.init.PsithurismEntityTypes;
import com.mmodding.psithurism.init.PsithurismItems;
import com.mmodding.psithurism.init.PsithurismWoodSets;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class PsithurismRenderers {

	public static void register(AdvancedContainer mod) {
		DataDrivenModelEvents.FINALIZE_ENTITY_MODELS.register((models, initial) -> {
			if (initial) {
				CosmeticRendererRegistry.registerCapRenderer(PsithurismCosmetics.KITSUNE_MASK.apply(models), HeadAnchor.HEAD_CENTER, PsithurismItems.KITSUNE_MASK);
				CosmeticRendererRegistry.registerCapRenderer(PsithurismCosmetics.ONI_MASK.apply(models), HeadAnchor.HEAD_CENTER, PsithurismItems.ONI_MASK);
				CosmeticRendererRegistry.registerCapRenderer(PsithurismCosmetics.FOX_EARS.apply(models), HeadAnchor.HEAD_CENTER, PsithurismItems.FOX_EARS);
				CosmeticRendererRegistry.registerCapRenderer(PsithurismCosmetics.STRAW_HAT.apply(models), HeadAnchor.HEAD_CENTER, PsithurismItems.STRAW_HAT);
				CosmeticRendererRegistry.registerPantsRenderer(PsithurismCosmetics.KITSUNE_TAIL.apply(models), PsithurismItems.KITSUNE_TAIL);
				CosmeticRendererRegistry.registerPantsRenderer(PsithurismCosmetics.FOX_TAIL.apply(models), PsithurismItems.FOX_TAIL);
				CosmeticRendererRegistry.registerSuitRenderer(PsithurismCosmetics.WINTER_SCHOOL_BAG.apply(models), PsithurismItems.WINTER_SCHOOL_BAG);
				CosmeticRendererRegistry.registerSuitRenderer(PsithurismCosmetics.SUMMER_SCHOOL_BAG.apply(models), PsithurismItems.SUMMER_SCHOOL_BAG);
			}
		});
		EntityRenderers.register(PsithurismEntityTypes.KOI, KoiRenderer::new);
		EntityRenderers.register(PsithurismWoodSets.DARK_CHERRY.getBoatEntityType(), context -> new BoatRenderer(context, PsithurismModelReferences.DARK_CHERRY_BOAT));
		EntityRenderers.register(PsithurismWoodSets.DARK_CHERRY.getChestBoatEntityType(), context -> new BoatRenderer(context, PsithurismModelReferences.DARK_CHERRY_CHEST_BOAT));
	}
}
