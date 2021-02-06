package com.remodstudios.lumidep.datagen.generators;

import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import com.swordglowsblue.artifice.api.builder.assets.BlockStateBuilder;
import com.swordglowsblue.artifice.api.util.IdUtils;
import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class StairsBlockGenerator extends AbstractParentedBlockGenerator {

    public StairsBlockGenerator(Identifier baseBlockId) {
        super(baseBlockId);
    }

    public StairsBlockGenerator(Block baseBlock) {
        super(baseBlock);
    }

    @Override
    protected void generateBlockStates(ArtificeResourcePack.ClientResourcePackBuilder rrp, Identifier id) {
        Identifier blockPath = IdUtils.wrapPath("block/", id);

        // i hate my life
        rrp.addBlockState(id, state -> {
            for (Direction facing : StairsBlock.FACING.getValues())
            for (BlockHalf half : StairsBlock.HALF.getValues())
            for (StairShape shape : StairsBlock.SHAPE.getValues()) {
                String varStr = String.format(
                        "facing=%s,half=%s,shape=%s",
                        facing, half, shape);

                state.variant(varStr, var -> {
                    StringBuilder modelStr = new StringBuilder(blockPath.toString());
                    switch (shape) {
                        case INNER_LEFT:
                        case INNER_RIGHT:
                            modelStr.append("_inner");
                            break;
                        case OUTER_LEFT:
                        case OUTER_RIGHT:
                            modelStr.append("_outer");
                            break;
                    }
                    var.model(new Identifier(modelStr.toString())).uvlock(true);

                    applyRotation(var, facing, half, shape);
                });
            }
        });
    }

    @Override
    protected void generateModels(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        pack.addBlockModel(id, model -> model
            .parent(new Identifier("block/stairs"))
            .texture("bottom", baseBlockId)
            .texture("top", baseBlockId)
            .texture("side", baseBlockId)
        );
        pack.addBlockModel(IdUtils.wrapPath(id, "_inner"), model -> model
            .parent(new Identifier("block/inner_stairs"))
            .texture("bottom", baseBlockId)
            .texture("top", baseBlockId)
            .texture("side", baseBlockId)
        );
        pack.addBlockModel(IdUtils.wrapPath(id, "_outer"), model -> model
            .parent(new Identifier("block/outer_stairs"))
            .texture("bottom", baseBlockId)
            .texture("top", baseBlockId)
            .texture("side", baseBlockId)
        );
    }

    private static void applyRotation(BlockStateBuilder.Variant variant, Direction facing, BlockHalf half, StairShape shape) {
        int y = facing.getHorizontal();
        if (half == BlockHalf.TOP) {
            y += 1; // ???
            variant.rotationX(180);
        }

        switch (shape) {
            case STRAIGHT:
                if (half != BlockHalf.BOTTOM) break;
            case INNER_RIGHT:
            case OUTER_RIGHT:
                y += 1;
                break;
        }
        variant.rotationY(y % 4 * 90);
    }
}
