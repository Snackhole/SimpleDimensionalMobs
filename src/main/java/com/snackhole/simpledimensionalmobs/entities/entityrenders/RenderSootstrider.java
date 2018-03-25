package com.snackhole.simpledimensionalmobs.entities.entityrenders;

import com.snackhole.simpledimensionalmobs.SimpleDimensionalMobsMain;
import com.snackhole.simpledimensionalmobs.entities.EntitySootstrider;
import net.minecraft.client.model.ModelSilverfish;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderSootstrider extends RenderLiving<EntitySootstrider> {
    private ResourceLocation mobTexture = new ResourceLocation(SimpleDimensionalMobsMain.MODID + ":textures/entity/sootstrider.png");
    public static final Factory FACTORY = new Factory();

    public RenderSootstrider(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSilverfish(), (float) 0.3);
    }

    @Override
    protected float getDeathMaxRotation(EntitySootstrider entityLivingBaseIn) {
        return (float) 180;
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySootstrider entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<EntitySootstrider> {
        @Override
        public Render<? super EntitySootstrider> createRenderFor(RenderManager manager) {
            return new RenderSootstrider(manager);
        }
    }
}