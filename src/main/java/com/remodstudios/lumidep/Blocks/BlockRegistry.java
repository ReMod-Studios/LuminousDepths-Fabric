package com.remodstudios.lumidep.Blocks;

import com.remodstudios.lumidep.LuminousDepths;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

import static net.minecraft.block.Blocks.*;

public class BlockRegistry {
    // Bwocks
    public static final Block BLACK_SAND = register(new Block(FabricBlockSettings.copyOf(DIRT).sounds(BlockSoundGroup.SAND)),"black_sand");
    public static final Block TUNGSTEN_DEPOSIT = register(new Block(FabricBlockSettings.copyOf(SANDSTONE).sounds(BlockSoundGroup.SAND)), "tungsten_deposit");
    public static final Block TUNGSTEN_BLOCK = register(new Block(FabricBlockSettings.copyOf(IRON_BLOCK)), "tungsten_block");
    public static final Block LUMEROCK = register(new Block(FabricBlockSettings.copyOf(GLOWSTONE)),"lumerock");

    public static final Block ABSTAIN_LUMP = null;
    public static final Block GORGE_MASS = null;

    // Methods
    private static Block register(Block block, String name) {
        return Registry.register(Registry.BLOCK, LuminousDepths.id(name), block);
    }

    public static void init() {

    }

}