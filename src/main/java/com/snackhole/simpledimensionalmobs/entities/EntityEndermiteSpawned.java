package com.snackhole.simpledimensionalmobs.entities;

import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class EntityEndermiteSpawned extends EntityEndermite {
    public EntityEndermiteSpawned(World worldIn) {
        super(worldIn);
        if (rand.nextInt(40) == 0) {
            setSpawnedByPlayer(true);
        }
    }

    @Override
    public void onLivingUpdate() {
        ReflectionHelper.setPrivateValue(EntityEndermite.class, this, (int) 0, "lifetime");
        super.onLivingUpdate();
    }
}
