package PorkerCraft.core.items.tools;

import PorkerCraft.PorkerCraft;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class PigAtyliaSpade extends ItemSpade {
	public PigAtyliaSpade(int id) {
		super(id, PorkerCraft.PigAtyliaTools);
		setFull3D();
		setUnlocalizedName("pigAtyliaSpade");
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("PorkerCraft:PigAtyliaSpade");
	}

	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
		if (par2Block.blockID == PorkerCraft.PorkDirt.blockID || par2Block.blockID == PorkerCraft.PorkGrass.blockID)
			return toolMaterial.getEfficiencyOnProperMaterial();
		return super.getStrVsBlock(par1ItemStack, par2Block);
	}
}
