package PorkerCraft.core.util;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import PorkerCraft.core.mob.entity.EntityFlyingPig;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

import PorkerCraft.core.mob.entity.*;

public class KeybindingHandler extends KeyHandler
{
	Minecraft mc;
	World world;
	EntityPlayer player;
	
	public static KeyBinding PigFlyUp = new KeyBinding("PigFlyUp", Keyboard.KEY_I);
	
	public static KeyBinding [] arrayOfKeys = new KeyBinding []
		{ PigFlyUp /*keyName*/};
	public static boolean [] areRepeating = new boolean []
		{false};

	public KeybindingHandler()
	{
		super(arrayOfKeys, areRepeating);
		mc = mc.getMinecraft();
	}

	@Override
	public String getLabel()
	{
		return "PorkerCraft KeyBindings";
	}
	
	@Override
	public void keyDown(EnumSet <TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
	{
		if (tickEnd && mc.thePlayer != null && mc.currentScreen == null)
		{
			if(kb.keyCode == PigFlyUp.keyCode)
			{			
				//world.playSoundFX(mc.thePlayer, "wraith1", 1.0f, 1.0f);
				mc.sndManager.playSoundFX("mob.PorkerCraft.wraith1", 1.0F, 1.0F);
			}
		}
	}
	

	@Override
	public void keyUp(EnumSet <TickType> types, KeyBinding kb, boolean tickEnd)
	{

	}

	@Override
	public EnumSet <TickType> ticks()
	{
		return EnumSet.of(TickType.CLIENT);
	}
}