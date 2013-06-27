package PorkerCraft.core.util;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import org.lwjgl.input.Keyboard;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class KeybindingHandler extends KeyHandler
{
	Minecraft mc;
	
	public static KeyBinding TEST = new KeyBinding("DisplayName", Keyboard.KEY_I);
    //public static KeyBinding TEST = new KeyBinding("key.test", 73);
	
	//public static KeyBinding acOptions = new KeyBinding("AC Options", Keyboard.KEY_J);
	
	public static KeyBinding [] arrayOfKeys = new KeyBinding []
		{ TEST /*keyName*/};
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
		return "Arcticraft KeyBindings";
	}

	@Override
	public void keyDown(EnumSet <TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
	{
		if (tickEnd && mc.thePlayer != null && mc.currentScreen == null)
		{
			if(kb.keyCode == TEST.keyCode)
			{
				mc.thePlayer.addChatMessage("TESTEST");
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