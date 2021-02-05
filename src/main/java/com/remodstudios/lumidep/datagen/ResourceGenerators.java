package com.remodstudios.lumidep.datagen;

import com.remodstudios.lumidep.datagen.generators.*;

public final class ResourceGenerators {

    public static final ResourceGenerator SIMPLE_BLOCK = new SimpleBlockGenerator();
    public static final ResourceGenerator SIMPLE_ITEM = new SimpleItemGenerator();
    public static final ResourceGenerator BLOCK_ITEM = new BlockItemGenerator();

    private ResourceGenerators() {}
}
