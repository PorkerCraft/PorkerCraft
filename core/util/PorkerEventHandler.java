package PorkerCraft.core.util;

import java.awt.Event;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import PorkerCraft.PorkerCraft;
import PorkerCraft.core.blocks.BlockPorkTreeSapling;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class PorkerEventHandler
{
private int BlockID;
/** Used to make the sapling grow the tree **/
@ForgeSubscribe
public void bonemealUsed(BonemealEvent event)
{
if(event.world.getBlockId(event.X, event.Y, event.Z) == PorkerCraft.PorkTreeSapling.blockID)
{
((BlockPorkTreeSapling)PorkerCraft.PorkTreeSapling).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
}
}

@SideOnly(Side.CLIENT)
@ForgeSubscribe
public void onSoundLoad(SoundLoadEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        mc.installResource("sound3/mob/PorkerCraft/wraith1.ogg",
        new File(mc.mcDataDir, "resources/sound3/mob/PorkerCraft/wraith1.ogg"));
}
}