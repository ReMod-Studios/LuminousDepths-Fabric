package com.remodstudios.lumidep;

import com.remodstudios.lumidep.blocks.BlockRegistry;
import com.remodstudios.lumidep.items.ItemRegistry;
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
        BlockRegistry.init();
        ItemRegistry.init();

        Artifice.registerDataPack(id("artifice_rp"), pack -> {
            ItemRegistry.generateData(pack);
            BlockRegistry.generateData(pack);

            try {
                pack.dumpResources("artifice.dbg", "data");
            } catch (IOException ioe) {
                log(Level.ERROR, "BRUH! Artifice failed to dump!");
                ioe.printStackTrace();
            }
        });

        /*
        RuntimeResourcePack rrp = RuntimeResourcePack.create("lumidep:rrp");
        TagsRegistry.genResources(rrp);
        rrp.dump(); // debug
        RRPCallback.EVENT.register(resources -> resources.add(rrp));
         */
    }

    public static void log(Level level, String message){
        LOGGER.log(level, message);
    }
    public static Identifier id(String path) { return new Identifier(MOD_ID, path); }

}