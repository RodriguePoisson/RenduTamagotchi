package tamagotchi.entite.tamagotchi;

import tamagotchi.entite.nourriture.I_Nourriture;
import tamagotchi.exception.IllegalEnergyException;
import tamagotchi.exception.IllegalFunException;
import tamagotchi.observateur.I_Tamagotchi_Observateur;

public class TamagotchiNormal extends Tamagotchi
{

	public TamagotchiNormal(String name) 
	{
		super(name);
	}

	@Override
	public void mange(I_Nourriture nourriture) throws IllegalEnergyException, IllegalFunException 
	{
		int energieValue = nourriture.getEnergyValue();
		int funValue = nourriture.getFunValue();
		
		if(energieValue<0) this.reduceEnergy(energieValue*-1);
		else this.augmentEnergy(energieValue);
		if(funValue<0)this.reduceFun(funValue*-1);
		else this.augmentFun(funValue);
	}

	@Override
	public void joue() 
	{
		try {
			this.augmentFun(1);
		} catch (IllegalFunException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void ennuie()
	{
		try {
			this.reduceFun(1);
		} catch (IllegalFunException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void faim()
	{
		try {
			this.reduceEnergy(1);
		} catch (IllegalEnergyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean is_happy()
	{
		boolean beaucoup_energie = this.getEnergy()>=this.getMaxEnergy()/2;
		boolean beaucoup_fun = this.getFun()>=this.getMaxFun()/2;
		return beaucoup_energie && beaucoup_fun;
	}

}
