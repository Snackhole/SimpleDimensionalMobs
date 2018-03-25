package com.snackhole.simpledimensionalmobs.entities.entityai;

import com.snackhole.simpledimensionalmobs.entities.EntityMagmaLurcher;
import net.minecraft.entity.ai.EntityAIAttackMelee;

public class EntityAIMagmaLurcherAttack extends EntityAIAttackMelee {
    private int raiseArmTicks;
    private EntityMagmaLurcher magmaLurcher;

    public EntityAIMagmaLurcherAttack(EntityMagmaLurcher magmaLurcherIn, double speedIn, boolean longMemoryIn) {
        super(magmaLurcherIn, speedIn, longMemoryIn);
        magmaLurcher = magmaLurcherIn;
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
        raiseArmTicks = 0;
    }

    @Override
    public void resetTask() {
        super.resetTask();
        magmaLurcher.setArmsRaised(false);
    }

    @Override
    public void updateTask() {
        super.updateTask();
        ++raiseArmTicks;
        if (raiseArmTicks >= 5 && attackTick < 10) {
            magmaLurcher.setArmsRaised(true);
        } else {
            magmaLurcher.setArmsRaised(false);
        }
    }
}
