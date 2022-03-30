package tamagotchi.entite.nourriture.fruit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tamagotchi.entite.nourriture.I_Nourriture;

public abstract class Fruit implements I_Nourriture
{
	private int funValue;
	
	public Fruit()
	{
		this.funValue = 1;
	}
	@Override
	public int getFunValue()
	{
		return this.funValue;
	}
	
	public static Fruit getRandomFruit()
	{
		List<Fruit> allFruits = new ArrayList<Fruit>();
		allFruits.add(new Pomme());
		allFruits.add(new Poire());
		allFruits.add(new Mangue());
		
		Collections.shuffle(allFruits);
		
		return allFruits.get(0);
	}
	
}
