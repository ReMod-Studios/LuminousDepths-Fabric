package com.remodstudios.lumidep.items;

import com.remodstudios.lumidep.blocks.BlockRegistry;
import com.remodstudios.lumidep.LuminousDepths;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class ItemRegistry {
    private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    private static final ItemGroup GROUP
            = FabricItemGroupBuilder.build(
                LuminousDepths.id("group"),
                () -> new ItemStack(ItemRegistry.ESCA)
            );

    private static final FabricItemSettings BASE_SETTINGS = new FabricItemSettings().group(GROUP);

    // Items begin here
    public static final Item ESCA = new Item(BASE_SETTINGS);
    public static final Item TUNGSTEN_INGOT = new Item(BASE_SETTINGS);
    public static final Item TUNGSTEN_NUGGET = new Item(BASE_SETTINGS);

    public static void init() {
        // Alternatively, we can make `add` methods return an Item value and make everything in the static final initializations above
        add("esca", ESCA);
        add("tungsten_block", BlockRegistry.TUNGSTEN_BLOCK);
        add("tungsten_deposit", BlockRegistry.TUNGSTEN_DEPOSIT);
        add("tungsten_ingot", TUNGSTEN_INGOT);
        add("tungsten_nugget", TUNGSTEN_NUGGET);
        // Today my brain is kill because too much confusing code for me -- Pichu
        register();
    }

    // Registry Methods
    private static <I extends Item> void add(String name, I item) {
        ITEMS.put(LuminousDepths.id(name), item);
    }

    private static <B extends Block> void add(String name, B block) {
        add(name, block, BASE_SETTINGS);
    }

    private static <B extends Block> void add(String name, B block, FabricItemSettings settings) {
        BlockItem blockItem = new BlockItem(block, settings);
        ITEMS.put(LuminousDepths.id(name), blockItem);
    }

    // This right here is the registry money maker
    // It's where all the magic happens
    public static void register() {
        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
        // Whangd00dle - In case we want to add fuels or flammable items
        // addFuels();
        // addFlammables();
    }

    private static void addFuels() {
        FuelRegistry fuelRegistry = FuelRegistry.INSTANCE;
    }

    private static void addFlammables() {
        FlammableBlockRegistry flammableRegistry = FlammableBlockRegistry.getDefaultInstance();
    }
}