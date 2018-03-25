package com.snackhole.simpledimensionalmobs.entities;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.world.World;

public class EntityStalker extends EntityCreeper {
    public EntityStalker(World worldIn) {
        super(worldIn);
        setPathPriority(PathNodeType.LAVA, (float) 8);
        setPathPriority(PathNodeType.DANGER_FIRE, (float) 0);
        setPathPriority(PathNodeType.DAMAGE_FIRE, (float) 0);
        isImmuneToFire = true;
        experienceValue = 10;
    }
}
