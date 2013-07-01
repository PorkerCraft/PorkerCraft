package PorkerCraft.core.items.armor;

import net.minecraft.client.renderer.texture.IconRegister;

public class PigAtyliaBoots extends PigAtyliaArmor {

	public PigAtyliaBoots(int id) {
		super(id, 3);
		setUnlocalizedName("pigAtyliaBoots");
	}
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("PorkerCraft:PigAtyliaBoots");
	}

}
