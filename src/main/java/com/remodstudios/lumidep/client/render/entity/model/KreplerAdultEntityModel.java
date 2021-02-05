package com.remodstudios.lumidep.client.render.entity.model;


import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class KreplerAdultEntityModel extends SinglePartEntityModel<Entity> {
/*	private final ModelPart bone;
	private final ModelPart bone_r1;
	private final ModelPart bone_r2;
	private final ModelPart bone_r3;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone9;
	private final ModelPart bone11;
	private final ModelPart bone10;
	private final ModelPart bone12;
	private final ModelPart bone5;
	private final ModelPart bone7;
	private final ModelPart bone8;
	private final ModelPart bone4;
	private final ModelPart bone4_r1;
	private final ModelPart bone4_r2;
	private final ModelPart bone6;
	private final ModelPart bone6_r1;
	private final ModelPart bone6_r2;
	private final ModelPart bone6_r3;*/

	public KreplerAdultEntityModel() {
/*		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelPart(this);
		bone.setRotationPoint(8.0F, -31.0F, -6.0F);
		

		bone_r1 = new ModelPart(this);
		bone_r1.setRotationPoint(1.0F, 12.0F, 2.0F);
		bone.addChild(bone_r1);
		setRotationAngle(bone_r1, 0.0873F, 0.0F, 0.0F);
		bone_r1.setTextureOffset(60, 64).addBox(-1.0F, -13.0F, -1.0F, 3.0F, 56.0F, 3.0F, 0.0F, false);

		bone_r2 = new ModelPart(this);
		bone_r2.setRotationPoint(1.0F, 12.0F, -3.0F);
		bone.addChild(bone_r2);
		setRotationAngle(bone_r2, -0.0873F, 0.0F, 0.0F);
		bone_r2.setTextureOffset(60, 64).addBox(-1.0F, -13.0F, -2.0F, 3.0F, 56.0F, 3.0F, 0.0F, false);

		bone_r3 = new ModelPart(this);
		bone_r3.setRotationPoint(1.0F, 12.0F, 0.0F);
		bone.addChild(bone_r3);
		setRotationAngle(bone_r3, 0.0F, 0.0F, -0.0873F);
		bone_r3.setTextureOffset(60, 64).addBox(-1.0F, -13.0F, -2.0F, 3.0F, 56.0F, 3.0F, 0.0F, false);

		bone2 = new ModelPart(this);
		bone2.setRotationPoint(-8.0F, -19.0F, -10.0F);
		

		bone3 = new ModelPart(this);
		bone3.setRotationPoint(0.0F, -40.0F, -15.0F);
		bone3.setTextureOffset(0, 0).addBox(-12.0F, 0.0F, -5.0F, 24.0F, 9.0F, 27.0F, 0.0F, false);

		bone9 = new ModelPart(this);
		bone9.setRotationPoint(12.0F, 4.0F, 0.0F);
		bone3.addChild(bone9);
		setRotationAngle(bone9, 0.0F, -1.309F, 0.0F);
		bone9.setTextureOffset(72, 84).addBox(0.0F, -10.0F, 0.0F, 15.0F, 20.0F, 0.0F, 0.0F, false);

		bone11 = new ModelPart(this);
		bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone3.addChild(bone11);
		setRotationAngle(bone11, -0.9599F, 0.0F, 0.0F);
		bone11.setTextureOffset(0, 0).addBox(-6.0F, -13.0F, 0.0F, 12.0F, 13.0F, 0.0F, 0.0F, false);

		bone10 = new ModelPart(this);
		bone10.setRotationPoint(-12.0F, 4.0F, 0.0F);
		bone3.addChild(bone10);
		setRotationAngle(bone10, 0.0F, 1.309F, 0.0F);
		bone10.setTextureOffset(75, 0).addBox(-15.0F, -10.0F, 0.0F, 15.0F, 20.0F, 0.0F, 0.0F, false);

		bone12 = new ModelPart(this);
		bone12.setRotationPoint(0.0F, 7.0F, -4.0F);
		bone3.addChild(bone12);
		bone12.setTextureOffset(34, 52).addBox(2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 1.0F, 0.0F, false);
		bone12.setTextureOffset(24, 52).addBox(-6.0F, -1.0F, -2.0F, 4.0F, 9.0F, 1.0F, 0.0F, false);

		bone5 = new ModelPart(this);
		bone5.setRotationPoint(-2.0F, 25.0F, -21.0F);
		bone3.addChild(bone5);
		setRotationAngle(bone5, 0.8727F, 0.0F, 0.0F);
		bone5.setTextureOffset(30, 36).addBox(1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 26.0F, 0.0F, false);

		bone7 = new ModelPart(this);
		bone7.setRotationPoint(1.5F, 0.0F, 0.0F);
		bone5.addChild(bone7);
		bone7.setTextureOffset(0, 104).addBox(0.0F, -1.0F, -7.0F, 0.0F, 4.0F, 7.0F, 0.0F, false);
		bone7.setTextureOffset(0, 13).addBox(-2.0F, -1.0F, -7.0F, 3.0F, 4.0F, 7.0F, 0.0F, false);

		bone8 = new ModelPart(this);
		bone8.setRotationPoint(2.0F, 0.0F, 0.0F);
		bone5.addChild(bone8);
		bone8.setTextureOffset(79, 57).addBox(-0.5F, -1.0F, -7.0F, 3.0F, 4.0F, 7.0F, 0.0F, false);
		bone8.setTextureOffset(0, 104).addBox(0.5F, -1.0F, -7.0F, 0.0F, 4.0F, 7.0F, 0.0F, false);

		bone4 = new ModelPart(this);
		bone4.setRotationPoint(0.0F, 5.0F, 23.0F);
		bone3.addChild(bone4);
		

		bone4_r1 = new ModelPart(this);
		bone4_r1.setRotationPoint(0.0F, -2.0F, 8.0F);
		bone4.addChild(bone4_r1);
		setRotationAngle(bone4_r1, 0.4363F, 0.0F, 0.0F);
		bone4_r1.setTextureOffset(0, 36).addBox(-10.0F, -1.9405F, 8.8198F, 20.0F, 0.0F, 16.0F, 0.0F, false);
		bone4_r1.setTextureOffset(72, 72).addBox(-6.0F, -1.9405F, -0.1802F, 12.0F, 3.0F, 9.0F, 0.0F, false);

		bone4_r2 = new ModelPart(this);
		bone4_r2.setRotationPoint(0.0F, 0.0F, -3.0F);
		bone4.addChild(bone4_r2);
		setRotationAngle(bone4_r2, 0.1745F, 0.0F, 0.0F);
		bone4_r2.setTextureOffset(60, 36).addBox(-8.0F, -3.0F, 0.0F, 16.0F, 5.0F, 11.0F, 0.0F, false);

		bone6 = new ModelPart(this);
		bone6.setRotationPoint(-8.0F, -31.0F, -6.0F);
		

		bone6_r1 = new ModelPart(this);
		bone6_r1.setRotationPoint(-1.0F, 12.0F, 2.0F);
		bone6.addChild(bone6_r1);
		setRotationAngle(bone6_r1, 0.0873F, 0.0F, 0.0F);
		bone6_r1.setTextureOffset(60, 64).addBox(-2.0F, -13.0F, -1.0F, 3.0F, 56.0F, 3.0F, 0.0F, true);

		bone6_r2 = new ModelPart(this);
		bone6_r2.setRotationPoint(-1.0F, 12.0F, -3.0F);
		bone6.addChild(bone6_r2);
		setRotationAngle(bone6_r2, -0.0873F, 0.0F, 0.0F);
		bone6_r2.setTextureOffset(60, 64).addBox(-2.0F, -13.0F, -2.0F, 3.0F, 56.0F, 3.0F, 0.0F, true);

		bone6_r3 = new ModelPart(this);
		bone6_r3.setRotationPoint(-1.0F, 12.0F, 0.0F);
		bone6.addChild(bone6_r3);
		setRotationAngle(bone6_r3, 0.0F, 0.0F, 0.0873F);
		bone6_r3.setTextureOffset(60, 64).addBox(-2.0F, -13.0F, -2.0F, 3.0F, 56.0F, 3.0F, 0.0F, true);*/
	}

	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public ModelPart getPart() {
		return null;
	}
}