package com.remodstudios.lumidep.client.render.entity;

import com.remodstudios.lumidep.client.render.entity.models.GoblinSharkEntityModel;
import com.remodstudios.lumidep.entities.GoblinSharkEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class GoblinSharkEntityRenderer extends GeoEntityRenderer<GoblinSharkEntity> {
    public GoblinSharkEntityRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new GoblinSharkEntityModel());
        this.shadowRadius = 0.7F; //change 0.7 to the desired shadow size.
    }
}
