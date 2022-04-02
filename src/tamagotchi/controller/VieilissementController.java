package tamagotchi.controller;

import tamagotchi.entite.tamagotchi.I_Tamagotchi;
import tamagotchi.exception.IllegalAgeException;

public class VieilissementController implements Runnable
{
	private I_Tamagotchi tamagotchi;
	private int time_vieilissement;
	public VieilissementController(I_Tamagotchi tamagotchi,int time_vieillissement)
	{
		this.tamagotchi = tamagotchi;
		this.time_vieilissement = time_vieillissement;
	}
	//Vieillit le tamagotchi en fonction du temps de vieillissement
	@Override
	public void run() 
	{
		while(this.tamagotchi.isAlive())
		{
			try {
				Thread.sleep(this.time_vieilissement);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try 
			{
				this.tamagotchi.vieillit();
				this.tamagotchi.faim();
				this.tamagotchi.ennuie();
			} catch (IllegalAgeException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
