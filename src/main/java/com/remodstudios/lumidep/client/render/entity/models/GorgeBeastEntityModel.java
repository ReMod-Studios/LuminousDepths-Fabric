package com.remodstudios.lumidep.client.render.entity.models;


import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.entities.GorgeBeastEntity;
import net.minecraft.util.Identifier;

public class GorgeBeastEntityModel extends SwimmingGeoModel<GorgeBeastEntity> {
    private static final Identifier MODEL = LuminousDepths.id("geo/gorgebeast.geo.json");
    private static final Identifier TEXTURE = LuminousDepths.id("textures/entity/gorgebeast.png");
    private static final Identifier ANIMATION = LuminousDepths.id("animations/gorgebeast.animation.json");

    @Override
    public Identifier getModelLocation(GorgeBeastEntity gorgeBeastEntity) {
        return MODEL;
    }

    @Override
    public Identifier getTextureLocation(GorgeBeastEntity gorgeBeastEntity) {
        return TEXTURE;
    }

    @Override
    public Identifier getAnimationFileLocation(GorgeBeastEntity gorgeBeastEntity) {
        return ANIMATION;
    }
}
