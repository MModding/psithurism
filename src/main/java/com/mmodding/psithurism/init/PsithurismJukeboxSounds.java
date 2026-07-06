package com.mmodding.psithurism.init;

import com.mmodding.psithurism.Psithurism;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;

public class PsithurismJukeboxSounds {

	public static final ResourceKey<JukeboxSong> TALES_OF_YORE = Psithurism.createKey(Registries.JUKEBOX_SONG, "tales_of_yore");
	public static final ResourceKey<JukeboxSong> REST = Psithurism.createKey(Registries.JUKEBOX_SONG, "rest");
}
