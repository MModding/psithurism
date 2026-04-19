package com.mmodding.psithurism.client.model;

import com.mmodding.psithurism.client.PsithurismClient;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;

// Made with Blockbench 5.1.3
public class KitsuneMaskModel extends EntityModel<HumanoidRenderState> {

	public static EntityModel<HumanoidRenderState> normal(EntityRendererProvider.Context context) {
		return new KitsuneMaskModel(context.bakeLayer(PsithurismClient.KITSUNE_MASK));
	}

	public static EntityModel<HumanoidRenderState> worn(EntityRendererProvider.Context context) {
		return new KitsuneMaskModel(context.bakeLayer(PsithurismClient.WORN_KITSUNE_MASK));
	}

	public KitsuneMaskModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createMaskLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(18, 0).addBox(-4.0F, -4.0F, -4.01F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(0, 11).addBox(4.01F, -4.0F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
			.texOffs(16, 11).addBox(-4.01F, -4.0F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
			.texOffs(18, 1).addBox(-4.0F, -4.0F, 4.01F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(18, 2).addBox(-2.0F, 2.0F, 1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(-4.0F, -6.0F, 0.0F, 8.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.0F, 4.0F, 0.3054F, -0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static LayerDefinition createWornMaskLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(18, 0).addBox(-12.0F, -7.0F, 3.99F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(0, 11).addBox(-3.99F, -7.0F, 4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
			.texOffs(16, 11).addBox(-12.01F, -7.0F, 4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
			.texOffs(18, 1).addBox(-12.0F, -5.0F, 12.01F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(-12.0F, -11.0F, 12.0F, 8.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
			.texOffs(18, 2).addBox(-10.0F, -3.0F, 13.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 27.0F, 8.0F, 0.0F, 3.1416F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}
