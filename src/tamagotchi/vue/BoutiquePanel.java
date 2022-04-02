package tamagotchi.vue;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tamagotchi.controller.CentralController;
import tamagotchi.entite.joueur.I_Joueur;
import tamagotchi.entite.nourriture.I_Nourriture;
import java.awt.event.*;

public class BoutiquePanel extends JPanel implements ActionListener
{
	
	private JLabel montant_or;
	private JButton btn_acheter;
	private I_Nourriture nourriture;
	private JPanel panObjet;
	private I_Joueur joueur;
	private CentralController centralController;

	public BoutiquePanel(I_Joueur joueur,CentralController centralController) 
	{
		this.centralController = centralController;
		this.joueur = joueur;
		this.nourriture = null;
		setBackground(Color.white);
		
		this.montant_or = new JLabel("Or : "+this.joueur.getArgent());
		this.btn_acheter = new JButton("Acheter");
		this.btn_acheter.addActionListener(this);
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.panObjet = new NourriturePanel(this.joueur);
		
		add(this.montant_or);
		add(this.panObjet);
		add(this.btn_acheter);
		setPreferredSize(new Dimension(175,100));
	}
	public BoutiquePanel(I_Joueur joueur,I_Nourriture nourriture,CentralController centralController)
	{
		this.centralController = centralController;
		this.joueur = joueur;
		this.nourriture = nourriture;
		setBackground(Color.white);
		
		this.montant_or = new JLabel("Or : "+this.joueur.getArgent());
		this.btn_acheter = new JButton("Acheter");
		this.btn_acheter.addActionListener(this);
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.panObjet = new NourriturePanel(this.joueur,this.nourriture);
		
		add(this.montant_or);
		add(this.panObjet);
		add(this.btn_acheter);
		setPreferredSize(new Dimension(175,100));
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//Traite la demande d'achat
		if(this.nourriture != null)
		{
			int price = this.nourriture.getPrice();
			if(this.joueur.canBuy(price))
			{
				this.centralController.add_nourriture(this.nourriture);
				this.centralController.acheteNourriture(this.nourriture);
				
				
				this.remove(this.panObjet);
				this.panObjet = new NourriturePanel(this.joueur);
				this.revalidate();
			}
		}
		
	}
}
