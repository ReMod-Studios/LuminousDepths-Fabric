package com.remodstudios.lumidep.datagen.generators;

import com.remodstudios.lumidep.datagen.ResourceGenerator;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.models.JModel;

public class BlockItemGenerator implements ResourceGenerator {

    public void genResources(RuntimeResourcePack rrp, String id) {
        this.generateItemModel(rrp, id);
    }

    protected void generateItemModel(RuntimeResourcePack rrp, String id) {
        rrp.addModel(
            JModel.model(prefixedPath("block", id)),
            prefixedId("item", id)
        );
    }
}
