package com.remodstudios.lumidep.client.render.entity.models;


import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.entities.IsopodEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IsopodEntityModel extends AnimatedGeoModel<IsopodEntity> {
    private static Identifier MODEL = LuminousDepths.id("geo/isopod.geo.json");
    private static Identifier TEXTURE = LuminousDepths.id("textures/entity/isopod.png");
    private static Identifier ANIMATION = LuminousDepths.id("animations/isopod.animation.json");

    @Override
    public Identifier getModelLocation(IsopodEntity isopodEntity) {
        return MODEL;
    }

    @Override
    public Identifier getTextureLocation(IsopodEntity isopodEntity) {
        return TEXTURE;
    }

    @Override
    public Identifier getAnimationFileLocation(IsopodEntity isopodEntity) {
        // No animations yet
        return null;
    }
}
