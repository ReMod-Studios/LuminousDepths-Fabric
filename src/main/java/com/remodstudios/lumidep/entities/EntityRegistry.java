package com.remodstudios.lumidep.entities;

import com.remodstudios.lumidep.LuminousDepths;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

public class EntityRegistry {

    // TODO
    // Make this better, there's gotta be a more fire-and-forget way to do this
    public static final EntityType<GoblinSharkEntity> TEST = Registry.register(Registry.ENTITY_TYPE,
            LuminousDepths.id("sharky_warky"),
            FabricEntityTypeBuilder
                    .create(SpawnGroup.WATER_CREATURE, GoblinSharkEntity::new)
                    .dimensions(EntityDimensions.fixed(0.9F, 0.6F))
                    .build());

    // Methods
    public static void init() {
        // Loads Class(TM)

        // TODO
        // Make this better, there's gotta be a more fire-and-forget way to do this
        FabricDefaultAttributeRegistry.register(TEST, GoblinSharkEntity.createGoblinSharkAttributes());
    }
}