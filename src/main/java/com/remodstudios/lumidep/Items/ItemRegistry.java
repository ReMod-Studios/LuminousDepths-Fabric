package com.remodstudios.lumidep.Items;

import com.remodstudios.lumidep.LuminousDepths;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

    private static final ItemGroup GROUP = FabricItemGroupBuilder.build(new Identifier(LuminousDepths.MOD_ID,"group"), () -> new ItemStack(ItemRegistry.ESCA));

    // Items go here
    public static final Item ESCA = register(new Item(new Item.Settings().group(GROUP)), "esca");


    // Block Items go here



    ///////////
    // Methods
    ///////////

    public static void init(){
        // Loads Class?
    }
    private static Item register(Item item, String name) {
        return Registry.register(Registry.ITEM, new Identifier(LuminousDepths.MOD_ID, name), item);
    }

    private static Item register(Block block, String name, Item.Settings settings) {
        return register(new BlockItem(block, settings), name);
    }
}