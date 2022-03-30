package tamagotchi.entite.nourriture.legume;

public class Aubergine extends Legume 
{
	private int price;
	private int energyValue;
	
	public Aubergine()
	{
		super();
		this.price = 600;
		this.energyValue = 26;
	}
	
	@Override
	public int getEnergyValue() {
		return this.energyValue;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}
	public String toString()
	{
		return "Aubergine";
	}

}
