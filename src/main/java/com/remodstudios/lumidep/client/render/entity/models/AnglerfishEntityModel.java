package com.remodstudios.lumidep.client.render.entity.models;


import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.entities.AnglerfishEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnglerfishEntityModel extends AnimatedGeoModel<AnglerfishEntity> {
    private static final Identifier MODEL = LuminousDepths.id("geo/anglerfish.geo.json");
    private static final Identifier TEXTURE = LuminousDepths.id("textures/entity/anglerfish.png");
    private static final Identifier ANIMATION = LuminousDepths.id("animations/anglerfish.animation.json");

    @Override
    public Identifier getModelLocation(AnglerfishEntity anglerfishEntity) {
        return MODEL;
    }

    @Override
    public Identifier getTextureLocation(AnglerfishEntity anglerfishEntity) {
        return TEXTURE;
    }

    @Override
    public Identifier getAnimationFileLocation(AnglerfishEntity anglerfishEntity) {
        // No animations yet
        return null;
    }
}
