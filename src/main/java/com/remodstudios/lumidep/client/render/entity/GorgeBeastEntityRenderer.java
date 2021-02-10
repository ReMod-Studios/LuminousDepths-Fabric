package com.remodstudios.lumidep.client.render.entity;

import com.remodstudios.lumidep.client.render.entity.models.GorgeBeastEntityModel;
import com.remodstudios.lumidep.entities.GorgeBeastEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class GorgeBeastEntityRenderer extends GeoEntityRenderer<GorgeBeastEntity> {
    public GorgeBeastEntityRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new GorgeBeastEntityModel());
        this.shadowRadius = 0.7F; //change 0.7 to the desired shadow size.
    }
}
