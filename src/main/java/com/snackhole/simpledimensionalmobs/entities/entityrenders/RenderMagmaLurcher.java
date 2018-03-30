package com.snackhole.simpledimensionalmobs.entities.entityrenders;

import com.snackhole.simpledimensionalmobs.SimpleDimensionalMobsMain;
import com.snackhole.simpledimensionalmobs.entities.EntityMagmaLurcher;
import com.snackhole.simpledimensionalmobs.entities.entitymodels.ModelMagmaLurcher;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderMagmaLurcher extends RenderLiving<EntityMagmaLurcher> {
    private ResourceLocation mobTexture = new ResourceLocation(SimpleDimensionalMobsMain.MODID + ":textures/entity/magma_lurcher.png");

    public RenderMagmaLurcher(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelMagmaLurcher(), (float) 0.5);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMagmaLurcher entity) {
        return mobTexture;
    }
}
