package com.remodstudios.lumidep.datagen;

import com.remodstudios.yarnandneedles.datagen.generators.item.SimpleItemGenerator;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import net.minecraft.util.Identifier;

public class SpawnEggItemGenerator extends SimpleItemGenerator {

    public static final SpawnEggItemGenerator INSTANCE = new SpawnEggItemGenerator();

    @Override
    protected void generateItemModel(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        pack.addItemModel(id, model -> model.parent(new Identifier("item/template_spawn_egg")));
    }
}
