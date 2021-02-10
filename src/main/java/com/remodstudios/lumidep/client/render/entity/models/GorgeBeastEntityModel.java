package com.remodstudios.lumidep.client.render.entity.models;


import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.entities.GorgeBeastEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GorgeBeastEntityModel extends AnimatedGeoModel<GorgeBeastEntity> {
    private static Identifier MODEL = LuminousDepths.id("geo/gorgebeast.geo.json");
    private static Identifier TEXTURE = LuminousDepths.id("textures/entity/gorgebeast.png");
    private static Identifier ANIMATION = LuminousDepths.id("animations/gorgebeast.animation.json");

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
        // No animations yet
        return null;
    }
}
