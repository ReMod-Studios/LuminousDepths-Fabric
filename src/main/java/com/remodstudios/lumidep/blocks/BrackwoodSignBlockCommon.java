package com.remodstudios.lumidep.blocks;

import com.remodstudios.lumidep.blocks.entities.BrackwoodSignBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

// this is jank
public final class BrackwoodSignBlockCommon {
    private BrackwoodSignBlockCommon() {
    }

    public static EnumProperty<MarkingType> MARKING = EnumProperty.of("marking", MarkingType.class);

    static ActionResult onSignUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        // TODO
        return ActionResult.PASS;
    }

    static BlockEntity createSignBE(BlockPos pos, BlockState state) {
        return new BrackwoodSignBlockEntity(pos, state);
    }

    static void appendBEProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(MARKING);
    }
}
