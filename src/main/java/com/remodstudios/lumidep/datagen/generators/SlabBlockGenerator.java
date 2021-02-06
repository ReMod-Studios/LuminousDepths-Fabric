package com.remodstudios.lumidep.datagen.generators;

import com.google.gson.JsonObject;
import com.remodstudios.lumidep.LuminousDepths;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.loot.JCondition;
import net.devtech.arrp.json.loot.JEntry;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.minecraft.util.Identifier;

public class SlabBlockGenerator extends SimpleBlockGenerator {

    // maybe not a very accurate name but whatever - leocth
    private final String baseModel;

    public SlabBlockGenerator(String doubleSlabModel) {
        this.baseModel = prefixedPath("block", doubleSlabModel);
    }

    @Override
    protected void generateBlockState(RuntimeResourcePack rrp, String id) {
        JState state = JState.state();
        String basePath = prefixedPath("block", id);

        state.add(JState.variant()
            .put("type=bottom", JState.model(basePath))
            .put("type=top", JState.model(basePath + "_top"))
            .put("type=double", JState.model(baseModel))
        );

        rrp.addBlockState(state, LuminousDepths.id(id));
    }

    @Override
    protected void generateModel(RuntimeResourcePack rrp, String id) {
        String basePath = prefixedPath("block", id);
        JTextures sharedTextures = JModel.textures()
                .var("bottom", baseModel)
                .var("top", baseModel)
                .var("side", baseModel);

        rrp.addModel(
            JModel.model("minecraft:block/slab")
                .textures(sharedTextures),
            prefixedId("block", id)
        );
        rrp.addModel(
            JModel.model("minecraft:block/slab_top")
                .textures(sharedTextures),
            prefixedId("block", id + "_top")
        );
    }

    @Override
    protected void generateLootTable(RuntimeResourcePack rrp, String id) {
        JsonObject propertyObject = new JsonObject();
        propertyObject.addProperty("type", "double");
        String itemId = lumidep(id);

        // rip my sanity - leocth
        // @formatter:off
        rrp.addLootTable(
            prefixedId("blocks", id),
            JLootTable.loot("minecraft:block")
                .pool(JLootTable.pool()
                    .rolls(1)
                    .bonus(0)
                    .entry(new JEntry()
                        .type("minecraft:item")
                        .name(itemId)
                        .function("minecraft:explosion_decay")
                        .function(
                            JLootTable.function("minecraft:set_count")
                                .condition(JLootTable.predicate("minecraft:block_state_property")
                                    .parameter("block", itemId)
                                    .parameter("properties", propertyObject)
                                )
                                .parameter("count", 2)
                                .parameter("add", false)
                        )
                    )
                )
        );
        // @formatter:on
    }
    void genLootTableArtifice(ArtificeResourcePack.ServerResourcePackBuilder pack, String id) {
        JsonObject propertyObject = new JsonObject();
        propertyObject.addProperty("type", "double");
        Identifier itemId = LuminousDepths.id(id);

        pack.addLootTable(
            prefixedId("blocks", id),
            loot ->
                loot
                .pool(pool ->
                    pool
                    .rolls(1)
                    .bonusRolls(0f)
                    .entry(entry ->
                        entry
                        .type(new Identifier("item"))
                        .name(itemId)
                        .function(new Identifier("explosion_decay"), f -> {})
                        .function(new Identifier("set_count"), f ->
                            f
                            .condition(new Identifier("block_state_property"), cond ->
                                cond
                                .add("block", itemId.toString())
                                .add("properties", propertyObject)
                            )
                            .add("count", 2)
                            .add("add", false)
                        )
                    )
                )
        );
    }

}
