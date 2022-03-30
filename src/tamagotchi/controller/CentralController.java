package tamagotchi.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import tamagotchi.entite.calculatrice.Calculatrice;
import tamagotchi.entite.calculatrice.I_Calculatrice;
import tamagotchi.entite.joueur.I_Joueur;
import tamagotchi.entite.joueur.Joueur;
import tamagotchi.entite.nourriture.*;
import tamagotchi.entite.tamagotchi.FactoryTamagotchi;
import tamagotchi.entite.tamagotchi.I_Tamagotchi;
import tamagotchi.entite.tamagotchi.TamagotchiNormal;
import tamagotchi.exception.IllegalAgeException;
import tamagotchi.exception.IllegalEnergyException;
import tamagotchi.exception.IllegalFunException;
import tamagotchi.observateur.I_GenerationNourritureObservateur;
public class CentralController 
{
	private List<I_GenerationNourritureObservateur> observateurs_generation;
	private I_Tamagotchi tamagotchi;
	private List<I_Nourriture> nourritureDansInventaire;
	private I_Joueur joueur;
	private I_Calculatrice calculatrice;
	public CentralController()
	{
		this.calculatrice = new Calculatrice();
		this.calculatrice.createResult();
		this.joueur = new Joueur("Rodrigue", 600);
		this.observateurs_generation = new ArrayList<I_GenerationNourritureObservateur>();
		this.nourritureDansInventaire = new LinkedList<I_Nourriture>();
		
		
		
	}
	
	public void addGenerationObservateur(I_GenerationNourritureObservateur observateur)
	{
		this.observateurs_generation.add(observateur);
	}
	
	public void alertGenerationObservateur(I_Nourriture nourriture)
	{
		for(I_GenerationNourritureObservateur observateurs : this.observateurs_generation)
		{
			observateurs.nourritureGenere(nourriture);
		}
	}
	
	public I_Tamagotchi getTama()
	{
		return this.tamagotchi;
	}
	
	public I_Joueur getJoueur()
	{
		return this.joueur;
	}
	
	public void add_nourriture(I_Nourriture nourriture)
	{
		this.nourritureDansInventaire.add(nourriture);
	}

	public void acheteNourriture(I_Nourriture nourriture)
	{
		this.joueur.retireArgent(nourriture.getPrice());
		
	}
	public List<I_Nourriture> getInventaire()
	{
		return this.nourritureDansInventaire;
	}

	public void NourriTama(I_Nourriture nourriture) 
	{
		try {
			System.out.println(nourriture.getEnergyValue());
			this.tamagotchi.mange(nourriture);
			this.nourritureDansInventaire.remove(nourriture);
		} catch (IllegalEnergyException | IllegalFunException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getCalcul()
	{
		return this.calculatrice.toString();
	}
	
	public boolean verifCalcul(int nombre)
	{
		return this.calculatrice.verif(nombre);
	}
	
	public void nouveauCalcul()
	{
		this.calculatrice.createResult();
	}

	public void recompenseTama()
	{
		try {
			this.tamagotchi.augmentFun(5);
		} catch (IllegalFunException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.joueur.ajouteArgent(50);
		
	}
	public void initialiseJeux(Properties properties)
	{
		FactoryTamagotchi factory_tama = new FactoryTamagotchi();
		this.tamagotchi = factory_tama.getTamagotchi(properties.getProperty("nom"));
		try {
			this.tamagotchi.setEnergyMax(Integer.parseInt(properties.get("energy_max").toString()));
			this.tamagotchi.setEnergy(this.tamagotchi.getMaxEnergy());
			this.tamagotchi.setFunMax(Integer.parseInt(properties.get("fun_max").toString()));
			this.tamagotchi.setFun(this.tamagotchi.getMaxFun());
			this.tamagotchi.setAge(1);
		} catch (IllegalEnergyException | IllegalFunException | IllegalAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NumberFormatException e2)
		{
			System.exit(0);
		}
		Thread thread_vieillisement = null;
		try
		{
			
			 thread_vieillisement = new Thread(new VieilissementController(this.tamagotchi,Integer.parseInt(properties.get("vieillissement").toString())));
		}catch(NumberFormatException e3)
		{
			System.exit(0);
		}
		GenerationNourritureController gen_controller = new GenerationNourritureController(this);
		Thread thread_generation_nourriture = new Thread(gen_controller);
		thread_generation_nourriture.start();
		thread_vieillisement.start();
	}

	
}
