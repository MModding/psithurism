package com.mmodding.psithurism.client.init;

import com.mmodding.psithurism.Psithurism;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.animal.fish.SalmonModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;

public class PsithurismModelLayers {

	public static final ModelLayerLocation KITSUNE_MASK = createModelLayer("kitsune_mask");
	public static final ModelLayerLocation WORN_KITSUNE_MASK = createWornModelLayer("kitsune_mask");

	public static final ModelLayerLocation ONI_MASK = createModelLayer("oni_mask");
	public static final ModelLayerLocation WORN_ONI_MASK = createWornModelLayer("oni_mask");

	public static final ModelLayerLocation STRAW_HAT = createModelLayer("straw_hat");

	public static final ModelLayerLocation FOX_EARS = createModelLayer("fox_ears");

	public static final ModelLayerLocation FOX_TAIL = createModelLayer("fox_tail");

	public static final ModelLayerLocation SCHOOL_BAG = createModelLayer("school_bag");

	public static final ModelLayerLocation KOI = createModelLayer("koi");
	public static final ModelLayerLocation KOI_LARGE = createModelLayer("koi_large");
	public static final ModelLayerLocation KOI_SMALL = createModelLayer("koi_small");

	public static final ModelLayerLocation DARK_CHERRY_BOAT = createModelLayer("boat/dark_cherry");
	public static final ModelLayerLocation DARK_CHERRY_CHEST_BOAT = createModelLayer("chest_boat/dark_cherry");

	private static ModelLayerLocation createModelLayer(String path) {
		return new ModelLayerLocation(Psithurism.createId(path), "main");
	}

	private static ModelLayerLocation createWornModelLayer(String path) {
		return new ModelLayerLocation(Psithurism.createId(path), "worn");
	}

	public static void register() {
		ModelLayerRegistry.registerModelLayer(KITSUNE_MASK, PsithurismModels::createKitsune);
		ModelLayerRegistry.registerModelLayer(WORN_KITSUNE_MASK, PsithurismModels::createWornKitsune);
		ModelLayerRegistry.registerModelLayer(ONI_MASK, PsithurismModels::createOni);
		ModelLayerRegistry.registerModelLayer(WORN_ONI_MASK, PsithurismModels::createWornOni);
		ModelLayerRegistry.registerModelLayer(STRAW_HAT, PsithurismModels::createStrawHat);
		ModelLayerRegistry.registerModelLayer(FOX_EARS, PsithurismModels::createFoxEars);
		ModelLayerRegistry.registerModelLayer(FOX_TAIL, PsithurismModels::createFoxTail);
		ModelLayerRegistry.registerModelLayer(SCHOOL_BAG, PsithurismModels::createSchoolBag);
		ModelLayerRegistry.registerModelLayer(KOI, PsithurismModels::createKoi);
		ModelLayerRegistry.registerModelLayer(KOI_LARGE, () -> PsithurismModels.createKoi().apply(SalmonModel.LARGE_TRANSFORMER));
		ModelLayerRegistry.registerModelLayer(KOI_SMALL, () -> PsithurismModels.createKoi().apply(SalmonModel.SMALL_TRANSFORMER));
		ModelLayerRegistry.registerModelLayer(DARK_CHERRY_BOAT, BoatModel::createBoatModel);
		ModelLayerRegistry.registerModelLayer(DARK_CHERRY_CHEST_BOAT, BoatModel::createChestBoatModel);
	}
}
