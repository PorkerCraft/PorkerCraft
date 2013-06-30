package PorkerCraft.core.mob.render;

import PorkerCraft.core.mob.entity.EntityPigMen;
import PorkerCraft.core.mob.model.ModelPigMen;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderPigMen extends RenderLiving
{
    /** Model of the villager. */
    protected ModelPigMen villagerModel;

    public RenderPigMen(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
        this.villagerModel = (ModelPigMen)this.mainModel;
    }

    /**
     * Determines wether Villager Render pass or not.
     */
    protected int shouldVillagerRenderPass(EntityPigMen par1EntityPigMen, int par2, float par3)
    {
        return -1;
    }

    public void renderVillager(EntityPigMen par1EntityPigMen, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityPigMen, par2, par4, par6, par8, par9);
    }

    protected void renderVillagerEquipedItems(EntityPigMen par1EntityPigMen, float par2)
    {
        super.renderEquippedItems(par1EntityPigMen, par2);
    }

    protected void preRenderVillager(EntityPigMen par1EntityPigMen, float par2)
    {
        float f1 = 0.9375F;

        if (par1EntityPigMen.getGrowingAge() < 0)
        {
            f1 = (float)((double)f1 * 0.5D);
            this.shadowSize = 0.25F;
        }
        else
        {
            this.shadowSize = 0.5F;
        }

        GL11.glScalef(f1, f1, f1);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.preRenderVillager((EntityPigMen)par1EntityLiving, par2);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
    {
        return this.shouldVillagerRenderPass((EntityPigMen)par1EntityLiving, par2, par3);
    }

    protected void renderEquippedItems(EntityLiving par1EntityLiving, float par2)
    {
        this.renderVillagerEquipedItems((EntityPigMen)par1EntityLiving, par2);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderVillager((EntityPigMen)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderVillager((EntityPigMen)par1Entity, par2, par4, par6, par8, par9);
    }
}
