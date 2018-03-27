package com.snackhole.simpledimensionalmobs.entities.entityrenders;

import com.snackhole.simpledimensionalmobs.SimpleDimensionalMobsMain;
import com.snackhole.simpledimensionalmobs.entities.EntityDeepWolf;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderDeepWolf extends RenderLiving<EntityDeepWolf> {
    private ResourceLocation mobTexture = new ResourceLocation(SimpleDimensionalMobsMain.MODID + ":textures/entity/deep_wolf.png");

    public RenderDeepWolf(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSpider(), (float) 1.3);
    }

    @Override
    protected float getDeathMaxRotation(EntityDeepWolf entityLivingBaseIn) {
        return (float) 180;
    }

    @Override
    protected void preRenderCallback(EntityDeepWolf entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale((float) 1.3, (float) 1.3, (float) 1.3);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDeepWolf entity) {
        return mobTexture;
    }
}
