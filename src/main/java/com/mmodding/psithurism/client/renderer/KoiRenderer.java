package com.mmodding.psithurism.client.renderer;

import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.client.init.PsithurismModelLayers;
import com.mmodding.psithurism.entity.Koi;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.animal.fish.SalmonModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.SalmonRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import org.jspecify.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class KoiRenderer extends MobRenderer<Koi, SalmonRenderState, SalmonModel> {

	private static final Identifier KOI_LOCATION = Psithurism.createId("textures/entity/fish/koi.png");

	private final SalmonModel koiModel;
	private final SalmonModel largeKoiModel;
	private final SalmonModel smallKoiModel;

	public KoiRenderer(final EntityRendererProvider.Context context) {
		super(context, new SalmonModel(context.bakeLayer(PsithurismModelLayers.KOI)), 0.4f);
		this.koiModel = new SalmonModel(context.bakeLayer(PsithurismModelLayers.KOI));
		this.largeKoiModel = new SalmonModel(context.bakeLayer(PsithurismModelLayers.KOI_LARGE));
		this.smallKoiModel = new SalmonModel(context.bakeLayer(PsithurismModelLayers.KOI_SMALL));
	}

	public void extractRenderState(final Koi entity, final SalmonRenderState state, final float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
	}

	public Identifier getTextureLocation(final SalmonRenderState state) {
		return KOI_LOCATION;
	}

	@Override
	protected @Nullable RenderType getRenderType(SalmonRenderState state, boolean isBodyVisible, boolean forceTransparent, boolean appearGlowing) {
		Identifier texture = this.getTextureLocation(state);
		if (forceTransparent) {
			return RenderTypes.entityTranslucentCullItemTarget(texture);
		} else if (isBodyVisible) {
			return RenderTypes.entityTranslucent(texture); // I'm defining translucency here because I don't want to copy SalmonModel for a single change
		} else {
			return appearGlowing ? RenderTypes.outline(texture) : null;
		}
	}

	public SalmonRenderState createRenderState() {
		return new SalmonRenderState();
	}

	protected void setupRotations(final SalmonRenderState state, final PoseStack poseStack, final float bodyRot, final float entityScale) {
		super.setupRotations(state, poseStack, bodyRot, entityScale);

		float amplitudeMultiplier = 1.0f;
		float angleMultiplier = 1.0f;

		if (!state.isInWater) {
			amplitudeMultiplier = 1.3f;
			angleMultiplier = 1.7f;
		}

		float bodyZRot = amplitudeMultiplier * 4.3f * Mth.sin(angleMultiplier * 0.6f * state.ageInTicks);
		poseStack.mulPose(Axis.YP.rotationDegrees(bodyZRot));

		if (!state.isInWater) {
			poseStack.translate(0.2f, 0.1f, 0.0f);
			poseStack.mulPose(Axis.ZP.rotationDegrees(90.0f));
		}
	}

	public void submit(final SalmonRenderState state, final PoseStack poseStack, final SubmitNodeCollector submitNodeCollector, final CameraRenderState camera) {
		this.model = switch (state.variant) {
			case SMALL -> this.smallKoiModel;
			case MEDIUM -> this.koiModel;
			case LARGE -> this.largeKoiModel;
		};
		super.submit(state, poseStack, submitNodeCollector, camera);
	}
}
