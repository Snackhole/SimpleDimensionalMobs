package com.snackhole.simpledimensionalmobs.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
    public static ItemBase oozeBall = new ItemBase("oozeball", "slimeball").setCreativeTab(CreativeTabs.MATERIALS);

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(oozeBall);
    }

    public static void registerModels() {
        oozeBall.registerItemModel();
    }
}
