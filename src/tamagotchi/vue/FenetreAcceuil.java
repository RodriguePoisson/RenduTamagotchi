package tamagotchi.vue;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import tamagotchi.controller.CentralController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class FenetreAcceuil extends JFrame implements ActionListener
{
	private JLabel energieMax,funMax,dureeVieillissement,nomTama;
	private JTextField f_energie_max,f_fun_max, f_duree_vieillissement,f_nom;
	private Properties myProp;
	private CentralController centralController;
	public FenetreAcceuil(Properties myProp)
	{
		this.centralController = new CentralController();
		this.myProp = myProp;
		
		this.energieMax = new JLabel("Energie max :");
		this.funMax = new JLabel("Fun max :");
		this.dureeVieillissement = new JLabel("Duree vieillissement (en seconde) :");
		this.nomTama = new JLabel("Nom du Tamagotchi");
		
		
		this.f_energie_max = new JTextField(10);
		this.f_fun_max = new JTextField(10);
		this.f_duree_vieillissement = new JTextField(10);
		this.f_nom = new JTextField(10);
		
		if(myProp != null)
		{
			f_energie_max.setText(myProp.get("energy_max").toString());
			f_fun_max.setText(myProp.get("fun_max").toString());
			f_duree_vieillissement.setText(myProp.get("vieillissement").toString());
			f_nom.setText(myProp.get("nom").toString());
		}
		else
		{
			this.myProp = new Properties();
		}
		
		Container contentPane = getContentPane();
		setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		JPanel panEnergie = new JPanel();
		JPanel panFun = new JPanel();
		JPanel panAge = new JPanel();
		JPanel panNom = new JPanel();
		
		panNom.add(this.nomTama);
		panNom.add(this.f_nom);
		
		panEnergie.add(this.energieMax);
		panEnergie.add(this.f_energie_max);
		
		panFun.add(this.funMax);
		panFun.add(this.f_fun_max);
		
		panAge.add(this.dureeVieillissement);
		panAge.add(this.f_duree_vieillissement);
		
		JButton bouton = new JButton("Lancez partie");
		bouton.addActionListener(this);

		contentPane.add(panNom);
		contentPane.add(panEnergie);
		contentPane.add(panFun);
		contentPane.add(panAge);
		contentPane.add(bouton);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) throws InterruptedException 
	{
		Properties myProp = new Properties();
		String propertiesFileLocation = "myProperties.properties";
		InputStream in=null;
		try
		{
			in = new FileInputStream(propertiesFileLocation);
			myProp.load(in);
			
		}catch(IOException e)
		{
			myProp = null;
		}finally {try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		new FenetreAcceuil(myProp);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{

		String propertiesFileLocation = "myProperties.properties";
		

		
		myProp.setProperty("energy_max", this.f_energie_max.getText());
		myProp.setProperty("fun_max", this.f_fun_max.getText());
		myProp.setProperty("vieillissement", this.f_duree_vieillissement.getText());
		myProp.setProperty("nom", this.f_nom.getText());
		
		try
		{
			OutputStream out = new FileOutputStream(propertiesFileLocation);
			myProp.store(out,"propriété de lancement");
			this.centralController.initialiseJeux(myProp);
			SwingUtilities.invokeLater(new FenetreJeux(this.centralController));
			out.close();
		}catch(IOException e1)
		{

		}
		
		
	}
}
