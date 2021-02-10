package com.remodstudios.lumidep.client.render.entity;

import com.remodstudios.lumidep.client.render.entity.models.BrokenGuardianEntityModel;
import com.remodstudios.lumidep.entities.BrokenGuardianEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class BrokenGuardianEntityRenderer extends GeoEntityRenderer<BrokenGuardianEntity> {
    public BrokenGuardianEntityRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new BrokenGuardianEntityModel());
        this.shadowRadius = 0.7F; //change 0.7 to the desired shadow size.
    }
}
