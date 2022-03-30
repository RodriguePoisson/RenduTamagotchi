package tamagotchi.vue;

import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tamagotchi.entite.tamagotchi.I_Tamagotchi;

public class InfoPartiePanel extends JPanel
{
	private I_Tamagotchi tamagotchi;
	private JLabel info_age;
	private JLabel info_energy;
	private JLabel info_fun;
	
	public InfoPartiePanel(I_Tamagotchi tamagotchi)
	{
		this.tamagotchi = tamagotchi;
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		this.info_age = new JLabel("   Age de "+this.tamagotchi.getName()+" : "+this.tamagotchi.getAge()+" ans");
		this.info_energy = new JLabel("   Energie : "+this.tamagotchi.getEnergy()+" !");
		this.info_fun = new JLabel("   Fun : "+this.tamagotchi.getFun()+" !");
		
		add(this.info_age);
		add(this.info_energy);
		add(this.info_fun);
		
	
	}
	
	
}
