package tamagotchi.entite.tamagotchi;

import java.util.ArrayList;
import java.util.List;

import tamagotchi.exception.IllegalAgeException;
import tamagotchi.exception.IllegalEnergyException;
import tamagotchi.exception.IllegalFunException;
import tamagotchi.observateur.I_Tamagotchi_Observateur;

public abstract class Tamagotchi implements I_Tamagotchi 
{
	private List<I_Tamagotchi_Observateur> observateurs;
	
	private int fun;
	private int max_fun;
	
	private int energy;
	private int max_energy;
	
	private int age;
	private String name;
	
	public Tamagotchi(String name)
	{
		this.name = name;
		this.observateurs = new ArrayList<I_Tamagotchi_Observateur>();
	}

	@Override
	public int getFun() 
	{
		return this.fun;
	}

	@Override
	public void setFun(int fun) throws IllegalFunException
	{

		if(fun>this.max_fun || fun<0)
		{
			throw new IllegalFunException("Le fun indiqué n'est pas correcte");
		}
		else
		{
			this.fun = fun;
		}
		this.alert_observateur();
	}
	
	@Override
	public int getMaxFun()
	{
		return this.max_fun;
	}
	
	@Override
	public int getMaxEnergy()
	{
		return this.max_energy;
	}

	@Override
	public void augmentEnergy(int energy) throws IllegalEnergyException
	{
		if(energy<=0)
		{
			throw new IllegalEnergyException("Ne pas augmenter l'energie avec un chiffre négatif");
		}
		else if(!(this.energy+energy>max_energy))
		{
			this.energy += energy;
		}
		else
		{
			this.energy = this.max_energy;
		}
		this.alert_observateur();
		
	}
	@Override
	public void setEnergy(int energy) throws IllegalEnergyException 
	{
		if(energy>this.max_energy || energy<0)
		{
			throw new IllegalEnergyException("l'energy indiqué n'est pas correcte");
		}
		else
		{			
			this.energy = energy;
		}
		this.alert_observateur();
	}

	@Override
	public int getEnergy() 
	{

		return this.energy;
	}

	@Override
	public int getAge()
	{
		return this.age;
	}

	@Override
	public void augmentAge(int age) throws IllegalAgeException 
	{
		if(age>0)
		{			
			this.age+=age;
		}
		else
		{
			throw new IllegalAgeException("Ne pas augmenter l'âge avec un chiffre négatif");
		}
		this.alert_observateur();
	}
	
	@Override
	public void setAge(int age) throws IllegalAgeException
	{
		if(age<0)
		{
			throw new IllegalAgeException("L'âge n'est pas correcte");
		}
		else
		{
			this.age = age;
		}
		this.alert_observateur();

	}

	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public boolean isAlive()
	{
		boolean a_assez_energie = this.energy>0;
		boolean a_assez_fun = this.fun>0;
		
		return a_assez_energie && a_assez_fun;
	}
	

	// Un tamagotchi vieillit seulement de 1 ans à chaque fois.
	@Override
	public void vieillit() throws IllegalAgeException
	{
		
			this.augmentAge(1);
		

	}

	@Override
	public void augmentFun(int fun) throws IllegalFunException {
		if(fun<=0)
		{
			throw new IllegalFunException("Ne pas augmenter le fun avec un chiffre négatif");
		}
		else if(fun+this.fun<=this.max_fun)
		{
			this.fun+=fun;
		}
		else
		{
			this.fun = this.max_fun;
		}
		this.alert_observateur();
		
	}

	@Override
	public void setFunMax(int fun) throws IllegalFunException {
		
		if(fun>this.getFun())
		{
			this.max_fun = fun;
		}
		else
		{
			throw new IllegalFunException("Le fun maximal ne peut pas être inférieur au fun du tamagotchi");
		}
		this.alert_observateur();
		
	}

	@Override
	public void setEnergyMax(int energy) throws IllegalEnergyException {
		if(energy> this.getEnergy())
		{
			this.max_energy = energy;
		}
		else
		{
			throw new IllegalEnergyException("L'energie maximale ne peut pas être inférieur à l'énergie du tamagotchi");
		}
		this.alert_observateur();
		
	}

	@Override
	public void reduceFun(int fun) throws IllegalFunException 
	{
		if(fun<=0)
		{
			throw new IllegalFunException("Ne pas réduire le fun avec un chiffre négatif");
		}
		else if(this.fun-fun>=0)
		{
			this.fun-= fun;
		}
		else
		{
			this.fun=0;
		}
		this.alert_observateur();
			
		
	}

	@Override
	public void reduceEnergy(int energy) throws IllegalEnergyException {
		if(energy<=0)
		{
			throw new IllegalEnergyException("Ne pas réduire l'énergie avec un chiffre négatif");
		}
		else if(this.energy-energy>=0)
		{
			this.energy -= energy;
		}
		else
		{
			this.energy = 0;
		}
		
		this.alert_observateur();
		
	}
	
	//Patern observateur voir classe Joueur pour plus d'information.
	@Override
	public void addObservateur(I_Tamagotchi_Observateur observateur) 
	{
		this.observateurs.add(observateur);
		
	}
	
	protected void alert_observateur()
	{
		for(I_Tamagotchi_Observateur obs : this.observateurs)
		{
			obs.est_mis_a_jour(this);
		}
	}


	

}
