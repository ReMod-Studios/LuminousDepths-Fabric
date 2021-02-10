package com.remodstudios.lumidep.client.render.entity;

import com.remodstudios.lumidep.client.render.entity.models.AdultKrelperEntityModel;
import com.remodstudios.lumidep.entities.AdultKreplerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class AdultKrelperEntityRenderer extends GeoEntityRenderer<AdultKreplerEntity> {
    public AdultKrelperEntityRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new AdultKrelperEntityModel());
        this.shadowRadius = 0.7F; //change 0.7 to the desired shadow size.
    }
}
