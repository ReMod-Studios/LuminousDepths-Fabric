package com.remodstudios.lumidep.datagen.generators;

import com.remodstudios.lumidep.datagen.ResourceGenerator;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import com.swordglowsblue.artifice.api.util.IdUtils;
import net.minecraft.util.Identifier;

public class BlockItemGenerator implements ResourceGenerator {

    protected void generateItemModel(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        pack.addItemModel(id, model -> model
            .parent(IdUtils.wrapPath("block/", id))
        );
    }

    @Override
    public void generateAssets(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        this.generateItemModel(pack, id);
    }

    @Override
    public void generateData(ArtificeResourcePack.ServerResourcePackBuilder pack, Identifier id) {

    }
}
