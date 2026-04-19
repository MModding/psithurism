package com.mmodding.psithurism.resource;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.worldgen.api.feature.FeaturePack;
import com.mmodding.psithurism.init.PsithurismConfiguredFeatures;
import com.mmodding.psithurism.init.PsithurismWoodSets;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;

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
			_ -> {}
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
			_ -> {}
		);

	public static void register(AdvancedContainer mod, FabricDynamicRegistryProvider.Entries registerable) {
		DARK_CHERRY.register(registerable);
	}
}
