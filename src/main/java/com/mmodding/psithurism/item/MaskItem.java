package com.mmodding.psithurism.item;

import com.mmodding.psithurism.init.PsithurismDataComponents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MaskItem extends Item {

	public MaskItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult use(Level level, Player player, InteractionHand hand) {
		if (!level.isClientSide()) {
			ItemStack stack = player.getItemInHand(hand);
			boolean worn = stack.getOrDefault(PsithurismDataComponents.WORN_MASK, false);
			stack.set(PsithurismDataComponents.WORN_MASK, !worn);
		}
		return InteractionResult.SUCCESS;
	}
}
