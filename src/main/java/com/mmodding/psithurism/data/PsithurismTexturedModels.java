package com.mmodding.psithurism.data;

import com.mmodding.library.datagen.api.model.block.MModdingTextureMappings;
import com.mmodding.psithurism.init.PsithurismWoodSets;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.world.level.block.Blocks;

public class PsithurismTexturedModels {

	public static final TexturedModel.Provider CHERRY_BONSAI = TexturedModel.createDefault(block -> MModdingTextureMappings.specificParticle(block, Blocks.CHERRY_LEAVES), PsithurismModelTemplates.CHERRY_BONSAI);
	public static final TexturedModel.Provider DARK_CHERRY_BONSAI = TexturedModel.createDefault(block -> MModdingTextureMappings.specificParticle(block, PsithurismWoodSets.DARK_CHERRY.getLeaves()), PsithurismModelTemplates.CHERRY_BONSAI);
	public static final TexturedModel.Provider PAPER_LANTERN = TexturedModel.createDefault(TextureMapping::defaultTexture, PsithurismModelTemplates.PAPER_LANTERN);
}
