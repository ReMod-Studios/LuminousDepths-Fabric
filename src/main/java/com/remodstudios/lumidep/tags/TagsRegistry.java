package com.remodstudios.lumidep.tags;

import com.remodstudios.lumidep.LuminousDepths;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;

// Have to name TagsRegistry cause FAPI's registry section is called TagRegistry
public class TagsRegistry {
    public static final Tag<Item> SHINY = TagRegistry.item(LuminousDepths.id("shiny"));

    public static void generateData(ArtificeResourcePack.ServerResourcePackBuilder pack) {
        pack.addItemTag(LuminousDepths.id("shiny"), tag -> tag
                // yes im using raw json :yeehaw: - leocth
                .values(
                        LuminousDepths.id("tungsten_block"),
                        LuminousDepths.id("tungsten_ingot"),
                        LuminousDepths.id("tungsten_nugget")
                )
        );
    }
}
