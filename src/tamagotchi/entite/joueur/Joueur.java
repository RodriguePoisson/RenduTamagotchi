package tamagotchi.entite.joueur;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tamagotchi.entite.nourriture.I_Nourriture;
import tamagotchi.observateur.I_Joueur_Observateur;

public class Joueur implements I_Joueur
{
	private int argent;
	private List<I_Nourriture> inventaire;
	private List<I_Joueur_Observateur> observateurs; 
	private String name;

	
	public Joueur(String name,int argent)
	{
		this.observateurs = new ArrayList<I_Joueur_Observateur>();
		this.name = name;
		this.argent = argent;
		this.inventaire = new LinkedList<I_Nourriture>();
	}
	@Override
	public int getArgent() 
	{
		// TODO Auto-generated method stub
		return this.argent;
	}

	@Override
	public List<I_Nourriture> getInventaire() 
	{
		// TODO Auto-generated method stub
		return this.inventaire;
	}

	@Override
	public void addNourritureToInventaire(I_Nourriture nourriture) 
	{
		this.inventaire.add(nourriture);
		
	}

	@Override
	public String getName() 
	{
		// TODO Auto-generated method stub
		return this.name;
	}
	@Override
	public void ajouteArgent(int argent) {
		this.argent += argent;
		this.alertObservateursArgent();
		
	}
	@Override
	public void retireArgent(int argent) {
		this.argent -= argent;
		this.alertObservateursArgent();
		
	}
	
	//Regarde si il y a assez d'argent.
	@Override
	public boolean canBuy(int argent) {
		// TODO Auto-generated method stub
		return this.argent>=argent;
	}
	
	//Observateur ajouté pour écouter quand certaines actions sont effectués (utilisé par les fenetres)
	@Override
	public void addObservateur(I_Joueur_Observateur observateur)
	{
		this.observateurs.add(observateur);
		
	}
	
	//Alerte les observateurs
	private void alertObservateursArgent()
	{
		for(I_Joueur_Observateur observateur : this.observateurs)
		{
			observateur.joueur_mis_a_jour(this);
		}
	}
	
	

}
