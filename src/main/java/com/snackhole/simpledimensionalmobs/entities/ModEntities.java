package com.snackhole.simpledimensionalmobs.entities;

import com.snackhole.simpledimensionalmobs.SimpleDimensionalMobsMain;
import com.snackhole.simpledimensionalmobs.entities.entityrenders.*;
import net.minecraft.client.renderer.entity.RenderEndermite;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityVex;
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
        registerMob(EntityDeepWolf.class, "deep_wolf", id++, "09262c", "0fb600", Biomes.HELL);
        registerMob(EntityStalker.class, "stalker", id++, "37508f", "000000", Biomes.HELL);
        registerMob(EntitySootstrider.class, "sootstrider", id++, "4f4f4f", "000000", Biomes.HELL);
        EntityRegistry.addSpawn(EntityVex.class, 100, 3, 5, EnumCreatureType.MONSTER, Biomes.HELL);
        EntityRegistry.addSpawn(EntityEnderman.class, 50, 4, 4, EnumCreatureType.MONSTER, Biomes.SKY);
        registerMob(EntityEndermiteSpawned.class, "endermite_spawned", id++, "161616", "6E6E6E", 20, Biomes.SKY);
        registerMob(EntityFarSpider.class, "far_spider", id++, "313030", "e905ff", 18, 4, 6, Biomes.SKY);
        registerMob(EntityVoidOoze.class, "void_ooze", id++, "a26ebf", "7d3ea0", 7, 1, 2, Biomes.SKY);
        registerMob(EntityEldritchAutomaton.class, "eldritch_automaton", id++, "45374d", "003834", 5, 1, 1, Biomes.SKY);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntityMagmaLurcher.class, RenderMagmaLurcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityDeepWolf.class, RenderDeepWolf.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityStalker.class, RenderStalker.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntitySootstrider.class, RenderSootstrider.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityEndermiteSpawned.class, RenderEndermite::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityFarSpider.class, RenderFarSpider.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityVoidOoze.class, RenderVoidOoze.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityEldritchAutomaton.class, RenderEldritchAutomaton.FACTORY);
    }

    private static void registerMob(Class<? extends EntityLiving> entityClass, String name, int id, String eggPrimary, String eggSecondary, Biome... biomes) {
        EntityRegistry.registerModEntity(new ResourceLocation(SimpleDimensionalMobsMain.MODID + ":" + name), entityClass, name, id, SimpleDimensionalMobsMain.simpleDimensionalMobsMainInstance, 64, 3, true, Integer.parseInt(eggPrimary, 16), Integer.parseInt(eggSecondary, 16));
        EntityRegistry.addSpawn(entityClass, 100, 3, 5, EnumCreatureType.MONSTER, biomes);
    }

    private static void registerMob(Class<? extends EntityLiving> entityClass, String name, int id, String eggPrimary, String eggSecondary, int weight, Biome... biomes) {
        EntityRegistry.registerModEntity(new ResourceLocation(SimpleDimensionalMobsMain.MODID + ":" + name), entityClass, name, id, SimpleDimensionalMobsMain.simpleDimensionalMobsMainInstance, 64, 3, true, Integer.parseInt(eggPrimary, 16), Integer.parseInt(eggSecondary, 16));
        EntityRegistry.addSpawn(entityClass, weight, 3, 5, EnumCreatureType.MONSTER, biomes);
    }

    private static void registerMob(Class<? extends EntityLiving> entityClass, String name, int id, String eggPrimary, String eggSecondary, int weight, int min, int max, Biome... biomes) {
        EntityRegistry.registerModEntity(new ResourceLocation(SimpleDimensionalMobsMain.MODID + ":" + name), entityClass, name, id, SimpleDimensionalMobsMain.simpleDimensionalMobsMainInstance, 64, 3, true, Integer.parseInt(eggPrimary, 16), Integer.parseInt(eggSecondary, 16));
        EntityRegistry.addSpawn(entityClass, weight, min, max, EnumCreatureType.MONSTER, biomes);
    }
}
