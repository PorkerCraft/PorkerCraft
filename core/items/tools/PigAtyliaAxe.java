package PorkerCraft.core.items.tools;

import PorkerCraft.PorkerCraft;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class PigAtyliaAxe extends ItemAxe {
	public PigAtyliaAxe(int id) {
		super(id, PorkerCraft.PigAtyliaTools);
		setFull3D();
		setUnlocalizedName("pigAtyliaAxe");
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("PorkerCraft:PigAtyliaAxe");
	}
	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
		if(par2Block.blockID == PorkerCraft.PorkTreeLog.blockID)
			return toolMaterial.getEfficiencyOnProperMaterial();
		return super.getStrVsBlock(par1ItemStack, par2Block);
	}
}
