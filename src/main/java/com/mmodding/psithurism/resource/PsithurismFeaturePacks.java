package com.mmodding.psithurism.resource;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.worldgen.api.feature.FeaturePack;
import com.mmodding.library.worldgen.api.feature.MModdingFeatures;
import com.mmodding.library.worldgen.api.feature.catalog.configurations.AdvancedLiquidVegetationPatchConfiguration;
import com.mmodding.psithurism.init.PsithurismBlocks;
import com.mmodding.psithurism.init.PsithurismConfiguredFeatures;
import com.mmodding.psithurism.init.PsithurismPlacedFeatures;
import com.mmodding.psithurism.init.PsithurismWoodSets;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.placement.*;

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
			pack -> pack.appendPlacedFeature(
				PsithurismPlacedFeatures.DARK_CHERRY_CHECKED,
				PlacementUtils.filteredByBlockSurvival(PsithurismWoodSets.DARK_CHERRY.getSapling())
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
			pack -> pack
				.appendPlacedFeature(
					PsithurismPlacedFeatures.DARK_CHERRY_BEES_005,
					PlacementUtils.filteredByBlockSurvival(PsithurismWoodSets.DARK_CHERRY.getSapling())
				)
				.appendPlacedFeature(
					PsithurismPlacedFeatures.CHERRY_GROOVE_DARK_CHERRY,
					VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 1), Blocks.CHERRY_SAPLING)
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
				modifiers -> modifiers
					.replace(PlacementModifierType.COUNT, CountPlacement.of(24))
					.replace(PlacementModifierType.RANDOM_OFFSET, RandomOffsetPlacement.ofTriangle(4, 2))
			)
		);

	private static final FeaturePack<AdvancedLiquidVegetationPatchConfiguration> ONSEN_WATER_LAKE = FeaturePack.of(MModdingFeatures.ADVANCED_LIQUID_VEGETATION_PATCH)
		.appendConfiguredFeature(
			PsithurismConfiguredFeatures.ONSEN_WATER_LAKE,
			new AdvancedLiquidVegetationPatchConfiguration(
				BlockTags.BASE_STONE_OVERWORLD,
				BlockStateProvider.simple(PsithurismBlocks.ASHINO_STONE.getMain()),
				BlockStateProvider.simple(PsithurismBlocks.ONSEN_WATER),
				PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
					BlockStateProvider.simple(PsithurismBlocks.ASHINO_STONE.get(BlockFamily.Variant.SLAB))
				)),
				CaveSurface.FLOOR,
				UniformInt.of(3, 6),
				0.1f,
				6,
				0.2f,
				UniformInt.of(6, 9),
				0.1f
			),
			pack -> pack.appendPlacedFeature(
				PsithurismPlacedFeatures.ONSEN_WATER_LAKE,
				RarityFilter.onAverageOnceEvery(3),
				InSquarePlacement.spread(),
				HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-30), VerticalAnchor.belowTop(30))
			)
		);

	public static void registerConfigs(AdvancedContainer mod, BootstrapContext<ConfiguredFeature<?, ?>> context) {
		DARK_CHERRY.registerConfigs(context);
		FLOWER_DARK_CHERRY.registerConfigs(context);
		ONSEN_WATER_LAKE.registerConfigs(context);
	}

	public static void registerPlacements(AdvancedContainer mod, BootstrapContext<PlacedFeature> context) {
		DARK_CHERRY.registerPlacements(context);
		FLOWER_DARK_CHERRY.registerPlacements(context);
		ONSEN_WATER_LAKE.registerPlacements(context);
	}
}
