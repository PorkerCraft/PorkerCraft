package PorkerCraft.core.items.armor;

import net.minecraft.client.renderer.texture.IconRegister;

public class PigAtyliaChestplate extends PigAtyliaArmor {

	public PigAtyliaChestplate(int id) {
		super(id, 1);
		setUnlocalizedName("pigAtyliaChestplate");
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("PorkerCraft:PigAtyliaChestplate");
	}

}
