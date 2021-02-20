package com.remodstudios.lumidep.items;

import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.datagen.SpawnEggItemGenerator;
import com.remodstudios.yarnandneedles.datagen.ResourceGenerator;
import com.remodstudios.yarnandneedles.datagen.generators.item.BlockItemGenerator;
import com.remodstudios.yarnandneedles.items.ItemRegistry;
import com.swordglowsblue.artifice.api.util.IdUtils;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Pair;

import static com.remodstudios.lumidep.LuminousDepths.BLOCKS;
import static com.remodstudios.yarnandneedles.datagen.ResourceGenerators.SIMPLE_ITEM;

@SuppressWarnings("unused")
public class LumiDepItems extends ItemRegistry {

    private final ItemGroup GROUP
            = FabricItemGroupBuilder.build(
                LuminousDepths.id("group"),
                () -> new ItemStack(LuminousDepths.ITEMS.ESCA)
            );

    private final FabricItemSettings BASE_SETTINGS = new FabricItemSettings().group(GROUP);

    //region Item declarations
    public final Item ESCA                       = add("esca");
    public final Item TUNGSTEN_INGOT             = add("tungsten_ingot");
    public final Item TUNGSTEN_NUGGET            = add("tungsten_nugget");


    public final BlockItem TUNGSTEN_BLOCK             = addBlockItem("tungsten_block");
    public final BlockItem TUNGSTEN_DEPOSIT           = addBlockItem("tungsten_deposit");
    public final BlockItem BLACK_SAND                 = addBlockItem("black_sand");
    public final BlockItem CORALLINE_ALGAE            = addBlockItem("coralline_algae");
    public final BlockItem DEAD_KELP                  = addBlockItem("dead_kelp");
    public final BlockItem LUMEROCK                   = addBlockItem("lumerock");
    public final BlockItem BRACKWOOD_LOG              = addBlockItem("brackwood_log");
    public final BlockItem STRIPPED_BRACKWOOD_LOG     = addBlockItem("stripped_brackwood_log");
    public final BlockItem BRACKWOOD_WOOD             = addBlockItem("brackwood_wood");
    public final BlockItem STRIPPED_BRACKWOOD_WOOD    = addBlockItem("stripped_brackwood_wood");
    public final BlockItem BRACKWOOD_PLANKS           = addBlockItem("brackwood_planks");
    public final BlockItem BRACKWOOD_PRESSURE_PLATE   = addBlockItem("brackwood_pressure_plate");
    public final BlockItem BRACKWOOD_BUTTON
            = addBlockItem("brackwood_button", new BlockItemGenerator(LuminousDepths.id("brackwood_button_inventory")));
    public final BlockItem BRACKWOOD_DOOR             = addBlockItem("brackwood_door", SIMPLE_ITEM);
    public final BlockItem BRACKWOOD_TRAPDOOR
            = addBlockItem("brackwood_trapdoor", new BlockItemGenerator(LuminousDepths.id("brackwood_trapdoor_bottom")));
    public final BlockItem BRACKWOOD_SIGN
            = add("brackwood_sign",
                    SIMPLE_ITEM,
                    new BrackwoodSignItem(BASE_SETTINGS, BLOCKS.BRACKWOOD_SIGN, BLOCKS.BRACKWOOD_WALL_SIGN)
            );
    public final BlockItem BRACKWOOD_SLAB             = addBlockItem("brackwood_slab");
    public final BlockItem BRACKWOOD_STAIRS           = addBlockItem("brackwood_stairs");
    public final BlockItem BRACKWOOD_FENCE
            = addBlockItem("brackwood_fence", new BlockItemGenerator(LuminousDepths.id("brackwood_fence_inventory")));
    public final BlockItem BRACKWOOD_FENCE_GATE       = addBlockItem("brackwood_fence_gate");

    public final SpawnEggItem ADULT_KREPLER_SPAWN_EGG = addSpawnEgg(LuminousDepths.ENTITIES.ADULT_KREPLER, 0x5D703B, 0x963B12);
    public final SpawnEggItem ANGLERFISH_SPAWN_EGG = addSpawnEgg(LuminousDepths.ENTITIES.ANGLERFISH, 0x2C2834, 0x64D3FF);
    public final SpawnEggItem BROKEN_GUARDIAN_SPAWN_EGG = addSpawnEgg(LuminousDepths.ENTITIES.BROKEN_GUARDIAN, 0x5D6362, 0x744332);
    public final SpawnEggItem GOBLIN_SHARK_SPAWN_EGG = addSpawnEgg(LuminousDepths.ENTITIES.GOBLIN_SHARK, 0x93688C, 0xA57B97);
    public final SpawnEggItem GORGE_BEAST_SPAWN_EGG = addSpawnEgg(LuminousDepths.ENTITIES.GORGE_BEAST, 0x1A282D, 0x00FF93);
    public final SpawnEggItem ISOPOD_SPAWN_EGG = addSpawnEgg(LuminousDepths.ENTITIES.ISOPOD, 0x9D555D, 0xB68579);
    public final SpawnEggItem MANTARAY_SPAWN_EGG = addSpawnEgg(LuminousDepths.ENTITIES.MANTARAY, 0x110F17, 0x888893);
    //endregion

    public LumiDepItems() {
        super(LuminousDepths.MOD_ID);
    }

    private BlockItem addBlockItem(String name) {
        return addBlockItem(name, BLOCKS.BLOCKS.get(LuminousDepths.id(name)).getLeft());
    }
    private BlockItem addBlockItem(String name, ResourceGenerator generator) {
        return addBlockItem(name, generator, BLOCKS.BLOCKS.get(LuminousDepths.id(name)).getLeft());
    }

    private SpawnEggItem addSpawnEgg(EntityType<? extends MobEntity> entityType, int primaryColor, int secondaryColor) {
        SpawnEggItem egg = new SpawnEggItem(entityType, primaryColor, secondaryColor, getDefaultSettings());
        ITEMS.put(
            IdUtils.wrapPath(LuminousDepths.ENTITIES.idOf(entityType), "_spawn_egg"),
            new Pair<>(egg, SpawnEggItemGenerator.INSTANCE)
        );
        return egg;
    }

    @Override
    protected FabricItemSettings getDefaultSettings() {
        return new FabricItemSettings().group(GROUP);
    }
}