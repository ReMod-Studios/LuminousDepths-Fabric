package com.remodstudios.lumidep.datagen.generators;

import com.remodstudios.lumidep.datagen.ResourceGenerator;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import com.swordglowsblue.artifice.api.util.IdUtils;
import net.minecraft.util.Identifier;

public class SimpleBlockGenerator implements ResourceGenerator {

    protected void generateBlockState(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        pack.addBlockState(id, state -> state
            .variant("", variant -> variant
                .model(IdUtils.wrapPath("block/", id))
            )
        );
    }

    protected void generateModel(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        pack.addBlockModel(id, model -> model
            .parent(new Identifier("block/cube_all"))
            .texture("all", IdUtils.wrapPath("block/", id))
        );
    }

    protected void generateLootTable(ArtificeResourcePack.ServerResourcePackBuilder pack, Identifier id) {
        pack.addLootTable(IdUtils.wrapPath("blocks/", id), loot -> loot
            .type(new Identifier("block"))
            .pool(pool -> pool
                .rolls(1)
                .bonusRolls(0f)
                .entry(entry -> entry
                    .type(new Identifier("item"))
                    .name(id)
                )
                .condition(new Identifier("survives_explosion"), c -> {})
            )
        );
    }

    @Override
    public void generateAssets(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        this.generateBlockState(pack, id);
        this.generateModel(pack, id);
    }

    @Override
    public void generateData(ArtificeResourcePack.ServerResourcePackBuilder pack, Identifier id) {
        this.generateLootTable(pack, id);
    }
}
