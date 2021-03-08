package com.remodstudios.lumidep.client.render.entity.models;


import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.entities.AdultKreplerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AdultKrelperEntityModel extends AnimatedGeoModel<AdultKreplerEntity> {
    private static final Identifier MODEL = LuminousDepths.id("geo/adultkrelper.geo.json");
    private static final Identifier TEXTURE = LuminousDepths.id("textures/entity/adultkrelper.png");
    private static final Identifier ANIMATION = LuminousDepths.id("animations/adultkrelper.animation.json");

    @Override
    public Identifier getModelLocation(AdultKreplerEntity adultKreplerEntity) {
        return MODEL;
    }

    @Override
    public Identifier getTextureLocation(AdultKreplerEntity adultKreplerEntity) {
        return TEXTURE;
    }

    @Override
    public Identifier getAnimationFileLocation(AdultKreplerEntity adultKreplerEntity) {
        // No animations yet
        return null;
    }
}
