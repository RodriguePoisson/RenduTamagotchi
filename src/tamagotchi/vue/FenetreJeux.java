package tamagotchi.vue;

import java.awt.Container;  
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Color;

import tamagotchi.controller.CentralController;
import tamagotchi.entite.joueur.I_Joueur;
import tamagotchi.entite.nourriture.I_Nourriture;
import tamagotchi.entite.tamagotchi.I_Tamagotchi;
import tamagotchi.observateur.I_GenerationNourritureObservateur;
import tamagotchi.observateur.I_Joueur_Observateur;
import tamagotchi.observateur.I_Tamagotchi_Observateur;


public class FenetreJeux extends JFrame implements I_Tamagotchi_Observateur,I_Joueur_Observateur,I_GenerationNourritureObservateur,Runnable
{

	private CentralController centralController;
	private JPanel panDessinJeux,panInfoJeux,panBoutique,panBarreJeux;
	private I_Tamagotchi tamagotchi;
	private I_Joueur joueur;
	private Container contentPane;

	public FenetreJeux(CentralController centralController)
	{
		this.centralController = centralController;
	}
	
	@Override
	public void run() 
	{
		
		this.centralController.addGenerationObservateur(this);
		this.tamagotchi = this.centralController.getTama();
		this.tamagotchi.addObservateur(this);
		this.joueur = this.centralController.getJoueur();
		this.joueur.addObservateur(this);
		setTitle("Tamagotchi");

		this.contentPane = getContentPane();
	
		this.panInfoJeux = new InfoPartiePanel(this.tamagotchi);
		
		this.panDessinJeux = new TamagochiDessin(this.tamagotchi);
		
		this.panBoutique = new BoutiquePanel(this.joueur, this.centralController);
		
		
		this.panBarreJeux = new BarreJeuxPanel(this.centralController);
		
		
		
	
		this.contentPane.add(this.panBoutique,"East");
		this.contentPane.add(this.panDessinJeux,"Center");
		this.contentPane.add(this.panInfoJeux,"North");
		this.contentPane.add(this.panBarreJeux,"South");
		pack();
		
		
		
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	@Override
	public void est_mis_a_jour(I_Tamagotchi tamagotchi) 
	{
		this.contentPane.remove(this.panInfoJeux);

		this.panInfoJeux = new InfoPartiePanel(tamagotchi);
		
		this.contentPane.add(this.panInfoJeux,"North");

		this.contentPane.validate();
		this.contentPane.repaint();
		
		
	}
	@Override
	public void nourritureGenere(I_Nourriture nourriture) 
	{
		this.contentPane.remove(this.panBoutique);
		
		this.panBoutique = new BoutiquePanel(this.joueur,nourriture,this.centralController);
		
		
		this.contentPane.add(this.panBoutique,"East");
		this.contentPane.validate();
		this.contentPane.repaint();
	}
	@Override
	public void joueur_mis_a_jour(I_Joueur joueur) 
	{
		this.contentPane.remove(this.panBoutique);
		this.panBoutique = new BoutiquePanel(joueur,this.centralController);
		
		this.contentPane.add(this.panBoutique,"East");
		
		this.contentPane.validate();
		this.contentPane.repaint();
	}
}



