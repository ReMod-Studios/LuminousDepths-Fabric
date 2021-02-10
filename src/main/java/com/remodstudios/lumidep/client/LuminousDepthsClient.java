package com.remodstudios.lumidep.client;

import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.blocks.LumiDepBlocks;
import com.remodstudios.lumidep.blocks.entities.BrackwoodSignBlockEntity;
import com.remodstudios.lumidep.client.render.entity.*;
import com.remodstudios.lumidep.client.render.block.entity.BrackwoodSignBlockEntityRenderer;
import com.remodstudios.lumidep.entities.LumiDepEntities;
import com.remodstudios.lumidep.items.LumiDepItems;
import com.swordglowsblue.artifice.api.Artifice;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import org.apache.logging.log4j.Level;

import java.io.IOException;

public class LuminousDepthsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(BrackwoodSignBlockEntity.TYPE, BrackwoodSignBlockEntityRenderer::new);

        // TODO
        // Make this better, there's gotta be a more fire-and-forget way to do this
        EntityRendererRegistry.INSTANCE.register(LumiDepEntities.TEST, AdultKrelperEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(LumiDepEntities.TEST1, AnglerfishEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(LumiDepEntities.TEST2, BrokenGuardianEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(LumiDepEntities.TEST3, GoblinSharkEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(LumiDepEntities.TEST4, GorgeBeastEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(LumiDepEntities.TEST5, IsopodEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(LumiDepEntities.TEST6, MantarayEntityRenderer::new);

        Artifice.registerAssetPack(LuminousDepths.id("artifice_rp"), pack -> {
            LumiDepBlocks.INSTANCE.generateAssets(pack);
            LumiDepItems.INSTANCE.generateAssets(pack);

            try {
                pack.dumpResources("artifice.dbg", "assets");
            } catch (IOException ioe) {
                LuminousDepths.log(Level.ERROR, "BRUH! Artifice failed to dump!");
                ioe.printStackTrace();
            }
        });
    }
}
