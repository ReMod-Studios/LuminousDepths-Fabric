package com.remodstudios.lumidep.client.render.entity.model;


import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class KreplerEntityModel extends SinglePartEntityModel<Entity> {
/*	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart nose;
	private final ModelPart tail;
	private final ModelPart tail_fin;
	private final ModelPart back_fin;
	private final ModelPart left_fin;
	private final ModelPart right_fin;*/

	public KreplerEntityModel() {
/*		textureWidth = 64;
		textureHeight = 64;

		body = new ModelPart(this);
		body.setRotationPoint(0.0F, 24.0F, -3.0F);
		body.setTextureOffset(0, 13).addBox(-4.0F, -7.0F, 0.0F, 8.0F, 7.0F, 13.0F, 0.0F, false);

		head = new ModelPart(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -7.0F, -6.0F, 8.0F, 7.0F, 6.0F, 0.0F, false);

		nose = new ModelPart(this);
		nose.setRotationPoint(0.0F, 0.0F, -10.0F);
		head.addChild(nose);
		nose.setTextureOffset(0, 13).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tail = new ModelPart(this);
		tail.setRotationPoint(0.0F, -2.5F, 14.0F);
		body.addChild(tail);
		tail.setTextureOffset(0, 33).addBox(-2.0F, -2.5F, -1.0F, 4.0F, 5.0F, 11.0F, 0.0F, false);

		tail_fin = new ModelPart(this);
		tail_fin.setRotationPoint(0.0F, 0.0F, 9.0F);
		tail.addChild(tail_fin);
		tail_fin.setTextureOffset(0, 49).addBox(-5.0F, -0.5F, -1.0F, 10.0F, 1.0F, 6.0F, 0.0F, false);

		back_fin = new ModelPart(this);
		back_fin.setRotationPoint(0.0F, -7.0F, 5.0F);
		body.addChild(back_fin);
		setRotationAngle(back_fin, -0.5236F, 0.0F, 0.0F);
		back_fin.setTextureOffset(29, 0).addBox(-0.5F, -4.25F, -1.0F, 1.0F, 5.0F, 4.0F, 0.0F, false);

		left_fin = new ModelPart(this);
		left_fin.setRotationPoint(3.0F, -1.0F, 2.0F);
		body.addChild(left_fin);
		setRotationAngle(left_fin, 0.0F, -0.4363F, 0.3491F);
		left_fin.setTextureOffset(40, 0).addBox(0.0F, -1.0F, -1.5F, 8.0F, 1.0F, 4.0F, 0.0F, false);

		right_fin = new ModelPart(this);
		right_fin.setRotationPoint(-3.0F, -1.0F, 2.0F);
		body.addChild(right_fin);
		setRotationAngle(right_fin, 0.0F, 0.4363F, -0.3491F);
		right_fin.setTextureOffset(40, 6).addBox(-8.0F, -1.0F, -1.5F, 8.0F, 1.0F, 4.0F, 0.0F, false);*/
	}

	@Override
	public void setAngles(Entity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}

	@Override
	public ModelPart getPart() {
		return null;
	}
}