package com.mmodding.psithurism.client;

import com.mmodding.library.rendering.api.sprite.TextureAliases;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.client.init.PsithurismModelLayers;
import com.mmodding.psithurism.client.init.PsithurismRenderers;
import com.mmodding.psithurism.init.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.particle.FallingLeavesParticle;
import net.minecraft.resources.Identifier;

import java.util.List;

@Environment(EnvType.CLIENT)
public class PsithurismClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		PsithurismModelLayers.register();
		PsithurismRenderers.register();
		TextureAliases.create(Psithurism.createId("block/dark_cherry_log"), Identifier.withDefaultNamespace("block/cherry_log"));
		TextureAliases.create(Psithurism.createId("block/white_petals_stem"), Identifier.withDefaultNamespace("block/pink_petals_stem"));
		BlockColorRegistry.register(List.of(BlockTintSources.constant(-1), BlockTintSources.grass()), PsithurismBlocks.WHITE_PETALS);
		ParticleProviderRegistry.getInstance().register(PsithurismParticleTypes.DARK_CHERRY_LEAVES, FallingLeavesParticle.CherryProvider::new);
	}
}
