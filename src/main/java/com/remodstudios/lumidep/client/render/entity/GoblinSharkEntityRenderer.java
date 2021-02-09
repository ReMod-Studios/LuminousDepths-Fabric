package com.remodstudios.lumidep.client.render.entity;

import com.remodstudios.lumidep.client.render.entity.models.GoblinSharkEntityModel;
import com.remodstudios.lumidep.entities.GoblinSharkEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class GoblinSharkEntityRenderer extends GeoEntityRenderer<GoblinSharkEntity> {
    public GoblinSharkEntityRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new GoblinSharkEntityModel());
        this.shadowRadius = 0.7F; //change 0.7 to the desired shadow size.
    }

    @Override
    public void renderEarly(GoblinSharkEntity animatable, MatrixStack stackIn, float ticks, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float partialTicks) {

    }
}
