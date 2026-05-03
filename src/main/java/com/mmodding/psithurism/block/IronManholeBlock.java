package com.mmodding.psithurism.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.redstone.Orientation;
import org.jspecify.annotations.Nullable;

public class IronManholeBlock extends TrapDoorBlock {

	public IronManholeBlock(BlockSetType type, Properties properties) {
		super(type, properties);
	}

	@Override
	protected void onPlace(final BlockState state, final Level level, final BlockPos pos, final BlockState oldState, final boolean movedByPiston) {
		if (oldState.getBlock() != state.getBlock() && level instanceof ServerLevel serverLevel) {
			this.checkAndFlip(state, serverLevel, pos);
		}
	}

	@Override
	protected void neighborChanged(
		final BlockState state, final Level level, final BlockPos pos, final Block block, @Nullable final Orientation orientation, final boolean movedByPiston
	) {
		if (level instanceof ServerLevel serverLevel) {
			this.checkAndFlip(state, serverLevel, pos);
		}
	}

	public void checkAndFlip(final BlockState state, final ServerLevel level, final BlockPos pos) {
		boolean signal = level.hasNeighborSignal(pos);
		if (signal != state.getValue(POWERED)) {
			BlockState newState = state;
			if (!(Boolean)state.getValue(POWERED)) {
				newState = state.cycle(OPEN);this.playSound(null, level, pos, signal);
			}

			level.setBlock(pos, newState.setValue(POWERED, signal), 3);
		}
	}

	@Override
	protected boolean hasAnalogOutputSignal(final BlockState state) {
		return true;
	}

	@Override
	protected int getAnalogOutputSignal(final BlockState state, final Level level, final BlockPos pos, final Direction direction) {
		return level.getBlockState(pos).getValue(OPEN) ? 15 : 0;
	}
}
