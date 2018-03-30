package com.snackhole.simpledimensionalmobs.entities;

import com.snackhole.simpledimensionalmobs.entities.entityai.EntityAIMagmaLurcherAttack;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class EntityMagmaLurcher extends EntityMob {
    private static final DataParameter<Boolean> ARMS_RAISED = EntityDataManager.createKey(EntityMagmaLurcher.class, DataSerializers.BOOLEAN);

    public EntityMagmaLurcher(World worldIn) {
        super(worldIn);
        setSize((float) 0.6, (float) 1.95);
        setPathPriority(PathNodeType.LAVA, (float) 8);
        setPathPriority(PathNodeType.DANGER_FIRE, (float) 0);
        setPathPriority(PathNodeType.DAMAGE_FIRE, (float) 0);
        isImmuneToFire = true;
        experienceValue = 10;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue((double) 35);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.13);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double) 5);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue((double) 2);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(ARMS_RAISED, false);
    }

    public void setArmsRaised(boolean armsRaised) {
        this.getDataManager().set(ARMS_RAISED, armsRaised);
    }

    @SideOnly(Side.CLIENT)
    public boolean isArmsRaised() {
        return this.getDataManager().get(ARMS_RAISED);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIMagmaLurcherAttack(this, (double) 1, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, (double) 1));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, (double) 1));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, (float) 8));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.applyEntityAI();
    }

    private void applyEntityAI() {
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, (double) 1, false));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[]{EntityPigZombie.class}));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<>(this, EntityVillager.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<>(this, EntityIronGolem.class, true));
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = super.attackEntityAsMob(entityIn);
        if (flag) {
            int duration = (int) this.world.getDifficultyForLocation(new BlockPos(this)).getAdditionalDifficulty();
            if (this.getHeldItemMainhand().isEmpty()) {
                entityIn.setFire(2 * duration);
            }
        }
        return flag;
    }

    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_MAGMA_CUBE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_ZOMBIE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLOCK_LAVA_AMBIENT;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ENTITY_ZOMBIE_STEP;
    }

    protected void playStepSound(BlockPos pos, Block blockIn) {
        playSound(getStepSound(), (float) 0.15, (float) 1);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL;
    }
}
