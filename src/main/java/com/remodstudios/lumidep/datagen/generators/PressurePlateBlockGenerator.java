package com.remodstudios.lumidep.datagen.generators;

import com.google.gson.JsonObject;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import com.swordglowsblue.artifice.api.util.IdUtils;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;

public class PressurePlateBlockGenerator extends AbstractParentedBlockGenerator {

    public PressurePlateBlockGenerator(Identifier baseBlockId) {
        super(baseBlockId);
    }

    public PressurePlateBlockGenerator(Block baseBlock) {
        super(baseBlock);
    }

    @Override
    protected void generateBlockStates(ArtificeResourcePack.ClientResourcePackBuilder rrp, Identifier id) {
        Identifier blockPath = IdUtils.wrapPath("block/", id);

        rrp.addBlockState(id, state -> state
            .variant("powered=false", v -> v.model(blockPath))
            .variant("powered=true", v -> v.model(IdUtils.wrapPath(blockPath, "_down")))
        );
    }

    @Override
    protected void generateModels(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        pack.addBlockModel(id, model -> model
            .parent(new Identifier("block/pressure_plate_up"))
            .texture("texture", baseBlockId)
        );
        pack.addBlockModel(IdUtils.wrapPath(id, "_down"), model -> model
            .parent(new Identifier("block/pressure_plate_down"))
                .texture("texture", baseBlockId)
        );
    }

}
