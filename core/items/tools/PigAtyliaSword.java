package PorkerCraft.core.items.tools;

import PorkerCraft.PorkerCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemSword;

public class PigAtyliaSword extends ItemSword {
	public PigAtyliaSword(int id) {
		super(id, PorkerCraft.PigAtyliaTools);
		setFull3D();
		setUnlocalizedName("pigAtyliaSword");
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("PorkerCraft:PigAtyliaSword");
	}

}
