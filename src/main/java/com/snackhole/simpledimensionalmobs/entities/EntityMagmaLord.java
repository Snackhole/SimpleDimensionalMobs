package com.snackhole.simpledimensionalmobs.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class EntityMagmaLord extends EntityMagmaLurcher {
    public EntityMagmaLord(World worldIn) {
        super(worldIn);
        setSize((float) 0.9, (float) 2.925);
        experienceValue *= 2;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double) 40);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double) 7);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue((double) 4);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.world.isRemote) {
            for (int i = 0; i < 2; ++i) {
                this.world.spawnParticle(EnumParticleTypes.BARRIER.FLAME, this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, (double) 0, (double) 0, (double) 0);
            }
        }
        int radius = 8;
        List<EntityPlayer> nearbyPlayers = world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(posX - radius, posY - radius, posZ - radius, posX + radius, posY + radius, posZ + radius));
        int duration = (int) this.world.getDifficultyForLocation(new BlockPos(this)).getAdditionalDifficulty();
        if (duration > 0) {
            for (EntityPlayer player : nearbyPlayers) {
                if (!player.isCreative()) {
                    player.setFire(2 * duration);
                }
            }
        }
    }
}
