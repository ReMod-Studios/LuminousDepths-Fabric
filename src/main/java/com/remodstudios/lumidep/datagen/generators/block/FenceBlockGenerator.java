package com.remodstudios.lumidep.datagen.generators.block;

import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import com.swordglowsblue.artifice.api.builder.assets.BlockStateBuilder;
import com.swordglowsblue.artifice.api.util.IdUtils;
import com.swordglowsblue.artifice.api.util.Processor;
import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.function.BiConsumer;

public class FenceBlockGenerator extends AbstractParentedBlockGenerator {

    public FenceBlockGenerator(Identifier baseBlockId) {
        super(baseBlockId);
    }

    public FenceBlockGenerator(Block baseBlock) {
        super(baseBlock);
    }

    @Override
    protected void generateBlockStates(ArtificeResourcePack.ClientResourcePackBuilder rrp, Identifier id) {
        Identifier fencePostPath = IdUtils.wrapPath("block/", id, "_post");
        Identifier fenceSidePath = IdUtils.wrapPath("block/", id, "_side");

        BiConsumer<Integer, BlockStateBuilder.Variant> applySideModel = (rot, v) -> v
                .model(fenceSidePath)
                .rotationY(rot)
                .uvlock(true);

        // when mojank is finally smort - leocth
        rrp.addBlockState(id, state -> state
            .multipartCase(c -> c.apply(v -> v.model(fencePostPath)))
            .multipartCase(c -> c
                .when("north", "true")
                .apply(v -> applySideModel.accept(0, v))
            )
            .multipartCase(c -> c
                .when("east", "true")
                .apply(v -> applySideModel.accept(90, v))
            )
            .multipartCase(c -> c
                .when("south", "true")
                .apply(v -> applySideModel.accept(180, v))
            )
            .multipartCase(c -> c
                .when("west", "true")
                .apply(v -> applySideModel.accept(270, v))
            )
        );
    }

    @Override
    protected void generateModels(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        pack.addBlockModel(IdUtils.wrapPath(id, "_inventory"), model -> model
            .parent(new Identifier("block/fence_inventory"))
            .texture("texture", baseBlockId)
        );
        pack.addBlockModel(IdUtils.wrapPath(id, "_post"), model -> model
            .parent(new Identifier("block/fence_post"))
            .texture("texture", baseBlockId)
        );
        pack.addBlockModel(IdUtils.wrapPath(id, "_side"), model -> model
            .parent(new Identifier("block/fence_side"))
            .texture("texture", baseBlockId)
        );
    }
}
