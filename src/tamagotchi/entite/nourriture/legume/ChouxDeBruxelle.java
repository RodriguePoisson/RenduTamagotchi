package tamagotchi.entite.nourriture.legume;

public class ChouxDeBruxelle extends Legume
{
	private int energyValue;
	private int price;
	
	public ChouxDeBruxelle()
	{
		super();
		this.energyValue = 21;
		this.price = 390;
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
		return "Choux de bruxelle";
	}
}
