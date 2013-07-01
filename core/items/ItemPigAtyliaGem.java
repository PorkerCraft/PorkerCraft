package PorkerCraft.core.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemPigAtyliaGem extends Item{

	public ItemPigAtyliaGem(int id) {
		super(id);
		setCreativeTab(CreativeTabs.tabMaterials);
		setFull3D();
		setUnlocalizedName("pigAtyliaGem");
	}
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("PorkerCraft:PigAtyliaGem");
	}
	

}
