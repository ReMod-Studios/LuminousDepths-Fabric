package com.remodstudios.lumidep.items;

import com.remodstudios.lumidep.datagen.ResourceGeneratable;
import com.sun.scenario.Settings;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.models.JModel;
import net.minecraft.item.Item;

public class ModBaseItem extends Item implements ResourceGeneratable {

    public ModBaseItem(Settings settings) {
        super(settings);
    }

    public ModBaseItem() {
        this(ItemRegistry.BASE_SETTINGS);
    }

    public void genResources(RuntimeResourcePack rrp, String id) {
        this.generateItemModel(rrp, id);
    }

    protected void generateItemModel(RuntimeResourcePack rrp, String id) {
        rrp.addModel(
            JModel.model("minecraft:item/generated")
                .textures(
                    JModel.textures()
                        .layer0(prefixedPath("item", id))
                ),
                prefixedId("item", id)
        );
    }
}
