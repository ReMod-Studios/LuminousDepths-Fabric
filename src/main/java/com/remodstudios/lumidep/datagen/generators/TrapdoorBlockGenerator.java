package com.remodstudios.lumidep.datagen.generators;

import com.google.gson.JsonObject;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import com.swordglowsblue.artifice.api.builder.assets.BlockStateBuilder;
import com.swordglowsblue.artifice.api.util.IdUtils;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import org.lwjgl.system.CallbackI;

public class TrapdoorBlockGenerator extends SimpleBlockGenerator {

    private static final String[] VARIANT_SUFFIXES = {"_bottom", "_top", "_open"};

    @Override
    protected void generateBlockStates(ArtificeResourcePack.ClientResourcePackBuilder rrp, Identifier id) {
        Identifier blockPath = IdUtils.wrapPath("block/", id);

        // @formatter:off
        rrp.addBlockState(id, state -> {
            for (Direction direction : TrapdoorBlock.FACING.getValues())
            for (BlockHalf half : TrapdoorBlock.HALF.getValues())
            for (boolean open : TrapdoorBlock.OPEN.getValues()) {
                String varStr = String.format(
                        "facing=%s,half=%s,open=%s",
                        direction.asString(), half.asString(), open);

                state.variant(varStr, var -> {
                    StringBuilder modelStr = new StringBuilder(blockPath.toString());
                    modelStr.append('_');
                    if (open) modelStr.append("open");
                    else modelStr.append(half.asString());
                    var.model(new Identifier(modelStr.toString()));
                    applyRotation(var, direction, half, open);
                });
            }
        });
        // @formatter:on
    }

    @Override
    protected void generateModels(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        Identifier blockPath = IdUtils.wrapPath("block/", id);

        for (String suffix : VARIANT_SUFFIXES) {
            pack.addBlockModel(IdUtils.wrapPath(id, suffix), model -> model
                .parent(new Identifier("block/template_orientable_trapdoor" + suffix))
                .texture("texture", blockPath)
            );
        }
    }

    private static void applyRotation(BlockStateBuilder.Variant variant, Direction direction, BlockHalf half, boolean open) {
        int y = direction.getHorizontal();
        if (open && half == BlockHalf.TOP)
            variant.rotationX(180); // O Mojang, why?????? - leocth
        else y += 2;
        variant.rotationY(y % 4 * 90);
    }
}