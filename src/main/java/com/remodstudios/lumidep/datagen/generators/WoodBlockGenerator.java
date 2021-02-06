package com.remodstudios.lumidep.datagen.generators;

import com.remodstudios.lumidep.LuminousDepths;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import com.swordglowsblue.artifice.api.util.IdUtils;
import net.minecraft.util.Identifier;

public class WoodBlockGenerator extends SimpleBlockGenerator {

    /*
     * the id of the corresponding log block
     * used for textures
     */
    private final Identifier logBlockId;

    public WoodBlockGenerator(Identifier logBlockId) {
        this.logBlockId = IdUtils.wrapPath("block/", logBlockId);
    }

    public WoodBlockGenerator(String logBlockId) {
        this(LuminousDepths.id(logBlockId));
    }

    /**
     * guesses the log id by removing `wood` at the end of the id and appending `log`
     */
    public WoodBlockGenerator() {
        this.logBlockId = null;
    }


    @Override
    protected void generateBlockState(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        Identifier modelId = IdUtils.wrapPath("block/", id);

        pack.addBlockState(id, state -> state
            .variant("axis=x", v -> v.model(modelId).rotationX(90).rotationY(90))
            .variant("axis=z", v -> v.model(modelId).rotationX(90))
            .variant("axis=y", v -> v.model(modelId))
        );
    }

    @Override
    protected void generateModel(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        // it works. who cares?
        Identifier logTexId = (logBlockId == null)
                ? new Identifier(
                        id.getNamespace(),
                        "block/" + id.getPath().replaceAll("wood$", "log"))
                : logBlockId;

        pack.addBlockModel(id, model -> model
            .parent(new Identifier("block/cube_column"))
            .texture("end", logTexId)
            .texture("side", logTexId)
        );
    }
}
