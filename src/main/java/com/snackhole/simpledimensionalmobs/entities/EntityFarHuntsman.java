package com.snackhole.simpledimensionalmobs.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityFarHuntsman extends EntityFarSpider {
    public EntityFarHuntsman(World worldIn) {
        super(worldIn);
        setSize((float) 1.8, (float) 2.55);
        experienceValue *= 5;
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            if (entityIn instanceof  EntityEndermiteSpawned) {
                return true;
            }
            if (entityIn instanceof EntityLivingBase) {
                EntityLivingBase entityLivingIn = (EntityLivingBase) entityIn;
                int i = 0;
                if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
                    i = 6;
                } else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
                    i = 10;
                }
                PotionEffect weaknessEffect = new PotionEffect(MobEffects.WEAKNESS, i * 20);
                PotionEffect miningFatigueEffect = new PotionEffect(MobEffects.MINING_FATIGUE, i * 20, 1);
                if (i > 0 && !entityLivingIn.isPotionActive(weaknessEffect.getPotion())) {
                    entityLivingIn.addPotionEffect(weaknessEffect);
                }
                if (i > 0 && !entityLivingIn.isPotionActive(miningFatigueEffect.getPotion())) {
                    entityLivingIn.addPotionEffect(miningFatigueEffect);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double) 40);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double) 8);
    }
}
