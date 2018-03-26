package com.snackhole.simpledimensionalmobs.entities.entityrenders;

import com.snackhole.simpledimensionalmobs.SimpleDimensionalMobsMain;
import com.snackhole.simpledimensionalmobs.entities.EntityEldritchAutomaton;
import com.snackhole.simpledimensionalmobs.entities.entitymodels.ModelEldritchAutomaton;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderEldritchAutomaton extends RenderLiving<EntityEldritchAutomaton> {
    private ResourceLocation mobTexture = new ResourceLocation(SimpleDimensionalMobsMain.MODID + ":textures/entity/eldritch_automaton.png");
    public static final Factory FACTORY = new Factory();

    public RenderEldritchAutomaton(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelEldritchAutomaton(), (float) 0.5);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEldritchAutomaton entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<EntityEldritchAutomaton> {

        @Override
        public Render<? super EntityEldritchAutomaton> createRenderFor(RenderManager manager) {
            return new RenderEldritchAutomaton(manager);
        }
    }
}
