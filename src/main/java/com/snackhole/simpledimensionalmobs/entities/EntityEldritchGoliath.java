package com.snackhole.simpledimensionalmobs.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityEldritchGoliath extends EntityEldritchAutomaton {
    public EntityEldritchGoliath(World worldIn) {
        super(worldIn);
        setSize((float) 2.8, (float) 5.4);
        experienceValue *= 10;
        ignoreFrustumCheck = true;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double) 400);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue((double) 8);
    }
}
