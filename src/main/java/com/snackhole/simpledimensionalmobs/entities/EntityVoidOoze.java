package com.snackhole.simpledimensionalmobs.entities;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.List;

public class EntityVoidOoze extends EntitySlime {
    public EntityVoidOoze(World worldIn) {
        super(worldIn);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.world.isRemote) {
            for (int i = 0; i < 2; ++i) {
                this.world.spawnParticle(EnumParticleTypes.PORTAL, this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
            }
        } else {
            int radius = 16;
            List<EntityPlayer> nearbyPlayers = world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(posX - radius, posY - radius, posZ - radius, posX + radius, posY + radius, posZ + radius));
            int duration = 0;
            if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
                duration = 7;
            } else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
                duration = 15;
            }
            if (duration > 0) {
                PotionEffect slowness = new PotionEffect(MobEffects.SLOWNESS, duration * 20, 4);
                PotionEffect hunger = new PotionEffect(MobEffects.HUNGER, duration * 20, 15);
                PotionEffect poison = new PotionEffect(MobEffects.POISON, duration * 20, 0);
                Potion slownessPotion = slowness.getPotion();
                Potion hungerPotion = hunger.getPotion();
                Potion poisonPotion = poison.getPotion();
                for (EntityPlayer player : nearbyPlayers) {
                    if (!player.isCreative()) {
                        if (!player.isPotionActive(slownessPotion)) {
                            player.addPotionEffect(slowness);
                        }
                        if (!player.isPotionActive(hungerPotion)) {
                            player.addPotionEffect(hunger);
                        }
                        if (!player.isPotionActive(poisonPotion)) {
                            player.addPotionEffect(poison);
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.getDifficulty() != EnumDifficulty.PEACEFUL;
    }

    @Override
    protected EntitySlime createInstance() {
        return new EntityVoidOoze(world);
    }

    @Override
    protected boolean canDamagePlayer() {
        return true;
    }
}
