package tamagotchi.entite.tamagotchi;

import tamagotchi.entite.nourriture.I_Nourriture;
import tamagotchi.exception.IllegalAgeException;
import tamagotchi.exception.IllegalEnergyException;
import tamagotchi.exception.IllegalFunException;
import tamagotchi.observateur.I_Tamagotchi_Observateur;

public interface I_Tamagotchi
{
	public abstract int getFun();
	public abstract void setFun(int fun) throws IllegalFunException;
	public abstract void augmentFun(int fun) throws IllegalFunException; 
	public abstract void setFunMax(int fun) throws IllegalFunException;
	public abstract void reduceFun(int fun) throws IllegalFunException;
	public abstract int getMaxFun();
	
	public abstract void setEnergy(int energy) throws IllegalEnergyException;
	public abstract void augmentEnergy(int energy)throws NumberFormatException, IllegalEnergyException;
	public abstract int getEnergy();
	public abstract void setEnergyMax(int energy) throws IllegalEnergyException;
	public abstract void reduceEnergy(int energy) throws IllegalEnergyException;
	public abstract int getMaxEnergy();
	
	public abstract int getAge();
	public abstract void augmentAge(int age) throws IllegalAgeException;
	public abstract void setAge(int age)throws IllegalAgeException;
	
	public abstract String getName();
	
	public abstract boolean isAlive();
	
	public abstract void mange(I_Nourriture nourriture) throws IllegalEnergyException, IllegalFunException;
	public abstract void joue();
	public abstract void ennuie();
	public abstract void faim();
	public abstract void vieillit() throws IllegalAgeException;
	
	public abstract boolean is_happy();
	
	public abstract String toString();
	
	public abstract void addObservateur(I_Tamagotchi_Observateur observateur);
	
	
}
