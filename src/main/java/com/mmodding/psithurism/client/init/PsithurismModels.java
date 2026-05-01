package com.mmodding.psithurism.client.init;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

// Blockbench Generated Models
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

	public static LayerDefinition createStrawHat() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition group = partdefinition.addOrReplaceChild("group", CubeListBuilder.create(), PartPose.offset(4.0F, 22.0F, 4.0F));

		PartDefinition cube_r1 = group.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 16).addBox(-4.01F, -3.01F, -4.0F, 8.02F, 3.0F, 8.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -7.0F, -3.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(32, 16).addBox(-4.0F, -10.0F, -4.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
			.texOffs(32, 32).addBox(4.0F, -10.0F, -4.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
			.texOffs(0, 27).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

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

	public static LayerDefinition createFoxTail() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition junction = partdefinition.addOrReplaceChild("junction", CubeListBuilder.create().texOffs(0, 25).addBox(-1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

		PartDefinition cube_r1 = junction.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 13).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r2 = junction.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 25).addBox(-3.7014F, -2.3326F, 3.2327F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
			.texOffs(8, 25).addBox(1.2986F, -2.3326F, 3.2327F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
			.texOffs(24, 23).addBox(-3.7014F, 2.6674F, 3.2327F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
			.texOffs(24, 21).addBox(-3.7014F, -2.3326F, 3.2327F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
			.texOffs(0, 13).addBox(-3.7014F, -2.3326F, -3.7673F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7014F, 5.8326F, 11.7673F, -0.2233F, 0.2129F, -0.0479F));

		PartDefinition cube_r3 = junction.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -3.1905F, -2.6252F, 6.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.6905F, 7.6252F, -0.7974F, -0.1536F, 0.1555F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static LayerDefinition createSchoolBag() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, 2.0F, 8.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
			.texOffs(0, 14).addBox(-4.2F, -4.0F, 2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
			.texOffs(0, 14).addBox(4.2F, -4.0F, 2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
			.texOffs(0, 13).addBox(-4.0F, -4.0F, 6.2F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(0, 14).addBox(4.2F, 2.0F, 2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
			.texOffs(0, 14).addBox(-4.2F, 2.0F, 2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
			.texOffs(0, 13).addBox(-4.0F, 2.0F, 6.2F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(0, 14).addBox(-4.01F, -1.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 15).addBox(-4.0F, -4.0F, -1.99F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(8, 14).addBox(-4.0F, -4.0F, -6.01F, 5.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 4.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 15).addBox(-4.0F, -4.0F, -1.99F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(8, 14).addBox(-4.0F, -4.0F, -6.01F, 5.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(0, 14).addBox(-4.01F, -4.0F, -6.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -1.0F, 4.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 14).addBox(-4.01F, -4.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 14).addBox(-4.01F, -5.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	public static LayerDefinition createKoi() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 26).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.5F, -8.0F));

		PartDefinition body_front = partdefinition.addOrReplaceChild("body_front", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.5F, 2.0F, 3.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.5F, -8.0F));

		PartDefinition body_back = partdefinition.addOrReplaceChild("body_back", CubeListBuilder.create().texOffs(0, 11).addBox(-1.5F, -2.5F, 0.0F, 3.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.5F, 0.0F));

		PartDefinition fin_right_r1 = body_back.addOrReplaceChild("fin_right_r1", CubeListBuilder.create().texOffs(18, 19).addBox(-4.5F, -1.0F, -6.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2678F, 1.1464F, 7.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition fin_left_r1 = body_back.addOrReplaceChild("fin_left_r1", CubeListBuilder.create().texOffs(18, 14).addBox(1.5F, -1.0F, -6.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2678F, 1.1464F, 7.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition tail = body_back.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(18, 0).addBox(0.0F, -3.5F, -2.0F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));

		PartDefinition fin_left = partdefinition.addOrReplaceChild("fin_left", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, 0.0F, 2.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 23.0F, -8.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition fin_right = partdefinition.addOrReplaceChild("fin_right", CubeListBuilder.create().texOffs(14, 24).addBox(-3.0F, 0.0F, 2.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 23.0F, -8.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition fin_back_1 = partdefinition.addOrReplaceChild("fin_back_1", CubeListBuilder.create().texOffs(18, 28).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, -3.0F));

		PartDefinition fin_back_2 = partdefinition.addOrReplaceChild("fin_back_2", CubeListBuilder.create().texOffs(10, 28).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}
