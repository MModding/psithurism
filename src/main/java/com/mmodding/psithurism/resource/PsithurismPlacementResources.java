package com.mmodding.psithurism.resource;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.psithurism.init.PsithurismFeatures;
import com.mmodding.psithurism.init.PsithurismPlacements;
import com.mmodding.psithurism.init.PsithurismWoodSets;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.*;

public class PsithurismPlacementResources {

	public static void configure(AdvancedContainer mod, BootstrapContext<PlacedFeature> context) {
		HolderGetter<Feature> features = context.lookup(Registries.FEATURE);
		PlacementUtils.register(
			context, PsithurismPlacements.DARK_CHERRY_CHECKED,
			features.getOrThrow(PsithurismFeatures.DARK_CHERRY),
			PlacementUtils.filteredByBlockSurvival(PsithurismWoodSets.DARK_CHERRY.getSapling())
		);
		PlacementUtils.register(
			context, PsithurismPlacements.DARK_CHERRY_BEES_005,
			features.getOrThrow(PsithurismFeatures.DARK_CHERRY_BEES_005),
			PlacementUtils.filteredByBlockSurvival(PsithurismWoodSets.DARK_CHERRY.getSapling()));
		PlacementUtils.register(
			context, PsithurismPlacements.CHERRY_GROOVE_DARK_CHERRY,
			features.getOrThrow(PsithurismFeatures.DARK_CHERRY_BEES_005),
			VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 1), Blocks.CHERRY_SAPLING)
		);
		PlacementUtils.register(
			context, PsithurismPlacements.FLOWER_DARK_CHERRY,
			features.getOrThrow(PsithurismFeatures.FLOWER_DARK_CHERRY),
			NoiseThresholdCountPlacement.of(-0.8, 5, 10),
			InSquarePlacement.spread(),
			PlacementUtils.HEIGHTMAP,
			BiomeFilter.biome(),
			CountPlacement.of(24),
			OffsetPlacement.ofTriangle(4, 2),
			BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)
		);
		PlacementUtils.register(
			context, PsithurismPlacements.ONSEN_WATER_LAKE,
			features.getOrThrow(PsithurismFeatures.ONSEN_WATER_LAKE),
			RarityFilter.onAverageOnceEvery(3),
			InSquarePlacement.spread(),
			HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-30), VerticalAnchor.belowTop(30))
		);
	}
}
