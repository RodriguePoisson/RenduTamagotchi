package tamagotchi.entite.nourriture.legume;

public class Brocoli extends Legume
{
	private int energyValue;
	private int price;
	
	public Brocoli()
	{
		super();
		this.energyValue = 12;
		this.price = 287;
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
		return "Brocoli";
	}
}
