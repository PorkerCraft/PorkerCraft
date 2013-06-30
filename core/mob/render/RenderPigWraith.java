package PorkerCraft.core.mob.render;

import PorkerCraft.core.mob.entity.EntityPigWraith;
import PorkerCraft.core.mob.model.ModelPigWraith;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class RenderPigWraith extends RenderLiving{

	public RenderPigWraith(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = ((ModelPigWraith)mainModel);
	}

	protected ModelPigWraith model;
	
	public void renderPigWraith(EntityPigWraith entity, double par2, double par4, double par6, float par8, float par9){
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9){
		renderPigWraith((EntityPigWraith)par1EntityLiving, par2, par4, par6, par8, par9);
	}
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9){
		renderPigWraith((EntityPigWraith)par1Entity, par2, par4, par6, par8, par9);
	}
	
}
