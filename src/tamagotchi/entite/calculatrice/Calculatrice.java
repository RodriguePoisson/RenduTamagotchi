package tamagotchi.entite.calculatrice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Calculatrice implements I_Calculatrice
{
	
	private int result;
	private List<String> list_operateur;
	private int nb_1;
	private int nb_2;
	private String op;
	
	public Calculatrice()
	{
		this.list_operateur = new ArrayList<String>();
		this.list_operateur.add("+");
		this.list_operateur.add("-");
		this.list_operateur.add("*");
	}
	
	@Override
	public  boolean verif(int nombre_donne)
	{
		return nombre_donne == this.result;
	}

	//cree un resultat en faisant des nombres aléatoire et des opérateurs aléatoires
	public void createResult()
	{
		Collections.shuffle(this.list_operateur);
		this.op = this.list_operateur.get(0);
		
		Random random = new Random();
		int nb1 = random.nextInt(10000);
		int nb2 = random.nextInt(10000);
		
		int nb1Mult = random.nextInt(21);
		int nb2Mult = random.nextInt(21);
		
		if(this.op.equals("+"))
		{
			this.nb_1 = nb1;
			this.nb_2 = nb2;
			this.result = nb1+nb2;
		}
		else if(this.op.equals("-"))
		{
			this.nb_1 = nb1;
			this.nb_2 = nb2;
			this.result = nb1-nb2;
		}
		else if(this.op.equals("*"))
		{
			this.nb_1 = nb1Mult;
			this.nb_2 = nb2Mult;
			this.result = nb1Mult*nb2Mult;
		}
		
	}
	
	//affiche sous forme : " 2154 + 9874 "
	public String toString()
	{
		return String.valueOf(this.nb_1)+"  "+this.op+"  "+String.valueOf(this.nb_2);
	}
	

}
