package com.remodstudios.lumidep.datagen.generators.block;

import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import com.swordglowsblue.artifice.api.builder.assets.BlockStateBuilder;
import com.swordglowsblue.artifice.api.util.IdUtils;
import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.block.Block;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class FenceGateBlockGenerator extends AbstractParentedBlockGenerator {

    private static final Object2IntMap<Direction> dir2Deg = new Object2IntLinkedOpenHashMap<>();
    private static final String[] VARIANT_SUFFIXES = { "", "_open", "_wall", "_wall_open" };

    static {
        dir2Deg.put(Direction.SOUTH, 0);
        dir2Deg.put(Direction.WEST, 1);
        dir2Deg.put(Direction.NORTH, 2);
        dir2Deg.put(Direction.EAST, 3);
    }

    public FenceGateBlockGenerator(Identifier baseBlockId) {
        super(baseBlockId);
    }

    public FenceGateBlockGenerator(Block baseBlock) {
        super(baseBlock);
    }

    @Override
    protected void generateBlockStates(ArtificeResourcePack.ClientResourcePackBuilder rrp, Identifier id) {
        Identifier blockPath = IdUtils.wrapPath("block/", id);

        rrp.addBlockState(id, state -> {
            for (Direction facing : FenceGateBlock.FACING.getValues())
            for (boolean in_wall : FenceGateBlock.IN_WALL.getValues())
            for (boolean open: FenceGateBlock.OPEN.getValues()) {
                String varStr = String.format(
                        "facing=%s,in_wall=%s,open=%s",
                        facing, in_wall, open);

                state.variant(varStr, var -> {
                    StringBuilder modelStr = new StringBuilder(blockPath.toString());
                    if (in_wall) modelStr.append("_wall");
                    if (open) modelStr.append("_open");
                    var .model(new Identifier(modelStr.toString()))
                        .uvlock(true)
                        .rotationY(dir2Deg.getInt(facing) * 90);
                });
            }
        });
    }

    @Override
    protected void generateModels(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        for (String suffix : VARIANT_SUFFIXES) {
            pack.addBlockModel(IdUtils.wrapPath(id, suffix), model -> model
                .parent(new Identifier("block/template_fence_gate" + suffix))
                .texture("texture", baseBlockId)
            );
        }
    }
}
