package com.mmodding.psithurism.init;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.woodset.api.WoodSet;
import com.mmodding.library.woodset.api.WoodSetBuilder;
import com.mmodding.library.woodset.api.WoodSetSettings;
import com.mmodding.psithurism.Psithurism;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.Optional;

public class PsithurismWoodSets {

	public static final TreeGrower DARK_CHERRY_GROWER = new TreeGrower("dark_cherry", Optional.empty(), Optional.of(PsithurismConfiguredFeatures.DARK_CHERRY), Optional.of(PsithurismConfiguredFeatures.DARK_CHERRY_BEES_005));

	public static final WoodSet DARK_CHERRY = WoodSetBuilder.create(Psithurism.namespace(), "dark_cherry", WoodTypeBuilder.copyOf(WoodType.CHERRY), BlockSetTypeBuilder.copyOf(BlockSetType.CHERRY))
		.withWoodSounds(SoundType.CHERRY_WOOD)
		.withUntintedLeaves(0.1f, PsithurismParticleTypes.DARK_CHERRY_LEAVES)
		.withLeavesSounds(SoundType.CHERRY_LEAVES)
		.withTreeGrower(DARK_CHERRY_GROWER)
		.withSaplingSounds(SoundType.CHERRY_SAPLING)
		.withSettings(WoodSetSettings.create(true, WoodSetSettings.LogDisplay.UV_LOCKED, () -> PsithurismBlocks.GOLDEN_CHAIN))
		.buildAndRegister();

	public static void register(AdvancedContainer mod) {}
}
