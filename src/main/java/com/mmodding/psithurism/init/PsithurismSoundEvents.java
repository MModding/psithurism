package com.mmodding.psithurism.init;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.psithurism.Psithurism;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class PsithurismSoundEvents {

	public static final Holder<SoundEvent> TALES_OF_YORE = register("music.tales_of_yore");
	public static final Holder<SoundEvent> REST = register("music.rest");

	private static Holder<SoundEvent> register(String path) {
		Identifier identifier = Psithurism.createId(path);
		return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
	}

	public static void register(AdvancedContainer mod) {}
}
