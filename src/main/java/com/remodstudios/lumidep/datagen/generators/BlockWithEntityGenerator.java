package com.remodstudios.lumidep.datagen.generators;

import com.remodstudios.lumidep.LuminousDepths;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.models.JModel;

public class BlockWithEntityGenerator extends SimpleBlockGenerator {

    private final String particleTexId;

    public BlockWithEntityGenerator(String particleTexId) {
        this.particleTexId = prefixedPath("block", particleTexId);
    }

    @Override
    protected void generateModel(RuntimeResourcePack rrp, String id) {
        rrp.addModel(
            JModel.model()
                .textures(JModel.textures()
                    .particle(particleTexId)),
            LuminousDepths.id(id)
        );
    }
}
