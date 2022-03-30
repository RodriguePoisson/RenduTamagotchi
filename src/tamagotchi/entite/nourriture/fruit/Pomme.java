package tamagotchi.entite.nourriture.fruit;

public class Pomme extends Fruit
{
	private int energyValue;
	private int price;
	
	public Pomme()
	{
		super();
		this.energyValue = 6;
		this.price = 300;
	}

	@Override
	public int getEnergyValue() {
		
		return this.energyValue;
	}

	@Override
	public int getPrice() {
		
		return this.price;
	}
	
	public String toString()
	{
		return "Pomme";
	}
}
