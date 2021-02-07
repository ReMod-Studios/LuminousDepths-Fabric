package com.remodstudios.lumidep.datagen.generators.block;

import com.google.gson.JsonObject;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import com.swordglowsblue.artifice.api.util.IdUtils;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class DoorBlockGenerator extends SimpleBlockGenerator {
    @Override
    protected void generateBlockStates(ArtificeResourcePack.ClientResourcePackBuilder rrp, Identifier id) {
        Identifier blockPath = IdUtils.wrapPath("block/", id);

        // @formatter:off
        rrp.addBlockState(id, state -> {
            for (Direction direction : DoorBlock.FACING.getValues())
            for (DoorHinge hinge : DoorBlock.HINGE.getValues())
            for (DoubleBlockHalf half : DoorBlock.HALF.getValues())
            for (boolean open : DoorBlock.OPEN.getValues()) {
                String varStr = String.format(
                        "facing=%s,half=%s,hinge=%s,open=%s",
                        direction.asString(), half.asString(), hinge, open);

                state.variant(varStr, var -> var
                    .model(new Identifier(getModelString(blockPath, half, hinge, open)))
                    .rotationY(getStateYRotation(direction, hinge, open)));
            }
        });
        // @formatter:on
    }

    @Override
    protected void generateModels(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
        String blockPath = id.toString();
        Identifier topTexId = IdUtils.wrapPath("block/", id, "_top");
        Identifier bottomTexId = IdUtils.wrapPath("block/", id, "_bottom");

        // @formatter:off
        for (DoubleBlockHalf half : DoorBlock.HALF.getValues()) {
            StringBuilder modelSb = new StringBuilder(blockPath);
            StringBuilder parentSb = new StringBuilder("minecraft:block/door_");
            modelSb.append('_');
            String halfString = half == DoubleBlockHalf.UPPER ? "top" : "bottom";
            modelSb.append(halfString); parentSb.append(halfString);
            pack.addBlockModel(new Identifier(modelSb.toString()), model -> model
                .parent(new Identifier(parentSb.toString()))
                .texture("top", topTexId)
                .texture("bottom", bottomTexId)
            );

            modelSb.append("_hinge"); parentSb.append("_rh");
            pack.addBlockModel(new Identifier(modelSb.toString()), model -> model
                .parent(new Identifier(parentSb.toString()))
                .texture("top", topTexId)
                .texture("bottom", bottomTexId)
            );
        }
        // @formatter:on
    }

    @Override
    protected void generateLootTable(ArtificeResourcePack.ServerResourcePackBuilder pack, Identifier id) {
        JsonObject propertyObject = new JsonObject();
        propertyObject.addProperty("half", "lower");

        pack.addLootTable(IdUtils.wrapPath("blocks/", id), loot -> loot
            .pool(pool -> pool
                .rolls(1)
                .bonusRolls(0f)
                .entry(entry -> entry
                    .type(new Identifier("item"))
                    .name(id)
                    .condition(new Identifier("block_state_property"), cond -> cond
                        .add("block", id.toString())
                        .add("properties", propertyObject)
                    )
                )
                .condition(new Identifier("survives_explosion"), cond -> {})
            )
        );
    }

    //region Helper methods
    private static String getModelString(Identifier blockPath, DoubleBlockHalf half, DoorHinge hinge, boolean open) {
        StringBuilder modelStr = new StringBuilder(blockPath.toString());
        modelStr.append(half == DoubleBlockHalf.UPPER ? "_top" : "_bottom");
        // clever boolean tricks here
        //        left | right
        //   open  Y      N
        // closed  N      Y
        boolean isHingeLeft = hinge == DoorHinge.LEFT;
        if (isHingeLeft == open) modelStr.append("_hinge");
        return modelStr.toString();
    }

    private static int getStateYRotation(Direction direction, DoorHinge hinge, boolean open) {
        int deg = direction.getHorizontal() + 1;
        if (open) {
            if (hinge == DoorHinge.LEFT) deg += 1;
            else deg -= 1;
        }
        return deg % 4 * 90;
    }
    //endregion
}
