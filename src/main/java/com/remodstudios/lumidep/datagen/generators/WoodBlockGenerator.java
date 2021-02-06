package com.remodstudios.lumidep.datagen.generators;

import com.remodstudios.lumidep.LuminousDepths;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import com.swordglowsblue.artifice.api.util.IdUtils;
import net.minecraft.util.Identifier;

public class WoodBlockGenerator extends AbstractParentedBlockGenerator {

    public WoodBlockGenerator(Identifier baseBlockId) {
        super(baseBlockId);
    }

    public WoodBlockGenerator(String baseBlockId) {
        super(baseBlockId);
    }


    @Override
    protected void generateBlockStates(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        Identifier modelId = IdUtils.wrapPath("block/", id);

        pack.addBlockState(id, state -> state
            .variant("axis=x", v -> v.model(modelId).rotationX(90).rotationY(90))
            .variant("axis=z", v -> v.model(modelId).rotationX(90))
            .variant("axis=y", v -> v.model(modelId))
        );
    }

    @Override
    protected void generateModels(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        pack.addBlockModel(id, model -> model
            .parent(new Identifier("block/cube_column"))
            .texture("end", baseBlockId)
            .texture("side", baseBlockId)
        );
    }
}
