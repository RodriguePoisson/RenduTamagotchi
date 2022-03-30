package tamagotchi.observateur;

import tamagotchi.entite.joueur.I_Joueur;

public interface I_Joueur_Observateur 
{
	public abstract void joueur_mis_a_jour(I_Joueur joueur);
}
