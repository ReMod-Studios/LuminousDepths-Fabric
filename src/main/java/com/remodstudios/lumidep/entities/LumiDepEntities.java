package com.remodstudios.lumidep.entities;

import com.remodstudios.lumidep.LuminousDepths;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class LumiDepEntities {

    public final Map<Identifier, RegistryEntry<?>> ENTITIES = new Object2ObjectLinkedOpenHashMap<>();

    public final EntityType<AdultKreplerEntity> ADULT_KREPLER =
            add("adult_swim", waterCreatureEntry(AdultKreplerEntity::new, AdultKreplerEntity.createAttributes()));
    public final EntityType<AnglerfishEntity> ANGLERFISH =
            add("esca_go_brr", waterCreatureEntry(AnglerfishEntity::new, AnglerfishEntity.createAttributes()));
    public final EntityType<BrokenGuardianEntity> BROKEN_GUARDIAN =
            add("guardian_with_erectile_dysfunction", waterCreatureEntry(BrokenGuardianEntity::new, BrokenGuardianEntity.createAttributes()));
    public final EntityType<GoblinSharkEntity> GOBLIN_SHARK =
            add("sharky_wanky", waterCreatureEntry(GoblinSharkEntity::new, GoblinSharkEntity.createAttributes()));
    public final EntityType<GorgeBeastEntity> GORGE_BEAST =
            add("vore_beast", waterCreatureEntry(GorgeBeastEntity::new, GorgeBeastEntity.createAttributes()));
    public final EntityType<IsopodEntity> ISOPOD =
            add("isopoggers", waterCreatureEntry(IsopodEntity::new, IsopodEntity.createAttributes()));
    public final EntityType<MantarayEntity> MANTARAY =
            add("megagay", waterCreatureEntry(MantarayEntity::new, MantarayEntity.createAttributes()));

    public static class RegistryEntry<T extends Entity> {
        @NotNull public final EntityType<T> entityType;

        public RegistryEntry(@NotNull EntityType<T> entityType) {
            this.entityType = entityType;
        }

        public void register(Identifier id) {
            Registry.register(Registry.ENTITY_TYPE, id, entityType);
        }

        public static class Living<T extends LivingEntity> extends RegistryEntry<T> {
            @Nullable public final DefaultAttributeContainer.Builder attributeBuilder;

            public Living(@NotNull EntityType<T> entityType, @Nullable DefaultAttributeContainer.Builder attributeBuilder) {
                super(entityType);
                this.attributeBuilder = attributeBuilder;
            }

            @Override
            public void register(Identifier id) {
                super.register(id);
                if (attributeBuilder != null)
                    FabricDefaultAttributeRegistry.register(entityType, attributeBuilder);
            }
        }
    }

    public static <T extends WaterCreatureEntity> RegistryEntry.Living<T> waterCreatureEntry(
            EntityType.EntityFactory<T> factory,
            DefaultAttributeContainer.Builder attributeBuilder)
    {
        return new RegistryEntry.Living<>(makeWaterEntityType(factory), attributeBuilder);
    }

    // Methods
    public void init() {
        ENTITIES.forEach((id, entry) -> entry.register(id));
    }

    public Identifier idOf(EntityType<?> type) {
        return ENTITIES.entrySet().stream()
                .filter(entry -> entry.getValue().entityType.equals(type))
                .map(Map.Entry::getKey).findFirst()
                .orElseThrow(() -> new IllegalStateException("Block not found in registry!"));
    }

    private <T extends Entity> EntityType<T> add(String id, RegistryEntry<T> entry) {
        ENTITIES.put(LuminousDepths.id(id), entry); return entry.entityType;
    }

    // This is very not poggers, just for Pichu's slave driving needs
    private static <T extends WaterCreatureEntity> EntityType<T> makeWaterEntityType(EntityType.EntityFactory<T> factory) {
        return FabricEntityTypeBuilder
                .create(SpawnGroup.WATER_CREATURE, factory)
                .dimensions(EntityDimensions.fixed(0.9F, 0.6F))
                .build();
    }
}