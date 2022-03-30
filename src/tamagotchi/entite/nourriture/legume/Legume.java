package tamagotchi.entite.nourriture.legume;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tamagotchi.entite.nourriture.I_Nourriture;

public abstract class Legume implements I_Nourriture
{
	private int funValue;
	public Legume()
	{
		this.funValue = -1;
	}
	@Override
	public int getFunValue()
	{
		return this.funValue;
	}
	
	public static Legume getRandomLegume()
	{
		List<Legume> allLegumes = new ArrayList<Legume>();
		allLegumes.add(new HarricotVert());
		allLegumes.add(new Flageolet());
		allLegumes.add(new ChouxDeBruxelle());
		allLegumes.add(new Brocoli());
		allLegumes.add(new Aubergine());
		allLegumes.add(new Courgette());
		Collections.shuffle(allLegumes);
		
		return allLegumes.get(0);
	}
}
