package com.snackhole.simpledimensionalmobs.entities.entityrenders;

import com.snackhole.simpledimensionalmobs.SimpleDimensionalMobsMain;
import com.snackhole.simpledimensionalmobs.entities.EntityFarSpider;
import com.snackhole.simpledimensionalmobs.entities.entitymodels.ModelFarSpider;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderFarSpider extends RenderLiving<EntityFarSpider> {
    private ResourceLocation mobTexture = new ResourceLocation(SimpleDimensionalMobsMain.MODID + ":textures/entity/far_spider.png");
    public static final Factory FACTORY = new Factory();

    public RenderFarSpider(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelFarSpider(), (float) 1);
    }

    @Override
    protected void preRenderCallback(EntityFarSpider entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale((float) 2, (float) 2, (float) 2);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityFarSpider entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<EntityFarSpider> {

        @Override
        public Render<? super EntityFarSpider> createRenderFor(RenderManager manager) {
            return new RenderFarSpider(manager);
        }
    }

    @Override
    protected float handleRotationFloat(EntityFarSpider livingBase, float partialTicks) {
        return (float) 1.5393804;
    }
}
