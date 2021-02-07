package com.remodstudios.lumidep.blocks;

import com.remodstudios.lumidep.blocks.entities.BrackwoodSignBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class BrackwoodWallSignBlock extends WallSignBlock {
    public BrackwoodWallSignBlock(Settings settings) {
        super(settings, LumidepSignType.BRACKWOOD);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BrackwoodSignBlockEntity(pos, state);
    }
}
