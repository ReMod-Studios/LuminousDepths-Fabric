package com.remodstudios.lumidep.datagen.generators;

import com.google.gson.JsonObject;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.loot.JEntry;
import net.devtech.arrp.json.loot.JLootTable;
import net.minecraft.block.DoorBlock;
import net.minecraft.util.math.Direction;

public class DoorBlockGenerator extends SimpleBlockGenerator {

    @Override
    protected void generateBlockState(RuntimeResourcePack rrp, String id) {
        // :OHFUCK: - leocth
        JState state = JState.state();

        for (Direction dir : DoorBlock.FACING.getValues()) {
            
        }
    }

    @Override
    protected void generateLootTable(RuntimeResourcePack rrp, String id) {
        JsonObject propertyObject = new JsonObject();
        propertyObject.addProperty("half", "lower");
        String itemId = lumidep(id);

        rrp.addLootTable(
            prefixedId("blocks", id),
            JLootTable.loot("minecraft:block")
                .pool(JLootTable.pool()
                    .rolls(1)
                    .bonus(0)
                    .entry(new JEntry()
                        .type("minecraft:item")
                        .name(itemId)
                        .condition(JLootTable.predicate("minecraft:block_state_property")
                            .parameter("block", itemId)
                            .parameter("properties", propertyObject)
                        )
                    )
                    .condition(JLootTable.predicate("minecraft:survives_explosion"))
                )
        );
    }
}
