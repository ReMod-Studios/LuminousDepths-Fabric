package com.remodstudios.lumidep.blocks;

import net.minecraft.util.StringIdentifiable;

public enum MarkingType implements StringIdentifiable {
    TEST("test"),
    TEST2("test2");

    private final String name;

    MarkingType(String name) {
        this.name = name;
    }

    @Override
    public String asString() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
