package PorkerCraft.core.mainmenu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;

import org.lwjgl.opengl.GL11;

public class GuiPorkerButton extends GuiButton
{

    public GuiPorkerButton(int i, int j, int k, String s)
    {
        super(i, j, k, s);
    }

    public GuiPorkerButton(int i, int j, int k, int l, int i1, String s)
    {
	super(i, j, k, l, i1, s);
        this.enabled = true;
        this.drawButton = true;
    }

    protected int getHoverState(boolean flag)
    {
        byte byte0 = 1;
        
    	if(!enabled)
    	{
        	byte0 = 0;
    	} 
		else if(flag)
    	{
			if(byte0 < 2)
			{
				byte0++;
			}
			if(scrollCrop < scrollCropMax)
			{
				scrollCrop++;
			}
			if (scrollHeight < scrollMin)
				scrollHeight++;
		} 
		else 
		{
			if(scrollCrop > scrollCropMax)
			{
				scrollCrop--;
			}
			if (scrollHeight > scrollMax)
				scrollHeight--;
			if (scrollHeight == scrollMax)
				retracting = false;      
		}
		
		return byte0;
    }

    public void drawButton(Minecraft minecraft, int i, int j)
    {
        if(!drawButton)
        {
            return;
        }
        
        FontRenderer fontrenderer = minecraft.fontRenderer;
        GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, minecraft.renderEngine.getTexture("/PorkerCraft/icons/buttons.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        boolean flag = i >= xPosition && j >= yPosition && i < xPosition + width && j < yPosition + height;
        int k = getHoverState(flag);
        drawTexturedModalRect(xPosition + scrollHeight - 90, yPosition, 0, 46 + k * 20, width / 2, height);
        drawTexturedModalRect(xPosition + scrollHeight + width / 2 - 90, yPosition, 200 - width / 2, 46 + k * 20, width / 2, height);
        mouseDragged(minecraft, i, j);
        
        minecraft.renderEngine.resetBoundTexture();
        
        if(!enabled)
        {
        	drawString(fontrenderer, displayString, xPosition + width / 10 + scrollHeight - 80, yPosition + (height - 8) / 2, -6250336);
        } else
        if(flag)
        {
        	drawString(fontrenderer, displayString, xPosition + width / 10 + scrollHeight - 80, yPosition + (height - 8) / 2, 0x77cccc);
        } else
        {
         drawString(fontrenderer, displayString, xPosition + width / 10 + scrollHeight - 80, yPosition + (height - 8) / 2, 14737632);
        }
    }

   protected void mouseDragged(Minecraft var1, int var2, int var3) {}

   public void mouseReleased(int var1, int var2) {}

   public boolean mousePressed(Minecraft var1, int var2, int var3) {
      return this.enabled && var2 >= this.xPosition && var3 >= this.yPosition && var2 < this.xPosition + this.width && var3 < this.yPosition + this.height;
   }
	
	public int scrollMax = 100;
	public int scrollHeight = scrollMax;
	public int scrollMin = 115;
	public int scrollCrop = 20;
	public int scrollCropMax = 90;
	public boolean retracting = false;
}
