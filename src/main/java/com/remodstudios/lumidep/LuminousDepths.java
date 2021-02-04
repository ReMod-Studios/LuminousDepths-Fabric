package com.remodstudios.lumidep;

import com.remodstudios.lumidep.Blocks.BlockRegistry;
import com.remodstudios.lumidep.Items.ItemRegistry;
import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LuminousDepths implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "lumidep";
    public static final String MOD_NAME = "Luminous Depths";

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        //TODO: Initializer
        ItemRegistry.init();
        BlockRegistry.init();
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}