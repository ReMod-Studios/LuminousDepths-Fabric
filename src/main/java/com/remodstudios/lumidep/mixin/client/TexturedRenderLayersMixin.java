package com.remodstudios.lumidep.mixin.client;

import com.remodstudios.lumidep.LuminousDepths;
import com.remodstudios.lumidep.blocks.LumidepSignType;
import com.remodstudios.lumidep.blocks.MarkingType;
import com.remodstudios.lumidep.util.SpriteIdentifierUtil;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(TexturedRenderLayers.class)
public class TexturedRenderLayersMixin {

    @Inject(method = "addDefaultTextures", at = @At("TAIL"))
    private static void addDefaultTextures(Consumer<SpriteIdentifier> adder, CallbackInfo ci) {
        adder.accept(SpriteIdentifierUtil.makeSignTexture(LumidepSignType.BRACKWOOD));
        adder.accept(SpriteIdentifierUtil.makeMarkingTexture(MarkingType.TEST));
    }


}
