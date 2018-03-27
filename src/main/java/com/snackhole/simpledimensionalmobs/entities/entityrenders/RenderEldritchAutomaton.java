package com.snackhole.simpledimensionalmobs.entities.entityrenders;

import com.snackhole.simpledimensionalmobs.SimpleDimensionalMobsMain;
import com.snackhole.simpledimensionalmobs.entities.EntityEldritchAutomaton;
import com.snackhole.simpledimensionalmobs.entities.entitymodels.ModelEldritchAutomaton;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderEldritchAutomaton extends RenderLiving<EntityEldritchAutomaton> {
    private ResourceLocation mobTexture = new ResourceLocation(SimpleDimensionalMobsMain.MODID + ":textures/entity/eldritch_automaton.png");

    public RenderEldritchAutomaton(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelEldritchAutomaton(), (float) 0.5);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEldritchAutomaton entity) {
        return mobTexture;
    }
}
