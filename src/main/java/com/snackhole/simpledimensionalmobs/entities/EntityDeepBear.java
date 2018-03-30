package com.snackhole.simpledimensionalmobs.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityDeepBear extends EntityDeepWolf {
    public EntityDeepBear(World worldIn) {
        super(worldIn);
        setSize((float) 2.7, (float) 1.65);
        experienceValue *= 5;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double) 40);
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double) 7);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            if (entityIn instanceof EntityLivingBase) {
                int i = 0;
                if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
                    i = 7;
                } else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
                    i = 15;
                }
                if (i > 0) {
                    ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, i * 20, 0));
                    ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, i * 20, 0));
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
