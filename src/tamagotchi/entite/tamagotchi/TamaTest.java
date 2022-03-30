package tamagotchi.entite.tamagotchi;

import static org.junit.jupiter.api.Assertions.* ;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import tamagotchi.entite.tamagotchi.TamagotchiNormal;
import tamagotchi.exception.IllegalAgeException;
import tamagotchi.exception.IllegalEnergyException;
import tamagotchi.exception.IllegalFunException;

public class TamaTest {
	
	I_Tamagotchi tama;

	@Test
	public void augmenteEnergyAvecEnergyAuMax()
	{
		tama = new TamagotchiNormal("tamaTest");
		try {
			tama.setEnergyMax(10);
			tama.setEnergy(10);
			tama.augmentEnergy(1);
			
		} catch (IllegalEnergyException e)
		{
			e.printStackTrace();
		}
		
		assertEquals(tama.getEnergy(), 10);	
	}
	
	@Test
	public void augmenteEnergy()
	{
		tama = new TamagotchiNormal("tamaTest");
		try {
			tama.setEnergyMax(10);
			tama.setEnergy(7);
			
			tama.augmentEnergy(1);
		} catch (IllegalEnergyException e)
		{
			e.printStackTrace();
		}
		
		assertEquals(tama.getEnergy(), 8);	
	}
	
	@Test
	public void augmenteEnergySuperieurAMax()
	{
		tama = new TamagotchiNormal("tamaTest");
		try {
			tama.setEnergyMax(10);
			tama.setEnergy(7);
			
			tama.augmentEnergy(5);
		} catch (IllegalEnergyException e)
		{
			e.printStackTrace();
		}
		
		assertEquals(tama.getEnergy(),10);
	}
	
	@Test
	public void augmenteEnergyAvecNegatif()
	{
		tama = new TamagotchiNormal("tamaTest");
		String message = null;
		try
		{
			tama.setEnergyMax(20);
			tama.setEnergy(15);
			tama.augmentEnergy(-4);
		}catch (IllegalEnergyException e)
		{
			message = e.getMessage();
		}
		
		assertTrue(message.equals("Ne pas augmenter l'energie avec un chiffre négatif"));
	}
	@Test
	public void reduceEnergy()
	{
		tama = new TamagotchiNormal("tamaTest");
		
		try {
			tama.setEnergyMax(10);
			tama.setEnergy(5);
			tama.reduceEnergy(1);
			
		} catch (IllegalEnergyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(tama.getEnergy(),4);
		
	}
	
	@Test
	public void reduceEnergyInferieurA0()
	{
		tama = new TamagotchiNormal("tamaTest");
			
		try {
			tama.setEnergyMax(10);
			tama.setEnergy(5);
			tama.reduceEnergy(8);
			
		} catch (IllegalEnergyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(tama.getEnergy(),0);
	}
	
	@Test
	public void reduceEnergyAvecChiffreNegatif()
	{
		tama = new TamagotchiNormal("tamaTest");
		String message = null;
		
		try {
			tama.setEnergyMax(10);
			tama.setEnergy(5);
			tama.reduceEnergy(-69);
			
		} catch (IllegalEnergyException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		assertTrue(message.equals("Ne pas réduire l'énergie avec un chiffre négatif"));
	}
	@Test
	public void reduceEnergyMoins0()
	{
		tama = new TamagotchiNormal("tamaTest");
		
		try {
			tama.setEnergyMax(10);
			tama.setEnergy(0);
			tama.reduceEnergy(1);
			
			assertEquals(tama.getEnergy(), 0);
		} catch (IllegalEnergyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void setAgeA20()
	{
		tama = new TamagotchiNormal("tamaTest");
		try {
			tama.setAge(20);
			assertEquals(tama.getAge(), 20);
		} catch (IllegalAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void setAgeAMoins20()
	{
		String message = null;
		tama = new TamagotchiNormal("tamaTest");
		try {
			tama.setAge(-20);
			
		} catch (IllegalAgeException e) {
			
			message = e.getMessage();
		}
		assertTrue(message.equals("L'âge n'est pas correcte"));
	}
	
	@Test
	public void augmenteAgeAgeDe20a21()
	{
		tama = new TamagotchiNormal("tamaTest");
		
		try {
			
			tama.setAge(20);
			tama.augmentAge(1);
		} catch (IllegalAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(tama.getAge(),21);
	}
	
	@Test
	public void augmenteAgeAvecChiffreNegatif()
	{
		tama = new TamagotchiNormal("tamaTest");
		String message = null;
		try {
			tama.setAge(20);
			tama.augmentAge(-5);
		} catch (IllegalAgeException e) 
		{
			message = e.getMessage();
		}	
		
		assertTrue(message.equals("Ne pas augmenter l'âge avec un chiffre négatif"));
	}
	
	@Test
	public void setEnergyA20AvecMaxA30()
	{
		tama = new TamagotchiNormal("tamaTest");
		
		try {
			tama.setEnergyMax(30);
			tama.setEnergy(20);
			assertEquals(tama.getEnergy(),20);
		} catch (IllegalEnergyException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void setEnergyA30AvecMaxA20()
	{
		tama = new TamagotchiNormal("tamaTest");
		String message = null;
		
		try {
			tama.setEnergyMax(20);
			tama.setEnergy(30);
		} catch (IllegalEnergyException e) {
			 message=e.getMessage();
		}
		
		assertTrue(message.equals("l'energy indiqué n'est pas correcte"));
		
	}
	@Test
	public void setEnergyAMoins5()
	{
		tama = new TamagotchiNormal("tamaTest");
		String message = null;
		
		try {
			tama.setEnergyMax(20);
			tama.setEnergy(-5);
		} catch (IllegalEnergyException e) {
			 message=e.getMessage();
		}
		
		assertTrue(message.equals("l'energy indiqué n'est pas correcte"));
		
	}
	
	@Test
	public void setMaxEnergieInferieurAEnergie()
	{
		tama = new TamagotchiNormal("tamaTest");
		String message = null;
		
		try {
			
			tama.setEnergyMax(20);
			tama.setEnergy(15);
			tama.setEnergyMax(14);
			
		} catch (IllegalEnergyException e) {
			 message=e.getMessage();
		}
		
		assertTrue(message.equals("L'energie maximale ne peut pas être inférieur à l'énergie du tamagotchi"));
		
	}
	
	@Test
	public void setFunA20AvecMaxA30()
	{
		tama = new TamagotchiNormal("tamaTest");
		
		try {
			tama.setFunMax(30);
			tama.setFun(20);
		
		} catch (IllegalFunException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(tama.getFun(),20);
	}
	
	@Test
	public void setFunA30AvecMaxA20()
	{
		tama = new TamagotchiNormal("tamaTest");
		String message = null;
		
		try {
			tama.setFunMax(20);
			tama.setFun(30);
		} catch (IllegalFunException e) {
			 message=e.getMessage();
		}
		
		assertTrue(message.equals("Le fun indiqué n'est pas correcte"));
		
	}
	@Test
	public void setFunAMoins5()
	{
		tama = new TamagotchiNormal("tamaTest");
		String message = null;
		
		try {
			tama.setFunMax(20);
			tama.setFun(-5);
		} catch (IllegalFunException e) {
			 message=e.getMessage();
		}
		
		assertTrue(message.equals("Le fun indiqué n'est pas correcte"));
		
	}
	
	@Test
	public void augmenteFunAvecChiffreNegatif()
	{
		tama = new TamagotchiNormal("tamaTest");
		String message = null;
		
		try {
			tama.setFunMax(30);
			tama.setFun(20);
			tama.augmentFun(-4);
		}catch(IllegalFunException e)
		{
			message = e.getMessage();
		}
		assertTrue(message.equals("Ne pas augmenter le fun avec un chiffre négatif"));
	}
	
	@Test
	public void setMaxFunInferieurAFun()
	{
		tama = new TamagotchiNormal("tamaTest");
		String message = null;
		
		try {
			
			tama.setFunMax(20);
			tama.setFun(15);
			tama.setFunMax(14);
			
		} catch (IllegalFunException e) {
			 message=e.getMessage();
		}
		
		assertTrue(message.equals("Le fun maximal ne peut pas être inférieur au fun du tamagotchi"));
	}
	
	@Test
	public void augmenteFunInferieurAuMax()
	{
		tama = new TamagotchiNormal("tamaTest");
		try {
			tama.setFunMax(30);
			tama.setFun(20);
			tama.augmentFun(2);
		} catch (IllegalFunException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(tama.getFun(),22);
	}
	
	@Test
	public void augmenteFunSUperieurAuMax()
	{
		tama = new TamagotchiNormal("tamaTest");
		
		try {
			tama.setFunMax(30);
			tama.setFun(24);
			tama.augmentFun(8);
		} catch (IllegalFunException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(tama.getFun(),30);
	}
	
	@Test
	public void reduitFunInferieurA0()
	{
		tama = new TamagotchiNormal("tamaTest");
		
		try {
			tama.setFunMax(30);
			tama.setFun(5);
			tama.reduceFun(8);
		} catch (IllegalFunException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(tama.getFun(),0);
	}
	
	@Test
	public void reduitFun()
	{
		tama = new TamagotchiNormal("tamaTest");
		
		try {
			tama.setFunMax(30);
			tama.setFun(20);
			tama.reduceFun(8);
		} catch (IllegalFunException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(tama.getFun(),12);
	}
	
	@Test
	public void energieA0EstMort()
	{
		tama = new TamagotchiNormal("tamaTest");
		
		try {
			tama.setEnergyMax(30);
			tama.setEnergy(20);
			tama.reduceEnergy(34);
			tama.setFunMax(30);
			tama.setFun(20);
		} catch (IllegalEnergyException | IllegalFunException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(tama.isAlive());
	}
	@Test
	public void energieEtFybSupperieurA0EstVivant()
	{
		tama = new TamagotchiNormal("tamaTest");
		
		try {
			tama.setEnergyMax(30);
			tama.setEnergy(28);
			tama.setFunMax(30);
			tama.setFun(20);
			
		} catch (IllegalEnergyException | IllegalFunException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(tama.isAlive());
	}
	
	@Test
	public void funA0EstMort()
	{
		tama = new TamagotchiNormal("tamaTest");
		
		try {
			tama.setEnergyMax(30);
			tama.setEnergy(20);
			tama.setFunMax(30);
			tama.setFun(20);
			tama.reduceFun(21);
		} catch (IllegalEnergyException | IllegalFunException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(tama.isAlive());
	}
	
	@Test
	public void ageA20Vieillit()
	{
		tama = new TamagotchiNormal("tamaTest");
		
		try {
			tama.setAge(20);
			tama.vieillit();
			
			assertEquals(tama.getAge(),21);
		} catch (IllegalAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void ageA20Vieillit2Fois()
	{
		tama = new TamagotchiNormal("tamaTest");
		
		try {
			tama.setAge(20);
			tama.vieillit();
			tama.vieillit();
			
			assertEquals(tama.getAge(),22);
		} catch (IllegalAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
/*	@Test
	public void manger() throws IllegalEnergyException
	{
		tama = new TamagotchiNormal("tamaTest");
		tama.setEnergyMax(30);
		tama.setEnergy(20);
	
		tama.mange();
		
		assertEquals(tama.getEnergy(),21);
	}
	@Test
	public void manger2fois() throws IllegalEnergyException
	{
		tama = new TamagotchiNormal("tamaTest");
		tama.setEnergyMax(30);
		tama.setEnergy(20);
	
		tama.mange();
		tama.mange();
		
		assertEquals(tama.getEnergy(),22);
	}*/
	
	@Test
	public void ennuie() throws IllegalFunException
	{
		tama = new TamagotchiNormal("tamaTest");
		tama.setFunMax(30);
		tama.setFun(20);
	
		tama.ennuie();

		
		assertEquals(tama.getFun(),19);
	}
	
	@Test
	public void ennuie2Fois() throws IllegalFunException
	{
		tama = new TamagotchiNormal("tamaTest");
		tama.setFunMax(30);
		tama.setFun(20);
	
		tama.ennuie();
		tama.ennuie();

		
		assertEquals(tama.getFun(),18);
	}
	
	@Test
	public void joue() throws IllegalFunException
	{
		tama = new TamagotchiNormal("tamaTest");
		
		tama.setFunMax(30);
		tama.setFun(20);
		tama.joue();
		
		assertEquals(tama.getFun(),21);
	}
	
	@Test
	public void joue2Fois() throws IllegalFunException
	{
		tama = new TamagotchiNormal("tamaTest");
		
		tama.setFunMax(30);
		tama.setFun(20);
		tama.joue();
		tama.joue();
		
		assertEquals(tama.getFun(),22);
	}
	
	@Test
	public void faim() throws IllegalEnergyException
	{
		tama = new TamagotchiNormal("tamaTest");
		
		tama.setEnergyMax(30);
		tama.setEnergy(20);
		tama.faim();
		
		assertEquals(tama.getEnergy(),19);
	}
	
	@Test
	public void faim2Fois() throws IllegalEnergyException
	{
		tama = new TamagotchiNormal("tamaTest");
		
		tama.setEnergyMax(30);
		tama.setEnergy(20);
		tama.faim();
		tama.faim();
		
		assertEquals(tama.getEnergy(),18);
	}
	
	
	

}
