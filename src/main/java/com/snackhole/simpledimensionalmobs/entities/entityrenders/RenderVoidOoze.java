package com.snackhole.simpledimensionalmobs.entities.entityrenders;

import com.snackhole.simpledimensionalmobs.SimpleDimensionalMobsMain;
import com.snackhole.simpledimensionalmobs.entities.EntityVoidOoze;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderVoidOoze extends RenderSlime {
    private ResourceLocation mobTexture = new ResourceLocation(SimpleDimensionalMobsMain.MODID + ":textures/entity/void_ooze.png");
    public static final Factory FACTORY = new Factory();

    public RenderVoidOoze(RenderManager manager) {
        super(manager);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySlime entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<EntityVoidOoze> {
        @Override
        public Render<? super EntityVoidOoze> createRenderFor(RenderManager manager) {
            return new RenderVoidOoze(manager);
        }
    }
}
