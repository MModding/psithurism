package com.mmodding.psithurism.client.cosmetic.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

public class OnsenSmokeParticle extends BaseAshSmokeParticle {

	protected OnsenSmokeParticle(ClientLevel level, double x, double y, double z, double xa, double ya, double za, float scale, SpriteSet sprites) {
		super(level, x, y, z, 0.0f, 0.0f, 0.0f, xa, ya, za, scale, sprites, 0.0f, 5, -1.0E-6f, false);
	}

	@Override
	public SingleQuadParticle.Layer getLayer() {
		return SingleQuadParticle.Layer.TRANSLUCENT;
	}

	@Environment(EnvType.CLIENT)
	public static class Provider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet sprites;

		public Provider(final SpriteSet sprites) {
			this.sprites = sprites;
		}

		public Particle createParticle(
			final SimpleParticleType options,
			final ClientLevel level,
			final double x,
			final double y,
			final double z,
			final double xAux,
			final double yAux,
			final double zAux,
			final RandomSource random
		) {
			OnsenSmokeParticle particle = new OnsenSmokeParticle(level, x, y, z, xAux, yAux, zAux, 3.0f, this.sprites);
			particle.setColor(1.0f, 1.0f, 1.0f);
			particle.setAlpha(0.9f);
			return particle;
		}
	}
}
