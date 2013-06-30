// Date: 23-6-2013 18:23:02
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// ZeuX
package PorkerCraft.core.mob.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.*;
import net.minecraft.util.MathHelper;

public class ModelPigGod extends ModelBase
{
  //fields
	public ModelRenderer Head;
	public ModelRenderer Body1;
	public ModelRenderer Body2;
	public ModelRenderer Leg1;
	public ModelRenderer Leg2;
	public ModelRenderer Arm1;
	public ModelRenderer Arm2;
  
  public ModelPigGod()
  {
	  textureWidth = 64;
      textureHeight = 32;

      setTextureOffset("Leg1", 5, 20);
      setTextureOffset("Leg2", 5, 20);
      setTextureOffset("Body2", 34, 0);
      setTextureOffset("Body1", 34, 0);
      setTextureOffset("Arm1", 20, 18);
      setTextureOffset("Arm2", 20, 18);
      setTextureOffset("Head", 10, 0);

      Leg1 = new ModelRenderer(this, 5, 20);
      Leg1.addBox(-1.5F, 0F, -1.5F, 3, 8, 3);
      Leg1.setRotationPoint(2F, 16F, 0.5F);
      Leg1.setTextureSize(64, 32);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg1.mirror = false;
      Leg2 = new ModelRenderer(this, 5, 20);
      Leg2.addBox(-1.5F, 0F, -1.5F, 3, 8, 3);
      Leg2.setRotationPoint(-3F, 16F, 1F);
      Leg2.setTextureSize(64, 32);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Leg2.mirror = false;
      Body2 = new ModelRenderer(this, 34, 0);
      Body2.addBox(0F, 0F, 0F, 10, 4, 4);
      Body2.setRotationPoint(-5F, 12F, -1.5F);
      Body2.setTextureSize(64, 32);
      Body2.mirror = true;
      setRotation(Body2, 0F, 0F, 0F);
      Body2.mirror = false;
      Body1 = new ModelRenderer(this, 34, 0);
      Body1.addBox(0F, 0F, 0F, 10, 4, 4);
      Body1.setRotationPoint(-5F, 8F, -1.5F);
      Body1.setTextureSize(64, 32);
      Body1.mirror = true;
      setRotation(Body1, 0F, 0F, 0F);
      Body1.mirror = false;
      Arm1 = new ModelRenderer(this, 20, 18);
      Arm1.addBox(0F, 0F, -1.5F, 1, 8, 3);
      Arm1.setRotationPoint(5F, 8F, 0.5F);
      Arm1.setTextureSize(64, 32);
      Arm1.mirror = true;
      setRotation(Arm1, 0F, 0F, 0F);
      Arm1.mirror = false;
      Arm2 = new ModelRenderer(this, 20, 18);
      Arm2.addBox(0F, 0F, -1.5F, 1, 8, 3);
      Arm2.setRotationPoint(-6F, 8F, 0.5F);
      Arm2.setTextureSize(64, 32);
      Arm2.mirror = true;
      setRotation(Arm2, 0F, 0F, 0F);
      Arm2.mirror = false;
      Head = new ModelRenderer(this, 10, 0);
      Head.addBox(-4F, -8F, -4F, 8, 8, 8);
      Head.setRotationPoint(0F, 8F, 0.5F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Head.mirror = false;
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
    setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    Head.render(par7);
    Leg1.render(par7);
    Leg2.render(par7);
    Arm1.render(par7);
    Arm2.render(par7);
    Body1.render(par7);
    Body2.render(par7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
      this.Head.rotateAngleY = par4 / (180F / (float)Math.PI);
      this.Head.rotateAngleX = par5 / (180F / (float)Math.PI);
	  this.Leg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
	  this.Leg1.rotateAngleY = 0.0F;
	  this.Leg2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
	  this.Leg2.rotateAngleY = 0.0F;
	  this.Arm1.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
	  this.Arm1.rotateAngleZ = 0.0F;
	  this.Arm2.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
	  this.Arm2.rotateAngleZ = 0.0F;
  }
}
