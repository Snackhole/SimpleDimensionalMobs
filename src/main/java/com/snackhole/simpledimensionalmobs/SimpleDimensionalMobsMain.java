package com.snackhole.simpledimensionalmobs;

import com.snackhole.simpledimensionalmobs.proxy.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    public SimpleDimensionalMobsMain() {
        simpleDimensionalMobsMainInstance = this;
    }
}
