package com.mmodding.psithurism.client.init;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

// Blockbench Generated Models
public class PsithurismModels {

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
