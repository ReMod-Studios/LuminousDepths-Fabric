package com.remodstudios.lumidep;

import com.remodstudios.lumidep.blocks.LumiDepBlocks;
import com.remodstudios.lumidep.items.LumiDepItems;
import com.remodstudios.lumidep.tags.TagsRegistry;
import com.swordglowsblue.artifice.api.Artifice;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class LuminousDepths implements ModInitializer {

    public static final String MOD_ID = "lumidep";
    public static final String MOD_NAME = "Luminous Depths";

    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        LumiDepBlocks.INSTANCE.init();
        LumiDepItems.INSTANCE.init();

        Artifice.registerDataPack(id("artifice_rp"), pack -> {
            LumiDepBlocks.INSTANCE.generateData(pack);
            LumiDepItems.INSTANCE.generateData(pack);
            TagsRegistry.generateData(pack);

            try {
                pack.dumpResources("artifice.dbg", "data");
            } catch (IOException ioe) {
                log(Level.ERROR, "BRUH! Artifice failed to dump!");
                ioe.printStackTrace();
            }
        });
    }

    public static void log(Level level, String message){
        LOGGER.log(level, message);
    }
    public static Identifier id(String path) { return new Identifier(MOD_ID, path); }

}