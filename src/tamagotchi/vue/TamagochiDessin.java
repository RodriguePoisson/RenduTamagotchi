package tamagotchi.vue;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import tamagotchi.entite.tamagotchi.I_Tamagotchi;

public class TamagochiDessin extends JPanel
{
	private I_Tamagotchi tamagotchi;
	private int diametre_tama = 200;
	public TamagochiDessin(I_Tamagotchi tamagotchi)
	{
		this.tamagotchi = tamagotchi;
		setPreferredSize(new Dimension(400,400));
	}
	
	@Override
	public void paint(Graphics g)
	{
		int x = 100;
		int y = 100;
		
		int x_oeil1= x+50;
		int x_oeil2 = x+diametre_tama-(diametre_tama/2)-7;
		int y_yeux = y+7;
		
		
		if(this.tamagotchi.isAlive())
		{
			int width_yeux = 10;
			
			g.drawRect(x_oeil1,y_yeux,width_yeux,width_yeux);
			g.drawRect(x_oeil2,y_yeux,width_yeux,width_yeux);
			
			int x_bouche = x+diametre_tama/2-10;
			int y_bouche = y+diametre_tama -20;
			if(this.tamagotchi.is_happy())
			{
				g.drawOval(x_bouche, y_bouche-33, 50, 25);
			}
			else
			{
				g.drawLine(x_bouche-50, y_bouche, x_bouche+50, y_bouche);
			}
		}
		else
		{
			g.drawString("MORT", 177,y_yeux+75);
		}
		g.drawRect(x,y,diametre_tama,diametre_tama);
	}
}
