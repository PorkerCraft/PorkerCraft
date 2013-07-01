package PorkerCraft.core.items.tools;

import PorkerCraft.PorkerCraft;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class PigAtyliaPickaxe extends ItemPickaxe {

	public PigAtyliaPickaxe(int id) {
		super(id, PorkerCraft.PigAtyliaTools);
		setFull3D();
		setUnlocalizedName("pigAtyliaPickaxe");
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("PorkerCraft:PigAtyliaPickaxe");
	}

	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
		if (par2Block.blockID == PorkerCraft.PorkStone.blockID)
			return toolMaterial.getEfficiencyOnProperMaterial();
		return super.getStrVsBlock(par1ItemStack, par2Block);
	}
}
