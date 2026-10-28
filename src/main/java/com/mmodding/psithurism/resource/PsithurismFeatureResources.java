package com.mmodding.psithurism.resource;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.levelgen.api.feature.catalog.AdvancedLiquidVegetationPatchFeature;
import com.mmodding.psithurism.init.PsithurismBlocks;
import com.mmodding.psithurism.init.PsithurismFeatures;
import com.mmodding.psithurism.init.PsithurismWoodSets;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.worldgen.BlockStateProviders;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class PsithurismFeatureResources {

	private static TreeFeature.Builder darkCherry(BootstrapContext<Feature> context) {
		return new TreeFeature.Builder(
			BlockStateProvider.of(PsithurismWoodSets.DARK_CHERRY.getLog()),
			new CherryTrunkPlacer(
				7,
				1,
				0,
				new WeightedListInt(WeightedList.<IntProvider>builder().add(ConstantInt.of(1), 1).add(ConstantInt.of(2), 1).add(ConstantInt.of(3), 1).build()),
				UniformInt.of(2, 4),
				UniformInt.of(-4, -3),
				UniformInt.of(-1, 0)
			),
			BlockStateProvider.of(PsithurismWoodSets.DARK_CHERRY.getLeaves()),
			new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25f, 0.5f, 0.16666667f, 0.33333334f),
			new TwoLayersFeatureSize(1, 0, 2),
			context.lookup(Registries.BLOCK_STATE_PROVIDER).getOrThrow(BlockStateProviders.SOIL_BENEATH_TREE)
		).ignoreVines();
	}

	public static void configure(AdvancedContainer mod, BootstrapContext<Feature> context) {
		context.register(PsithurismFeatures.DARK_CHERRY, darkCherry(context).build());
		BeehiveDecorator beehive005 = new BeehiveDecorator(0.05f);
		context.register(PsithurismFeatures.DARK_CHERRY_BEES_005, darkCherry(context).decorators(List.of(beehive005)).build());
		context.register(PsithurismFeatures.FLOWER_DARK_CHERRY, new SimpleBlockFeature(new WeightedStateProvider(VegetationFeatures.flowerBedPatchBuilder(PsithurismBlocks.WHITE_PETALS))));
		context.register(PsithurismFeatures.ONSEN_WATER_LAKE, new AdvancedLiquidVegetationPatchFeature(
			BlockStateProvider.holderOf(PsithurismBlocks.ONSEN_WATER),
			context.lookup(Registries.BLOCK).getOrThrow(BlockTags.BASE_STONE_OVERWORLD),
			BlockStateProvider.holderOf(PsithurismBlocks.ASHINO_STONE.getMain()),
			PlacementUtils.inlinePlaced(new SimpleBlockFeature(BlockStateProvider.of(PsithurismBlocks.ASHINO_STONE.get(BlockFamily.Variant.SLAB)))),
			CaveSurface.FLOOR,
			UniformInt.of(3, 6),
			0.1f,
			6,
			0.2f,
			UniformInt.of(6, 9),
			0.1f
		));
	}
}
