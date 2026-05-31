package com.mmodding.psithurism.client.init;

import com.mmodding.library.resource.api.client.cosmetic.Cosmetic;
import com.mmodding.library.resource.api.client.cosmetic.catalog.DirectCosmetic;
import com.mmodding.library.resource.api.client.model.data.DataDrivenModelEvents.FinalizeEntityModels.ModelGetter;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.client.cosmetic.BagCosmetic;
import com.mmodding.psithurism.client.cosmetic.EarsCosmetic;
import com.mmodding.psithurism.client.cosmetic.MaskCosmetic;
import com.mmodding.psithurism.client.cosmetic.TailCosmetic;

import java.util.function.Function;

public class PsithurismCosmetics {

	public static final Function<ModelGetter, Cosmetic> KITSUNE_MASK = models -> new MaskCosmetic("kitsune", models.getModel(PsithurismModelReferences.KITSUNE_MASK), models.getModel(PsithurismModelReferences.WORN_KITSUNE_MASK));
	public static final Function<ModelGetter, Cosmetic> ONI_MASK = models -> new MaskCosmetic("oni", models.getModel(PsithurismModelReferences.ONI_MASK), models.getModel(PsithurismModelReferences.WORN_ONI_MASK));
	public static final Function<ModelGetter, Cosmetic> FOX_EARS = models -> new EarsCosmetic("fox", models.getModel(PsithurismModelReferences.FOX_EARS));
	public static final Function<ModelGetter, Cosmetic> STRAW_HAT = models -> new DirectCosmetic(models.getModel(PsithurismModelReferences.STRAW_HAT), Psithurism.createTexture("hat/straw"));
	public static final Function<ModelGetter, Cosmetic> KITSUNE_TAIL = models -> new TailCosmetic("kitsune", models.getModel(PsithurismModelReferences.TAIL));
	public static final Function<ModelGetter, Cosmetic> FOX_TAIL = models -> new TailCosmetic("fox", models.getModel(PsithurismModelReferences.TAIL));
	public static final Function<ModelGetter, Cosmetic> WINTER_SCHOOL_BAG = models -> new BagCosmetic("school_winter", models.getModel(PsithurismModelReferences.SCHOOL_BAG));
	public static final Function<ModelGetter, Cosmetic> SUMMER_SCHOOL_BAG = models -> new BagCosmetic("school_summer", models.getModel(PsithurismModelReferences.SCHOOL_BAG));
}
