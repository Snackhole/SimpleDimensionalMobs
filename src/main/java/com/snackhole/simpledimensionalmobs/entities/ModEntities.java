package com.snackhole.simpledimensionalmobs.entities;

import com.snackhole.simpledimensionalmobs.SimpleDimensionalMobsMain;
import com.snackhole.simpledimensionalmobs.entities.entityrenders.*;
import net.minecraft.client.renderer.entity.RenderEndermite;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityShulker;
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
        registerMob(EntityMagmaLord.class, "magma_lord", id++, "6a2e0e", "f89e44", 5, Biomes.HELL);
        registerMob(EntityDeepWolf.class, "deep_wolf", id++, "09262c", "0fb600", Biomes.HELL);
        registerMob(EntityDeepBear.class, "deep_bear", id++, "09262c", "0fb600", 5, Biomes.HELL);
        registerMob(EntityStalker.class, "stalker", id++, "37508f", "000000", Biomes.HELL);
        registerMob(EntitySootstrider.class, "sootstrider", id++, "4f4f4f", "000000", Biomes.HELL);
        EntityRegistry.addSpawn(EntityVex.class, 100, 3, 5, EnumCreatureType.MONSTER, Biomes.HELL);
        EntityRegistry.addSpawn(EntityEnderman.class, 50, 4, 4, EnumCreatureType.MONSTER, Biomes.SKY);
        registerMob(EntityEndermiteSpawned.class, "endermite_spawned", id++, "161616", "6E6E6E", 18, Biomes.SKY);
        registerMob(EntityFarSpider.class, "far_spider", id++, "313030", "e905ff", 18, Biomes.SKY);
        registerMob(EntityFarHuntsman.class, "far_huntsman", id++, "313030", "e905ff", 1, Biomes.SKY);
        registerMob(EntityFarHarvestman.class, "far_harvestman", id++, "313030", "e905ff", 1, Biomes.SKY);
        registerMob(EntityVoidOoze.class, "void_ooze", id++, "a26ebf", "7d3ea0", 8, Biomes.SKY);
        registerMob(EntityEldritchAutomaton.class, "eldritch_automaton", id++, "45374d", "003834", 3, Biomes.SKY);
        registerMob(EntityEldritchGoliath.class, "eldritch_goliath", id++, "45374d", "003834", 1, Biomes.SKY);
        EntityRegistry.addSpawn(EntityShulker.class, 3, 3, 5, EnumCreatureType.MONSTER, Biomes.SKY);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntityMagmaLurcher.class, RenderMagmaLurcher::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityMagmaLord.class, RenderMagmaLord::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDeepWolf.class, RenderDeepWolf::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDeepBear.class, RenderDeepBear::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityStalker.class, RenderStalker::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySootstrider.class, RenderSootstrider::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityEndermiteSpawned.class, RenderEndermite::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityFarSpider.class, RenderFarSpider::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityFarHuntsman.class, RenderFarHuntsman::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityFarHarvestman.class, RenderFarHarvestman::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityVoidOoze.class, RenderVoidOoze::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityEldritchAutomaton.class, RenderEldritchAutomaton::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityEldritchGoliath.class, RenderEldritchGoliath::new);
    }

    private static void registerMob(Class<? extends EntityLiving> entityClass, String name, int id, String eggPrimary, String eggSecondary, Biome... biomes) {
        EntityRegistry.registerModEntity(new ResourceLocation(SimpleDimensionalMobsMain.MODID + ":" + name), entityClass, name, id, SimpleDimensionalMobsMain.simpleDimensionalMobsMainInstance, 64, 3, true, Integer.parseInt(eggPrimary, 16), Integer.parseInt(eggSecondary, 16));
        EntityRegistry.addSpawn(entityClass, 100, 3, 5, EnumCreatureType.MONSTER, biomes);
    }

    private static void registerMob(Class<? extends EntityLiving> entityClass, String name, int id, String eggPrimary, String eggSecondary, int weight, Biome... biomes) {
        EntityRegistry.registerModEntity(new ResourceLocation(SimpleDimensionalMobsMain.MODID + ":" + name), entityClass, name, id, SimpleDimensionalMobsMain.simpleDimensionalMobsMainInstance, 64, 3, true, Integer.parseInt(eggPrimary, 16), Integer.parseInt(eggSecondary, 16));
        EntityRegistry.addSpawn(entityClass, weight, 3, 5, EnumCreatureType.MONSTER, biomes);
    }
}
