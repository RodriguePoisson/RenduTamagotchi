package tamagotchi.vue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tamagotchi.controller.CentralController;
import tamagotchi.entite.nourriture.I_Nourriture;
import tamagotchi.exception.IllegalEnergyException;
import tamagotchi.exception.IllegalFunException;

public class InventaireFenetre extends JFrame implements ActionListener
{
	private CentralController centralController;
	private List<I_Nourriture> inventaire;
	private Container contentPane;
	private Map<JButton,I_Nourriture> buttonToNourriture;
	private JPanel panInventaire;
	public InventaireFenetre(CentralController centralController)
	{
		this.buttonToNourriture = new HashMap<JButton,I_Nourriture>();
		this.contentPane = this.getContentPane();
		this.centralController = centralController;
		this.inventaire = this.centralController.getInventaire();
		panInventaire = new JPanel();
		for(I_Nourriture nourriture : this.inventaire)
		{
			JButton button = new JButton(nourriture.toString());
			panInventaire.add(button);
			button.addActionListener(this);
			this.buttonToNourriture.put(button, nourriture);
		}
		add(panInventaire);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600,600);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.centralController.NourriTama(this.buttonToNourriture.get(e.getSource()));
		this.panInventaire.remove((JComponent)e.getSource());
		this.panInventaire.validate();
		this.panInventaire.repaint();
		
		this.dispose();
		
	}
}
