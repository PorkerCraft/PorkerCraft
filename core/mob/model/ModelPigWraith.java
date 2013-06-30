package PorkerCraft.core.mob.model;

import PorkerCraft.core.mob.entity.EntityPigWraith;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPigWraith extends ModelBase
{
  //fields
    ModelRenderer Legs;
    ModelRenderer Arm1;
    ModelRenderer Arm2;
    ModelRenderer Head;
    
    public EntityPigWraith Wraith;
  
  public ModelPigWraith()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Legs = new ModelRenderer(this, 36, 0);
      Legs.addBox(0F, 0F, -5F, 10, 20, 4);
      Legs.setRotationPoint(-5F, 4F, 3F);
      Legs.setTextureSize(64, 32);
      Legs.mirror = true;
      setRotation(Legs, 0F, 0F, 0F);
      Arm1 = new ModelRenderer(this, 16, 16);
      Arm1.addBox(0F, 0F, 0F, 4, 12, 4);
      Arm1.setRotationPoint(5F, 4F, -2F);
      Arm1.setTextureSize(64, 32);
      Arm1.mirror = true;
      setRotation(Arm1, 0F, 0F, 0F);
      Arm2 = new ModelRenderer(this, 16, 16);
      Arm2.addBox(0F, 0F, 0F, 4, 12, 4);
      Arm2.setRotationPoint(-9F, 4F, -2F);
      Arm2.setTextureSize(64, 32);
      Arm2.mirror = true;
      setRotation(Arm2, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 0, 0);
      Head.addBox(0F, 0F, 0F, 8, 8, 8);
      Head.setRotationPoint(-4F, -4F, -4F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Legs.render(f5);
    Arm1.render(f5);
    Arm2.render(f5);
    Head.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, Wraith);
  }

}
