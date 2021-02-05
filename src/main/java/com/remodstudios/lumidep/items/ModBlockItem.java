package com.remodstudios.lumidep.items;

import com.remodstudios.lumidep.datagen.ResourceGeneratable;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.models.JModel;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class ModBlockItem extends BlockItem implements ResourceGeneratable {
    public ModBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

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
