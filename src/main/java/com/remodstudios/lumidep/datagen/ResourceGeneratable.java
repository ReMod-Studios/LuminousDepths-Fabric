package com.remodstudios.lumidep.datagen;

import com.remodstudios.lumidep.LuminousDepths;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.minecraft.util.Identifier;

public interface ResourceGeneratable {
    void genResources(RuntimeResourcePack rrp, String id);

    default String prefixedPath(String ns, String prefix, String path) {
        return ns + ":" + prefix + "/" + path;
    }

    default String prefixedPath(String prefix, String path) {
        return prefixedPath(LuminousDepths.MOD_ID, prefix, path);
    }

    default Identifier prefixedId(String ns, String prefix, String path) {
        return new Identifier(ns, prefix + "/" + path);
    }

    default Identifier prefixedId(String prefix, String path) {
        return LuminousDepths.id(prefix + "/" + path);
    }

    default String lumidep(String path) {
        return LuminousDepths.MOD_ID + ":" + path;
    }


}
