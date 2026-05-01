package com.mmodding.psithurism.fluid;

import com.mmodding.library.fluid.api.AdvancedFlowableFluid;
import com.mmodding.library.fluid.api.property.FluidProperties;
import com.mmodding.psithurism.init.PsithurismBlocks;
import com.mmodding.psithurism.init.PsithurismFluids;
import com.mmodding.psithurism.init.PsithurismItems;
import com.mmodding.psithurism.init.PsithurismParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public class OnsenWaterFluid extends AdvancedFlowableFluid {

	public OnsenWaterFluid(boolean still) {
		super(BlockStateProperties.LEVEL_FLOWING, still);
	}

	@Override
	protected void createFluidProperties(FluidProperties.Builder builder) {}

	@Override
	public void neighborCollision(Level level, BlockPos blockPos, Direction direction, BlockPos blockPos1) {}

	@Override
	public ParticleOptions getDrippingParticle() {
		return ParticleTypes.DRIPPING_WATER;
	}

	@Override
	public Fluid getFlowing() {
		return PsithurismFluids.FLOWING_ONSEN_WATER;
	}

	@Override
	public Fluid getSource() {
		return PsithurismFluids.ONSEN_WATER;
	}

	@Override
	protected void animateTick(Level level, BlockPos pos, FluidState fluidState, RandomSource random) {
		BlockPos above = pos.above();
		if (level.getBlockState(above).isAir() && !level.getBlockState(above).isSolidRender()) {
			if (random.nextInt(30) == 0) {
				double x = pos.getX() + random.nextDouble();
				double y = pos.getY() + 1.0;
				double z = pos.getZ() + random.nextDouble();
				level.addParticle(PsithurismParticleTypes.ONSEN_STEAM, x, y, z, 0.0, 0.0, 0.0);
				level.playLocalSound(x, y, z, SoundEvents.CAMPFIRE_CRACKLE, SoundSource.AMBIENT, 0.2f + random.nextFloat() * 0.2f, 0.9f + random.nextFloat() * 0.15f, false);
			}
		}
	}

	@Override
	protected boolean canConvertToSource(ServerLevel level) {
		return level.getGameRules().get(GameRules.WATER_SOURCE_CONVERSION);
	}

	@Override
	protected void beforeDestroyingBlock(LevelAccessor level, BlockPos pos, BlockState state) {}

	@Override
	protected int getSlopeFindDistance(LevelReader level) {
		return 4;
	}

	@Override
	protected int getDropOff(LevelReader level) {
		return 1;
	}

	@Override
	public Item getBucket() {
		return PsithurismItems.ONSEN_WATER_BUCKET;
	}

	@Override
	protected boolean canBeReplacedWith(FluidState state, BlockGetter level, BlockPos pos, Fluid other, Direction direction) {
		return direction == Direction.DOWN && !other.isSame(PsithurismFluids.FLOWING_ONSEN_WATER) && !other.isSame(PsithurismFluids.ONSEN_WATER);
	}

	@Override
	public int getTickDelay(LevelReader level) {
		return 5;
	}

	@Override
	protected float getExplosionResistance() {
		return 100.0f;
	}

	@Override
	protected BlockState createLegacyBlock(FluidState fluidState) {
		return PsithurismBlocks.ONSEN_WATER.defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(fluidState));
	}
}
