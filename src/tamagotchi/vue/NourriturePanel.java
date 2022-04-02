package tamagotchi.vue;

import javax.swing.JPanel;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;

import tamagotchi.entite.joueur.I_Joueur;
import tamagotchi.entite.nourriture.I_Nourriture;

public class NourriturePanel extends JPanel
{
	private I_Joueur joueur;
	private I_Nourriture nourriture;
	public NourriturePanel(I_Joueur joueur)
	{
		this.joueur = joueur;
		this.nourriture = null;
	}
	public NourriturePanel(I_Joueur joueur,I_Nourriture nourriture)
	{
		this.joueur = joueur;
		this.nourriture = nourriture;
		this.setPreferredSize(new Dimension(100,100));
	}
	public void paint(Graphics g)
	{
		//Affiche en rouge le prix si le joueur ne peut pas l'acheter et en vert si il peut
		g.drawRect(0,0,174,100);
		if(this.nourriture != null)
		{
			g.drawString(this.nourriture.toString(),10,25);
			
			if(this.joueur.canBuy(this.nourriture.getPrice()))
			{
				//VERT
				g.setColor(new Color(0,153,51));
			}
			else
			{				
				//ROUGE
				g.setColor(new Color(153,0,0));
			}
			
			g.drawString(String.valueOf(this.nourriture.getPrice())+" Or",10,50);
		}
		else
		{
			g.drawString("Pas de nourriture disponible",5,25);
		}
	}
}
