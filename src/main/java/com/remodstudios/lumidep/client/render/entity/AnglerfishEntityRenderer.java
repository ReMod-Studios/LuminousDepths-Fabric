package com.remodstudios.lumidep.client.render.entity;

import com.remodstudios.lumidep.client.render.entity.models.AnglerfishEntityModel;
import com.remodstudios.lumidep.entities.AnglerfishEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class AnglerfishEntityRenderer extends GeoEntityRenderer<AnglerfishEntity> {
    public AnglerfishEntityRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new AnglerfishEntityModel());
        this.shadowRadius = 0.7F; //change 0.7 to the desired shadow size.
    }
}
