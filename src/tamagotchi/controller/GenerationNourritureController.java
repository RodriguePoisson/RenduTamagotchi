package tamagotchi.controller;

import java.util.Random;

import tamagotchi.entite.nourriture.I_Nourriture;
import tamagotchi.entite.nourriture.fruit.Fruit;
import tamagotchi.entite.nourriture.legume.Legume;

public class GenerationNourritureController implements Runnable
{
	private CentralController centralController;
	public GenerationNourritureController(CentralController centralController)
	{
		this.centralController = centralController;
	}

	@Override
	//toutes les 5 secondes un fruit est g�n�r�
	public void run() 
	{
		while(true)
		{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Random r = new Random();
			int value_random_0_ou_1 = r.nextInt(2);
			I_Nourriture nourriture;
			if(value_random_0_ou_1 == 0)nourriture= Fruit.getRandomFruit();
			else nourriture= Legume.getRandomLegume();
			
			this.centralController.alertGenerationObservateur(nourriture);
		}
		
	}

}
