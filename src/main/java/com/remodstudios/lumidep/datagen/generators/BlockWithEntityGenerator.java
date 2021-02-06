package com.remodstudios.lumidep.datagen.generators;

import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;

public class BlockWithEntityGenerator extends AbstractParentedBlockGenerator {

    public BlockWithEntityGenerator(Identifier particleTextureId) {
        super(particleTextureId);
    }

    public BlockWithEntityGenerator(Block baseBlock) {
        super(baseBlock);
    }

    @Override
    protected void generateModels(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        pack.addBlockModel(id, model -> model.texture("particle", baseBlockId));
    }
}
