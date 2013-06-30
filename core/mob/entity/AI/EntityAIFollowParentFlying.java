package PorkerCraft.core.mob.entity.AI;

import java.util.Iterator;
import java.util.List;

import PorkerCraft.core.mob.entity.EntityPorkerMobFlying;


import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIFollowParentFlying extends EntityAIBase
{
    /** The child that is following its parent. */
    EntityPorkerMobFlying childAnimal;
    EntityPorkerMobFlying parentAnimal;
    float field_75347_c;
    private int field_75345_d;

    public EntityAIFollowParentFlying(EntityPorkerMobFlying entityPorkerMobFlying, float par2)
    {
        this.childAnimal = entityPorkerMobFlying;
        this.field_75347_c = par2;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.childAnimal.getGrowingAge() >= 0)
        {
            return false;
        }
        else
        {
            List list = this.childAnimal.worldObj.getEntitiesWithinAABB(this.childAnimal.getClass(), this.childAnimal.boundingBox.expand(8.0D, 4.0D, 8.0D));
            EntityPorkerMobFlying EntityPorkerMobFlying = null;
            double d0 = Double.MAX_VALUE;
            Iterator iterator = list.iterator();

            while (iterator.hasNext())
            {
                EntityPorkerMobFlying EntityPorkerMobFlying1 = (EntityPorkerMobFlying)iterator.next();

                if (EntityPorkerMobFlying1.getGrowingAge() >= 0)
                {
                    double d1 = this.childAnimal.getDistanceSqToEntity(EntityPorkerMobFlying1);

                    if (d1 <= d0)
                    {
                        d0 = d1;
                        EntityPorkerMobFlying = EntityPorkerMobFlying1;
                    }
                }
            }

            if (EntityPorkerMobFlying == null)
            {
                return false;
            }
            else if (d0 < 9.0D)
            {
                return false;
            }
            else
            {
                this.parentAnimal = EntityPorkerMobFlying;
                return true;
            }
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        if (!this.parentAnimal.isEntityAlive())
        {
            return false;
        }
        else
        {
            double d0 = this.childAnimal.getDistanceSqToEntity(this.parentAnimal);
            return d0 >= 9.0D && d0 <= 256.0D;
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.field_75345_d = 0;
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.parentAnimal = null;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        if (--this.field_75345_d <= 0)
        {
            this.field_75345_d = 10;
            this.childAnimal.getNavigator().tryMoveToEntityLiving(this.parentAnimal, this.field_75347_c);
        }
    }
}
