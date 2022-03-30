package tamagotchi.entite.tamagotchi;

public class FactoryTamagotchi implements I_Factory_Tamagotchi 
{
	public FactoryTamagotchi()
	{
		
	}
	@Override
	public I_Tamagotchi getTamagotchi(String name) 
	{
		
		return new TamagotchiNormal(name);
	}

}
