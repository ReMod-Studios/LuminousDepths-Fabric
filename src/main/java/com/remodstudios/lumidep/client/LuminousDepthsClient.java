package com.remodstudios.lumidep.client;

import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.blocks.BlockRegistry;
import com.remodstudios.lumidep.items.ItemRegistry;
import com.swordglowsblue.artifice.api.Artifice;
import net.fabricmc.api.ClientModInitializer;
import org.apache.logging.log4j.Level;

import java.io.IOException;

public class LuminousDepthsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Artifice.registerAssetPack(LuminousDepths.id("artifice_rp"), pack -> {
            ItemRegistry.generateAssets(pack);
            BlockRegistry.generateAssets(pack);

            try {
                pack.dumpResources("artifice.dbg", "assets");
            } catch (IOException ioe) {
                LuminousDepths.log(Level.ERROR, "BRUH! Artifice failed to dump!");
                ioe.printStackTrace();
            }
        });
    }
}
