package com.mmodding.psithurism.entity;

import com.mmodding.psithurism.init.PsithurismItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.fish.Salmon;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Koi extends Salmon {

	public Koi(EntityType<? extends Salmon> type, Level level) {
		super(type, level);
	}

	@Override
	public ItemStack getBucketItemStack() {
		return PsithurismItems.KOI_WATER_BUCKET.getDefaultInstance();
	}
}
