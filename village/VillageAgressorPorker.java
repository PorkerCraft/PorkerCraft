package PorkerCraft.village;

import net.minecraft.entity.EntityLiving;

class VillageAgressor
{
    public EntityLiving agressor;
    public int agressionTime;

    final VillagePorker villageObj;

    VillageAgressor(VillagePorker par1Village, EntityLiving par2EntityLiving, int par3)
    {
        this.villageObj = par1Village;
        this.agressor = par2EntityLiving;
        this.agressionTime = par3;
    }
}
