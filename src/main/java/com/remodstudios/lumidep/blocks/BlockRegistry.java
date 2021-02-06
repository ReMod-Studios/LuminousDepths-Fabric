package com.remodstudios.lumidep.blocks;

import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.datagen.ResourceGenerator;
import com.remodstudios.lumidep.datagen.generators.BlockWithEntityGenerator;
import com.remodstudios.lumidep.datagen.generators.SlabBlockGenerator;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.SignType;
import net.minecraft.util.registry.Registry;

import java.util.Map;

import static net.minecraft.block.Blocks.*;
import static com.remodstudios.lumidep.datagen.ResourceGenerators.*;

public class BlockRegistry {
    public static final Map<Identifier, Pair<Block, ResourceGenerator>> BLOCKS = new Object2ObjectLinkedOpenHashMap<>();

    //region Block declarations
    public static final Block BLACK_SAND = add("black_sand", new Block(FabricBlockSettings.copyOf(DIRT).sounds(BlockSoundGroup.SAND)));
    public static final Block TUNGSTEN_DEPOSIT = add("tungsten_deposit", new Block(FabricBlockSettings.copyOf(SANDSTONE).sounds(BlockSoundGroup.SAND)));
    public static final Block TUNGSTEN_BLOCK = add("tungsten_block", newCopy(IRON_BLOCK));
    public static final Block CORALLINE_ALGAE = add("coralline_algae", newCopy(VINE));
    public static final Block DEAD_KELP = add("dead_kelp", newCopy(KELP_PLANT));
    public static final Block LUMEROCK = add("lumerock", newCopy(GLOWSTONE));

    public static final Block BRACKWOOD_LOG = add("brackwood_log", LOG_BLOCK, newLog());
    public static final Block STRIPPED_BRACKWOOD_LOG = add("stripped_brackwood_log", LOG_BLOCK, newLog());
    public static final Block BRACKWOOD_WOOD = add("brackwood_wood", WOOD_BLOCK, newLog());
    public static final Block STRIPPED_BRACKWOOD_WOOD = add("stripped_brackwood_wood", WOOD_BLOCK, newLog());
    public static final Block BRACKWOOD_PLANKS = add("brackwood_planks", newCopy(OAK_PLANKS));
    public static final Block BRACKWOOD_PRESSURE_PLATE = add("brackwood_pressure_plate", newCopy(OAK_PRESSURE_PLATE));
    public static final Block BRACKWOOD_BUTTON = add("brackwood_button", newCopy(OAK_BUTTON));
    public static final Block BRACKWOOD_DOOR = add("brackwood_door", new ModDoorBlock(FabricBlockSettings.copyOf(OAK_DOOR)));
    public static final Block BRACKWOOD_TRAPDOOR = add("brackwood_trapdoor", newCopy(OAK_TRAPDOOR));
    public static final Block BRACKWOOD_SIGN = add("brackwood_sign", new BlockWithEntityGenerator("brackwood_planks"), new SignBlock(FabricBlockSettings.copyOf(OAK_SIGN), SignType.WARPED));
    public static final Block BRACKWOOD_SLAB = add("brackwood_slab", new SlabBlockGenerator("brackwood_planks"), new SlabBlock(FabricBlockSettings.copyOf(OAK_SLAB)));
    public static final Block BRACKWOOD_STAIRS = add("brackwood_stairs", newCopy(OAK_STAIRS));
    public static final Block BRACKWOOD_FENCE = add("brackwood_fence", newCopy(OAK_FENCE));
    public static final Block BRACKWOOD_FENCE_GATE = add("brackwood_fence_gate", newCopy(OAK_FENCE_GATE));


    public static final Block ABSTAIN_LUMP = null; //TODO: Abstain
    public static final Block GORGE_MASS = null; //TODO: Gorge
    //endregion

    public static void init() {
        register();
    }

    public static void register() {
        BLOCKS.forEach((id, pair) -> Registry.register(Registry.BLOCK, id, pair.getLeft()));
    }

    //region Datagen methods
    public static void generateAssets(ArtificeResourcePack.ClientResourcePackBuilder pack) {
        BLOCKS.forEach((id, pair) -> pair.getRight().generateAssets(pack, id));
    }

    public static void generateData(ArtificeResourcePack.ServerResourcePackBuilder pack) {
        BLOCKS.forEach((id, pair) -> pair.getRight().generateData(pack, id));
    }
    //endregion

    //region Registry methods
    private static <B extends Block> B add(String name, B block) {
        return add(name, SIMPLE_BLOCK, block);
    }

    private static <B extends Block> B add(String name, ResourceGenerator generator, B block) {
        BLOCKS.put(LuminousDepths.id(name), new Pair<>(block, generator)); return block;
    }
    //endregion

    //region Block creation helpers
    private static Block newCopy(Block block) {
        return new Block(FabricBlockSettings.copyOf(block));
    }
    private static Block newLog() {
        return new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    }
    //endregion

}