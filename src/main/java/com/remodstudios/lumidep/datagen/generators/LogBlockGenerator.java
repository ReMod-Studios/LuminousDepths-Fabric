package com.remodstudios.lumidep.datagen.generators;

import com.remodstudios.lumidep.LuminousDepths;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.minecraft.util.Identifier;

public class LogBlockGenerator extends SimpleBlockGenerator {




    void genResourcesArtifice(ArtificeResourcePack.ClientResourcePackBuilder pack, String id) {
        Identifier horizontalId = LuminousDepths.id("block/" + id + "horizontal");
        Identifier baseId = LuminousDepths.id("block/" + id);

        pack.addBlockState(LuminousDepths.id(id), state -> state
            .variant("axis=x", variant -> variant.model(horizontalId).rotationX(90).rotationY(90))
            .variant("axis=z", variant -> variant.model(horizontalId).rotationX(90))
            .variant("axis=y", variant -> variant.model(baseId)));
    }


    @Override
    protected void generateBlockState(RuntimeResourcePack rrp, String id) {
        JState state = JState.state();
        String basePath = prefixedPath("block", id);
        String horizontal = basePath + "_horizontal";

        state.add(JState.variant()
            .put("axis=x", JState.model(horizontal).x(90).y(90))
            .put("axis=z", JState.model(horizontal).x(90))
            .put("axis=y", JState.model(basePath))
        );

        rrp.addBlockState(state, LuminousDepths.id(id));
    }

    @Override
    protected void generateModel(RuntimeResourcePack rrp, String id) {
        String basePath = prefixedPath("block", id);
        JTextures sharedTextures = JModel.textures()
                .var("end", basePath + "_top")
                .var("side", basePath);


        rrp.addModel(
            JModel.model("minecraft:block/cube_column")
                    .textures(sharedTextures),
            prefixedId("block", id)
        );
        rrp.addModel(
            JModel.model("minecraft:block/cube_column_horizontal")
                    .textures(sharedTextures),
            prefixedId("block", id + "_horizontal")
        );
    }
}
