package com.remodstudios.lumidep.blocks;

import com.remodstudios.yarnandneedles.blocks.SignTypeRegistry;
import net.minecraft.util.SignType;

public class LumidepSignType extends SignType {
    public static final LumidepSignType BRACKWOOD = new LumidepSignType("brackwood");

    static {
        SignTypeRegistry.register(BRACKWOOD);
    }

    protected LumidepSignType(String name) {
        super(name);
    }
}
