package com.mmodding.psithurism.resource;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.psithurism.init.PsithurismJukeboxSounds;
import com.mmodding.psithurism.init.PsithurismSoundEvents;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.JukeboxSong;

public class PsithurismJukeboxSoundResources {

	public static void configure(AdvancedContainer mod, BootstrapContext<JukeboxSong> context) {
		context.register(PsithurismJukeboxSounds.TALES_OF_YORE, new JukeboxSong(PsithurismSoundEvents.TALES_OF_YORE, Component.translatable("item.psithurism.music_disc_tales_of_yore.desc"), 73.014f, 6));
		context.register(PsithurismJukeboxSounds.REST, new JukeboxSong(PsithurismSoundEvents.REST, Component.translatable("item.psithurism.music_disc_rest.desc"), 173.164f, 2));
	}
}
