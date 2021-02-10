package com.remodstudios.lumidep.client.render.entity;

import com.remodstudios.lumidep.client.render.entity.models.MantarayEntityModel;
import com.remodstudios.lumidep.entities.MantarayEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class MantarayEntityRenderer extends GeoEntityRenderer<MantarayEntity> {
    public MantarayEntityRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MantarayEntityModel());
        this.shadowRadius = 0.7F; //change 0.7 to the desired shadow size.
    }
}
