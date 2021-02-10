package com.remodstudios.lumidep.client.render.entity;

import com.remodstudios.lumidep.client.render.entity.models.IsopodEntityModel;
import com.remodstudios.lumidep.entities.IsopodEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class IsopodEntityRenderer extends GeoEntityRenderer<IsopodEntity> {
    public IsopodEntityRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new IsopodEntityModel());
        this.shadowRadius = 0.7F; //change 0.7 to the desired shadow size.
    }
}
