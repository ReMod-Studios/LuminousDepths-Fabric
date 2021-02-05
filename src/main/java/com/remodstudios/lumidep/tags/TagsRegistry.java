package com.remodstudios.lumidep.tags;

import com.remodstudios.lumidep.LuminousDepths;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.tags.JTag;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;

// Have to name tagsRegistry cause FAPI's registry section is called TagRegistry
public class TagsRegistry {
    public static final Tag<Item> SHINY = TagRegistry.item(LuminousDepths.id("shiny"));

    public static void genResources(RuntimeResourcePack rrp) {
        rrp.addTag(LuminousDepths.id("shiny"), addMetals());
    }

    private static JTag addMetals() {
        JTag tag = JTag.tag();

        // TODO
        // Lol have fun adding all the items
        tag.add(LuminousDepths.id("tungsten_block"));
        tag.add(LuminousDepths.id("tungsten_ingot"));
        tag.add(LuminousDepths.id("tungsten_nugget"));

        return tag;
    }
}
