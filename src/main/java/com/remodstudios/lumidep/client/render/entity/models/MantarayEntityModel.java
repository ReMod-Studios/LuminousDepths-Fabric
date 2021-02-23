package com.remodstudios.lumidep.client.render.entity.models;


import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.entities.MantarayEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MantarayEntityModel extends AnimatedGeoModel<MantarayEntity> {
    private static final Identifier MODEL = LuminousDepths.id("geo/mantaray.geo.json");
    private static final Identifier TEXTURE = LuminousDepths.id("textures/entity/mantaray.png");
    private static final Identifier ANIMATION = LuminousDepths.id("animations/mantaray.animation.json");

    @Override
    public Identifier getModelLocation(MantarayEntity mantarayEntity) {
        return MODEL;
    }

    @Override
    public Identifier getTextureLocation(MantarayEntity mantarayEntity) {
        return TEXTURE;
    }

    @Override
    public Identifier getAnimationFileLocation(MantarayEntity mantarayEntity) {
        // No animations yet
        return null;
    }
}
