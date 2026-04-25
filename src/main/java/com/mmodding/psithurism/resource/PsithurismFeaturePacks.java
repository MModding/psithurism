package com.mmodding.psithurism.resource;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.worldgen.api.feature.FeaturePack;
import com.mmodding.psithurism.init.PsithurismBlocks;
import com.mmodding.psithurism.init.PsithurismConfiguredFeatures;
import com.mmodding.psithurism.init.PsithurismPlacedFeatures;
import com.mmodding.psithurism.init.PsithurismWoodSets;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

import java.util.List;

public class PsithurismFeaturePacks {

	private static final FeaturePack<TreeConfiguration> DARK_CHERRY = FeaturePack.of(Feature.TREE)
		.replicateConfiguredFeature(
			TreeFeatures.CHERRY,
			PsithurismConfiguredFeatures.DARK_CHERRY,
			configuration -> new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(PsithurismWoodSets.DARK_CHERRY.getLog()),
				configuration.trunkPlacer,
				BlockStateProvider.simple(PsithurismWoodSets.DARK_CHERRY.getLeaves()),
				configuration.foliagePlacer,
				configuration.minimumSize
			).build(),
			pack -> pack.replicatePlacedFeature(
				TreePlacements.CHERRY_CHECKED,
				PsithurismPlacedFeatures.DARK_CHERRY_CHECKED,
				modifiers -> modifiers.mutateTypeTo(
					PlacementModifierType.BLOCK_PREDICATE_FILTER,
					_ -> PlacementUtils.filteredByBlockSurvival(PsithurismWoodSets.DARK_CHERRY.getSapling())
				)
			)
		)
		.replicateConfiguredFeature(
			TreeFeatures.CHERRY_BEES_005,
			PsithurismConfiguredFeatures.DARK_CHERRY_BEES_005,
			configuration -> new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(PsithurismWoodSets.DARK_CHERRY.getLog()),
				configuration.trunkPlacer,
				BlockStateProvider.simple(PsithurismWoodSets.DARK_CHERRY.getLeaves()),
				configuration.foliagePlacer,
				configuration.minimumSize
			).decorators(List.of(new BeehiveDecorator(0.05f))).build(),
			pack -> pack.replicatePlacedFeature(
				TreePlacements.CHERRY_BEES_005,
				PsithurismPlacedFeatures.DARK_CHERRY_BEES_005,
				modifiers -> modifiers.mutateTypeTo(
					PlacementModifierType.BLOCK_PREDICATE_FILTER,
					_ -> PlacementUtils.filteredByBlockSurvival(PsithurismWoodSets.DARK_CHERRY.getSapling())
				)
			)
		);

	private static final FeaturePack<SimpleBlockConfiguration> FLOWER_DARK_CHERRY = FeaturePack.of(Feature.SIMPLE_BLOCK)
		.replicateConfiguredFeature(
			VegetationFeatures.FLOWER_CHERRY,
			PsithurismConfiguredFeatures.FLOWER_DARK_CHERRY,
			_ -> new SimpleBlockConfiguration(new WeightedStateProvider(VegetationFeatures.flowerBedPatchBuilder(PsithurismBlocks.WHITE_PETALS))),
			pack -> pack.replicatePlacedFeature(
				VegetationPlacements.FLOWER_CHERRY,
				PsithurismPlacedFeatures.FLOWER_DARK_CHERRY,
				modifiers -> modifiers.mutateTypeTo(PlacementModifierType.COUNT, _ -> CountPlacement.of(12))
			)
		);

	public static void registerConfigs(AdvancedContainer mod, BootstrapContext<ConfiguredFeature<?, ?>> context) {
		DARK_CHERRY.registerConfigs(context);
		FLOWER_DARK_CHERRY.registerConfigs(context);
	}

	public static void registerPlacements(AdvancedContainer mod, BootstrapContext<PlacedFeature> context) {
		DARK_CHERRY.registerPlacements(context);
		FLOWER_DARK_CHERRY.registerPlacements(context);
	}
}
