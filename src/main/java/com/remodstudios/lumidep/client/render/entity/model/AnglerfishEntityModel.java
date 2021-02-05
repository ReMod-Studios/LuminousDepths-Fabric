package com.remodstudios.lumidep.client.render.entity.model;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.Entity;

public class AnglerfishEntityModel extends SinglePartEntityModel<Entity> {
/*	private final ModelPart body;
	private final ModelPart bone3;
	private final ModelPart bone2;
	private final ModelPart bone;
	private final ModelPart eye;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart tail3;
	private final ModelPart spine1;
	private final ModelPart spine2;
	private final ModelPart spine3;
	private final ModelPart spine4;
	private final ModelPart spine5;
	private final ModelPart spine6;
	private final ModelPart spine7;
	private final ModelPart spine8;
	private final ModelPart spine9;
	private final ModelPart spine10;
	private final ModelPart spine11;
	private final ModelPart spine12;*/

	public AnglerfishEntityModel() {
		/*textureWidth = 64;
		textureHeight = 64;

		body = new ModelPart(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(body, 0.0F, 3.1416F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-4.0F, 15.0F, -1.0F, 8.0F, 9.0F, 9.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-4.0F, 15.0F, 8.0F, 0.0F, 6.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(4, 0).addBox(4.0F, 15.0F, 8.0F, 0.0F, 6.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(23, 0).addBox(-4.0F, 15.0F, 8.0F, 8.0F, 0.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(22, 22).addBox(0.0F, 13.0F, -3.0F, 0.0F, 4.0F, 7.0F, 0.0F, false);
		body.setTextureOffset(0, 10).addBox(0.0F, 7.0F, 7.0F, 0.0F, 8.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(0, 42).addBox(-0.5F, 9.0F, 12.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone3 = new ModelPart(this);
		bone3.setRotationPoint(-4.0F, 17.0F, 4.0F);
		body.addChild(bone3);
		setRotationAngle(bone3, -0.2618F, 0.6109F, 0.0F);
		bone3.setTextureOffset(25, 0).addBox(0.7057F, -1.712F, -5.5629F, 0.0F, 4.0F, 5.0F, 0.0F, false);

		bone2 = new ModelPart(this);
		bone2.setRotationPoint(4.0F, 17.0F, 4.0F);
		body.addChild(bone2);
		setRotationAngle(bone2, -0.2618F, -0.6109F, 0.0F);
		bone2.setTextureOffset(25, 0).addBox(-0.7057F, -1.712F, -5.5629F, 0.0F, 4.0F, 5.0F, 0.0F, false);

		bone = new ModelPart(this);
		bone.setRotationPoint(0.0F, 24.0F, 8.0F);
		body.addChild(bone);
		setRotationAngle(bone, -1.0472F, 0.0F, 0.0F);
		bone.setTextureOffset(16, 18).addBox(-4.0F, -8.0F, 0.0F, 8.0F, 8.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(0, 31).addBox(4.0F, -8.0F, -2.0F, 0.0F, 6.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(23, 2).addBox(-4.0F, -8.0F, -2.0F, 8.0F, 0.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(4, 31).addBox(-4.0F, -8.0F, -2.0F, 0.0F, 6.0F, 2.0F, 0.0F, false);

		eye = new ModelPart(this);
		eye.setRotationPoint(0.0F, 0.5F, -8.25F);
		

		tail1 = new ModelPart(this);
		tail1.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(tail1, 0.0F, 3.1416F, 0.0F);
		tail1.setTextureOffset(9, 28).addBox(-2.0F, 16.0F, -6.0F, 4.0F, 5.0F, 5.0F, 0.0F, false);

		tail2 = new ModelPart(this);
		tail2.setRotationPoint(0.0F, 18.0F, 6.0F);
		setRotationAngle(tail2, 0.0F, 3.1416F, 0.0F);
		tail2.setTextureOffset(0, 19).addBox(0.0F, -3.0F, -6.0F, 0.0F, 7.0F, 7.0F, 0.0F, false);

		tail3 = new ModelPart(this);
		tail3.setRotationPoint(0.0F, 0.0F, 22.0F);
		

		spine1 = new ModelPart(this);
		spine1.setRotationPoint(0.0F, 5.5F, 7.0F);
		

		spine2 = new ModelPart(this);
		spine2.setRotationPoint(0.0F, 5.5F, -7.0F);
		

		spine3 = new ModelPart(this);
		spine3.setRotationPoint(-7.0F, 5.5F, 0.0F);
		

		spine4 = new ModelPart(this);
		spine4.setRotationPoint(7.0F, 5.5F, 0.0F);
		

		spine5 = new ModelPart(this);
		spine5.setRotationPoint(7.0F, 16.0F, -7.0F);
		

		spine6 = new ModelPart(this);
		spine6.setRotationPoint(-7.0F, 16.0F, -7.0F);
		

		spine7 = new ModelPart(this);
		spine7.setRotationPoint(-7.0F, 16.0F, 7.0F);
		

		spine8 = new ModelPart(this);
		spine8.setRotationPoint(7.0F, 16.0F, 7.0F);
		

		spine9 = new ModelPart(this);
		spine9.setRotationPoint(0.0F, 26.5F, 7.0F);
		

		spine10 = new ModelPart(this);
		spine10.setRotationPoint(0.0F, 26.5F, -7.0F);
		

		spine11 = new ModelPart(this);
		spine11.setRotationPoint(-7.0F, 26.5F, 0.0F);
		

		spine12 = new ModelPart(this);
		spine12.setRotationPoint(7.0F, 26.5F, 0.0F);*/
		
	}

	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public ModelPart getPart() {
		return null;
	}
}