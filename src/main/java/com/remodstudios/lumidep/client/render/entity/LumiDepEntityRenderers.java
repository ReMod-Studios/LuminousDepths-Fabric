package com.remodstudios.lumidep.client.render.entity;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;

import java.util.List;

import static com.remodstudios.lumidep.LuminousDepths.ENTITIES;

@Environment(EnvType.CLIENT)
public class LumiDepEntityRenderers {
    public static final LumiDepEntityRenderers INSTANCE = new LumiDepEntityRenderers();

    public final List<TypeToRendererPair<? extends Entity>> RENDERERS = new ObjectArrayList<>();

    public static class TypeToRendererPair<E extends Entity> {
        public final EntityType<E> type;
        public final EntityRendererFactory<E> rendererFactory;

        public TypeToRendererPair(EntityType<E> type, EntityRendererFactory<E> rendererFactory) {
            this.type = type;
            this.rendererFactory = rendererFactory;
        }

        public void register() {
            EntityRendererRegistry.INSTANCE.register(type, rendererFactory);
        }
    }

    public LumiDepEntityRenderers() {
        add(ENTITIES.ADULT_KREPLER, AdultKrelperEntityRenderer::new);
        add(ENTITIES.ANGLERFISH, AnglerfishEntityRenderer::new);
        add(ENTITIES.BROKEN_GUARDIAN, BrokenGuardianEntityRenderer::new);
        add(ENTITIES.GOBLIN_SHARK, GoblinSharkEntityRenderer::new);
        add(ENTITIES.GORGE_BEAST, GorgeBeastEntityRenderer::new);
        add(ENTITIES.ISOPOD, IsopodEntityRenderer::new);
        add(ENTITIES.MANTARAY, MantarayEntityRenderer::new);
    }

    public void init() {
        RENDERERS.forEach(TypeToRendererPair::register);
    }

    private <T extends Entity> void add(EntityType<T> entityType, EntityRendererFactory<T> entry) {
        RENDERERS.add(new TypeToRendererPair<>(entityType, entry));
    }
}
