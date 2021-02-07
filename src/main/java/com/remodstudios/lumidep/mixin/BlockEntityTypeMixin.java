package com.remodstudios.lumidep.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.SignBlock;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin {

    @Inject(method = "supports", at = @At(
        value = "INVOKE",
        target = "Ljava/util/Set;contains(Ljava/lang/Object;)Z"
    ), cancellable = true)
    private void supports(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        //noinspection EqualsBetweenInconvertibleTypes
        if (BlockEntityType.SIGN.equals(this) && state.getBlock() instanceof SignBlock) {
            cir.setReturnValue(true);
        }
    }
}
