package com.mmodding.psithurism.data;

import com.mmodding.psithurism.init.PsithurismWoodSets;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.world.level.block.Blocks;

public class PsithurismTextureMappings {

	public static final TextureMapping DARK_CHERRY_LOG = new TextureMapping()
		.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(Blocks.CHERRY_LOG))
		.put(TextureSlot.END, TextureMapping.getBlockTexture(PsithurismWoodSets.DARK_CHERRY.getLog(), "_top"))
		.put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(Blocks.CHERRY_LOG));
}
