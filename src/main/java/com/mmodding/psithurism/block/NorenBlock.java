package com.mmodding.psithurism.block;

import com.mmodding.library.block.api.catalog.sized.FacingSizedBlock;
import com.mmodding.library.java.api.container.Unit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class NorenBlock extends FacingSizedBlock {

	public static final IntegerProperty Y = FacingSizedBlock.makeOfSize(SizeAxis.HEIGHT, 3);

	public NorenBlock(Properties properties) {
		super(true, properties);
	}

	@Override
	protected BlockState setInnerX(BlockState state, int x) {
		return state;
	}

	@Override
	protected BlockState setInnerY(BlockState state, int y) {
		return state.setValue(Y, y);
	}

	@Override
	protected BlockState setInnerZ(BlockState state, int z) {
		return state;
	}

	@Override
	protected int getInnerX(BlockState state) {
		return 0;
	}

	@Override
	protected int getInnerY(BlockState state) {
		return state.getValue(Y);
	}

	@Override
	protected int getInnerZ(BlockState state) {
		return 0;
	}

	@Override
	protected int getLength() {
		return 1;
	}

	@Override
	protected int getHeight() {
		return 3;
	}

	@Override
	protected int getWidth() {
		return 1;
	}

	// shifting the placement check for it to be considered from the top
	@Override
	public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
		BlockState candidate = this.getCandidateForPlacement(ctx);
		Unit.Mutable<Boolean> noBlockCollisions = Unit.mutable(true);
		this.forEach(
			ctx.getLevel(), ctx.getClickedPos().below(this.getHeight() - 1), candidate,
			(_, state, _) -> noBlockCollisions.mutateValue(noBlockCollisions.value() && state.canBeReplaced())
		);
		if (noBlockCollisions.value()) {
			return candidate;
		}
		else {
			return null;
		}
	}

	// shifting the placement check for it to be considered from the top
	@Override
	public boolean canSurvive(BlockState blockState, LevelReader world, BlockPos blockPos) {
		return super.canSurvive(blockState, world, blockPos.below(this.getHeight() - 1));
	}

	// shifting the placement for it to be considered from the top
	@Override
	public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
		super.setPlacedBy(level, pos.below(this.getHeight() - 1), state, entity, stack);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return LadderBlock.SHAPES.get(state.getValue(this.getFacingProperty()));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(Y);
	}

	@Override
	protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
		if (this.drops.isEmpty()) {
			return Collections.emptyList();
		}

		LootParams lootParams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
		ServerLevel level = lootParams.getLevel();
		LootTable table = level.getServer().reloadableRegistries().getLootTable(this.drops.get());
		return table.getRandomItems(lootParams);
	}
}
