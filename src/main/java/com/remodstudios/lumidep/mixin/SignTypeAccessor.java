package com.remodstudios.lumidep.mixin;

import net.minecraft.util.SignType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(SignType.class)
public interface SignTypeAccessor {
    @Accessor("VALUES")
    static Set<SignType> getValues() { throw new AssertionError(); }
}
