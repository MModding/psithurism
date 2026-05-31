package com.mmodding.psithurism.client;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.core.api.client.ExtendedClientModInitializer;
import com.mmodding.library.core.api.management.ElementsManager;
import com.mmodding.library.java.api.color.Color;
import com.mmodding.library.resource.api.client.sprite.TextureAliases;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.client.particle.OnsenSmokeParticle;
import com.mmodding.psithurism.client.init.PsithurismModelReferences;
import com.mmodding.psithurism.client.init.PsithurismRenderers;
import com.mmodding.psithurism.init.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.particle.FallingLeavesParticle;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;

import java.util.List;

@Environment(EnvType.CLIENT)
public class PsithurismClient implements ExtendedClientModInitializer {

	@Override
	public void setupManager(ElementsManager manager) {
		manager.content(PsithurismModelReferences::register);
		manager.content(PsithurismRenderers::register);
	}

	@Override
	public void onInitializeClient(AdvancedContainer mod) {
		TextureAliases.create(Psithurism.createId("block/dark_cherry_log"), Identifier.withDefaultNamespace("block/cherry_log"));
		TextureAliases.create(Psithurism.createId("block/white_petals_stem"), Identifier.withDefaultNamespace("block/pink_petals_stem"));
		BlockColorRegistry.register(List.of(BlockTintSources.constant(-1), BlockTintSources.grass()), PsithurismBlocks.WHITE_PETALS);
		ParticleProviderRegistry.getInstance().register(PsithurismParticleTypes.DARK_CHERRY_LEAVES, FallingLeavesParticle.CherryProvider::new);
		ParticleProviderRegistry.getInstance().register(PsithurismParticleTypes.ONSEN_STEAM, OnsenSmokeParticle.Provider::new);
		FluidRenderingRegistry.register(
			PsithurismFluids.ONSEN_WATER,
			PsithurismFluids.FLOWING_ONSEN_WATER,
			new FluidModel.Unbaked(
				new Material(Identifier.withDefaultNamespace("block/water_still")),
				new Material(Identifier.withDefaultNamespace("block/water_flow")),
				new Material(Identifier.withDefaultNamespace("block/water_overlay")),
				BlockTintSources.constant(Color.rgb(147, 218, 230).toDecimal())
			)
		);
	}
}
