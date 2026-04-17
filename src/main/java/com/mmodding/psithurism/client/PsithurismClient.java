package com.mmodding.psithurism.client;

import com.mmodding.library.rendering.api.renderer.CapModelRenderer;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.client.init.PsithurismAccessoryInfos;
import com.mmodding.psithurism.client.model.KitsuneMaskModel;
import com.mmodding.psithurism.client.model.OniMaskModel;
import com.mmodding.psithurism.init.PsithurismItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;

@Environment(EnvType.CLIENT)
public class PsithurismClient implements ClientModInitializer {

	public static final ModelLayerLocation KITSUNE_MASK = createModelLayer("kitsune_mask");
	public static final ModelLayerLocation ONI_MASK = createModelLayer("oni_mask");

	private static ModelLayerLocation createModelLayer(String path) {
		return new ModelLayerLocation(Psithurism.createId(path), "main");
	}

	@Override
	public void onInitializeClient() {
		ModelLayerRegistry.registerModelLayer(KITSUNE_MASK, KitsuneMaskModel::createMaskLayer);
		ModelLayerRegistry.registerModelLayer(ONI_MASK, OniMaskModel::createMaskLayer);
		ArmorRenderer.register(context -> new CapModelRenderer(PsithurismAccessoryInfos.KITSUNE, context), PsithurismItems.KITSUNE_MASK);
		ArmorRenderer.register(context -> new CapModelRenderer(PsithurismAccessoryInfos.ONI, context), PsithurismItems.ONI_MASK);
	}
}
