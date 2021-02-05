package com.remodstudios.lumidep.client.render.entity.model;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.Entity;

public class GoblinsharkEntityModel extends SinglePartEntityModel<Entity> {
/*	private final ModelPart head;
	private final ModelPart head2;
	private final ModelPart bone7;
	private final ModelPart body;
	private final ModelPart body2;
	private final ModelPart bone;
	private final ModelPart bone4;
	private final ModelPart bone3;
	private final ModelPart bone2;
	private final ModelPart bone5;
	private final ModelPart tail;
	private final ModelPart unknown_bone;
	private final ModelPart bone6;
	private final ModelPart bone8;
	private final ModelPart right_fin;
	private final ModelPart left_fin;
	private final ModelPart back_fin;*/

	public GoblinsharkEntityModel() {
		/*textureWidth = 128;
		textureHeight = 128;

		head = new ModelPart(this);
		head.setRotationPoint(0.0F, 20.0F, -6.0F);
		

		head2 = new ModelPart(this);
		head2.setRotationPoint(0.0F, 1.0F, 1.0F);
		head.addChild(head2);
		head2.setTextureOffset(35, 0).addBox(-4.0F, -7.0F, -6.0F, 8.0F, 5.0F, 7.0F, 0.0F, false);
		head2.setTextureOffset(0, 27).addBox(-2.0F, -7.0F, -19.0F, 4.0F, 2.0F, 6.0F, 0.0F, false);
		head2.setTextureOffset(49, 20).addBox(-3.0F, -7.0F, -13.0F, 6.0F, 3.0F, 7.0F, 0.0F, false);

		bone7 = new ModelPart(this);
		bone7.setRotationPoint(0.0F, -2.0F, 1.0F);
		head2.addChild(bone7);
		setRotationAngle(bone7, 0.2618F, 0.0F, 0.0F);
		bone7.setTextureOffset(44, 45).addBox(-4.0F, 0.0F, -6.0F, 8.0F, 1.0F, 6.0F, 0.0F, false);

		body = new ModelPart(this);
		body.setRotationPoint(0.0F, 24.0F, -3.0F);
		

		body2 = new ModelPart(this);
		body2.setRotationPoint(0.0F, 0.0F, -2.0F);
		body.addChild(body2);
		body2.setTextureOffset(0, 0).addBox(-4.0F, -11.0F, 1.0F, 8.0F, 8.0F, 19.0F, 0.0F, false);

		bone = new ModelPart(this);
		bone.setRotationPoint(0.0F, -12.0F, 3.0F);
		body.addChild(bone);
		setRotationAngle(bone, -0.7854F, 0.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-1.0F, -7.0F, 1.4142F, 2.0F, 7.0F, 5.0F, 0.0F, false);

		bone4 = new ModelPart(this);
		bone4.setRotationPoint(4.0F, -5.0F, 17.0F);
		body.addChild(bone4);
		setRotationAngle(bone4, 0.0873F, -0.5236F, 0.8727F);
		bone4.setTextureOffset(0, 40).addBox(-3.4218F, -0.4846F, -3.6177F, 6.0F, 1.0F, 4.0F, 0.0F, false);

		bone3 = new ModelPart(this);
		bone3.setRotationPoint(-4.0F, -5.0F, 7.0F);
		body.addChild(bone3);
		setRotationAngle(bone3, 0.0873F, 0.5236F, -0.8727F);
		bone3.setTextureOffset(35, 12).addBox(-5.0782F, -0.4092F, -4.755F, 8.0F, 1.0F, 6.0F, 0.0F, false);

		bone2 = new ModelPart(this);
		bone2.setRotationPoint(4.0F, -5.0F, 7.0F);
		body.addChild(bone2);
		setRotationAngle(bone2, 0.0873F, -0.5236F, 0.8727F);
		bone2.setTextureOffset(49, 30).addBox(-2.9218F, -0.4092F, -4.755F, 8.0F, 1.0F, 6.0F, 0.0F, false);

		bone5 = new ModelPart(this);
		bone5.setRotationPoint(-4.0F, -5.0F, 17.0F);
		body.addChild(bone5);
		setRotationAngle(bone5, 0.0873F, 0.5236F, -0.8727F);
		bone5.setTextureOffset(0, 35).addBox(-2.5782F, -0.4846F, -3.6177F, 6.0F, 1.0F, 4.0F, 0.0F, false);

		tail = new ModelPart(this);
		tail.setRotationPoint(0.0F, 21.5F, 11.0F);
		tail.setTextureOffset(24, 27).addBox(-3.0F, -7.5F, 3.0F, 6.0F, 5.0F, 13.0F, 0.0F, false);

		unknown_bone = new ModelPart(this);
		unknown_bone.setRotationPoint(0.0F, -4.5F, 12.0F);
		tail.addChild(unknown_bone);
		setRotationAngle(unknown_bone, 0.4363F, 0.0F, 0.0F);
		unknown_bone.setTextureOffset(0, 27).addBox(-1.0F, -1.4837F, -0.6711F, 2.0F, 7.0F, 20.0F, 0.0F, false);

		bone6 = new ModelPart(this);
		bone6.setRotationPoint(0.0F, -3.5F, 10.0F);
		tail.addChild(bone6);
		setRotationAngle(bone6, 0.6981F, 0.0F, 0.0F);
		bone6.setTextureOffset(24, 27).addBox(-1.0F, -2.6441F, -3.5635F, 2.0F, 5.0F, 3.0F, 0.0F, false);

		bone8 = new ModelPart(this);
		bone8.setRotationPoint(0.0F, -9.5F, 8.0F);
		tail.addChild(bone8);
		setRotationAngle(bone8, -0.7854F, 0.0F, 0.0F);
		bone8.setTextureOffset(0, 12).addBox(-1.0F, -1.1716F, 0.0F, 2.0F, 4.0F, 3.0F, 0.0F, false);

		right_fin = new ModelPart(this);
		right_fin.setRotationPoint(4.5F, 24.0F, -2.0F);
		

		left_fin = new ModelPart(this);
		left_fin.setRotationPoint(-4.5F, 24.0F, -2.0F);
		

		back_fin = new ModelPart(this);
		back_fin.setRotationPoint(0.0F, 13.0F, -5.0F);*/
		
	}

	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public ModelPart getPart() {
		return null;
	}
}