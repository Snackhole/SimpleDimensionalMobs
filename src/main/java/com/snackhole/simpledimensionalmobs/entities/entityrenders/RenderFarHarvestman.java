package com.snackhole.simpledimensionalmobs.entities.entityrenders;

import com.snackhole.simpledimensionalmobs.entities.EntityFarSpider;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderFarHarvestman extends RenderFarSpider {
    public RenderFarHarvestman(RenderManager rendermanagerIn) {
        super(rendermanagerIn);
        shadowSize *= 0.25;
    }

    @Override
    protected void preRenderCallback(EntityFarSpider entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale((float) 0.25, (float) 0.25, (float) 0.25);
    }
}
