package com.mmodding.psithurism.client.init;

import com.mmodding.library.rendering.api.cosmetic.Cosmetic;
import com.mmodding.psithurism.client.cosmetic.EarsCosmetic;
import com.mmodding.psithurism.client.cosmetic.MaskCosmetic;

public class PsithurismCosmetics {

	public static final Cosmetic KITSUNE_MASK = new MaskCosmetic("kitsune", PsithurismModelLayers.KITSUNE_MASK, PsithurismModelLayers.WORN_KITSUNE_MASK);
	public static final Cosmetic ONI_MASK = new MaskCosmetic("oni", PsithurismModelLayers.ONI_MASK, PsithurismModelLayers.WORN_ONI_MASK);
	public static final Cosmetic FOX_EARS = new EarsCosmetic("fox", PsithurismModelLayers.FOX_EARS);
}
