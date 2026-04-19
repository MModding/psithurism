package com.mmodding.psithurism.client;

import com.mmodding.library.java.api.list.BiList;
import com.mmodding.library.rendering.api.renderer.CapModelRenderer;
import com.mmodding.library.rendering.api.sprite.TextureAliases;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.client.init.PsithurismAccessoryInfos;
import com.mmodding.psithurism.client.model.KitsuneMaskModel;
import com.mmodding.psithurism.client.model.OniMaskModel;
import com.mmodding.psithurism.init.PsithurismDataComponents;
import com.mmodding.psithurism.init.PsithurismItems;
import com.mmodding.psithurism.init.PsithurismParticleTypes;
import com.mmodding.psithurism.init.PsithurismWoodSets;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.particle.FallingLeavesParticle;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.Identifier;

@Environment(EnvType.CLIENT)
public class PsithurismClient implements ClientModInitializer {

	public static final ModelLayerLocation KITSUNE_MASK = createModelLayer("kitsune_mask");
	public static final ModelLayerLocation WORN_KITSUNE_MASK = createWornModelLayer("kitsune_mask");

	public static final ModelLayerLocation ONI_MASK = createModelLayer("oni_mask");
	public static final ModelLayerLocation WORN_ONI_MASK = createWornModelLayer("oni_mask");

	public static final ModelLayerLocation DARK_CHERRY_BOAT = createModelLayer("boat/dark_cherry");
	public static final ModelLayerLocation DARK_CHERRY_CHEST_BOAT = createModelLayer("chest_boat/dark_cherry");

	private static ModelLayerLocation createModelLayer(String path) {
		return new ModelLayerLocation(Psithurism.createId(path), "main");
	}

	private static ModelLayerLocation createWornModelLayer(String path) {
		return new ModelLayerLocation(Psithurism.createId(path), "worn");
	}

	@Override
	public void onInitializeClient() {
		TextureAliases.create(Psithurism.createId("block/dark_cherry_log"), Identifier.withDefaultNamespace("block/cherry_log"));
		ModelLayerRegistry.registerModelLayer(KITSUNE_MASK, KitsuneMaskModel::createMaskLayer);
		ModelLayerRegistry.registerModelLayer(WORN_KITSUNE_MASK, KitsuneMaskModel::createWornMaskLayer);
		ModelLayerRegistry.registerModelLayer(ONI_MASK, OniMaskModel::createMaskLayer);
		ModelLayerRegistry.registerModelLayer(WORN_ONI_MASK, OniMaskModel::createWornMaskLayer);
		ModelLayerRegistry.registerModelLayer(DARK_CHERRY_BOAT, BoatModel::createBoatModel);
		ModelLayerRegistry.registerModelLayer(DARK_CHERRY_CHEST_BOAT, BoatModel::createChestBoatModel);
		ArmorRenderer.register(context -> new CapModelRenderer(
			BiList.of(
				stack -> !stack.getOrDefault(PsithurismDataComponents.WORN_MASK, false),
				PsithurismAccessoryInfos.KITSUNE,
				stack -> stack.getOrDefault(PsithurismDataComponents.WORN_MASK, false),
				PsithurismAccessoryInfos.WORN_KITSUNE
			), context
		), PsithurismItems.KITSUNE_MASK);
		ArmorRenderer.register(context -> new CapModelRenderer(
			BiList.of(
				stack -> !stack.getOrDefault(PsithurismDataComponents.WORN_MASK, false),
				PsithurismAccessoryInfos.ONI,
				stack -> stack.getOrDefault(PsithurismDataComponents.WORN_MASK, false),
				PsithurismAccessoryInfos.WORN_ONI
			), context
		), PsithurismItems.ONI_MASK);
		EntityRenderers.register(PsithurismWoodSets.DARK_CHERRY.getBoatEntityType(), context -> new BoatRenderer(context, DARK_CHERRY_BOAT));
		EntityRenderers.register(PsithurismWoodSets.DARK_CHERRY.getChestBoatEntityType(), context -> new BoatRenderer(context, DARK_CHERRY_CHEST_BOAT));
		ParticleProviderRegistry.getInstance().register(PsithurismParticleTypes.DARK_CHERRY_LEAVES, FallingLeavesParticle.CherryProvider::new);
	}
}
