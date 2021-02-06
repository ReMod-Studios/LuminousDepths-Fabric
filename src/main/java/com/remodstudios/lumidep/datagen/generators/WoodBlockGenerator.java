package com.remodstudios.lumidep.datagen.generators;

import com.remodstudios.lumidep.LuminousDepths;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;

public class WoodBlockGenerator extends SimpleBlockGenerator {
    @Override
    protected void generateBlockState(RuntimeResourcePack rrp, String id) {
        JState state = JState.state();
        String basePath = prefixedPath("block", id);

        state.add(JState.variant()
            .put("axis=x", JState.model(basePath).x(90).y(90))
            .put("axis=z", JState.model(basePath).x(90))
            .put("axis=y", JState.model(basePath))
        );

        rrp.addBlockState(state, LuminousDepths.id(id));
    }

    @Override
    protected void generateModel(RuntimeResourcePack rrp, String id) {
        String basePath = prefixedPath("block", id.replaceFirst("wood$", "log"));

        rrp.addModel(
            JModel.model("minecraft:block/cube_column")
                .textures(JModel.textures()
                    .var("end", basePath)
                    .var("side", basePath)
            ),
            prefixedId("block", id)
        );
    }
}
