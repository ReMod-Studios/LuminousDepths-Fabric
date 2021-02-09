package com.remodstudios.lumidep.blocks;

import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.yarnandneedles.blocks.*;
import com.remodstudios.yarnandneedles.datagen.generators.block.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static com.remodstudios.yarnandneedles.datagen.ResourceGenerators.*;
import static net.minecraft.block.Blocks.*;

@SuppressWarnings("unused")
public class LumiDepBlocks extends BlockRegistry {
    public static final LumiDepBlocks INSTANCE = new LumiDepBlocks();

    //region Block declarations
    public final Block BLACK_SAND = add("black_sand", new Block(FabricBlockSettings.copyOf(DIRT).sounds(BlockSoundGroup.SAND)));
    public final Block TUNGSTEN_DEPOSIT = add("tungsten_deposit", new Block(FabricBlockSettings.copyOf(SANDSTONE).sounds(BlockSoundGroup.SAND)));
    public final Block TUNGSTEN_BLOCK = add("tungsten_block", newCopy(IRON_BLOCK));
    public final Block CORALLINE_ALGAE =
            add("coralline_algae",
                RegistrySettings.of(SIMPLE_BLOCK, RenderLayer.getTranslucent()),
                new Block(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).strength(0.2F).sounds(BlockSoundGroup.VINE).nonOpaque())
            );
    public final Block DEAD_KELP = add("dead_kelp", newCopy(KELP_PLANT));
    public final Block LUMEROCK = add("lumerock", newCopy(GLOWSTONE));

    public final Block BRACKWOOD_LOG = add("brackwood_log", RegistrySettings.of(LOG_BLOCK), newLog());
    public final Block STRIPPED_BRACKWOOD_LOG = add("stripped_brackwood_log", RegistrySettings.of(LOG_BLOCK), newLog());
    public final Block BRACKWOOD_WOOD =
            add("brackwood_wood",
                RegistrySettings.of(new WoodBlockGenerator(idOf(BRACKWOOD_LOG))), newLog()
            );
    public final Block STRIPPED_BRACKWOOD_WOOD =
            add("stripped_brackwood_wood",
                RegistrySettings.of(new WoodBlockGenerator(idOf(STRIPPED_BRACKWOOD_LOG))), newLog()
            );
    public final Block BRACKWOOD_PLANKS = add("brackwood_planks", newCopy(OAK_PLANKS));
    private final Identifier brackwoodPlanksId = idOf(BRACKWOOD_PLANKS);
    public final Block BRACKWOOD_PRESSURE_PLATE =
            add("brackwood_pressure_plate",
                RegistrySettings.of(new PressurePlateBlockGenerator(brackwoodPlanksId)),
                new ModPressurePlateBlock(
                        PressurePlateBlock.ActivationRule.EVERYTHING,
                        FabricBlockSettings.copyOf(OAK_PRESSURE_PLATE))
            );
    public final Block BRACKWOOD_BUTTON =
            add("brackwood_button",
                RegistrySettings.of(new ButtonBlockGenerator(brackwoodPlanksId)),
                new ModWoodenButtonBlock(FabricBlockSettings.copyOf(OAK_BUTTON))
            );
    public final Block BRACKWOOD_DOOR =
            add("brackwood_door",
                RegistrySettings.of(DOOR_BLOCK, RenderLayer.getCutout()),
                new ModDoorBlock(FabricBlockSettings.copyOf(OAK_DOOR))
            );
    public final Block BRACKWOOD_TRAPDOOR =
            add("brackwood_trapdoor",
                RegistrySettings.of(TRAPDOOR_BLOCK, RenderLayer.getCutout()),
                new ModTrapdoorBlock(FabricBlockSettings.copyOf(OAK_TRAPDOOR))
            );
    public final Block BRACKWOOD_SIGN =
            add("brackwood_sign",
                RegistrySettings.of(new BlockWithEntityGenerator(brackwoodPlanksId)),
                new BrackwoodSignBlock(FabricBlockSettings.copyOf(OAK_SIGN))
            );
    public final Block BRACKWOOD_WALL_SIGN =
            add("brackwood_wall_sign",
                RegistrySettings.of(new BlockWithEntityGenerator(brackwoodPlanksId)),
                new BrackwoodWallSignBlock(FabricBlockSettings.copyOf(OAK_SIGN))
            );
    public final Block BRACKWOOD_SLAB =
            add("brackwood_slab",
                RegistrySettings.of(new SlabBlockGenerator(brackwoodPlanksId)),
                new SlabBlock(FabricBlockSettings.copyOf(OAK_SLAB))
            );
    public final Block BRACKWOOD_STAIRS =
            add("brackwood_stairs",
                RegistrySettings.of(new StairsBlockGenerator(brackwoodPlanksId)),
                new ModStairsBlock(BRACKWOOD_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(OAK_STAIRS))
            );
    public final Block BRACKWOOD_FENCE =
            add("brackwood_fence",
                RegistrySettings.of(new FenceBlockGenerator(brackwoodPlanksId)),
                new FenceBlock(FabricBlockSettings.copyOf(OAK_FENCE))
            );
    public final Block BRACKWOOD_FENCE_GATE =
            add("brackwood_fence_gate",
                RegistrySettings.of(new FenceGateBlockGenerator(brackwoodPlanksId)),
                new FenceGateBlock(FabricBlockSettings.copyOf(OAK_FENCE_GATE))
            );

    public final Block ABSTAIN_LUMP = null; //TODO: Abstain
    public final Block GORGE_MASS = null; //TODO: Gorge

    public LumiDepBlocks() {
        super(LuminousDepths.MOD_ID);
    }
    //endregion

    private static Block newCopy(Block block) {
        return new Block(FabricBlockSettings.copyOf(block));
    }
    private static Block newLog() {
        return new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    }
}