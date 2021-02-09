package com.remodstudios.lumidep.blocks;

import com.remodstudios.yarnandneedles.blocks.SignTypeRegistry;
import net.minecraft.util.SignType;

public class LumiDepSignType extends SignType {
    public static final LumiDepSignType BRACKWOOD = new LumiDepSignType("brackwood");

    static {
        SignTypeRegistry.register(BRACKWOOD);
    }

    protected LumiDepSignType(String name) {
        super(name);
    }
}
