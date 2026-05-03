package com.mmodding.psithurism.data;

import com.mmodding.psithurism.Psithurism;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;

import java.util.Optional;

public class PsithurismModelTemplates {

	public static final ModelTemplate STONE_LANTERN = create("template_stone_lantern", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate CHERRY_BONSAI = create("template_cherry_bonsai", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate FUTON = create("template_futon", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate TERU_TERU_BOZU = create("template_teru_teru_bozu", TextureSlot.TEXTURE, TextureSlot.PARTICLE);

	private static ModelTemplate create(final String id, final TextureSlot... slots) {
		return new ModelTemplate(Optional.of(Psithurism.createId("block/" + id)), Optional.empty(), slots);
	}
}
