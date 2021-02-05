package com.remodstudios.lumidep.datagen.generators;

import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.datagen.ResourceGenerator;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.loot.JCondition;
import net.devtech.arrp.json.loot.JEntry;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.models.JModel;

public class SimpleBlockGenerator implements ResourceGenerator {
    public void genResources(RuntimeResourcePack rrp, String id) {
        this.generateBlockState(rrp, id);
        this.generateModel(rrp, id);
        this.generateLootTable(rrp, id);
    }

    protected void generateBlockState(RuntimeResourcePack rrp, String id) {
        rrp.addBlockState(
            JState.state(
                JState.variant().put("", JState.model(prefixedPath("block", id)))
            ),
            LuminousDepths.id(id)
        );
    }

    protected void generateModel(RuntimeResourcePack rrp, String id) {
        rrp.addModel(
            JModel.model("minecraft:block/cube_all")
                .textures(JModel.textures()
                    .var("all", prefixedPath("block", id))
                ),
            prefixedId("block", id)
        );
    }

    protected void generateLootTable(RuntimeResourcePack rrp, String id) {
        rrp.addLootTable(
            prefixedId("blocks", id),
            JLootTable.loot("minecraft:block")
                .pool(JLootTable.pool()
                    .entry(new JEntry()
                        .type("minecraft:item")
                        .name(lumidep(id))
                    )
                    .condition(new JCondition("minecraft:survives_explosion"))
                    .rolls(1)
                    .bonus(0)
                )
        );
    }
}
