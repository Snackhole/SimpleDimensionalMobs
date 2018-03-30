package com.snackhole.simpledimensionalmobs.entities.entityrenders;

import com.snackhole.simpledimensionalmobs.entities.EntityDeepWolf;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderDeepBear extends RenderDeepWolf {
    public RenderDeepBear(RenderManager rendermanagerIn) {
        super(rendermanagerIn);
        shadowSize *= 1.5;
    }

    @Override
    protected void preRenderCallback(EntityDeepWolf entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale((float) 1.95, (float) 1.95, (float) 1.95);
    }
}
