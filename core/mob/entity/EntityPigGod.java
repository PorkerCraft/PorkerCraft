package PorkerCraft.core.mob.entity;

import PorkerCraft.core.mob.entity.AI.EntityAIFollowParentPorker;
import PorkerCraft.core.mob.entity.AI.EntityAIMatePorker;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityPigGod extends EntityPorkerMob {

    /** AI task for player control. */
    private final EntityAIControlledByPlayer aiControlledByPlayer;
    String Name;
	
	public EntityPigGod(World par1World) {
		super(par1World);
		this.setSize(1.2F, 3.0F);
        float f = 0.4F;
		this.texture = "/mods/PorkerCraft/mob/pigGod.png";
		this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIWander(this, f));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.tasks.addTask(5, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(6, new EntityAIMoveIndoors(this));
		this.tasks.addTask(7, new EntityAIMatePorker(this, f));
        this.tasks.addTask(8, new EntityAITempt(this, 0.3F, Item.carrot.itemID, false));
        this.tasks.addTask(8, new EntityAITempt(this, 0.3F, Item.carrotOnAStick.itemID, false));
        this.tasks.addTask(9, new EntityAIAttackOnCollide(this, EntityZombie.class, this.moveSpeed, true));
        this.tasks.addTask(10, new EntityAIAttackOnCollide(this, EntitySkeleton.class, this.moveSpeed, true));
        this.tasks.addTask(10, new EntityAIAttackOnCollide(this, EntitySpider.class, this.moveSpeed, true));
        this.tasks.addTask(10, new EntityAIAttackOnCollide(this, EntitySkellyPig.class, this.moveSpeed, true));
        this.tasks.addTask(10, new EntityAIAttackOnCollide(this, EntityPigZombie.class, this.moveSpeed, true));
        this.tasks.addTask(11, this.aiControlledByPlayer = new EntityAIControlledByPlayer(this, 0.34F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.tasks.addTask(12, new EntityAIFollowParentPorker(this, 0.28F));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZombie.class, 16.0F, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, 16.0F, 0, true)); 
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySpider.class, 16.0F, 0, true)); 
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySkellyPig.class, 16.0F, 0, true)); 
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPigZombie.class, 16.0F, 0, true)); 
        
        Name = "Flying Pig";
	}
	
	private ChunkCoordinates currentFlightTarget;

    public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
    {
        return this.spawnBabyAnimal(par1EntityAgeable);
    }
	
	public EntityPigGod spawnBabyAnimal(EntityAgeable par1EntityAgeable)
    {
        return new EntityPigGod(this.worldObj);
    }
	
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setBoolean("Saddle", this.getSaddled());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setSaddled(par1NBTTagCompound.getBoolean("Saddle"));
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack par1ItemStack)
    {
        return par1ItemStack != null && par1ItemStack.itemID == Item.carrot.itemID;
    }

	@Override
	public int getMaxHealth() {
		return 100;
	}
	
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.pig.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.pig.say";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.pig.death";
    }
    
    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound("mob.pig.step", 0.15F, 1.0F);
    }
    
    protected int getDropItemId()
    {
        return this.isBurning() ? Item.porkCooked.itemID : Item.porkRaw.itemID;
    }
    
    protected void dropFewItems(boolean par1, int par2)
    {
        int j = this.rand.nextInt(25) + 1 + this.rand.nextInt(4 + par2);

        for (int k = 0; k < j; ++k)
        {
            if (this.isBurning())
            {
                this.dropItem(Item.porkCooked.itemID, 1);
            }
            else
            {
                this.dropItem(Item.porkRaw.itemID, 1);
            }
        }
    }
    
    public boolean isAIEnabled()
    {
        return true;
    }
    
    public boolean attackEntityAsMob(Entity par1Entity)
    {
        boolean flag = super.attackEntityAsMob(par1Entity);

        if (flag && this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < (float)this.worldObj.difficultySetting * 0.3F)
        {
            par1Entity.setFire(2 * this.worldObj.difficultySetting);
        }

        return flag;
    }

    /**
     * Returns the amount of damage a mob should deal.
     */
    public int getAttackStrength(Entity par1Entity)
    {
        ItemStack itemstack = this.getHeldItem();
        float f = (float)(this.getMaxHealth() - this.getHealth()) / (float)this.getMaxHealth();
        int i = 10 + MathHelper.floor_float(f * 4.0F);

        if (itemstack != null)
        {
            i += itemstack.getDamageVsEntity(this);
        }

        return i;
    }
    
    protected void addRandomArmor()
    {
        super.addRandomArmor();

        if (this.rand.nextFloat() < (this.worldObj.difficultySetting == 3 ? 0.05F : 0.01F))
        {
            int i = this.rand.nextInt(3);

            if (i == 0)
            {
                this.setCurrentItemOrArmor(0, new ItemStack(Item.swordIron));
            }
            else
            {
                this.setCurrentItemOrArmor(0, new ItemStack(Item.shovelIron));
            }
        }
    }
    
    public int getTotalArmorValue()
    {
        int i = super.getTotalArmorValue() + 2;

        if (i > 20)
        {
            i = 20;
        }

        return i;
    }
    
    /**
     * returns true if all the conditions for steering the entity are met. For pigs, this is true if it is being ridden
     * by a player and the player is holding a carrot-on-a-stick
     */
    public boolean canBeSteered()
    {
        ItemStack itemstack = ((EntityPlayer)this.riddenByEntity).getHeldItem();
        return itemstack != null && itemstack.itemID == Item.carrotOnAStick.itemID;
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        if (super.interact(par1EntityPlayer))
        {
            return true;
        }
        else if (this.getSaddled() && !this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == par1EntityPlayer))
        {
            par1EntityPlayer.mountEntity(this);
            //return true;
            return setSaddled(true);
        }
        else
        {
            return false;
        }
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItemsPorker(boolean par1, int par2)
    {
        int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + par2);

        for (int k = 0; k < j; ++k)
        {
            if (this.isBurning())
            {
                this.dropItem(Item.porkCooked.itemID, 1);
            }
            else
            {
                this.dropItem(Item.porkRaw.itemID, 1);
            }
        }

        if (this.getSaddled())
        {
            this.dropItem(Item.saddle.itemID, 1);
        }
    }

    /**
     * Returns true if the pig is saddled.
     */
    public boolean getSaddled()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    /**
     * Set or remove the saddle of the pig.
     * @return 
     */
    public boolean setSaddled(boolean par1)
    {
        if (par1)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)1));
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)0));
        }
        
		return par1;
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float par1)
    {
        super.fall(par1);

        if (par1 > 5.0F && this.riddenByEntity instanceof EntityPlayer)
        {
            ((EntityPlayer)this.riddenByEntity).triggerAchievement(AchievementList.flyPig);
        }
    }

    /**
     * Return the AI task for player control.
     */
    public EntityAIControlledByPlayer getAIControlledByPlayer()
    {
        return this.aiControlledByPlayer;
    }
}
