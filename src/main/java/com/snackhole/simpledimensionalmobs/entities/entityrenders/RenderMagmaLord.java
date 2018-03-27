package com.snackhole.simpledimensionalmobs.entities.entityrenders;

import com.snackhole.simpledimensionalmobs.entities.EntityMagmaLurcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderMagmaLord extends  RenderMagmaLurcher {
    public RenderMagmaLord(RenderManager renderManagerIn) {
        super(renderManagerIn);
        shadowSize *= 1.5;
    }

    @Override
    protected void preRenderCallback(EntityMagmaLurcher entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale((float) 1.5, (float) 1.5, (float) 1.5);
    }
}
