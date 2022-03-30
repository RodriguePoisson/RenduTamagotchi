package tamagotchi.observateur;

import tamagotchi.entite.nourriture.I_Nourriture;

public interface I_GenerationNourritureObservateur 
{
	public abstract void nourritureGenere(I_Nourriture nourriture);
}
