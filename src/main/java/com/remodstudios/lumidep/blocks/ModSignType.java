package com.remodstudios.lumidep.blocks;

import com.remodstudios.lumidep.mixin.SignTypeAccessor;
import net.minecraft.util.SignType;

public class ModSignType extends SignType {
    public static final SignType BRACKWOOD = new ModSignType("brackwood");

    static {
        SignTypeAccessor.getValues().add(BRACKWOOD);
    }
    public ModSignType(String name) {
        super(name);
    }
}
