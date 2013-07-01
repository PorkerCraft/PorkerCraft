package PorkerCraft.client.sounds;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import PorkerCraft.PorkerCraft;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PorkerSounds
{
	  @ForgeSubscribe
	  public void onSound(SoundLoadEvent event)
	  {
	    try
	    {
	      event.manager.soundPoolSounds.addSound("porkercraft/wraith/living1.ogg", PorkerCraft.class.getResource("PorkerCraft/Mobs/Wraith/wraith1.ogg"));
	      event.manager.soundPoolSounds.addSound("porkercraft/wraith/living2.ogg", PorkerCraft.class.getResource("PorkerCraft/Mobs/Wraith/wraith2.ogg"));
	      event.manager.soundPoolSounds.addSound("porkercraft/wraith/living3.ogg", PorkerCraft.class.getResource("PorkerCraft/Mobs/Wraith/wraith3.ogg"));
	    }
	    catch (Exception e)
	    {
	      System.err.println("[Porkercraft] Failed to register one or more sounds.");
	    }
	  }
}