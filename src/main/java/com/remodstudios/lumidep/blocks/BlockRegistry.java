package com.remodstudios.lumidep.blocks;

import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.datagen.ResourceGeneratable;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.minecraft.block.Blocks.*;

public class BlockRegistry {
    private static final Map<String, Block> BLOCKS = new LinkedHashMap<>();

    // Bwocks
    public static final Block BLACK_SAND = new ModBaseBlock(FabricBlockSettings.copyOf(DIRT).sounds(BlockSoundGroup.SAND));
    public static final Block TUNGSTEN_DEPOSIT = new ModBaseBlock(FabricBlockSettings.copyOf(SANDSTONE).sounds(BlockSoundGroup.SAND));
    public static final Block TUNGSTEN_BLOCK = new ModBaseBlock(FabricBlockSettings.copyOf(IRON_BLOCK));

    public static final Block CORALLINE_ALGAE = new ModBaseBlock(FabricBlockSettings.copyOf(VINE));
    public static final Block DEAD_KELP = new ModBaseBlock(FabricBlockSettings.copyOf(KELP_PLANT));
    public static final Block LUMEROCK = new ModBaseBlock(FabricBlockSettings.copyOf(GLOWSTONE));

    public static final Block ABSTAIN_LUMP = null; //TODO
    public static final Block GORGE_MASS = null; //TODO

    static {
        add("black_sand", BLACK_SAND);
        add("tungsten_deposit", TUNGSTEN_DEPOSIT);
        add("tungsten_block", TUNGSTEN_BLOCK);
        add("coralline_algae", CORALLINE_ALGAE);
        add("dead_kelp", DEAD_KELP);
        add("lumerock", LUMEROCK);
    }

    public static void init() {
        register();
    }

    public static void genResources(RuntimeResourcePack rrp) {
        BLOCKS.forEach((id, block) -> {
            if (block instanceof ResourceGeneratable) {
                ((ResourceGeneratable) block).genResources(rrp, id);
            }
        });
    }

    // Registry Methods
    private static <B extends Block> void add(String name, B block) {
        BLOCKS.put(name, block);
    }

    // This right here is the registry money maker
    // It's where all the magic happens
    public static void register() {
        for (String id : BLOCKS.keySet()) {
            Registry.register(Registry.BLOCK, LuminousDepths.id(id), BLOCKS.get(id));
        }
    }

}