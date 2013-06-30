package PorkerCraft.core.mob.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelPigMen extends ModelBase
{
    public ModelRenderer head = new ModelRenderer(this, 0, 0);
    public ModelRenderer body;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer Arm1;
    public ModelRenderer Arm2;
    public ModelRenderer Nose;
    protected float field_78145_g = 8.0F;
    protected float field_78151_h = 4.0F;

    public ModelPigMen()
    {
    	textureWidth = 64;
        textureHeight = 32;

        setTextureOffset("leg1", 0, 16);
        setTextureOffset("leg2", 0, 16);
        setTextureOffset("body", 16, 16);
        setTextureOffset("head", 0, 0);
        setTextureOffset("Arm1", 24, 16);
        setTextureOffset("Arm2", 24, 16);
        setTextureOffset("Nose", 40, 0);

        leg1 = new ModelRenderer(this, 0, 16);
        leg1.addBox(-2F, 0F, -2F, 4, 12, 4);
        leg1.setRotationPoint(2F, 12F, 0F);
        leg1.setTextureSize(64, 32);
        leg1.mirror = true;
        setRotation(leg1, 0F, 0F, 0F);
        leg1.mirror = false;
        leg2 = new ModelRenderer(this, 0, 16);
        leg2.addBox(-2F, 0F, -2F, 4, 12, 4);
        leg2.setRotationPoint(-2F, 12F, 0F);
        leg2.setTextureSize(64, 32);
        leg2.mirror = true;
        setRotation(leg2, 0F, 0F, 0F);
        leg2.mirror = false;
        body = new ModelRenderer(this, 16, 16);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setRotationPoint(0F, 0F, 0F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        body.mirror = false;
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        head.mirror = false;
        Arm1 = new ModelRenderer(this, 24, 16);
        Arm1.addBox(0F, 0F, -2F, 4, 12, 4);
        Arm1.setRotationPoint(4F, 0F, 0F);
        Arm1.setTextureSize(64, 32);
        Arm1.mirror = true;
        setRotation(Arm1, 0F, 0F, 0F);
        Arm1.mirror = false;
        Arm2 = new ModelRenderer(this, 24, 16);
        Arm2.addBox(-4F, 0F, -2F, 4, 12, 4);
        Arm2.setRotationPoint(-4F, 0F, 0F);
        Arm2.setTextureSize(64, 32);
        Arm2.mirror = true;
        setRotation(Arm2, 0F, 0F, 0F);
        Arm2.mirror = false;
        Nose = new ModelRenderer(this, 40, 0);
        Nose.addBox(-2F, -4F, -5F, 4, 3, 1);
        Nose.setRotationPoint(0F, 0F, 0F);
        Nose.setTextureSize(64, 32);
        Nose.mirror = true;
        setRotation(Nose, 0F, 0F, 0F);
        Nose.mirror = false;

    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);

        if (this.isChild)
        {
            float f6 = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, this.field_78145_g * par7, this.field_78151_h * par7);
            this.head.render(par7);
            this.Nose.render(par7);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
            GL11.glTranslatef(0.0F, 24.0F * par7, 0.0F);
            this.body.render(par7);
            this.leg1.render(par7);
            this.leg2.render(par7);
            this.Arm1.render(par7);
            this.Arm2.render(par7);
            GL11.glPopMatrix();
        }
        else
        {
            this.head.render(par7);
            this.body.render(par7);
            this.leg1.render(par7);
            this.leg2.render(par7);
            this.Arm1.render(par7);
            this.Arm2.render(par7);
            this.Nose.render(par7);
        }
    }
    
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
    {
        this.head.rotateAngleX = par5 / (180F / (float)Math.PI);
        this.head.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.Nose.rotateAngleX = par5 / (180F / (float)Math.PI);
        this.Nose.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.body.rotateAngleX = 0.0F;
        this.leg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        this.Arm2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        this.leg2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        this.Arm1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
    }
}
