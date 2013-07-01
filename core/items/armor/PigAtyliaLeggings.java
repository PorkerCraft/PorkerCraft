package PorkerCraft.core.items.armor;

import net.minecraft.client.renderer.texture.IconRegister;

public class PigAtyliaLeggings extends PigAtyliaArmor{

	public PigAtyliaLeggings(int id) {
		super(id, 2);
		setUnlocalizedName("pigAtyliaLeggings");
	}
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("PorkerCraft:PigAtyliaLeggings");
	}
}
