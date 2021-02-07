package com.remodstudios.lumidep.datagen.generators.block;

import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import com.swordglowsblue.artifice.api.builder.assets.BlockStateBuilder;
import com.swordglowsblue.artifice.api.util.IdUtils;
import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.block.Block;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class ButtonBlockGenerator extends AbstractParentedBlockGenerator {

    private static final Object2IntMap<Direction> dir2Deg = new Object2IntLinkedOpenHashMap<>();

    static {
        // for some reason its clockwise instead of counterclockwise... - leocth
        dir2Deg.put(Direction.NORTH, 0);
        dir2Deg.put(Direction.EAST, 1);
        dir2Deg.put(Direction.SOUTH, 2);
        dir2Deg.put(Direction.WEST, 3);
    }

    public ButtonBlockGenerator(Identifier baseBlockId) {
        super(baseBlockId);
    }

    public ButtonBlockGenerator(Block baseBlock) {
        super(baseBlock);
    }

    @Override
    protected void generateBlockStates(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        Identifier blockPath = IdUtils.wrapPath("block/", id);
        Identifier pressedModelPath = IdUtils.wrapPath("block/", id, "_pressed");

        pack.addBlockState(id, state -> {
            for (Direction facing : AbstractButtonBlock.FACING.getValues())
            for (WallMountLocation face : AbstractButtonBlock.FACE.getValues())
            for (boolean powered : AbstractButtonBlock.POWERED.getValues()) {
                String varStr = String.format(
                        "face=%s,facing=%s,powered=%s",
                        face.asString(), // so motherfucking mojang forgot to implement `toString` on `WallMountLocation`...
                        facing,
                        powered);

                state.variant(varStr, var -> {
                    switch (face) {
                        case WALL: var.rotationX(90).uvlock(true); break;
                        case CEILING: var.rotationX(180); break;
                    }
                    var.model(powered ? pressedModelPath : blockPath);
                    applyRotation(var, facing, face);
                });
            }
        });
    }

    @Override
    protected void generateModels(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        pack.addBlockModel(id, model -> model
            .parent(new Identifier("block/button"))
            .texture("texture", baseBlockId)
        );
        pack.addBlockModel(IdUtils.wrapPath(id, "_pressed"), model -> model
            .parent(new Identifier("block/button_pressed"))
            .texture("texture", baseBlockId)
        );
        pack.addBlockModel(IdUtils.wrapPath(id, "_inventory"), model -> model
            .parent(new Identifier("block/button_inventory"))
            .texture("texture", baseBlockId)
        );
    }

    private static void applyRotation(BlockStateBuilder.Variant variant, Direction facing, WallMountLocation face) {
        int y = dir2Deg.getInt(facing);
        if (face == WallMountLocation.CEILING) y += 2;
        variant.rotationY(y % 4 * 90);
    }
}
