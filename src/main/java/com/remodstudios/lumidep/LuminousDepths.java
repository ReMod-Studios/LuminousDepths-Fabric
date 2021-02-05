package com.remodstudios.lumidep;

import com.remodstudios.lumidep.blocks.BlockRegistry;
import com.remodstudios.lumidep.items.ItemRegistry;
import com.remodstudios.lumidep.tags.TagsRegistry;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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
        BlockRegistry.init();
        ItemRegistry.init();

        RuntimeResourcePack rrp = RuntimeResourcePack.create("lumidep:rrp");
        ItemRegistry.genResources(rrp);
        BlockRegistry.genResources(rrp);
        TagsRegistry.genResources(rrp);
        rrp.dump(); // debug
        RRPCallback.EVENT.register(resources -> resources.add(rrp));
    }

    public static void log(Level level, String message){
        LOGGER.log(level, message);
    }
    public static Identifier id(String path) { return new Identifier(MOD_ID, path); }

}