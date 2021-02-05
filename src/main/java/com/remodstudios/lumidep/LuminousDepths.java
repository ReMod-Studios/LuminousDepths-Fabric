package com.remodstudios.lumidep;

import com.remodstudios.lumidep.Blocks.BlockRegistry;
import com.remodstudios.lumidep.Items.ItemRegistry;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LuminousDepths implements ModInitializer {

    public static final String MOD_ID = "lumidep";
    public static final String MOD_NAME = "Luminous Depths";

    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        ItemRegistry.init();
        BlockRegistry.init();
    }

    public static void log(Level level, String message){
        LOGGER.log(level, message);
    }
    public static Identifier id(String path) { return new Identifier(MOD_ID, path); }

}