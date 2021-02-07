package com.remodstudios.lumidep.datagen.generators.item;

import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.datagen.ResourceGenerator;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import com.swordglowsblue.artifice.api.util.IdUtils;
import net.minecraft.util.Identifier;

public class BlockItemGenerator implements ResourceGenerator {

    private final Identifier parentModelId;

    public BlockItemGenerator(Identifier parentModelId) {
        this.parentModelId = parentModelId;
    }
    public BlockItemGenerator(String parentModelId) {
        this(LuminousDepths.id(parentModelId));
    }

    // use block id
    public BlockItemGenerator() {
        this.parentModelId = null;
    }

    protected void generateItemModel(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        pack.addItemModel(id, model -> model
            .parent(IdUtils.wrapPath("block/", parentModelId == null ? id : parentModelId))
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
