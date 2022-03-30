package tamagotchi.observateur;

import tamagotchi.entite.joueur.I_Joueur;
import tamagotchi.entite.tamagotchi.I_Tamagotchi;

public interface I_Tamagotchi_Observateur
{
	public abstract void est_mis_a_jour(I_Tamagotchi tamagotchi);

}
