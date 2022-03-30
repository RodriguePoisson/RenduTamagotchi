package tamagotchi.entite.nourriture.fruit;

public class Mangue extends Fruit
{
	private int price;
	private int energyValue;
	
	public Mangue()
	{
		this.price = 100;
		this.energyValue = 1;
	}

	@Override
	public int getEnergyValue() {
		// TODO Auto-generated method stub
		return this.energyValue;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}
	
	public String toString()
	{
		return "Mangue";
	}
}
