package PorkerCraft.core.items.tools;

import PorkerCraft.PorkerCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemHoe;

public class PigAtyliaHoe extends ItemHoe {
	public PigAtyliaHoe(int id) {
		super(id, PorkerCraft.PigAtyliaTools);
		setFull3D();
		setUnlocalizedName("pigAtyliaHoe");
	}
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("PorkerCraft:PigAtyliaHoe");
	}
}
