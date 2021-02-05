package com.remodstudios.lumidep.items;

import com.remodstudios.lumidep.blocks.BlockRegistry;
import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.datagen.ResourceGeneratable;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

import java.util.Map;

public class ItemRegistry {
    private static final Map<String, Item> ITEMS = new Object2ObjectLinkedOpenHashMap<>();

    private static final ItemGroup GROUP
            = FabricItemGroupBuilder.build(
                LuminousDepths.id("group"),
                () -> new ItemStack(ItemRegistry.ESCA)
            );

    public static final FabricItemSettings BASE_SETTINGS = new FabricItemSettings().group(GROUP);

    // Items begin here
    public static final ModBaseItem ESCA = new ModBaseItem();
    public static final ModBaseItem TUNGSTEN_INGOT = new ModBaseItem();
    public static final ModBaseItem TUNGSTEN_NUGGET = new ModBaseItem();

    static {
        add("esca", ESCA);
        add("tungsten_ingot", TUNGSTEN_INGOT);
        add("tungsten_nugget", TUNGSTEN_NUGGET);

        add("tungsten_block", BlockRegistry.TUNGSTEN_BLOCK);
        add("tungsten_deposit", BlockRegistry.TUNGSTEN_DEPOSIT);
        add("black_sand", BlockRegistry.BLACK_SAND);
        add("coralline_algae", BlockRegistry.CORALLINE_ALGAE);
        add("dead_kelp", BlockRegistry.DEAD_KELP);
        add("lumerock", BlockRegistry.LUMEROCK);
    }

    public static void init() {
        // Today my brain is kill because too much confusing code for me -- Pichu
        register();
    }

    public static void genResources(RuntimeResourcePack rrp) {
        ITEMS.forEach((id, item) -> {
            if (item instanceof ResourceGeneratable) {
                ((ResourceGeneratable) item).genResources(rrp, id);
            }
        });
    }

    // Registry Methods
    private static <I extends Item> void add(String name, I item) {
        ITEMS.put(name, item);
    }

    private static <B extends Block> void add(String name, B block) {
        add(name, block, BASE_SETTINGS);
    }

    private static <B extends Block> void add(String name, B block, FabricItemSettings settings) {
        ITEMS.put(name, new ModBlockItem(block, settings));
    }

    // This right here is the registry money maker
    // It's where all the magic happens
    public static void register() {
        for (String id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, LuminousDepths.id(id), ITEMS.get(id));
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