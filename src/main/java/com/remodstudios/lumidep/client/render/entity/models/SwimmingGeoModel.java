package com.remodstudios.lumidep.client.render.entity.models;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public abstract class SwimmingGeoModel<T extends Entity & IAnimatable> extends AnimatedGeoModel<T> {
    @Override
    public void setLivingAnimations(T entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone body = this.getAnimationProcessor().getBone("body");
        if (body != null) {
            body.setRotationX((MathHelper.lerp(customPredicate.getPartialTick(), entity.prevPitch, entity.pitch) * -0.017453292F));
        }
    }
}
