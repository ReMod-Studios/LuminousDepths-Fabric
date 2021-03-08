package com.remodstudios.lumidep.client.render.entity.models;


import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.entities.BrokenGuardianEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BrokenGuardianEntityModel extends AnimatedGeoModel<BrokenGuardianEntity> {
    private static final Identifier MODEL = LuminousDepths.id("geo/brokenguardian.geo.json");
    private static final Identifier TEXTURE = LuminousDepths.id("textures/entity/brokenguardian.png");
    private static final Identifier ANIMATION = LuminousDepths.id("animations/brokenguardian.animation.json");

    @Override
    public Identifier getModelLocation(BrokenGuardianEntity brokenGuardianEntity) {
        return MODEL;
    }

    @Override
    public Identifier getTextureLocation(BrokenGuardianEntity brokenGuardianEntity) {
        return TEXTURE;
    }

    @Override
    public Identifier getAnimationFileLocation(BrokenGuardianEntity brokenGuardianEntity) {
        // No animations yet
        return null;
    }
}
