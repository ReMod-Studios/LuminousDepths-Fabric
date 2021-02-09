package com.remodstudios.lumidep.blocks.entities;

import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.blocks.LumiDepBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;

// just here to use the ber
public class BrackwoodSignBlockEntity extends BlockEntity {

    public static final BlockEntityType<BrackwoodSignBlockEntity> TYPE;

    public BrackwoodSignBlockEntity(BlockPos pos, BlockState state) {
        super(TYPE, pos, state);
    }

    static {
        TYPE = Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                LuminousDepths.id("brackwood_sign"),
                FabricBlockEntityTypeBuilder.create(
                    BrackwoodSignBlockEntity::new,
                    LumiDepBlocks.INSTANCE.BRACKWOOD_SIGN,
                    LumiDepBlocks.INSTANCE.BRACKWOOD_WALL_SIGN
                )
                .build());
    }
}
