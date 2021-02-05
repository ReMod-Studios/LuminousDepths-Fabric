package com.remodstudios.lumidep.blocks;

import com.remodstudios.lumidep.LuminousDepths;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.minecraft.block.Blocks.*;

public class BlockRegistry {
    private static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();

    // Bwocks
    public static final Block BLACK_SAND = new Block(FabricBlockSettings.copyOf(DIRT).sounds(BlockSoundGroup.SAND));
    public static final Block TUNGSTEN_DEPOSIT = new Block(FabricBlockSettings.copyOf(SANDSTONE).sounds(BlockSoundGroup.SAND));
    public static final Block TUNGSTEN_BLOCK = new Block(FabricBlockSettings.copyOf(IRON_BLOCK));

    public static final Block CORALLINE_ALGAE = new Block(FabricBlockSettings.copyOf(VINE));
    public static final Block DEAD_KELP = new Block(FabricBlockSettings.copyOf(KELP_PLANT));
    public static final Block LUMEROCK = new Block(FabricBlockSettings.copyOf(GLOWSTONE));

    public static final Block ABSTAIN_LUMP = null;
    public static final Block GORGE_MASS = null;

    public static void init() {
        // Alternatively, we can make `add` methods return a Block value and make everything in the static final initializations above
        add("black_sand", BLACK_SAND);
        add("tungsten_deposit", TUNGSTEN_DEPOSIT);
        add("tungsten_block", TUNGSTEN_BLOCK);
        add("coralline_algae", CORALLINE_ALGAE);
        add("dead_kelp", DEAD_KELP);
        add("lumerock", LUMEROCK);

        register();
    }

    // Registry Methods
    private static <B extends Block> void add(String name, B block) {
        BLOCKS.put(LuminousDepths.id(name), block);
    }

    // This right here is the registry money maker
    // It's where all the magic happens
    public static void register() {
        for (Identifier id : BLOCKS.keySet()) {
            Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
        }
    }

}