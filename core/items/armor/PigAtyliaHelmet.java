package PorkerCraft.core.items.armor;

import net.minecraft.client.renderer.texture.IconRegister;

public class PigAtyliaHelmet extends PigAtyliaArmor {

	public PigAtyliaHelmet(int id) {
		super(id, 0);
		setUnlocalizedName("pigAtyliaHelmet");
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("PorkerCraft:PigAtyliaHelmet");
	}
}
