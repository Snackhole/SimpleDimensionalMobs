package com.snackhole.simpledimensionalmobs.entities.entityrenders;

import com.snackhole.simpledimensionalmobs.entities.EntityFarSpider;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderFarHuntsman extends RenderFarSpider {
    public RenderFarHuntsman(RenderManager rendermanagerIn) {
        super(rendermanagerIn);
        shadowSize *= 1.5;
    }

    @Override
    protected void preRenderCallback(EntityFarSpider entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale((float) 3, (float) 3, (float) 3);
    }
}
