package com.mmodding.psithurism.client.model;

import com.mmodding.psithurism.client.PsithurismClient;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;

// Made with Blockbench 5.1.3
public class KitsuneMaskModel extends EntityModel<HumanoidRenderState> {

	public KitsuneMaskModel(EntityRendererProvider.Context context) {
		super(context.bakeLayer(PsithurismClient.KITSUNE_MASK));
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
}
