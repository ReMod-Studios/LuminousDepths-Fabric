package com.remodstudios.lumidep.client.render.entity.models;


import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.entities.GoblinSharkEntity;
import net.minecraft.util.Identifier;

public class GoblinSharkEntityModel extends SwimmingGeoModel<GoblinSharkEntity> {
    private static Identifier MODEL = LuminousDepths.id("geo/goblinshark.geo.json");
    private static Identifier TEXTURE = LuminousDepths.id("textures/entity/goblinshark.png");
    private static Identifier ANIMATION = LuminousDepths.id("animations/goblinshark.animation.json");

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
}
