package com.mmodding.psithurism.init;

import com.mmodding.library.block.entity.api.BlockEntityTypeSupport;
import com.mmodding.library.core.api.AdvancedContainer;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class PsithurismBlockEntities {

	public static void register(AdvancedContainer mod) {
		BlockEntityTypeSupport.callbackOf(BlockEntityType.SIGN).register(BlockEntityTypeSupport.callbackOf(BlockEntityType.SIGN).defaultPhaseId(), supportedBlocks -> {
			supportedBlocks.add(PsithurismBlocks.DARK_CHERRY.get(BlockFamily.Variant.SIGN));
			supportedBlocks.add(PsithurismBlocks.DARK_CHERRY.get(BlockFamily.Variant.WALL_SIGN));
		});
	}
}
