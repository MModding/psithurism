package com.mmodding.psithurism.client.model;

import com.mmodding.psithurism.client.PsithurismClient;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;

// Made with Blockbench 5.1.3
public class OniMaskModel extends EntityModel<HumanoidRenderState> {

	public static EntityModel<HumanoidRenderState> normal(EntityRendererProvider.Context context) {
		return new OniMaskModel(context.bakeLayer(PsithurismClient.ONI_MASK));
	}

	public static EntityModel<HumanoidRenderState> worn(EntityRendererProvider.Context context) {
		return new OniMaskModel(context.bakeLayer(PsithurismClient.WORN_ONI_MASK));
	}

	public OniMaskModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createMaskLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 18).addBox(-4.1723F, -2.0237F, 0.3701F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(-4.1723F, -3.0237F, -0.6299F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1723F, 19.0F, -4.5865F, -2.9234F, 0.7854F, 3.1416F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 2).addBox(3.153F, 1.9763F, 0.847F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 2.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 21).addBox(2.847F, 1.9763F, 0.847F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
			.texOffs(18, 2).addBox(2.847F, -6.0237F, 0.847F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5865F, 0.0F, -2.2419F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 21).addBox(0.0F, -0.3244F, 0.2627F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1723F, 1.5399F, -1.2974F, 0.6109F, 0.0F, 0.0F));

		PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(18, 18).addBox(1.153F, -6.0237F, 1.4334F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1723F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 0).addBox(-4.0F, -4.0F, -4.01F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(18, 1).addBox(-4.0F, -4.0F, 4.01F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(0, 9).addBox(4.01F, -4.0F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
			.texOffs(16, 9).addBox(-4.01F, -4.0F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static LayerDefinition createWornMaskLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, 0.0F, 1.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.0F, -4.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 2).addBox(3.0F, 4.0F, 1.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8277F, 0.0F, 2.4135F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 21).addBox(3.0F, 4.0F, 1.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
			.texOffs(18, 2).addBox(3.0F, -4.0F, 1.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4142F, 0.0F, -1.8284F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 21).addBox(0.0F, 1.4575F, -0.7207F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.5399F, -0.8839F, 0.6109F, 0.0F, 0.0F));

		PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(18, 18).addBox(1.0F, -4.0F, 1.5865F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.4135F, 0.0F, 0.7854F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 0).addBox(-4.0F, -2.0F, -4.01F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(18, 1).addBox(-4.0F, -4.0F, 4.01F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(0, 9).addBox(4.01F, -4.0F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
			.texOffs(16, 9).addBox(-4.01F, -4.0F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}
