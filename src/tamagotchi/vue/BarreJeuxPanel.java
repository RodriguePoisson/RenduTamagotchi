package tamagotchi.vue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.plaf.DimensionUIResource;

import tamagotchi.controller.CentralController;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class BarreJeuxPanel extends JPanel implements ActionListener
{
	private JButton btn_inventaire,btn_verif_calcul,btn_fin_partie;
	private JLabel label_calcul,label_erreur_calcul;
	private CentralController centralController;
	private JTextArea champ_result;

	public BarreJeuxPanel(CentralController centralController)
	{
		this.centralController = centralController;
		this.btn_inventaire = new JButton("Inventaire");
		this.btn_inventaire.addActionListener(this);
		this.btn_verif_calcul = new JButton("Vérifier le calcul");
		this.btn_verif_calcul.addActionListener(this);
		this.btn_fin_partie = new JButton("Finir la partie");
		this.btn_fin_partie.addActionListener(this);
		this.champ_result = new JTextArea();
		this.champ_result.setPreferredSize(new Dimension(50,20));
		this.label_erreur_calcul = new JLabel();
		this.label_calcul = new JLabel(this.centralController.getCalcul()+" : ");
		add(this.label_erreur_calcul);
		add(this.label_calcul);
		add(this.champ_result);
		add(this.btn_verif_calcul);
		add(this.btn_inventaire);
		add(this.btn_fin_partie);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//OUVRE L'INVENTAIRE DU JOUEUR
		if(e.getSource()==this.btn_inventaire)
		{
			new InventaireFenetre(this.centralController);
		}
		
		//verifie le calcul si vrai appelle la fonction recompense tamagotchi du controller, sinon affiche faux
		if(e.getSource()==this.btn_verif_calcul)
		{
		
			boolean est_vrai;
			try
			{
				
				est_vrai = this.centralController.verifCalcul(Integer.parseInt(this.champ_result.getText()));
				if(est_vrai)
				{
					this.centralController.nouveauCalcul();
					this.label_calcul.setText(this.centralController.getCalcul());
					this.label_erreur_calcul.setText("");
					this.centralController.recompenseTama();
				}
				else
				{
					this.label_erreur_calcul.setText("FAUX");
				}
	
			}catch(NumberFormatException e1)
			{
				JOptionPane.showMessageDialog(null, "VEUILLEZ RENTRER UN NOMBRE VALIDE","ERREUR", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		//Met fin à la partie et regarde dans les properties du projet si le record a été battu
		if(e.getSource()==this.btn_fin_partie)
		{
			String propertiesFileLocation = "myPropertiesFin.properties";
			Properties prop = new Properties();
			try
			{
				
				//prop.setProperty("record", propertiesFileLocation);
				InputStream in = new FileInputStream(propertiesFileLocation);
				prop.load(in);
				System.out.println(prop.getProperty("record"));
				if(prop.getProperty("record") != null)
				{
					int record = Integer.parseInt(prop.getProperty("record"));
					System.out.println(record);
					
					if(this.centralController.getTama().getAge()>record)
					{
						JOptionPane.showMessageDialog(null, "Votre tamagotchi a atteint l'age de "+this.centralController.getTama().getAge()+" Nouveau record précédent record : "+prop.getProperty("record"),"fin de partie",JOptionPane.INFORMATION_MESSAGE);
						prop.setProperty("record",String.valueOf(this.centralController.getTama().getAge()));
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Votre tamagotchi a atteint l'age de "+this.centralController.getTama().getAge()+" Votre record est de "+prop.getProperty("record"),"fin de partie",JOptionPane.INFORMATION_MESSAGE);
						
					}
				}
				else
				{
	
					JOptionPane.showMessageDialog(null, "Votre tamagotchi a atteint l'age de "+this.centralController.getTama().getAge()+" Nouveau record","fin de partie",JOptionPane.INFORMATION_MESSAGE);
					prop.setProperty("record",String.valueOf(this.centralController.getTama().getAge()));
				}
				OutputStream out = new FileOutputStream(propertiesFileLocation);
				prop.store(out, "fin");
			}catch(IOException e1){}
			finally
			{
			
				System.exit(0);
			
			}}
	}
}
