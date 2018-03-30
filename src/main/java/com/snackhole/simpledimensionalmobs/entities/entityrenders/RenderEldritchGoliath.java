package com.snackhole.simpledimensionalmobs.entities.entityrenders;

import com.snackhole.simpledimensionalmobs.entities.EntityEldritchAutomaton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderEldritchGoliath extends RenderEldritchAutomaton {
    public RenderEldritchGoliath(RenderManager rendermanagerIn) {
        super(rendermanagerIn);
        shadowSize *= 2;
    }

    @Override
    protected void preRenderCallback(EntityEldritchAutomaton entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale((float) 2, (float) 2, (float) 2);
    }
}
