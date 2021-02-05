package com.remodstudios.lumidep.datagen;

import com.remodstudios.lumidep.blocks.BlockRegistry;
import com.remodstudios.lumidep.items.ItemRegistry;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RRPPreGenEntrypoint;
import net.devtech.arrp.api.RuntimeResourcePack;

public class LumiDepPreGenEntryPoint implements RRPPreGenEntrypoint {
    @Override
    public void pregen() {
        RuntimeResourcePack rrp = RuntimeResourcePack.create("lumidep:rrp");
        ItemRegistry.genResources(rrp);
        BlockRegistry.genResources(rrp);
        rrp.dump();
        RRPCallback.EVENT.register(resources -> resources.add(rrp));
    }
}
