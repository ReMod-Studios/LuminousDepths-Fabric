package com.remodstudios.lumidep.datagen;

import com.remodstudios.lumidep.datagen.generators.*;

public final class ResourceGenerators {

    public static final ResourceGenerator SIMPLE_BLOCK = new SimpleBlockGenerator();
    public static final ResourceGenerator SIMPLE_ITEM = new SimpleItemGenerator();
    public static final ResourceGenerator BLOCK_ITEM = new BlockItemGenerator();
    public static final ResourceGenerator LOG_BLOCK = new LogBlockGenerator();
    public static final ResourceGenerator WOOD_BLOCK = new WoodBlockGenerator();
    public static final ResourceGenerator DOOR_BLOCK = new DoorBlockGenerator();
    public static final ResourceGenerator TRAPDOOR_BLOCK = new TrapdoorBlockGenerator();

    private ResourceGenerators() {}
}
