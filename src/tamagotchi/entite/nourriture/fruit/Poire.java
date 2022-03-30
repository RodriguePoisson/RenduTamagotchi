package tamagotchi.entite.nourriture.fruit;

public class Poire extends Fruit
{
	private int price;
	private int energyValue;
	
	public Poire()
	{
		this.energyValue =3;
		this.price=260;
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
		return "Poire";
	}
}
