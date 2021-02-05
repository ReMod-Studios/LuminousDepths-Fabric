package com.remodstudios.lumidep.blocks;

import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.datagen.ResourceGenerator;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Pair;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;

import java.util.Map;

import static net.minecraft.block.Blocks.*;
import static com.remodstudios.lumidep.datagen.ResourceGenerators.*;

public class BlockRegistry {
    public static final Map<String, Pair<Block, ResourceGenerator>> BLOCKS = new Object2ObjectLinkedOpenHashMap<>();

    //region Block declarations
    public static final Block BLACK_SAND;
    public static final Block TUNGSTEN_DEPOSIT;
    public static final Block TUNGSTEN_BLOCK;
    public static final Block CORALLINE_ALGAE;
    public static final Block DEAD_KELP;
    public static final Block LUMEROCK;

    public static final Block BRACKWOOD_LOG;
    public static final Block STRIPPED_BRACKWOOD_LOG;
    public static final Block BRACKWOOD_WOOD;
    public static final Block STRIPPED_BRACKWOOD_WOOD;
    public static final Block BRACKWOOD_PLANKS;
    public static final Block BRACKWOOD_PRESSURE_PLATE;
    public static final Block BRACKWOOD_BUTTON;
    public static final Block BRACKWOOD_DOOR;
    public static final Block BRACKWOOD_TRAPDOOR;
    public static final Block BRACKWOOD_SIGN;
    public static final Block BRACKWOOD_SLAB;
    public static final Block BRACKWOOD_STAIRS;
    public static final Block BRACKWOOD_FENCE;
    public static final Block BRACKWOOD_FENCE_GATE;


    public static final Block ABSTAIN_LUMP = null; //TODO: Abstain
    public static final Block GORGE_MASS = null; //TODO: Gorge
    //endregion

    static {
        try {
            BLACK_SAND = add("black_sand", new Block(FabricBlockSettings.copyOf(DIRT).sounds(BlockSoundGroup.SAND)));
            TUNGSTEN_DEPOSIT = add("tungsten_deposit", new Block(FabricBlockSettings.copyOf(SANDSTONE).sounds(BlockSoundGroup.SAND)));
            TUNGSTEN_BLOCK = add("tungsten_block", newCopy(IRON_BLOCK));
            CORALLINE_ALGAE = add("coralline_algae", newCopy(VINE));
            DEAD_KELP = add("dead_kelp", newCopy(KELP_PLANT));
            LUMEROCK = add("lumerock", newCopy(GLOWSTONE));

            BRACKWOOD_LOG = add("brackwood_log", new Block(FabricBlockSettings.of(Material.WOOD)));
            STRIPPED_BRACKWOOD_LOG = add("stripped_brackwood_log", new Block(FabricBlockSettings.of(Material.WOOD)));
            BRACKWOOD_WOOD = add("brackwood_wood", newCopy(OAK_WOOD));
            STRIPPED_BRACKWOOD_WOOD = add("stripped_brackwood_wood", newCopy(STRIPPED_OAK_WOOD));
            BRACKWOOD_PLANKS = add("brackwood_planks", newCopy(OAK_PLANKS));
            BRACKWOOD_PRESSURE_PLATE = add("brackwood_pressure_plate", newCopy(OAK_PRESSURE_PLATE));
            BRACKWOOD_BUTTON = add("brackwood_button", newCopy(OAK_BUTTON));
            BRACKWOOD_DOOR = add("brackwood_door", newCopy(OAK_DOOR));
            BRACKWOOD_TRAPDOOR = add("brackwood_trapdoor", newCopy(OAK_TRAPDOOR));
            BRACKWOOD_SIGN = add("brackwood_sign", newCopy(OAK_SIGN));
            BRACKWOOD_SLAB = add("brackwood_slab", newCopy(OAK_SLAB));
            BRACKWOOD_STAIRS = add("brackwood_stairs", newCopy(OAK_STAIRS));
            BRACKWOOD_FENCE = add("brackwood_fence", newCopy(OAK_FENCE));
            BRACKWOOD_FENCE_GATE = add("brackwood_fence_gate", newCopy(OAK_FENCE_GATE));
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    public static void init() {
        register();
    }

    public static void genResources(RuntimeResourcePack rrp) {
        BLOCKS.forEach((id, pair) -> pair.getRight().genResources(rrp, id));
    }

    private static <B extends Block> B add(String name, B block) {
        return add(name, SIMPLE_BLOCK, block);
    }

    private static <B extends Block> B add(String name, ResourceGenerator generator, B block) {
        BLOCKS.put(name, new Pair<>(block, generator)); return block;
    }

    public static void register() {
        BLOCKS.forEach((id, pair) -> Registry.register(Registry.BLOCK, LuminousDepths.id(id), pair.getLeft()));
    }

    private static Block newCopy(Block block) {
        return new Block(FabricBlockSettings.copyOf(block));
    }
}