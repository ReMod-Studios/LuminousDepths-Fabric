package com.remodstudios.lumidep.items;

import com.remodstudios.lumidep.blocks.BlockRegistry;
import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.datagen.ResourceGenerator;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.Registry;

import java.util.Map;

import static com.remodstudios.lumidep.datagen.ResourceGenerators.*;
import static net.minecraft.block.Blocks.*;
import static com.remodstudios.lumidep.blocks.BlockRegistry.*;


public class ItemRegistry {
    private static final Map<String, Pair<Item, ResourceGenerator>> ITEMS = new Object2ObjectLinkedOpenHashMap<>();

    private static final ItemGroup GROUP
            = FabricItemGroupBuilder.build(
                LuminousDepths.id("group"),
                () -> new ItemStack(ItemRegistry.ESCA)
            );

    private static final FabricItemSettings BASE_SETTINGS = new FabricItemSettings().group(GROUP);

    // Items begin here
    public static final Item ESCA = add("esca", new Item(BASE_SETTINGS));
    public static final Item TUNGSTEN_INGOT = add("tungsten_ingot", new Item(BASE_SETTINGS));
    public static final Item TUNGSTEN_NUGGET = add("tungsten_nugget", new Item(BASE_SETTINGS));

    public static final Item TUNGSTEN_BLOCK             = addBlockItem("tungsten_block");
    public static final Item TUNGSTEN_DEPOSIT           = addBlockItem("tungsten_deposit");
    public static final Item BLACK_SAND                 = addBlockItem("black_sand");
    public static final Item CORALLINE_ALGAE            = addBlockItem("coralline_algae");
    public static final Item DEAD_KELP                  = addBlockItem("dead_kelp");
    public static final Item LUMEROCK                   = addBlockItem("lumerock");
    public static final Item BRACKWOOD_LOG              = addBlockItem("brackwood_log");
    public static final Item STRIPPED_BRACKWOOD_LOG     = addBlockItem("stripped_brackwood_log");
    public static final Item BRACKWOOD_WOOD             = addBlockItem("brackwood_wood");
    public static final Item STRIPPED_BRACKWOOD_WOOD    = addBlockItem("stripped_brackwood_wood");
    public static final Item BRACKWOOD_PLANKS           = addBlockItem("brackwood_planks");
    public static final Item BRACKWOOD_PRESSURE_PLATE   = addBlockItem("brackwood_pressure_plate");
    public static final Item BRACKWOOD_BUTTON           = addBlockItem("brackwood_button");
    public static final Item BRACKWOOD_DOOR             = addBlockItem("brackwood_door");
    public static final Item BRACKWOOD_TRAPDOOR         = addBlockItem("brackwood_trapdoor");
    public static final Item BRACKWOOD_SIGN             = addBlockItem("brackwood_sign");
    public static final Item BRACKWOOD_SLAB             = addBlockItem("brackwood_slab");
    public static final Item BRACKWOOD_STAIRS           = addBlockItem("brackwood_stairs");
    public static final Item BRACKWOOD_FENCE            = addBlockItem("brackwood_fence");
    public static final Item BRACKWOOD_FENCE_GATE       = addBlockItem("brackwood_fence_gate");

    public static void init() {
        register();
    }

    public static void genResources(RuntimeResourcePack rrp) {
        ITEMS.forEach((id, pair) -> pair.getRight().genResources(rrp, id));
    }

    private static <I extends Item> I add(String name, I item) {
        return add(name,  SIMPLE_ITEM, item);
    }

    private static <I extends Item> I add(String name, ResourceGenerator generator, I item) {
        ITEMS.put(name, new Pair<>(item, generator));
        return item;
    }

    private static BlockItem addBlockItem(String id) {
        return add(id, BLOCK_ITEM, BLOCKS.get(id).getLeft(), BASE_SETTINGS);
    }

    private static <B extends Block> BlockItem add(String name, B block) {
        return add(name, BLOCK_ITEM, block, BASE_SETTINGS);
    }

    private static <B extends Block> BlockItem add(String name, ResourceGenerator generator, B block, FabricItemSettings settings) {
        BlockItem item = new BlockItem(block, settings);
        ITEMS.put(name, new Pair<>(item, generator));
        return item;
    }

    public static void register() {
        ITEMS.forEach((id, pair) -> Registry.register(Registry.ITEM, LuminousDepths.id(id), pair.getLeft()));
    }
}