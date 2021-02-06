package com.remodstudios.lumidep.blocks;

import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.datagen.ResourceGenerator;
import com.remodstudios.lumidep.datagen.generators.BlockWithEntityGenerator;
import com.remodstudios.lumidep.datagen.generators.SlabBlockGenerator;
import com.remodstudios.lumidep.datagen.generators.WoodBlockGenerator;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.SignType;
import net.minecraft.util.registry.Registry;

import java.util.Map;

import static net.minecraft.block.Blocks.*;
import static com.remodstudios.lumidep.datagen.ResourceGenerators.*;

public class BlockRegistry {
    public static final Map<Identifier, Pair<Block, RegistrySettings>> BLOCKS = new Object2ObjectLinkedOpenHashMap<>();

    //region Block declarations
    public static final Block BLACK_SAND = add("black_sand", new Block(FabricBlockSettings.copyOf(DIRT).sounds(BlockSoundGroup.SAND)));
    public static final Block TUNGSTEN_DEPOSIT = add("tungsten_deposit", new Block(FabricBlockSettings.copyOf(SANDSTONE).sounds(BlockSoundGroup.SAND)));
    public static final Block TUNGSTEN_BLOCK = add("tungsten_block", newCopy(IRON_BLOCK));
    public static final Block CORALLINE_ALGAE = add("coralline_algae", newCopy(VINE));
    public static final Block DEAD_KELP = add("dead_kelp", newCopy(KELP_PLANT));
    public static final Block LUMEROCK = add("lumerock", newCopy(GLOWSTONE));

    public static final Block BRACKWOOD_LOG = add("brackwood_log", RegistrySettings.of(LOG_BLOCK), newLog());
    public static final Block STRIPPED_BRACKWOOD_LOG = add("stripped_brackwood_log", RegistrySettings.of(LOG_BLOCK), newLog());
    public static final Block BRACKWOOD_WOOD =
            add("brackwood_wood",
                RegistrySettings.of(new WoodBlockGenerator("brackwood_log")), newLog()
            );
    public static final Block STRIPPED_BRACKWOOD_WOOD =
            add("stripped_brackwood_wood",
                RegistrySettings.of(new WoodBlockGenerator("stripped_brackwood_log")), newLog()
            );
    public static final Block BRACKWOOD_PLANKS = add("brackwood_planks", newCopy(OAK_PLANKS));
    public static final Block BRACKWOOD_PRESSURE_PLATE = add("brackwood_pressure_plate", newCopy(OAK_PRESSURE_PLATE));
    public static final Block BRACKWOOD_BUTTON = add("brackwood_button", newCopy(OAK_BUTTON));
    public static final Block BRACKWOOD_DOOR =
            add("brackwood_door",
                RegistrySettings.of(DOOR_BLOCK, RenderLayer.getCutout()),
                new ModDoorBlock(FabricBlockSettings.copyOf(OAK_DOOR))
            );
    public static final Block BRACKWOOD_TRAPDOOR =
            add("brackwood_trapdoor",
                RegistrySettings.of(TRAPDOOR_BLOCK, RenderLayer.getCutout()),
                new ModTrapdoorBlock(FabricBlockSettings.copyOf(OAK_TRAPDOOR)));
    public static final Block BRACKWOOD_SIGN =
            add("brackwood_sign",
                RegistrySettings.of(new BlockWithEntityGenerator("brackwood_planks")),
                new SignBlock(FabricBlockSettings.copyOf(OAK_SIGN), SignType.WARPED)
            );
    public static final Block BRACKWOOD_SLAB =
            add("brackwood_slab",
                RegistrySettings.of(new SlabBlockGenerator("brackwood_planks")),
                new SlabBlock(FabricBlockSettings.copyOf(OAK_SLAB))
            );
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
        BLOCKS.forEach((id, pair) -> {
            Block block = pair.getLeft();
            Registry.register(Registry.BLOCK, id, block);
            RenderLayer layer = pair.getRight().renderLayer;
            if (layer != null) BlockRenderLayerMap.INSTANCE.putBlock(block, layer);
        });
    }

    //region Datagen methods
    public static void generateAssets(ArtificeResourcePack.ClientResourcePackBuilder pack) {
        BLOCKS.forEach((id, pair) -> pair.getRight().resourceGenerator.generateAssets(pack, id));
    }

    public static void generateData(ArtificeResourcePack.ServerResourcePackBuilder pack) {
        BLOCKS.forEach((id, pair) -> pair.getRight().resourceGenerator.generateData(pack, id));
    }
    //endregion

    //region Registry methods
    private static <B extends Block> B add(String name, B block) {
        return add(name, RegistrySettings.of(), block);
    }

    private static <B extends Block> B add(String name, RegistrySettings generator, B block) {
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

    protected static class RegistrySettings {
        public final ResourceGenerator resourceGenerator;
        public final RenderLayer renderLayer;

        protected RegistrySettings(ResourceGenerator resourceGenerator, RenderLayer renderLayer) {
            this.resourceGenerator = resourceGenerator;
            this.renderLayer = renderLayer;
        }

        public static RegistrySettings of() {
            return new RegistrySettings(SIMPLE_BLOCK, null);
        }
        public static RegistrySettings of(ResourceGenerator resourceGenerator) {
            return new RegistrySettings(resourceGenerator, null);
        }
        public static RegistrySettings of(ResourceGenerator resourceGenerator, RenderLayer renderLayer) {
            return new RegistrySettings(resourceGenerator, renderLayer);
        }
    }
}