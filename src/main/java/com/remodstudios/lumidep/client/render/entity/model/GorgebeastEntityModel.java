package com.remodstudios.lumidep.client.render.entity.model;


import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.Entity;

public class GorgebeastEntityModel extends SinglePartEntityModel<Entity> {
/*	private final ModelPart unknown_bone;
	private final ModelPart unknown_bone_r1;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart bone2;
	private final ModelPart bone7;
	private final ModelPart bone6;
	private final ModelPart bone6_r1;
	private final ModelPart bone6_r2;
	private final ModelPart bone5;
	private final ModelPart bone5_r1;
	private final ModelPart bone5_r2;
	private final ModelPart bone4;
	private final ModelPart bone4_r1;
	private final ModelPart bone4_r2;
	private final ModelPart bone8;
	private final ModelPart bone9;
	private final ModelPart bone9_r1;
	private final ModelPart bone9_r2;
	private final ModelPart bone10;
	private final ModelPart bone10_r1;
	private final ModelPart bone10_r2;
	private final ModelPart bone11;
	private final ModelPart bone11_r1;
	private final ModelPart bone11_r2;
	private final ModelPart bone12;
	private final ModelPart bone12_r1;
	private final ModelPart bone;
	private final ModelPart bone_r1;*/

	public GorgebeastEntityModel() {
/*		textureWidth = 256;
		textureHeight = 256;

		unknown_bone = new ModelPart(this);
		unknown_bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		unknown_bone_r1 = new ModelPart(this);
		unknown_bone_r1.setRotationPoint(0.0F, -26.0F, 19.0F);
		unknown_bone.addChild(unknown_bone_r1);
		setRotationAngle(unknown_bone_r1, -0.5236F, 0.0F, 0.0F);
		unknown_bone_r1.setTextureOffset(0, 0).addBox(-1.0F, -4.7144F, -3.2641F, 2.0F, 8.0F, 7.0F, 0.0F, false);

		head = new ModelPart(this);
		head.setRotationPoint(0.0F, 16.0F, -14.0F);
		head.setTextureOffset(0, 69).addBox(-10.0F, -14.0F, -28.0F, 20.0F, 17.0F, 28.0F, 0.0F, false);
		head.setTextureOffset(79, 123).addBox(-10.0F, 0.0F, -28.0F, 20.0F, 0.0F, 28.0F, 0.0F, false);

		jaw = new ModelPart(this);
		jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(jaw);
		jaw.setTextureOffset(96, 0).addBox(-10.0F, -1.0F, -28.0F, 20.0F, 6.0F, 28.0F, 0.0F, false);
		jaw.setTextureOffset(79, 123).addBox(-10.0F, 3.0F, -28.0F, 20.0F, 0.0F, 28.0F, 0.0F, false);

		bone2 = new ModelPart(this);
		bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone2.setTextureOffset(0, 0).addBox(-13.0F, -25.0F, -14.0F, 26.0F, 25.0F, 44.0F, 0.0F, false);

		bone7 = new ModelPart(this);
		bone7.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		bone6 = new ModelPart(this);
		bone6.setRotationPoint(0.0F, -13.0F, 27.0F);
		bone7.addChild(bone6);
		setRotationAngle(bone6, 0.0F, 0.0F, -2.0944F);
		

		bone6_r1 = new ModelPart(this);
		bone6_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone6.addChild(bone6_r1);
		setRotationAngle(bone6_r1, -0.0873F, 0.0F, -0.5236F);
		bone6_r1.setTextureOffset(0, 114).addBox(-4.0F, 13.3764F, 37.7622F, 8.0F, 5.0F, 28.0F, 0.0F, false);

		bone6_r2 = new ModelPart(this);
		bone6_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone6.addChild(bone6_r2);
		setRotationAngle(bone6_r2, -0.2618F, 0.0F, -0.5236F);
		bone6_r2.setTextureOffset(59, 77).addBox(-4.0F, 6.5911F, 3.1058F, 8.0F, 5.0F, 37.0F, 0.0F, false);

		bone5 = new ModelPart(this);
		bone5.setRotationPoint(0.0F, -13.0F, 27.0F);
		bone7.addChild(bone5);
		setRotationAngle(bone5, 0.0F, 0.0F, -1.0472F);
		

		bone5_r1 = new ModelPart(this);
		bone5_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone5.addChild(bone5_r1);
		setRotationAngle(bone5_r1, -0.0873F, 0.0F, -0.5236F);
		bone5_r1.setTextureOffset(0, 114).addBox(-4.0F, 13.3764F, 37.7622F, 8.0F, 5.0F, 28.0F, 0.0F, false);

		bone5_r2 = new ModelPart(this);
		bone5_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone5.addChild(bone5_r2);
		setRotationAngle(bone5_r2, -0.2618F, 0.0F, -0.5236F);
		bone5_r2.setTextureOffset(59, 77).addBox(-4.0F, 6.5911F, 3.1058F, 8.0F, 5.0F, 37.0F, 0.0F, false);

		bone4 = new ModelPart(this);
		bone4.setRotationPoint(0.0F, -13.0F, 27.0F);
		bone7.addChild(bone4);
		

		bone4_r1 = new ModelPart(this);
		bone4_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone4.addChild(bone4_r1);
		setRotationAngle(bone4_r1, -0.0873F, 0.0F, -0.5236F);
		bone4_r1.setTextureOffset(0, 114).addBox(-4.0F, 13.3764F, 37.7622F, 8.0F, 5.0F, 28.0F, 0.0F, false);

		bone4_r2 = new ModelPart(this);
		bone4_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone4.addChild(bone4_r2);
		setRotationAngle(bone4_r2, -0.2618F, 0.0F, -0.5236F);
		bone4_r2.setTextureOffset(59, 77).addBox(-4.0F, 6.5911F, 3.1058F, 8.0F, 5.0F, 37.0F, 0.0F, false);

		bone8 = new ModelPart(this);
		bone8.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		bone9 = new ModelPart(this);
		bone9.setRotationPoint(0.0F, -13.0F, 27.0F);
		bone8.addChild(bone9);
		setRotationAngle(bone9, 0.0F, 0.0F, 2.0944F);
		

		bone9_r1 = new ModelPart(this);
		bone9_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone9.addChild(bone9_r1);
		setRotationAngle(bone9_r1, -0.0873F, 0.0F, 0.5236F);
		bone9_r1.setTextureOffset(0, 114).addBox(-4.0F, 13.3764F, 37.7622F, 8.0F, 5.0F, 28.0F, 0.0F, true);

		bone9_r2 = new ModelPart(this);
		bone9_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone9.addChild(bone9_r2);
		setRotationAngle(bone9_r2, -0.2618F, 0.0F, 0.5236F);
		bone9_r2.setTextureOffset(59, 77).addBox(-4.0F, 6.5911F, 3.1058F, 8.0F, 5.0F, 37.0F, 0.0F, true);

		bone10 = new ModelPart(this);
		bone10.setRotationPoint(0.0F, -13.0F, 27.0F);
		bone8.addChild(bone10);
		setRotationAngle(bone10, 0.0F, 0.0F, 1.0472F);
		

		bone10_r1 = new ModelPart(this);
		bone10_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone10.addChild(bone10_r1);
		setRotationAngle(bone10_r1, -0.0873F, 0.0F, 0.5236F);
		bone10_r1.setTextureOffset(0, 114).addBox(-4.0F, 13.3764F, 37.7622F, 8.0F, 5.0F, 28.0F, 0.0F, true);

		bone10_r2 = new ModelPart(this);
		bone10_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone10.addChild(bone10_r2);
		setRotationAngle(bone10_r2, -0.2618F, 0.0F, 0.5236F);
		bone10_r2.setTextureOffset(59, 77).addBox(-4.0F, 6.5911F, 3.1058F, 8.0F, 5.0F, 37.0F, 0.0F, true);

		bone11 = new ModelPart(this);
		bone11.setRotationPoint(0.0F, -13.0F, 27.0F);
		bone8.addChild(bone11);
		

		bone11_r1 = new ModelPart(this);
		bone11_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone11.addChild(bone11_r1);
		setRotationAngle(bone11_r1, -0.0873F, 0.0F, 0.5236F);
		bone11_r1.setTextureOffset(0, 114).addBox(-4.0F, 13.3764F, 37.7622F, 8.0F, 5.0F, 28.0F, 0.0F, true);

		bone11_r2 = new ModelPart(this);
		bone11_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone11.addChild(bone11_r2);
		setRotationAngle(bone11_r2, -0.2618F, 0.0F, 0.5236F);
		bone11_r2.setTextureOffset(59, 77).addBox(-4.0F, 6.5911F, 3.1058F, 8.0F, 5.0F, 37.0F, 0.0F, true);

		bone12 = new ModelPart(this);
		bone12.setRotationPoint(13.0F, 19.0F, 4.0F);
		

		bone12_r1 = new ModelPart(this);
		bone12_r1.setRotationPoint(-3.0F, -2.0F, -2.0F);
		bone12.addChild(bone12_r1);
		setRotationAngle(bone12_r1, 0.0F, -0.5236F, 0.7854F);
		bone12_r1.setTextureOffset(112, 90).addBox(-2.7493F, -1.5858F, -8.9409F, 32.0F, 3.0F, 18.0F, 0.0F, false);

		bone = new ModelPart(this);
		bone.setRotationPoint(-13.0F, 19.0F, 4.0F);
		

		bone_r1 = new ModelPart(this);
		bone_r1.setRotationPoint(3.0F, -2.0F, -2.0F);
		bone.addChild(bone_r1);
		setRotationAngle(bone_r1, 0.0F, 0.5236F, -0.7854F);
		bone_r1.setTextureOffset(112, 69).addBox(-29.2507F, -1.5858F, -8.9409F, 32.0F, 3.0F, 18.0F, 0.0F, false);*/
	}

	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public ModelPart getPart() {
		return null;
	}
}