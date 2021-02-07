package com.remodstudios.lumidep.blocks.entities;

import com.remodstudios.lumidep.blocks.BlockRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

// just here to use the ber
public class BrackwoodSignBlockEntity extends BlockEntity {

    public static final BlockEntityType<BrackwoodSignBlockEntity> TYPE;

    public BrackwoodSignBlockEntity(BlockPos pos, BlockState state) {
        super(TYPE, pos, state);
    }

    static {
        TYPE = FabricBlockEntityTypeBuilder.create(BrackwoodSignBlockEntity::new, BlockRegistry.BRACKWOOD_SIGN).build();
    }
}
