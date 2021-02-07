package com.remodstudios.lumidep.blocks;

import com.remodstudios.lumidep.blocks.entities.BrackwoodSignBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.SignBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SignType;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BrackwoodSignBlock extends SignBlock implements BrackwoodSignBlockCommon {
    public BrackwoodSignBlock(Settings settings) {
        super(settings, LumidepSignType.BRACKWOOD);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return BrackwoodSignBlockCommon.super.onSignUse(state, world, pos, player, hand, hit);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BrackwoodSignBlockEntity(pos, state);
    }
}
