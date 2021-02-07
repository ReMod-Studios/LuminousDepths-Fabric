package com.remodstudios.lumidep.datagen.generators.block;

import com.remodstudios.lumidep.blocks.BlockRegistry;
import com.swordglowsblue.artifice.api.util.IdUtils;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;

/**
 * Generator that contains a reference to a base block.
 * Used for slabs, stairs, fences, walls, ...
 */
public abstract class AbstractParentedBlockGenerator extends SimpleBlockGenerator {

    @NotNull protected final Identifier baseBlockId;

    public AbstractParentedBlockGenerator(Identifier baseBlockId) {
        this.baseBlockId = IdUtils.wrapPath("block/", baseBlockId);
    }

    public AbstractParentedBlockGenerator(Block baseBlock) {
        this(BlockRegistry.BLOCKS
                .entrySet().stream()
                .filter(entry -> Objects.equals(baseBlock, entry.getValue().getLeft()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(new Identifier("air")));
    }

}
