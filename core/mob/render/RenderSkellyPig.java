package PorkerCraft.core.mob.render;

import PorkerCraft.core.mob.entity.EntitySkellyPig;
import PorkerCraft.core.mob.model.ModelSkellyPig;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class RenderSkellyPig extends RenderLiving {

	public RenderSkellyPig(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = ((ModelSkellyPig)mainModel);
	}

	protected ModelSkellyPig model;
	
	public void renderSkellyPig(EntitySkellyPig entity, double par2, double par4, double par6, float par8, float par9){
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9){
		renderSkellyPig((EntitySkellyPig)par1EntityLiving, par2, par4, par6, par8, par9);
	}
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9){
		renderSkellyPig((EntitySkellyPig)par1Entity, par2, par4, par6, par8, par9);
	}

}
