package tamagotchi.entite.joueur;

import java.util.List;

import tamagotchi.entite.nourriture.I_Nourriture;
import tamagotchi.observateur.I_Joueur_Observateur;

public interface I_Joueur 
{
	public abstract int getArgent();
	public abstract void ajouteArgent(int argent);
	public abstract void retireArgent(int argent);
	
	public abstract boolean canBuy(int argent);
	
	public abstract List<I_Nourriture> getInventaire();
	public abstract void addNourritureToInventaire(I_Nourriture nourriture);
	
	public abstract void addObservateur(I_Joueur_Observateur observateur);
	
	public abstract String getName();
}
