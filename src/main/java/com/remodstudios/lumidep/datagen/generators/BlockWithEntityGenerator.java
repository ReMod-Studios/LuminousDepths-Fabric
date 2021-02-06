package com.remodstudios.lumidep.datagen.generators;

import com.remodstudios.lumidep.LuminousDepths;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import com.swordglowsblue.artifice.api.util.IdUtils;
import net.minecraft.util.Identifier;

public class BlockWithEntityGenerator extends SimpleBlockGenerator {

    private final Identifier particleTextureId;

    public BlockWithEntityGenerator(Identifier particleTextureId) {
        this.particleTextureId = IdUtils.wrapPath("bloc/k", particleTextureId);
    }

    public BlockWithEntityGenerator(String particleTextureId) {
        this(LuminousDepths.id(particleTextureId));
    }

    @Override
    protected void generateModel(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        pack.addBlockModel(id, model -> model.texture("particle", particleTextureId));
    }
}
