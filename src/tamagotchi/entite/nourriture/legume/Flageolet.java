package tamagotchi.entite.nourriture.legume;

public class Flageolet extends Legume
{

	private int energyValue;
	private int price;
	
	public Flageolet()
	{
		super();
		this.energyValue = 5;
		this.price = 129;
	}
	@Override
	public int getEnergyValue() 
	{
		
		return this.energyValue;
	}
	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}
	
	public String toString()
	{
		return "Flageolet";
	}

}
