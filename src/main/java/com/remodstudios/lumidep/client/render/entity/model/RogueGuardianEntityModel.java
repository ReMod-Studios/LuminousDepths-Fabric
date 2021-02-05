package com.remodstudios.lumidep.client.render.entity.model;


import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

// Need to change entity but leaving as is for lack of errors for now
public class RogueGuardianEntityModel extends SinglePartEntityModel<GuardianEntity> {
	private static final float[] SPIKE_PITCHES = new float[]{1.75F, 0.25F, 0.0F, 0.0F, 0.5F, 0.5F, 0.5F, 0.5F, 1.25F, 0.75F, 0.0F, 0.0F};
	private static final float[] SPIKE_YAWS = new float[]{0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 1.75F, 1.25F, 0.75F, 0.0F, 0.0F, 0.0F, 0.0F};
	private static final float[] SPIKE_ROLLS = new float[]{0.0F, 0.0F, 0.25F, 1.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.75F, 1.25F};
	private static final float[] SPIKE_PIVOTS_X = new float[]{0.0F, 0.0F, 8.0F, -8.0F, -8.0F, 8.0F, 8.0F, -8.0F, 0.0F, 0.0F, 8.0F, -8.0F};
	private static final float[] SPIKE_PIVOTS_Y = new float[]{-8.0F, -8.0F, -8.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, 8.0F};
	private static final float[] SPIKE_PIVOTS_Z = new float[]{8.0F, -8.0F, 0.0F, 0.0F, -8.0F, -8.0F, 8.0F, 8.0F, 8.0F, -8.0F, 0.0F, 0.0F};
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart eye;
	private final ModelPart[] spikes;
	private final ModelPart[] tail;

	public RogueGuardianEntityModel(ModelPart root) {
		this.root = root;
		this.spikes = new ModelPart[12];
		this.head = root.getChild("head");

		for(int i = 0; i < this.spikes.length; ++i) {
			this.spikes[i] = this.head.getChild(getSpikeName(i));
		}

		this.eye = this.head.getChild("eye");
		this.tail = new ModelPart[3];
		this.tail[0] = this.head.getChild("tail0");
		this.tail[1] = this.tail[0].getChild("tail1");
		this.tail[2] = this.tail[1].getChild("tail2");

		/*{
			textureWidth = 128;
			textureHeight = 128;

			head = new ModelPart(this);
			head.setPivot(0.0F, 24.0F, 0.0F);
			head.setTextureOffset(0, 68).addBox(-6.0F, -2.0F, -6.0F, 12.0F, 5.0F, 0.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-6.0F, -14.0F, -8.0F, 12.0F, 12.0F, 16.0F, 0.0F, false);
			head.setTextureOffset(28, 50).addBox(-8.0F, -14.0F, -6.0F, 2.0F, 12.0F, 12.0F, 0.0F, false);
			head.setTextureOffset(0, 42).addBox(6.0F, -14.0F, -6.0F, 2.0F, 12.0F, 12.0F, 0.0F, false);
			head.setTextureOffset(36, 36).addBox(-6.0F, -16.0F, -6.0F, 12.0F, 2.0F, 12.0F, 0.0F, false);
			head.setTextureOffset(0, 28).addBox(-6.0F, -2.0F, -6.0F, 12.0F, 2.0F, 12.0F, 0.0F, false);

			eye = new ModelPart(this);
			eye.setPivot(0.0F, -24.0F, 0.0F);
			head.addChild(eye);
			eye.setTextureOffset(0, 0).addBox(-1.0F, 16.0F, -8.25F, 2.0F, 2.0F, 1.0F, 0.0F, false);

			tailpart0 = new ModelPart(this);
			tailpart0.setPivot(0.0F, -24.0F, 0.0F);
			head.addChild(tailpart0);
			tailpart0.setTextureOffset(40, 0).addBox(-2.0F, 14.0F, 8.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);

			tailpart1 = new ModelPart(this);
			tailpart1.setPivot(0.0F, 0.0F, 0.0F);
			tailpart0.addChild(tailpart1);
			tailpart1.setTextureOffset(0, 0).addBox(1.5F, 17.0F, 18.0F, 0.0F, 2.0F, 3.0F, 0.0F, false);
			tailpart1.setTextureOffset(49, 21).addBox(-1.5F, 14.0F, 16.0F, 3.0F, 3.0F, 7.0F, 0.0F, false);

			tailpart2 = new ModelPart(this);
			tailpart2.setPivot(0.0F, 0.0F, 0.0F);
			tailpart1.addChild(tailpart2);
			tailpart2.setTextureOffset(0, 0).addBox(-1.0F, 14.0F, 23.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);
			tailpart2.setTextureOffset(16, 33).addBox(0.0F, 10.5F, 26.0F, 0.0F, 9.0F, 9.0F, 0.0F, false);

			spikepart0 = new ModelPart(this);
			spikepart0.setPivot(0.0F, -24.0F, 0.0F);
			head.addChild(spikepart0);
			setRotationAngle(spikepart0, 0.0F, 0.0F, 0.7854F);


			spikepart1 = new ModelPart(this);
			spikepart1.setPivot(0.0F, -24.0F, 0.0F);
			head.addChild(spikepart1);
			setRotationAngle(spikepart1, 0.0F, 0.0F, -0.7854F);
			spikepart1.setTextureOffset(58, 59).addBox(-12.25F, -0.5F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

			spikepart2 = new ModelPart(this);
			spikepart2.setPivot(0.0F, -24.0F, 0.0F);
			head.addChild(spikepart2);
			setRotationAngle(spikepart2, 0.7854F, 0.0F, 0.0F);
			spikepart2.setTextureOffset(52, 50).addBox(-1.0F, -4.5F, -12.25F, 2.0F, 9.0F, 2.0F, 0.0F, false);

			spikepart3 = new ModelPart(this);
			spikepart3.setPivot(0.0F, -22.0F, 16.0F);
			head.addChild(spikepart3);
			setRotationAngle(spikepart3, -0.7854F, 0.0F, 0.0F);
			spikepart3.setTextureOffset(52, 50).addBox(-1.0F, 5.3995F, -2.3505F, 2.0F, 9.0F, 2.0F, 0.0F, false);

			spikepart4 = new ModelPart(this);
			spikepart4.setPivot(0.0F, -24.0F, 0.0F);
			head.addChild(spikepart4);
			setRotationAngle(spikepart4, 0.0F, 0.0F, 2.3562F);
			spikepart4.setTextureOffset(32, 50).addBox(10.25F, -27.5F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

			spikepart5 = new ModelPart(this);
			spikepart5.setPivot(-7.0F, -1.0F, 0.0F);
			head.addChild(spikepart5);
			setRotationAngle(spikepart5, 0.0F, 3.1416F, -2.3562F);
			spikepart5.setTextureOffset(32, 50).addBox(-1.0637F, -6.2868F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

			spikepart6 = new ModelPart(this);
			spikepart6.setPivot(0.0F, -24.0F, 0.0F);
			head.addChild(spikepart6);
			setRotationAngle(spikepart6, 2.3562F, 0.0F, 0.0F);


			spikepart7 = new ModelPart(this);
			spikepart7.setPivot(0.0F, -24.0F, 0.0F);
			head.addChild(spikepart7);
			setRotationAngle(spikepart7, -2.3562F, 0.0F, 0.0F);


			spikepart8 = new ModelPart(this);
			spikepart8.setPivot(0.0F, -24.0F, 0.0F);
			head.addChild(spikepart8);
			setRotationAngle(spikepart8, 1.5708F, -0.7854F, 0.0F);
			spikepart8.setTextureOffset(36, 28).addBox(-1.0F, -13.5F, -17.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

			spikepart9 = new ModelPart(this);
			spikepart9.setPivot(0.0F, -24.0F, 0.0F);
			head.addChild(spikepart9);
			setRotationAngle(spikepart9, 1.5708F, 0.7854F, 0.0F);


			spikepart10 = new ModelPart(this);
			spikepart10.setPivot(0.0F, -24.0F, 0.0F);
			head.addChild(spikepart10);
			setRotationAngle(spikepart10, 1.5708F, -2.3562F, 0.0F);
			spikepart10.setTextureOffset(52, 50).addBox(-1.0F, -15.2279F, -17.3505F, 2.0F, 9.0F, 2.0F, 0.0F, false);

			spikepart11 = new ModelPart(this);
			spikepart11.setPivot(0.0F, -24.0F, 0.0F);
			head.addChild(spikepart11);
			setRotationAngle(spikepart11, 1.5708F, 2.3562F, 0.0F);
		}*/
		
	}

	private static String getSpikeName(int index) {
		return "spike" + index;
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData root = modelData.getRoot();
		ModelPartData head = root.addChild("head", ModelPartBuilder.create()
				.uv(0, 0).cuboid(-6.0F, 10.0F, -8.0F, 12.0F, 12.0F, 16.0F)
				.uv(0, 28).cuboid(-8.0F, 10.0F, -6.0F, 2.0F, 12.0F, 12.0F)
				.uv(0, 28).cuboid(6.0F, 10.0F, -6.0F, 2.0F, 12.0F, 12.0F, true)
				.uv(16, 40).cuboid(-6.0F, 8.0F, -6.0F, 12.0F, 2.0F, 12.0F)
				.uv(16, 40).cuboid(-6.0F, 22.0F, -6.0F, 12.0F, 2.0F, 12.0F),
				ModelTransform.NONE);
		ModelPartBuilder modelPartBuilder = ModelPartBuilder.create()
				.uv(0, 0).cuboid(-1.0F, -4.5F, -1.0F, 2.0F, 9.0F, 2.0F);

		for(int i = 0; i < 12; ++i) {
			float f = getSpikePivotX(i, 0.0F, 0.0F);
			float g = getSpikePivotY(i, 0.0F, 0.0F);
			float h = getSpikePivotZ(i, 0.0F, 0.0F);
			float j = 3.1415927F * SPIKE_PITCHES[i];
			float k = 3.1415927F * SPIKE_YAWS[i];
			float l = 3.1415927F * SPIKE_ROLLS[i];
			head.addChild(getSpikeName(i), modelPartBuilder, ModelTransform.of(f, g, h, j, k, l));
		}

		head.addChild("eye", ModelPartBuilder.create()
				.uv(8, 0).cuboid(-1.0F, 15.0F, 0.0F, 2.0F, 2.0F, 1.0F),
				ModelTransform.pivot(0.0F, 0.0F, -8.25F));
		ModelPartData tail0 = head.addChild("tail0", ModelPartBuilder.create()
				.uv(40, 0).cuboid(-2.0F, 14.0F, 7.0F, 4.0F, 4.0F, 8.0F),
				ModelTransform.NONE);
		ModelPartData tail1 = tail0.addChild("tail1", ModelPartBuilder.create()
				.uv(0, 54).cuboid(0.0F, 14.0F, 0.0F, 3.0F, 3.0F, 7.0F),
				ModelTransform.pivot(-1.5F, 0.5F, 14.0F));
		tail1.addChild("tail2", ModelPartBuilder.create()
				.uv(41, 32).cuboid(0.0F, 14.0F, 0.0F, 2.0F, 2.0F, 6.0F)
				.uv(25, 19).cuboid(1.0F, 10.5F, 3.0F, 1.0F, 9.0F, 9.0F),
				ModelTransform.pivot(0.5F, 0.5F, 6.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	public ModelPart getPart() {
		return this.root;
	}

	public void setAngles(GuardianEntity guardianEntity, float f, float g, float h, float i, float j) {
		float k = h - (float)guardianEntity.age;
		this.head.yaw = i * 0.017453292F;
		this.head.pitch = j * 0.017453292F;
		float l = (1.0F - guardianEntity.getSpikesExtension(k)) * 0.55F;
		this.updateSpikeExtensions(h, l);
		Entity entity = MinecraftClient.getInstance().getCameraEntity();
		if (guardianEntity.hasBeamTarget()) {
			entity = guardianEntity.getBeamTarget();
		}

		if (entity != null) {
			Vec3d vec3d = ((Entity)entity).getCameraPosVec(0.0F);
			Vec3d vec3d2 = guardianEntity.getCameraPosVec(0.0F);
			double d = vec3d.y - vec3d2.y;
			if (d > 0.0D) {
				this.eye.pivotY = 0.0F;
			} else {
				this.eye.pivotY = 1.0F;
			}

			Vec3d vec3d3 = guardianEntity.getRotationVec(0.0F);
			vec3d3 = new Vec3d(vec3d3.x, 0.0D, vec3d3.z);
			Vec3d vec3d4 = (new Vec3d(vec3d2.x - vec3d.x, 0.0D, vec3d2.z - vec3d.z)).normalize().rotateY(1.5707964F);
			double e = vec3d3.dotProduct(vec3d4);
			this.eye.pivotX = MathHelper.sqrt((float)Math.abs(e)) * 2.0F * (float)Math.signum(e);
		}

		this.eye.visible = true;
		float m = guardianEntity.getTailAngle(k);
		this.tail[0].yaw = MathHelper.sin(m) * 3.1415927F * 0.05F;
		this.tail[1].yaw = MathHelper.sin(m) * 3.1415927F * 0.1F;
		this.tail[2].yaw = MathHelper.sin(m) * 3.1415927F * 0.15F;
	}

	private void updateSpikeExtensions(float animationProgress, float extension) {
		for(int i = 0; i < 12; ++i) {
			this.spikes[i].pivotX = getSpikePivotX(i, animationProgress, extension);
			this.spikes[i].pivotY = getSpikePivotY(i, animationProgress, extension);
			this.spikes[i].pivotZ = getSpikePivotZ(i, animationProgress, extension);
		}

	}

	private static float getAngle(int index, float animationProgress, float magnitude) {
		return 1.0F + MathHelper.cos(animationProgress * 1.5F + (float)index) * 0.01F - magnitude;
	}

	private static float getSpikePivotX(int index, float animationProgress, float extension) {
		return SPIKE_PIVOTS_X[index] * getAngle(index, animationProgress, extension);
	}

	private static float getSpikePivotY(int index, float animationProgress, float extension) {
		return 16.0F + SPIKE_PIVOTS_Y[index] * getAngle(index, animationProgress, extension);
	}

	private static float getSpikePivotZ(int index, float animationProgress, float extension) {
		return SPIKE_PIVOTS_Z[index] * getAngle(index, animationProgress, extension);
	}
}