package com.remodstudios.lumidep.Blocks;

import com.remodstudios.lumidep.LuminousDepths;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {
    // Blocks go here




    //////////
    // Methods
    //////////

    private static Block register(Block block, String name) {
        return Registry.register(Registry.BLOCK, new Identifier(LuminousDepths.MOD_ID, name), block);
    }

    public static void init() {
        // just loads the class
    }
}