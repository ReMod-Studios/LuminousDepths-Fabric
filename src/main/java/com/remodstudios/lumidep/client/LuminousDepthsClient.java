package com.remodstudios.lumidep.client;

import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.blocks.entities.BrackwoodSignBlockEntity;
import com.remodstudios.lumidep.client.render.block.entity.BrackwoodSignBlockEntityRenderer;
import com.remodstudios.lumidep.client.render.entity.LumiDepEntityRenderers;
import com.swordglowsblue.artifice.api.Artifice;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import org.apache.logging.log4j.Level;

import java.io.IOException;

@Environment(EnvType.CLIENT)
public class LuminousDepthsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(BrackwoodSignBlockEntity.TYPE, BrackwoodSignBlockEntityRenderer::new);

        LumiDepEntityRenderers.INSTANCE.init();

        Artifice.registerAssetPack(LuminousDepths.id("artifice_rp"), pack -> {
            LuminousDepths.BLOCKS.generateAssets(pack);
            LuminousDepths.ITEMS.generateAssets(pack);

            try {
                pack.dumpResources("artifice.dbg", "assets");
            } catch (IOException ioe) {
                LuminousDepths.log(Level.ERROR, "BRUH! Artifice failed to dump!");
                ioe.printStackTrace();
            }
        });
    }
}
