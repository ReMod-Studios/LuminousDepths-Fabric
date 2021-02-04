package com.remodstudios.lumidep.Items;

import com.remodstudios.lumidep.LuminousDepths;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

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

    public static void init(){
        register(ESCA, "esca");
        register(TUNGSTEN_INGOT, "tungsten_ingot");
        register(TUNGSTEN_NUGGET, "tungsten_nugget");
    }

    // Registry Methods
    private static Item register(Item item, String name) {
        return Registry.register(Registry.ITEM, LuminousDepths.id(name), item);
    }

    private static Item register(Block block, String name) {
        return register(block, name, BASE_SETTINGS);
    }

    private static Item register(Block block, String name, Item.Settings settings) {
        return register(new BlockItem(block, settings), name);
    }
}