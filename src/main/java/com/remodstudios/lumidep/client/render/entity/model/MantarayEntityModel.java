package com.remodstudios.lumidep.client.render.entity.model;


import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

// TODO
// <T extends Entity> -> <T extends MantarayEntity>
public class MantarayEntityModel<T extends Entity> extends SinglePartEntityModel<T> {
	private final ModelPart root;
	private final ModelPart body;
	/*
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone4;
	private final ModelPart head;
	private final ModelPart left_wing;
	private final ModelPart bone5;
	private final ModelPart left_wing_tip;
	private final ModelPart right_wing;
	private final ModelPart bone6;
	private final ModelPart right_wing_tip;
	*/
	private final ModelPart tail;
	private final ModelPart tailFin;

	public MantarayEntityModel(ModelPart root) {
		this.root = root;
		this.body = root.getChild("body");
		this.tail = this.body.getChild("tail");
		this.tailFin = this.tail.getChild("tail_fin");

		/*
		textureWidth = 256;
		textureHeight = 256;

		body = new ModelPart(this);
		body.setPivot(0.0F, 0.0F, 0.0F);
		

		bone = new ModelPart(this);
		bone.setPivot(0.0F, 24.0F, 0.0F);
		body.addChild(bone);
		bone.setTextureOffset(135, 145).addBox(-9.0F, -4.0F, 7.0F, 18.0F, 7.0F, 17.0F, 0.0F, false);
		bone.setTextureOffset(0, 106).addBox(-18.0F, -5.0F, -29.0F, 36.0F, 11.0F, 40.0F, 0.0F, false);
		bone.setTextureOffset(133, 53).addBox(-1.0F, -1.0F, 24.0F, 2.0F, 2.0F, 35.0F, 0.0F, false);

		bone2 = new ModelPart(this);
		bone2.setPivot(13.0F, 24.0F, -34.0F);
		body.addChild(bone2);
		setRotationAngle(bone2, 0.0F, 0.6981F, -0.8727F);
		bone2.setTextureOffset(0, 19).addBox(-7.1352F, 1.234F, -10.6471F, 6.0F, 2.0F, 17.0F, 0.0F, false);

		bone3 = new ModelPart(this);
		bone3.setPivot(-13.0F, 24.0F, -34.0F);
		body.addChild(bone3);
		setRotationAngle(bone3, 0.0F, -0.6981F, 0.8727F);
		bone3.setTextureOffset(0, 0).addBox(1.1352F, 1.234F, -10.6471F, 6.0F, 2.0F, 17.0F, 0.0F, false);

		bone4 = new ModelPart(this);
		bone4.setPivot(0.0F, 21.0F, 10.0F);
		body.addChild(bone4);
		setRotationAngle(bone4, -0.6109F, 0.0F, 0.0F);
		bone4.setTextureOffset(29, 0).addBox(-1.0F, -11.343F, 4.9459F, 2.0F, 7.0F, 7.0F, 0.0F, false);

		head = new ModelPart(this);
		head.setPivot(0.0F, 1.0F, -7.0F);
		setRotationAngle(head, -0.0262F, 0.0F, 0.0F);
		

		left_wing = new ModelPart(this);
		left_wing.setPivot(-2.0F, -2.0F, -8.0F);
		

		bone5 = new ModelPart(this);
		bone5.setPivot(3.0F, 26.0F, 8.0F);
		left_wing.addChild(bone5);
		bone5.setTextureOffset(133, 0).addBox(41.0F, -1.0F, -23.0F, 22.0F, 2.0F, 31.0F, 0.0F, false);
		bone5.setTextureOffset(0, 53).addBox(0.0F, -1.0F, -23.0F, 41.0F, 2.0F, 51.0F, 0.0F, false);

		left_wing_tip = new ModelPart(this);
		left_wing_tip.setPivot(-8.0F, -2.0F, -8.0F);
		

		right_wing = new ModelPart(this);
		right_wing.setPivot(3.0F, -2.0F, -8.0F);
		

		bone6 = new ModelPart(this);
		bone6.setPivot(-57.0F, 26.0F, 3.0F);
		right_wing.addChild(bone6);
		bone6.setTextureOffset(0, 0).addBox(12.0F, -1.0F, -18.0F, 41.0F, 2.0F, 51.0F, 0.0F, false);
		bone6.setTextureOffset(112, 112).addBox(-10.0F, -1.0F, -18.0F, 22.0F, 2.0F, 31.0F, 0.0F, false);

		right_wing_tip = new ModelPart(this);
		right_wing_tip.setPivot(9.0F, -2.0F, -8.0F);
		

		tail = new ModelPart(this);
		tail.setPivot(0.0F, -2.0F, 1.0F);
		

		tail2 = new ModelPart(this);
		tail2.setPivot(0.0F, -1.5F, 7.0F);*/
		
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData root = modelData.getRoot();

		// I want die

		return TexturedModelData.of(modelData, 256, 256);
	}

	public ModelPart getPart() {
		return this.root;
	}

	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.body.pitch = headPitch * 0.017453292F;
		this.body.yaw = headYaw * 0.017453292F;
		if (Entity.squaredHorizontalLength(entity.getVelocity()) > 1.0E-7D) {
			ModelPart var10000 = this.body;
			var10000.pitch += -0.05F - 0.05F * MathHelper.cos(animationProgress * 0.3F);
			this.tail.pitch = -0.1F * MathHelper.cos(animationProgress * 0.3F);
			this.tailFin.pitch = -0.2F * MathHelper.cos(animationProgress * 0.3F);
		}

	}

	public void setRotationAngle(ModelPart modelRenderer, float pitch, float yaw, float roll) {
		modelRenderer.pitch = pitch;
		modelRenderer.yaw = yaw;
		modelRenderer.roll = roll;
	}
}