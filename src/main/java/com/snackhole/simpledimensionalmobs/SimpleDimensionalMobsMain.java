package com.snackhole.simpledimensionalmobs;

import com.snackhole.simpledimensionalmobs.entities.ModEntities;
import com.snackhole.simpledimensionalmobs.items.ModItems;
import com.snackhole.simpledimensionalmobs.proxy.IProxy;
import com.snackhole.simpledimensionalmobs.recipe.ModRecipes;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = SimpleDimensionalMobsMain.MODID, version = SimpleDimensionalMobsMain.VERSION)
public class SimpleDimensionalMobsMain {
    public static final String MODID = "simpledimensionalmobs";
    public static final String VERSION = "1";
    @SidedProxy(clientSide = "com.snackhole.simpledimensionalmobs.proxy.ClientProxy", serverSide = "com.snackhole.simpledimensionalmobs.proxy.ServerProxy")
    public static IProxy proxy;
    @Mod.Instance
    public static SimpleDimensionalMobsMain simpleDimensionalMobsMainInstance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModEntities.init();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModRecipes.init();
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    public SimpleDimensionalMobsMain() {
        simpleDimensionalMobsMainInstance = this;
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            ModItems.registerModels();
        }
    }
}
