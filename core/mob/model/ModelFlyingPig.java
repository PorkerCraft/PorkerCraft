package PorkerCraft.core.mob.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

import PorkerCraft.core.mob.entity.EntityFlyingPig;

public class ModelFlyingPig extends ModelBase
{
    public ModelRenderer head = new ModelRenderer(this, 0, 0);
    public ModelRenderer body;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer Wing1;
    public ModelRenderer Wing2;
    public ModelRenderer Nose;
    protected float field_78145_g = 8.0F;
    protected float field_78151_h = 4.0F;

    public ModelFlyingPig()
    {
    	textureWidth = 128;
        textureHeight = 64;

        setTextureOffset("head", 0, 0);
        setTextureOffset("body", 28, 8);
        setTextureOffset("leg1", 0, 16);
        setTextureOffset("leg2", 0, 16);
        setTextureOffset("Wing1", 72, 0);
        setTextureOffset("Wing2", 72, 0);
        setTextureOffset("leg3", 0, 16);
        setTextureOffset("leg4", 0, 16);
        setTextureOffset("Nose", 16, 16);

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -6F, -6F, 8, 8, 8);
        head.setRotationPoint(0F, 10F, -8F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        head.mirror = false;
        body = new ModelRenderer(this, 28, 8);
        body.addBox(0F, 0F, 0F, 10, 16, 8);
        body.setRotationPoint(-5F, 18F, -8F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        body.mirror = false;
        leg1 = new ModelRenderer(this, 0, 16);
        leg1.addBox(-2F, 0F, -2F, 4, 6, 4);
        leg1.setRotationPoint(3F, 18F, 7F);
        leg1.setTextureSize(64, 32);
        leg1.mirror = true;
        setRotation(leg1, 0F, 0F, 0F);
        leg1.mirror = false;
        leg2 = new ModelRenderer(this, 0, 16);
        leg2.addBox(-2F, 0F, -2F, 4, 6, 4);
        leg2.setRotationPoint(-3F, 18F, 7F);
        leg2.setTextureSize(64, 32);
        leg2.mirror = true;
        setRotation(leg2, 0F, 0F, 0F);
        leg2.mirror = false;
        Wing1 = new ModelRenderer(this, 72, 0);
        Wing1.addBox(0F, 0F, -4F, 8, 1, 8);
        Wing1.setRotationPoint(5F, 10F, 0F);
        Wing1.setTextureSize(64, 32);
        Wing1.mirror = true;
        setRotation(Wing1, 0F, 0F, 0F);
        Wing1.mirror = false;
        Wing2 = new ModelRenderer(this, 72, 0);
        Wing2.addBox(-8F, 0F, -4F, 8, 1, 8);
        Wing2.setRotationPoint(-5F, 10F, 0F);
        Wing2.setTextureSize(64, 32);
        Wing2.mirror = true;
        setRotation(Wing2, 0F, 0F, 0F);
        Wing2.mirror = false;
        leg3 = new ModelRenderer(this, 0, 16);
        leg3.addBox(-2F, 0F, -2F, 4, 6, 4);
        leg3.setRotationPoint(-3F, 18F, -5F);
        leg3.setTextureSize(64, 32);
        leg3.mirror = true;
        setRotation(leg3, 0F, 0F, 0F);
        leg3.mirror = false;
        leg4 = new ModelRenderer(this, 0, 16);
        leg4.addBox(-2F, 0F, -2F, 4, 6, 4);
        leg4.setRotationPoint(3F, 18F, -5F);
        leg4.setTextureSize(64, 32);
        leg4.mirror = true;
        setRotation(leg4, 0F, 0F, 0F);
        leg4.mirror = false;
        Nose = new ModelRenderer(this, 16, 16);
        Nose.addBox(-2F, -2F, -7F, 4, 3, 1);
        Nose.setRotationPoint(0F, 10F, -8F);
        Nose.setTextureSize(64, 32);
        Nose.mirror = true;
        setRotation(Nose, 0F, 0F, 0F);
        Nose.mirror = false;
        this.body.addChild(this.Wing1);
        this.body.addChild(this.Wing2);
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
            this.leg3.render(par7);
            this.leg4.render(par7);
            this.Wing1.render(par7);
            this.Wing2.render(par7);
            GL11.glPopMatrix();
        }
        else
        {
            this.head.render(par7);
            this.body.render(par7);
            this.leg1.render(par7);
            this.leg2.render(par7);
            this.leg3.render(par7);
            this.leg4.render(par7);
            this.Wing1.render(par7);
            this.Wing2.render(par7);
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
    	EntityFlyingPig entityflyingpig = (EntityFlyingPig)par7Entity;
    	
    	if(entityflyingpig.getWillPigFly() == false){
    	this.head.rotateAngleX = par5 / (180F / (float)Math.PI);
        this.head.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.Nose.rotateAngleX = par5 / (180F / (float)Math.PI);
        this.Nose.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.leg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        this.leg4.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        this.leg2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        this.leg3.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        this.Wing1.rotateAngleZ = ((float)Math.PI / 2F);
        this.Wing2.rotateAngleZ = -this.Wing1.rotateAngleY;
    	}else{
        	this.head.rotateAngleX = par5 / (180F / (float)Math.PI);
            this.head.rotateAngleY = par4 / (180F / (float)Math.PI);
            this.Nose.rotateAngleX = par5 / (180F / (float)Math.PI);
            this.Nose.rotateAngleY = par4 / (180F / (float)Math.PI);
            this.body.rotateAngleX = ((float)Math.PI / 2F);
            this.leg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
            this.leg4.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
            this.leg2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
            this.leg3.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
            this.Wing1.rotateAngleZ = MathHelper.cos(par4 * 1.3F) * (float)Math.PI * 0.25F;;
            this.Wing2.rotateAngleZ = -this.Wing1.rotateAngleY;	
    	}
    }
}
