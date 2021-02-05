package com.remodstudios.lumidep.datagen.generators;

import com.remodstudios.lumidep.datagen.ResourceGenerator;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.models.JModel;

public class SimpleItemGenerator implements ResourceGenerator {
    @Override
    public void genResources(RuntimeResourcePack rrp, String id) {
        this.generateItemModel(rrp, id);
    }

    protected void generateItemModel(RuntimeResourcePack rrp, String id) {
        rrp.addModel(
            JModel.model("minecraft:item/generated")
                .textures(
                    JModel.textures().layer0(prefixedPath("item", id))
                ),
            prefixedId("item", id)
        );
    }
}
