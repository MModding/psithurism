package com.mmodding.psithurism.data;

import com.mmodding.psithurism.Psithurism;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;

import java.util.Optional;

public class PsithurismModelTemplates {

	public static final ModelTemplate STONE_LANTERN = create("template_stone_lantern", TextureSlot.ALL, TextureSlot.PARTICLE);

	private static ModelTemplate create(final String id, final TextureSlot... slots) {
		return new ModelTemplate(Optional.of(Psithurism.createId("block/" + id)), Optional.empty(), slots);
	}
}
