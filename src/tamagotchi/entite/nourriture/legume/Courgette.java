package tamagotchi.entite.nourriture.legume;

public class Courgette extends Legume
{
	private int price;
	private int energyValue;
	public Courgette()
	{
		super();
		this.energyValue = 36;
		this.price = 14;
	}
	@Override
	public int getEnergyValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}
	
	public String toString()
	{
		return "Courgette";
	}

}
