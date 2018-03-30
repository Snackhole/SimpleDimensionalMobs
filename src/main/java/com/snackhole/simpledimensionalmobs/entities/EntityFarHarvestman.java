package com.snackhole.simpledimensionalmobs.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityFarHarvestman extends EntityFarSpider {
    public EntityFarHarvestman(World worldIn) {
        super(worldIn);
        setSize((float) 0.15, (float) 0.2125);
        experienceValue = 1;
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        return true;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double) 2);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double) 1);
    }
}
