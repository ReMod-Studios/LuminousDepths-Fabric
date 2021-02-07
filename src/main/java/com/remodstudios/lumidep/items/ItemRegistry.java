package com.remodstudios.lumidep.items;

import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.blocks.BlockRegistry;
import com.remodstudios.lumidep.datagen.ResourceGenerator;
import com.remodstudios.lumidep.datagen.generators.item.BlockItemGenerator;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.Registry;

import java.util.Map;

import static com.remodstudios.lumidep.datagen.ResourceGenerators.*;
import static com.remodstudios.lumidep.blocks.BlockRegistry.*;


public class ItemRegistry {
    private static final Map<Identifier, Pair<Item, ResourceGenerator>> ITEMS = new Object2ObjectLinkedOpenHashMap<>();

    private static final ItemGroup GROUP
            = FabricItemGroupBuilder.build(
                LuminousDepths.id("group"),
                () -> new ItemStack(ItemRegistry.ESCA)
            );

    private static final FabricItemSettings BASE_SETTINGS = new FabricItemSettings().group(GROUP);

    //region Item declarations
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
    public static final Item BRACKWOOD_BUTTON           = addBlockItem("brackwood_button", new BlockItemGenerator("brackwood_button_inventory"));
    public static final Item BRACKWOOD_DOOR             = addBlockItem("brackwood_door", SIMPLE_ITEM);
    public static final Item BRACKWOOD_TRAPDOOR         = addBlockItem("brackwood_trapdoor", new BlockItemGenerator("brackwood_trapdoor_bottom"));
    public static final Item BRACKWOOD_SIGN
            = add("brackwood_sign",
                    SIMPLE_ITEM,
                    new SignItem(BASE_SETTINGS, BlockRegistry.BRACKWOOD_SIGN, BRACKWOOD_WALL_SIGN)
            );
    public static final Item BRACKWOOD_SLAB             = addBlockItem("brackwood_slab");
    public static final Item BRACKWOOD_STAIRS           = addBlockItem("brackwood_stairs");
    public static final Item BRACKWOOD_FENCE            = addBlockItem("brackwood_fence", new BlockItemGenerator("brackwood_fence_inventory"));
    public static final Item BRACKWOOD_FENCE_GATE       = addBlockItem("brackwood_fence_gate");
    //endregion

    public static void init() {
        register();
    }

    public static void register() {
        ITEMS.forEach((id, pair) -> Registry.register(Registry.ITEM, id, pair.getLeft()));
    }

    //region Datagen methods
    public static void generateAssets(ArtificeResourcePack.ClientResourcePackBuilder pack) {
        ITEMS.forEach((id, pair) -> pair.getRight().generateAssets(pack, id));
    }

    public static void generateData(ArtificeResourcePack.ServerResourcePackBuilder pack) {
        ITEMS.forEach((id, pair) -> pair.getRight().generateData(pack, id));
    }
    //endregion
    //region Registry methods
    private static <I extends Item> I add(String name, I item) {
        return add(name,  SIMPLE_ITEM, item);
    }

    private static <I extends Item> I add(String name, ResourceGenerator generator, I item) {
        ITEMS.put(LuminousDepths.id(name), new Pair<>(item, generator));
        return item;
    }

    private static BlockItem addBlockItem(String name) {
        return addBlockItem(name, BLOCK_ITEM);
    }

    private static BlockItem addBlockItem(String name, ResourceGenerator generator) {
        return addBlockItem(name, generator, BLOCKS.get(LuminousDepths.id(name)).getLeft(), BASE_SETTINGS);
    }

    private static BlockItem addBlockItem(String name, Block block) {
        return addBlockItem(name, BLOCK_ITEM, block);
    }

    private static BlockItem addBlockItem(String name, ResourceGenerator generator, Block block) {
        return addBlockItem(name, generator, block, BASE_SETTINGS);
    }


    private static BlockItem addBlockItem(String name, ResourceGenerator generator, Block block, FabricItemSettings settings) {
        BlockItem item = new BlockItem(block, settings);
        ITEMS.put(LuminousDepths.id(name), new Pair<>(item, generator));
        return item;
    }
    //endregion

}