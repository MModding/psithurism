package com.mmodding.psithurism.block.entity;

import com.mmodding.psithurism.block.TeruTeruBozuBlock;
import com.mmodding.psithurism.init.PsithurismBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class TeruTeruBozuBlockEntity extends BlockEntity {

	private static final int PER_LEVEL_RECOVERY = 4 * 24000; // 4 in-game days
	private static final int FULL_RECOVERY = 4 * PER_LEVEL_RECOVERY; // 4 levels

	private int willPower = 4 * PER_LEVEL_RECOVERY; // shut up Mona

	public TeruTeruBozuBlockEntity(BlockPos worldPosition, BlockState blockState) {
		super(PsithurismBlockEntityTypes.TERU_TERU_BOZU, worldPosition, blockState);
	}

	public boolean canConsumeLevel() {
		return this.willPower >= PER_LEVEL_RECOVERY; // 1 level
	}

	public void consumeLevel(Level level, BlockPos pos, BlockState state) {
		this.willPower -= PER_LEVEL_RECOVERY;
		level.setBlock(pos, state.setValue(TeruTeruBozuBlock.NECKLACE, state.getValue(TeruTeruBozuBlock.NECKLACE) - 1), Block.UPDATE_ALL);
	}

	public static void tick(Level level, BlockPos pos, BlockState state, TeruTeruBozuBlockEntity blockEntity) {
		if (blockEntity.willPower < FULL_RECOVERY) {
			blockEntity.willPower += 1;
			int oldLevel = state.getValue(TeruTeruBozuBlock.NECKLACE);
			int newLevel = blockEntity.willPower / PER_LEVEL_RECOVERY;
			if (oldLevel != newLevel) {
				state.setValue(TeruTeruBozuBlock.NECKLACE, newLevel);
			}
		}
	}

	@Override
	protected void saveAdditional(ValueOutput output) {
		output.putInt("will_power", this.willPower);
		super.saveAdditional(output);
	}

	@Override
	protected void loadAdditional(ValueInput input) {
		this.willPower = input.getIntOr("will_power", FULL_RECOVERY);
		super.loadAdditional(input);
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
		return saveWithoutMetadata(registries);
	}
}
