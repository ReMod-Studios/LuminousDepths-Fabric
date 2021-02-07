package com.remodstudios.lumidep.util;

import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.blocks.MarkingType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.SignType;

public final class SpriteIdentifierUtil {
    private SpriteIdentifierUtil() {}

    public static SpriteIdentifier makeSignTexture(SignType type) {
        return new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, LuminousDepths.id("entity/signs/" + type.getName()));
    }

    public static SpriteIdentifier makeMarkingTexture(MarkingType type) {
        return new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, LuminousDepths.id("entity/signs/marking/" + type.asString()));
    }
}
