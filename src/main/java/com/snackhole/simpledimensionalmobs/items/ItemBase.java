package com.snackhole.simpledimensionalmobs.items;

import com.snackhole.simpledimensionalmobs.SimpleDimensionalMobsMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class ItemBase extends Item {
    protected String name;
    private String oreName;

    public ItemBase(String name, String oreName) {
        this.name = name;
        this.oreName = oreName;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registerItemModel() {
        SimpleDimensionalMobsMain.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    public void initOreDict() {
        OreDictionary.registerOre(oreName, this);
    }
}
