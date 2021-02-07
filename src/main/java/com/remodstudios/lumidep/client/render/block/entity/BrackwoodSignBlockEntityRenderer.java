package com.remodstudios.lumidep.client.render.block.entity;

import com.google.common.collect.ImmutableMap;
import com.remodstudios.lumidep.blocks.LumidepSignType;
import com.remodstudios.lumidep.blocks.entities.BrackwoodSignBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.SignBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.SignType;
import net.minecraft.util.math.Vec3f;

public class BrackwoodSignBlockEntityRenderer implements BlockEntityRenderer<BrackwoodSignBlockEntity> {

    private static final SignType SIGN_TYPE = LumidepSignType.BRACKWOOD;
    private final SignBlockEntityRenderer.SignModel signModel;

    public BrackwoodSignBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.signModel = new SignBlockEntityRenderer.SignModel(ctx.getLayerModelPart(EntityModelLayers.createSign(SIGN_TYPE)));
    }

    @Override
    public void render(BrackwoodSignBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState blockState = entity.getCachedState();
        matrices.push();
        matrices.translate(0.5D, 0.5D, 0.5D);
        float h;
        if (blockState.getBlock() instanceof SignBlock) {
            h = -blockState.get(SignBlock.ROTATION) * 360 / 16.0F;
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(h));
            signModel.stick.visible = true;
        } else {
            h = -blockState.get(WallSignBlock.FACING).asRotation();
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(h));
            matrices.translate(0.0D, -0.3125D, -0.4375D);
            signModel.stick.visible = false;
        }

        matrices.push();
        matrices.scale(0.6666667F, -0.6666667F, -0.6666667F);
        SpriteIdentifier spriteIdentifier = TexturedRenderLayers.getSignTextureId(SIGN_TYPE);
        VertexConsumer vertexConsumer = spriteIdentifier.getVertexConsumer(vertexConsumers, signModel::getLayer);
        signModel.root.render(matrices, vertexConsumer, light, overlay);
        matrices.pop();
    }
}
