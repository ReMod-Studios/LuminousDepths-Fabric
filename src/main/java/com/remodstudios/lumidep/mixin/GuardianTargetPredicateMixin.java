package com.remodstudios.lumidep.mixin;

import com.remodstudios.lumidep.entities.GorgeBeastEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.GuardianEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net/minecraft/entity/mob/GuardianEntity$GuardianTargetPredicate")
public class GuardianTargetPredicateMixin {
    @Shadow
    @Final
    private GuardianEntity owner;

    @Inject(at = @At("HEAD"),
            method = "test(Lnet/minecraft/entity/LivingEntity;)Z",
            cancellable = true
    )
    private void testForGorgeBeast(@Nullable LivingEntity livingEntity, CallbackInfoReturnable<Boolean> ci) {
        if (livingEntity instanceof GorgeBeastEntity && livingEntity.squaredDistanceTo(this.owner) > 9.0D) {
            ci.setReturnValue(true);
        }
    }
}
