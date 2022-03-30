package tamagotchi.entite.nourriture.legume;

public class HarricotVert extends Legume
{
	private int energyValue;
	private int price;
	public HarricotVert() 
	{
		super();
		this.energyValue = 7;
		this.price = 180;
	}
	@Override
	public int getEnergyValue() 
	{
		return 10;
	}
	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}
	
	public String toString()
	{
		return "Haricot Vert";
	}

}
