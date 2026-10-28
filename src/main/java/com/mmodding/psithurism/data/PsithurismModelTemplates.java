package com.mmodding.psithurism.data;

import com.mmodding.psithurism.Psithurism;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;

import java.util.Optional;

public class PsithurismModelTemplates {

	public static final ModelTemplate STONE_LANTERN = create("template_stone_lantern", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate CHERRY_BONSAI = create("template_cherry_bonsai", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate FUTON = create("template_futon", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate NOKIXXXXGAWARA = create("template_nokixxxxgawara", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate LARGE_NOKIXXXXGAWARA_MEDALLION = create("template_large_nokixxxxgawara_medallion", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate LARGE_NOKIXXXXGAWARA_BORDER = create("template_large_nokixxxxgawara_border", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate TERU_TERU_BOZU = create("template_teru_teru_bozu", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate PAPER_LANTERN = create("template_paper_lantern", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate SLIDING_DOOR_BOTTOM = create("template_sliding_door_bottom", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate SLIDING_DOOR_TOP = create("template_sliding_door_top", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate SLIDING_DOOR_BOTTOM_OPEN = create("template_sliding_door_bottom_open", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate SLIDING_DOOR_TOP_OPEN = create("template_sliding_door_top_open", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate FLOOR_LAMP_TOP = create("template_floor_lamp_top", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate FLOOR_LAMP_BOTTOM = create("template_floor_lamp_bottom", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate NOREN_TOP = create("template_noren_top", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate NOREN_MIDDLE = create("template_noren_middle", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
	public static final ModelTemplate NOREN_BOTTOM = create("template_noren_bottom", TextureSlot.TEXTURE, TextureSlot.PARTICLE);

	private static ModelTemplate create(final String id, final TextureSlot... slots) {
		return new ModelTemplate(Optional.of(Psithurism.createId("block/" + id)), Optional.empty(), slots);
	}
}
