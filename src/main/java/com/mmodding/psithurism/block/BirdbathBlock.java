package com.mmodding.psithurism.block;

import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

public class BirdbathBlock extends Block implements BucketPickup {

	public static final BooleanProperty WATER_FILLED = BooleanProperty.create("water_filled");

	private static final VoxelShape SHAPE = Block.column(12.0f, 0.0f, 10.0f);

	public BirdbathBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(WATER_FILLED, false));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(WATER_FILLED);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	protected InteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
		if (level.mayInteract(player, pos) && player.mayUseItemAt(pos.relative(hitResult.getDirection()), hitResult.getDirection(), itemStack) && !state.getValue(WATER_FILLED) && itemStack.is(ConventionalItemTags.WATER_BUCKETS) && itemStack.getItem() instanceof BucketItem bucketItem) {
			level.setBlock(pos, state.setValue(WATER_FILLED, true), 11);
			ItemStack emptyResult = ItemUtils.createFilledResult(itemStack, player, bucketItem.getEmptySuccessItem(itemStack, player));
			return InteractionResult.SUCCESS.heldItemTransformedTo(emptyResult);
		}
		else {
			return super.useItemOn(itemStack, state, level, pos, player, hand, hitResult);
		}
	}

	@Override
	public ItemStack pickupBlock(@Nullable LivingEntity user, LevelAccessor level, BlockPos pos, BlockState state) {
		if (state.getValue(WATER_FILLED)) {
			level.setBlock(pos, state.setValue(WATER_FILLED, false), 11);
			return new ItemStack(Fluids.WATER.getBucket());
		}
		else {
			return ItemStack.EMPTY;
		}
	}

	@Override
	public Optional<SoundEvent> getPickupSound() {
		return Fluids.WATER.getPickupSound();
	}
}
