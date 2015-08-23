//Source file: H:\\Studie\\ZwartJas\\Workspace\\ZwartJas\\src\\controller\\RegistratieController.java
package controller;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;

import ui.*;
import domein.*;

/**
 * Verantwoordelijk voor het uivoeren van UseCase SpelerRegistreren
 */
public class RegistratieController {
	
	public static Speler speler;
	
	public static String naam;
	
	public static SpelersGui sg;
	
	private static Boolean add = true; // Als geboortedatum niet goed >> false

	
	
	/**
	 * @roseuid 492989BA0005
	 */
	@SuppressWarnings("static-access")
	public RegistratieController(SpelersGui sg) 
	{
		this.sg = sg;
		sg.setRegistratieController(this);
		
	} // public RegistratieController(SpelersGui sg)

	public static void zetSpeler(String naam, Calendar datum, Double saldo, Boolean meedoen) 
	{
		speler = new Speler();
		checkNaam(naam);
		checkGeboorteDatum(datum);
		checkStartSaldo(saldo);
		speler.zetMeedoenAanVolgendeRonde(meedoen);
		
		if (add) 
		{
			Bewaar();
		}
		else 
		{
			add = true;
		}
		
		zetSpelerTabel();
		
	} // public static void zetSpeler(String naam, Calendar datum, Double saldo, Boolean meedoen)

	
	
	/**
	 * @param naam
	 * @roseuid 492989DC0116
	 */
	
	/**
	 * KLEINE BUG. Na meerdere keren een bestande naam ingegeven te hebben en
	 * daarna een correcte wordt een voorgaand ingegeven naam ingevuld.
	 */
	public static void checkNaam(String naam) 
	{
		Vector<Speler> spelers = Speler.$geefGeregistreerdeSpelers();
	
		while (naam.length() == 0) {
			naam = (String) JOptionPane
					.showInputDialog("Je hebt geen naam ingevuld.\nGeef je naam in.");
		}
		
		Iterator<Speler> gegevens = spelers.iterator();
		
		while (gegevens.hasNext()) {
			Speler speler = gegevens.next();
		
			if (naam.equalsIgnoreCase(speler.getNaam())) 
			{
				naam = (String) JOptionPane
						.showInputDialog("Je hebt een bestaande naam ingevuld.\nGeef je naam in.");
				checkNaam(naam);
			}
		
		}
		
		speler.zetNaam(naam);
	
	} // public static void checkNaam(String naam)

	
	
	/**
	 * @param geboorteDatum
	 * @roseuid 49298AD400DC
	 */
	public static void checkGeboorteDatum(Calendar datum) 
	{
		Calendar cal = Calendar.getInstance();
		int ltJaar = cal.get(Calendar.YEAR) - datum.get(Calendar.YEAR);
	
		if (ltJaar < 18) 
		{
			DialogHelper
					.$showErrorMessage("Je bent te jong om mee te mogen spelen.\n"
							+ "Je moet minimaal 18 jaar zijn.");
			add = false;
		}
		else if (ltJaar == 18) 
		{
			int ltDag = cal.get(Calendar.DAY_OF_YEAR)
					- datum.get(Calendar.DAY_OF_YEAR);
			if (ltDag <= 0) 
			{
				DialogHelper
						.$showErrorMessage("Je bent te jong om mee te mogen spelen.\n"
								+ "Je moet minimaal 18 jaar zijn.");
				add = false;
			}
		
		}
		else 
		{
			speler.zetGeboorteDatum(datum);
		}
	
	} // public static void checkGeboorteDatum(Calendar datum)
	
	

	/**
	 * Stelt het startsaldo van een speler in.
	 * 
	 * @param saldo
	 * @throws java.lang.IllegalArgumentException
	 * @roseuid 49298B6B027D
	 */
	public static void checkStartSaldo(double saldo) throws IllegalArgumentException 
	{
		try {
			while (saldo < 10.0) {
				saldo = Double
						.parseDouble(DialogHelper
								.$showInputDialog("Je hebt een te laag saldo ingevoerd.\nHet minimale bedrag = 10,00."));
			}
	
		}
		catch (Exception e) 
		{
			DialogHelper.$showErrorMessage("Je hebt geen getal ingevoerd!");
		}
		
		speler.zetStartSaldo(saldo);
		
	} // public static void checkStartSaldo(double saldo)

	
	
	/**
	 * Geeft de Spelers terug aan de tabel.
	 */
	public static void zetSpelerTabel() 
	{
		Vector<Speler> spelers = Speler.$geefAlleSpelers();
		
		DecimalFormat nf = new DecimalFormat("###.00");
		
		Iterator<Speler> gegevens = spelers.iterator();
		
		Object[] actief = SpelersGui.mod2.toArray();
		
		SpelersGui.mod1.removeAllElements();
		
		while (gegevens.hasNext()) {
						
			Speler speler = gegevens.next();
			StringTokenizer sNaam = new StringTokenizer(speler.getNaam());
			String capNaam = "";
		
			if (actief.length == 0) 
			{
				while (sNaam.hasMoreTokens()) {
					String s = sNaam.nextToken();
					capNaam += s.substring(0, 1).toUpperCase()
							+ s.substring(1).toLowerCase() + " ";
				}
			
				capNaam += "        Saldo: \u20AC"
						+ nf.format(speler.getStartSaldo());
				SpelersGui.mod1.addElement(capNaam);
			}
			else 
			{
				Boolean gelijk = false;
				for (int i = 0; i < actief.length; i++) {
					
					String n = (String) actief[i];
					
					if (speler.getNaam().equalsIgnoreCase(n.substring(0, speler.getNaam().length()))) 
					{
						gelijk = true;
					}
				
				}
				
				if (gelijk == false) {
				
					while (sNaam.hasMoreTokens()) {
						String s = sNaam.nextToken();
						capNaam += s.substring(0, 1).toUpperCase()
								+ s.substring(1).toLowerCase() + " ";

					}
					
					capNaam += "        Saldo: \u20AC"
							+ nf.format(speler.getStartSaldo());
					
					SpelersGui.mod1.addElement(capNaam);
				
				}

			} // if (actief.length == 0)
		
		} // while (gegevens.hasNext())
		
	} // public static void zetSpelerTabel()

	
	
	/**
	 * @roseuid 49298CAD008D
	 */
	public static void Bewaar() 
	{
		Speler.$spelerToevoegen(speler);
	
	} // public static void Bewaar()

	
	
		public static void MaakActief(Object[] spelerActief) 
	{
		Vector<Speler> spelers = Speler.$geefAlleSpelers();
	    Vector<Speler> sp = (Vector<Speler>) spelers.clone();

		Object[] actief = spelerActief;
		
		for (int i = 0; i < actief.length; i++) {
		
			String s = (String) actief[i];
			Iterator<Speler> gegevens = sp.iterator();
			
			while (gegevens.hasNext()) {
			
				Speler speler = gegevens.next();
				
				if (speler.getNaam().equalsIgnoreCase(s.substring(0, speler.getNaam().length()))) 
				{
					speler.zetMeedoenAanVolgendeRonde(true);
					sp.remove(speler);
					break;
				}
				else 
				{
					speler.zetMeedoenAanVolgendeRonde(false);
				}
			
			}
		
		}
		Speler.maakGeregistreerdeSpelers();
	}
}
