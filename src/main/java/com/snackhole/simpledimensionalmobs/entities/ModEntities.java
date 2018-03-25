package com.snackhole.simpledimensionalmobs.entities;

import com.snackhole.simpledimensionalmobs.SimpleDimensionalMobsMain;
import com.snackhole.simpledimensionalmobs.entities.entityrenders.RenderMagmaLurcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEntities {
    public static void init() {
        int id = 1;
        registerMob(EntityMagmaLurcher.class, "magma_lurcher", id++, "6a2e0e", "f89e44", Biomes.HELL);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntityMagmaLurcher.class, RenderMagmaLurcher.FACTORY);
    }

    private static void registerMob(Class<? extends EntityLiving> entityClass, String name, int id, String eggPrimary, String eggSecondary, Biome... biomes) {
        EntityRegistry.registerModEntity(new ResourceLocation(SimpleDimensionalMobsMain.MODID + ":" + name), entityClass, name, id, SimpleDimensionalMobsMain.simpleDimensionalMobsMainInstance, 64, 3, true, Integer.parseInt(eggPrimary, 16), Integer.parseInt(eggSecondary, 16));
        EntityRegistry.addSpawn(entityClass, 100, 3, 5, EnumCreatureType.MONSTER, biomes);
    }
}
