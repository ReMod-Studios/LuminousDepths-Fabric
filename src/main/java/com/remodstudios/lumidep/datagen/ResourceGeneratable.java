package com.remodstudios.lumidep.datagen;

import net.devtech.arrp.api.RuntimeResourcePack;

public interface ResourceGeneratable {
    void genResources(RuntimeResourcePack rrp, String id);
}
