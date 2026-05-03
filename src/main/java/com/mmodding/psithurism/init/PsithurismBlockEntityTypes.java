package com.mmodding.psithurism.init;

import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.psithurism.block.entity.TeruTeruBozuBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class PsithurismBlockEntityTypes {

	public static final BlockEntityType<TeruTeruBozuBlockEntity> TERU_TERU_BOZU = FabricBlockEntityTypeBuilder.create(TeruTeruBozuBlockEntity::new, PsithurismBlocks.TERU_TERU_BOZU).build();

	public static void register(AdvancedContainer mod) {
		mod.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, "teru_teru_bozu", TERU_TERU_BOZU);
	}
}
