package com.mmodding.psithurism.client.init;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.psithurism.Psithurism;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.animal.fish.SalmonModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.resources.Identifier;

public class PsithurismModelReferences {

	public static final Identifier KITSUNE_MASK = Psithurism.createId("kitsune_mask");
	public static final Identifier WORN_KITSUNE_MASK = Psithurism.createId("worn_kitsune_mask");

	public static final Identifier ONI_MASK = Psithurism.createId("oni_mask");
	public static final Identifier WORN_ONI_MASK = Psithurism.createId("worn_oni_mask");

	public static final Identifier STRAW_HAT = Psithurism.createId("straw_hat");

	public static final Identifier FOX_EARS = Psithurism.createId("fox_ears");

	public static final Identifier TAIL = Psithurism.createId("tail");

	public static final Identifier SCHOOL_BAG = Psithurism.createId("school_bag");

	public static final ModelLayerLocation KOI = createModelLayer("koi");
	public static final ModelLayerLocation KOI_LARGE = createModelLayer("koi_large");
	public static final ModelLayerLocation KOI_SMALL = createModelLayer("koi_small");

	public static final ModelLayerLocation DARK_CHERRY_BOAT = createModelLayer("boat/dark_cherry");
	public static final ModelLayerLocation DARK_CHERRY_CHEST_BOAT = createModelLayer("chest_boat/dark_cherry");

	private static ModelLayerLocation createModelLayer(String path) {
		return new ModelLayerLocation(Psithurism.createId(path), "main");
	}

	public static void register(AdvancedContainer mod) {
		ModelLayerRegistry.registerModelLayer(KOI, PsithurismModels::createKoi);
		ModelLayerRegistry.registerModelLayer(KOI_LARGE, () -> PsithurismModels.createKoi().apply(SalmonModel.LARGE_TRANSFORMER));
		ModelLayerRegistry.registerModelLayer(KOI_SMALL, () -> PsithurismModels.createKoi().apply(SalmonModel.SMALL_TRANSFORMER));
		ModelLayerRegistry.registerModelLayer(DARK_CHERRY_BOAT, BoatModel::createBoatModel);
		ModelLayerRegistry.registerModelLayer(DARK_CHERRY_CHEST_BOAT, BoatModel::createChestBoatModel);
	}
}
