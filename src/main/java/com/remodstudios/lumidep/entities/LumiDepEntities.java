package com.remodstudios.lumidep.entities;

import com.remodstudios.lumidep.LuminousDepths;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.util.registry.Registry;

public class LumiDepEntities {

    public static final LumiDepEntities INSTANCE = new LumiDepEntities();

    // TODO
    // Make this better, there's gotta be a more fire-and-forget way to do this
    public static final EntityType<AdultKreplerEntity> TEST = Registry.register(Registry.ENTITY_TYPE, LuminousDepths.id("adult_swim"), makeTestEntity(AdultKreplerEntity::new));
    public static final EntityType<AnglerfishEntity> TEST1 = Registry.register(Registry.ENTITY_TYPE, LuminousDepths.id("esca_go_brr"), makeTestEntity(AnglerfishEntity::new));
    public static final EntityType<BrokenGuardianEntity> TEST2 = Registry.register(Registry.ENTITY_TYPE, LuminousDepths.id("guardian_with_erectile_dysfunction"), makeTestEntity(BrokenGuardianEntity::new));
    public static final EntityType<GoblinSharkEntity> TEST3 = Registry.register(Registry.ENTITY_TYPE, LuminousDepths.id("sharky_warky"), makeTestEntity(GoblinSharkEntity::new));
    public static final EntityType<GorgeBeastEntity> TEST4 = Registry.register(Registry.ENTITY_TYPE, LuminousDepths.id("vore_beast"), makeTestEntity(GorgeBeastEntity::new));
    public static final EntityType<IsopodEntity> TEST5 = Registry.register(Registry.ENTITY_TYPE, LuminousDepths.id("isopoggers"), makeTestEntity(IsopodEntity::new));
    public static final EntityType<MantarayEntity> TEST6 = Registry.register(Registry.ENTITY_TYPE, LuminousDepths.id("megagay"), makeTestEntity(MantarayEntity::new));

    // Methods
    public void init() {
        // Loads Class(TM)

        // TODO
        // Make this better, there's gotta be a more fire-and-forget way to do this
        FabricDefaultAttributeRegistry.register(TEST, GoblinSharkEntity.createGoblinSharkAttributes());
        FabricDefaultAttributeRegistry.register(TEST1, GoblinSharkEntity.createGoblinSharkAttributes());
        FabricDefaultAttributeRegistry.register(TEST2, GoblinSharkEntity.createGoblinSharkAttributes());
        FabricDefaultAttributeRegistry.register(TEST3, GoblinSharkEntity.createGoblinSharkAttributes());
        FabricDefaultAttributeRegistry.register(TEST4, GoblinSharkEntity.createGoblinSharkAttributes());
        FabricDefaultAttributeRegistry.register(TEST5, GoblinSharkEntity.createGoblinSharkAttributes());
        FabricDefaultAttributeRegistry.register(TEST6, GoblinSharkEntity.createGoblinSharkAttributes());
    }

    // This is very not poggers, just for Pichu's slave driving needs
    public static <T extends WaterCreatureEntity> EntityType<T> makeTestEntity(EntityType.EntityFactory<T> factory) {
        return FabricEntityTypeBuilder
                .create(SpawnGroup.WATER_CREATURE, factory)
                .dimensions(EntityDimensions.fixed(0.9F, 0.6F))
                .build();
    }
}