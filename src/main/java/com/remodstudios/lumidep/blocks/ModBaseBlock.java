package com.remodstudios.lumidep.blocks;

import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.datagen.ResourceGeneratable;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.loot.JCondition;
import net.devtech.arrp.json.loot.JEntry;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.loot.JRoll;
import net.devtech.arrp.json.models.JModel;
import net.minecraft.block.Block;

public class ModBaseBlock extends Block implements ResourceGeneratable {
    public ModBaseBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void genResources(RuntimeResourcePack rrp, String id) {
        this.generateBlockState(rrp, id);
        this.generateModel(rrp, id);
        this.generateLootTable(rrp, id);
    }

    // this is only for simple blocks with one default blockstate
    protected void generateBlockState(RuntimeResourcePack rrp, String id) {
        // TODO im tired of seeing `LuminousDepths.MODID + ":block/" + id` everywhere - leocth
        rrp.addBlockState(
            JState.state(
                JState.variant().put("", JState.model(LuminousDepths.MOD_ID + ":block/" + id))
            ),
            LuminousDepths.id(id)
        );
    }

    protected void generateModel(RuntimeResourcePack rrp, String id) {
        rrp.addModel(
            JModel.model("minecraft:block/cube_all")
                .textures(JModel.textures()
                    .var("all", LuminousDepths.MOD_ID + ":block/" + id)
                ),
            LuminousDepths.id("block/" + id)
        );
    }

    protected void generateLootTable(RuntimeResourcePack rrp, String id) {
        rrp.addLootTable(
            LuminousDepths.id("blocks/" + id),
            JLootTable.loot("minecraft:block")
                .pool(JLootTable.pool()
                    .entry(new JEntry()
                        .type("minecraft:item")
                        .name(LuminousDepths.MOD_ID + ":" + id)
                    )
                    .condition(new JCondition("minecraft:survives_explosion"))
                    .rolls(1)
                    .bonus(0)
                )
        );
    }

}
