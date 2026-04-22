package com.mmodding.psithurism.client.init;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class PsithurismModels {

	public static LayerDefinition createKitsune() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(18, 0).addBox(-4.0F, -5.0F, -4.01F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(0, 11).addBox(4.01F, -5.0F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
			.texOffs(16, 11).addBox(-4.01F, -5.0F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
			.texOffs(18, 1).addBox(-4.0F, -5.0F, 4.01F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(18, 2).addBox(-2.0F, 2.0F, 1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(-4.0F, -6.0F, 0.0F, 8.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -5.0F, 4.0F, 0.3054F, -0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static LayerDefinition createWornKitsune() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(18, 0).addBox(-12.0F, -7.0F, 3.99F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(0, 11).addBox(-3.99F, -7.0F, 4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
			.texOffs(16, 11).addBox(-12.01F, -7.0F, 4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
			.texOffs(18, 1).addBox(-12.0F, -5.0F, 12.01F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(-12.0F, -11.0F, 12.0F, 8.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
			.texOffs(18, 2).addBox(-10.0F, -3.0F, 13.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 23.0F, 8.0F, 0.0F, 3.1416F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static LayerDefinition createOni() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 18).addBox(-4.1723F, -5.9289F, 1.2358F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(-4.1723F, -6.9289F, 0.2358F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1723F, 19.0F, -4.5865F, -2.9234F, 0.7854F, 3.1416F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 2).addBox(2.5409F, -1.9289F, 1.4591F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 2.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 21).addBox(3.4591F, -1.9289F, 1.4591F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
			.texOffs(18, 2).addBox(3.4591F, -9.9289F, 1.4591F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5865F, 0.0F, -2.2419F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 21).addBox(0.0F, -3.0268F, 3.2118F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1723F, 1.5399F, -1.2974F, 0.6109F, 0.0F, 0.0F));

		PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(18, 18).addBox(0.5409F, -9.9289F, 2.0456F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1723F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 0).addBox(-4.0F, -8.0F, -4.01F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(18, 1).addBox(-4.0F, -8.0F, 4.01F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(0, 9).addBox(4.01F, -8.0F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
			.texOffs(16, 9).addBox(-4.01F, -8.0F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static LayerDefinition createWornOni() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, -4.0F, 1.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(-4.0F, -5.0F, 0.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.0F, -4.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 2).addBox(3.0F, 0.0F, 1.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8277F, 0.0F, 2.4135F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 21).addBox(3.0F, 0.0F, 1.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
			.texOffs(18, 2).addBox(3.0F, -8.0F, 1.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4142F, 0.0F, -1.8284F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 21).addBox(0.0F, -1.8191F, 1.5736F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.5399F, -0.8839F, 0.6109F, 0.0F, 0.0F));

		PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(18, 18).addBox(1.0F, -8.0F, 1.5865F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.4135F, 0.0F, 0.7854F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 0).addBox(-4.0F, -6.0F, -4.01F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(18, 1).addBox(-4.0F, -8.0F, 4.01F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(0, 9).addBox(4.01F, -8.0F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
			.texOffs(16, 9).addBox(-4.01F, -8.0F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static LayerDefinition createFoxEars() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(10, 0).addBox(-2.0F, -4.0F, -1.01F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(-3.0F, -3.0F, -1.01F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -10.0F, -3.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -4.0F, -1.01F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
			.texOffs(0, 5).addBox(0.0F, -3.0F, -1.01F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -10.0F, -3.0F, 0.0F, 0.0F, 0.7854F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}
}
