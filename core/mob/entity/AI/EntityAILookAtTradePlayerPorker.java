package PorkerCraft.core.mob.entity.AI;

import PorkerCraft.core.mob.entity.EntityPigMen;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;

public class EntityAILookAtTradePlayerPorker extends EntityAIWatchClosest
{
    private final EntityPigMen theMerchant;

    public EntityAILookAtTradePlayerPorker(EntityPigMen par1EntityVillager)
    {
        super(par1EntityVillager, EntityPlayer.class, 8.0F);
        this.theMerchant = par1EntityVillager;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.theMerchant.isTrading())
        {
            this.closestEntity = this.theMerchant.getCustomer();
            return true;
        }
        else
        {
            return false;
        }
    }
}
