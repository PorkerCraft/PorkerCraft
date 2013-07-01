package PorkerCraft.core.items.armor;

import PorkerCraft.PorkerCraft;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class PigAtyliaArmor extends ItemArmor {
	public PigAtyliaArmor(int id, int type) {
		super(id, PorkerCraft.PigAtyliaArmor, PorkerCraft.PigAtyliaArmorSkin, type);
		setFull3D();
	}
}
