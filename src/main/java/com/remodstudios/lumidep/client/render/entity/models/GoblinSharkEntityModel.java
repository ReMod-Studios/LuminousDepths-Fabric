package com.remodstudios.lumidep.client.render.entity.models;


import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.entities.GoblinSharkEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GoblinSharkEntityModel extends AnimatedGeoModel<GoblinSharkEntity> {
    private static Identifier MODEL = LuminousDepths.id("geo/goblinshark.geo.json");
    private static Identifier TEXTURE = LuminousDepths.id("textures/entity/goblinshark.png");
    private static Identifier ANIMATION = LuminousDepths.id("animations/base_aquatic.animation.json");

    @Override
    public Identifier getModelLocation(GoblinSharkEntity goblinSharkEntity) {
        return MODEL;
    }

    @Override
    public Identifier getTextureLocation(GoblinSharkEntity goblinSharkEntity) {
        return TEXTURE;
    }

    @Override
    public Identifier getAnimationFileLocation(GoblinSharkEntity goblinSharkEntity) {
        return ANIMATION;
    }

    @Override
    public void setLivingAnimations(GoblinSharkEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone body = this.getAnimationProcessor().getBone("body");
        if (body != null) {
            body.setRotationX(entity.pitch * -0.017453292F);
        }
    }
}
