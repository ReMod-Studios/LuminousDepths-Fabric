package com.remodstudios.lumidep.client.render.entity.model;


import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class IsopodEntityModel extends SinglePartEntityModel<Entity> {
/*	private final ModelPart body;
	private final ModelPart unknown_bone;
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone4;
	private final ModelPart bone5;
	private final ModelPart head;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart body2;*/

	public IsopodEntityModel() {
		/*textureWidth = 64;
		textureHeight = 64;

		body = new ModelPart(this);
		body.setRotationPoint(0.0F, 21.0F, 6.0F);
		

		unknown_bone = new ModelPart(this);
		unknown_bone.setRotationPoint(0.0F, 3.0F, -6.0F);
		body.addChild(unknown_bone);
		unknown_bone.setTextureOffset(35, 35).addBox(2.0F, -1.0F, -14.0F, 9.0F, 0.0F, 4.0F, 0.0F, false);
		unknown_bone.setTextureOffset(17, 34).addBox(-11.0F, -1.0F, -14.0F, 9.0F, 0.0F, 4.0F, 0.0F, false);

		bone = new ModelPart(this);
		bone.setRotationPoint(0.0F, 3.0F, -6.0F);
		body.addChild(bone);
		bone.setTextureOffset(0, 24).addBox(-8.0F, -2.0F, 8.0F, 16.0F, 0.0F, 10.0F, 0.0F, false);
		bone.setTextureOffset(0, 34).addBox(-4.0F, -4.0F, -12.0F, 8.0F, 4.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-7.0F, -6.0F, -8.0F, 14.0F, 6.0F, 18.0F, 0.0F, false);

		bone2 = new ModelPart(this);
		bone2.setRotationPoint(7.0F, 2.0F, -11.0F);
		body.addChild(bone2);
		

		bone3 = new ModelPart(this);
		bone3.setRotationPoint(-7.0F, 2.0F, -11.0F);
		body.addChild(bone3);
		

		bone4 = new ModelPart(this);
		bone4.setRotationPoint(0.0F, 3.0F, -6.0F);
		body.addChild(bone4);
		setRotationAngle(bone4, 0.0F, 0.0F, 0.1745F);
		bone4.setTextureOffset(0, 0).addBox(1.4958F, -0.5519F, -10.6009F, 5.0F, 0.0F, 2.0F, 0.0F, false);
		bone4.setTextureOffset(0, 0).addBox(6.5511F, -1.3036F, 6.6732F, 5.0F, 0.0F, 2.0F, 0.0F, false);
		bone4.setTextureOffset(0, 0).addBox(5.7699F, -1.1299F, 5.0F, 5.0F, 0.0F, 2.0F, 0.0F, false);
		bone4.setTextureOffset(0, 0).addBox(5.7699F, -1.1299F, 2.0F, 5.0F, 0.0F, 2.0F, 0.0F, false);
		bone4.setTextureOffset(0, 0).addBox(5.7699F, -1.1299F, -1.0F, 5.0F, 0.0F, 2.0F, 0.0F, false);
		bone4.setTextureOffset(0, 0).addBox(5.7699F, -1.1299F, -4.0F, 5.0F, 0.0F, 2.0F, 0.0F, false);
		bone4.setTextureOffset(0, 0).addBox(6.5661F, -1.3036F, -5.8442F, 5.0F, 0.0F, 2.0F, 0.0F, false);

		bone5 = new ModelPart(this);
		bone5.setRotationPoint(0.0F, 3.0F, -6.0F);
		body.addChild(bone5);
		setRotationAngle(bone5, 0.0F, 0.0F, -0.1745F);
		bone5.setTextureOffset(0, 0).addBox(-6.4958F, -0.5519F, -10.6009F, 5.0F, 0.0F, 2.0F, 0.0F, true);
		bone5.setTextureOffset(0, 0).addBox(-11.5511F, -1.3036F, 6.6732F, 5.0F, 0.0F, 2.0F, 0.0F, true);
		bone5.setTextureOffset(0, 0).addBox(-10.7699F, -1.1299F, 5.0F, 5.0F, 0.0F, 2.0F, 0.0F, true);
		bone5.setTextureOffset(0, 0).addBox(-10.7699F, -1.1299F, 2.0F, 5.0F, 0.0F, 2.0F, 0.0F, true);
		bone5.setTextureOffset(0, 0).addBox(-10.7699F, -1.1299F, -1.0F, 5.0F, 0.0F, 2.0F, 0.0F, true);
		bone5.setTextureOffset(0, 0).addBox(-10.7699F, -1.1299F, -4.0F, 5.0F, 0.0F, 2.0F, 0.0F, true);
		bone5.setTextureOffset(0, 0).addBox(-11.5661F, -1.3036F, -5.8442F, 5.0F, 0.0F, 2.0F, 0.0F, true);

		head = new ModelPart(this);
		head.setRotationPoint(0.0F, 19.0F, -10.0F);
		

		leg1 = new ModelPart(this);
		leg1.setRotationPoint(3.5F, 22.0F, 11.0F);
		

		leg2 = new ModelPart(this);
		leg2.setRotationPoint(-3.5F, 22.0F, 11.0F);
		

		leg3 = new ModelPart(this);
		leg3.setRotationPoint(5.0F, 21.0F, -4.0F);
		

		leg4 = new ModelPart(this);
		leg4.setRotationPoint(-5.0F, 21.0F, -4.0F);
		

		body2 = new ModelPart(this);
		body2.setRotationPoint(0.0F, 21.0F, 6.0F);*/
		
	}

	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){

	}

	@Override
	public ModelPart getPart() {
		return null;
	}
}