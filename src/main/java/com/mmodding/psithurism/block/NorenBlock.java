package com.mmodding.psithurism.block;

import com.mmodding.library.block.api.catalog.sized.FacingSizedBlock;
import com.mmodding.library.block.api.catalog.sized.SizeManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class NorenBlock extends FacingSizedBlock {

	public static final SizeManager MANAGER = SizeManager.create(1, 3, 1);

	public NorenBlock(Properties properties) {
		super(true, properties);
	}

	@Override
	protected SizeManager getSizeManager() {
		return MANAGER;
	}

	@Override
	protected Vec3i getPlacementOrigin(BlockState state) {
		return new Vec3i(0, 2, 0);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return LadderBlock.SHAPES.get(state.getValue(this.getFacingProperty()));
	}
}
