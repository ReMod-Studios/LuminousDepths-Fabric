package com.remodstudios.lumidep.items;

import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.blocks.LumiDepBlocks;
import com.remodstudios.yarnandneedles.datagen.ResourceGenerator;
import com.remodstudios.yarnandneedles.datagen.generators.item.BlockItemGenerator;
import com.remodstudios.yarnandneedles.items.ItemRegistry;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import static com.remodstudios.yarnandneedles.datagen.ResourceGenerators.SIMPLE_ITEM;

@SuppressWarnings("unused")
public class LumiDepItems extends ItemRegistry {

    public static final LumiDepItems INSTANCE = new LumiDepItems();

    private final ItemGroup GROUP
            = FabricItemGroupBuilder.build(
                LuminousDepths.id("group"),
                () -> new ItemStack(LumiDepItems.INSTANCE.ESCA)
            );

    private final FabricItemSettings BASE_SETTINGS = new FabricItemSettings().group(GROUP);

    //region Item declarations
    public final Item ESCA                       = add("esca");
    public final Item TUNGSTEN_INGOT             = add("tungsten_ingot");
    public final Item TUNGSTEN_NUGGET            = add("tungsten_nugget");

    public final Item TUNGSTEN_BLOCK             = addBlockItem("tungsten_block");
    public final Item TUNGSTEN_DEPOSIT           = addBlockItem("tungsten_deposit");
    public final Item BLACK_SAND                 = addBlockItem("black_sand");
    public final Item CORALLINE_ALGAE            = addBlockItem("coralline_algae");
    public final Item DEAD_KELP                  = addBlockItem("dead_kelp");
    public final Item LUMEROCK                   = addBlockItem("lumerock");
    public final Item BRACKWOOD_LOG              = addBlockItem("brackwood_log");
    public final Item STRIPPED_BRACKWOOD_LOG     = addBlockItem("stripped_brackwood_log");
    public final Item BRACKWOOD_WOOD             = addBlockItem("brackwood_wood");
    public final Item STRIPPED_BRACKWOOD_WOOD    = addBlockItem("stripped_brackwood_wood");
    public final Item BRACKWOOD_PLANKS           = addBlockItem("brackwood_planks");
    public final Item BRACKWOOD_PRESSURE_PLATE   = addBlockItem("brackwood_pressure_plate");
    public final Item BRACKWOOD_BUTTON
            = addBlockItem("brackwood_button", new BlockItemGenerator(LuminousDepths.id("brackwood_button_inventory")));
    public final Item BRACKWOOD_DOOR             = addBlockItem("brackwood_door", SIMPLE_ITEM);
    public final Item BRACKWOOD_TRAPDOOR
            = addBlockItem("brackwood_trapdoor", new BlockItemGenerator(LuminousDepths.id("brackwood_trapdoor_bottom")));
    public final Item BRACKWOOD_SIGN
            = add("brackwood_sign",
                    SIMPLE_ITEM,
                    new BrackwoodSignItem(BASE_SETTINGS, LumiDepBlocks.INSTANCE.BRACKWOOD_SIGN, LumiDepBlocks.INSTANCE.BRACKWOOD_WALL_SIGN)
            );
    public final Item BRACKWOOD_SLAB             = addBlockItem("brackwood_slab");
    public final Item BRACKWOOD_STAIRS           = addBlockItem("brackwood_stairs");
    public final Item BRACKWOOD_FENCE
            = addBlockItem("brackwood_fence", new BlockItemGenerator(LuminousDepths.id("brackwood_fence_inventory")));
    public final Item BRACKWOOD_FENCE_GATE       = addBlockItem("brackwood_fence_gate");
    //endregion

    public LumiDepItems() {
        super(LuminousDepths.MOD_ID);
    }

    private BlockItem addBlockItem(String name) {
        return addBlockItem(name, LumiDepBlocks.INSTANCE.BLOCKS.get(LuminousDepths.id(name)).getLeft());
    }
    private BlockItem addBlockItem(String name, ResourceGenerator generator) {
        return addBlockItem(name, generator, LumiDepBlocks.INSTANCE.BLOCKS.get(LuminousDepths.id(name)).getLeft());
    }

    @Override
    protected FabricItemSettings getDefaultSettings() {
        return new FabricItemSettings().group(GROUP);
    }
}