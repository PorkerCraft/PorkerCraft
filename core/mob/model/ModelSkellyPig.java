package PorkerCraft.core.mob.model;

import net.minecraft.client.model.ModelQuadruped;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSkellyPig extends ModelQuadruped
{
    public ModelSkellyPig()
    {
        this(0.0F);
    }

    public ModelSkellyPig(float par1)
    {
        super(6, par1);
        this.head.setTextureOffset(16, 16).addBox(-2.0F, 0.0F, -9.0F, 4, 3, 1, par1);
        this.field_78145_g = 4.0F;
    }
}
