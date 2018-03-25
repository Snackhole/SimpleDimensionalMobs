package com.snackhole.simpledimensionalmobs.entities.entityrenders;

import com.snackhole.simpledimensionalmobs.SimpleDimensionalMobsMain;
import com.snackhole.simpledimensionalmobs.entities.EntityMagmaLurcher;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderMagmaLurcher extends RenderLiving<EntityMagmaLurcher> {
    private ResourceLocation mobTexture = new ResourceLocation(SimpleDimensionalMobsMain.MODID + ":textures/entity/magma_lurcher.png");
    public static final Factory FACTORY = new Factory();

    public RenderMagmaLurcher(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelZombie(), (float) 0.5);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMagmaLurcher entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<EntityMagmaLurcher> {
        @Override
        public Render<? super EntityMagmaLurcher> createRenderFor(RenderManager manager) {
            return new RenderMagmaLurcher(manager);
        }
    }
}
