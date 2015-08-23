//Source file: H:\\Studie\\ZwartJas\\Workspace\\ZwartJas\\src\\controller\\OverzichtController.java

/**     OPMERKING  **
 * Diverse methodes niet gebruikt ivm een andere manier van aanroepen.
 */
package controller;

import java.util.*;

import domein.*;
import ui.*;

public class OverzichtController {
	
	
	/**
	 * @roseuid 492983130239
	 */

	private Spel toonSpel;
	
	private Speler toonSpeler;
	
	private String spelerNaam;
	
	// public Vector<Spelronde> toonSpelronde = new Vector<Spelronde>();
	
	public Vector<Speler> rondeSpelers = new Vector<Speler>();
	
	public Vector<SpelerDeelname> spelerDeelname = new Vector<SpelerDeelname>();
	
	public OverzichtGui og;

	
	
	public OverzichtController(OverzichtGui og) 
	{
		this.og = og;
		og.setOverzichtController(this);
	
	} // public OverzichtController(OverzichtGui og)

	
	
	
//	public OverzichtController(Spel spel) 
//	{ 
//		toonSpel = spel; toonOverzicht();
//	
//	}
	 
//	public OverzichtController(Speler speler) 
//	{ 
//		toonSpeler = speler;
//		spelerNaam = toonSpeler.naam; toonOverzichtVoorSpeler(spelerNaam); 
//	
//	}

	
	
	/**
	 * Zorgt ervoor dat het overzichtsscherm getoond wordt en dat we in Use Case
	 * Overzicht terecht komen
	 * 
	 * @roseuid 49297B9F01E4
	 */
	public void toonOverzicht() 
	{
//		  this.OverzichtController(new OverzichtGui());
	  
	} // public void toonOverzicht()
	 
	
	  
	/**
	 * Maakt een overzicht voor de gegeven speler
	 * 
	 * @param naam
	 * @roseuid 492B0D5C0390
	 */
	public void toonOverzichtVoorSpeler(String spelerNaam) {
		Vector<Speler> spelers =  Speler.$geefAlleSpelers();
		Speler overzichtSpeler = null;
		for (Speler s : spelers)
		{
			if (spelerNaam.equals(s.getNaam()))
			{
				overzichtSpeler = s;
				break;
			}
		}
		if (overzichtSpeler == null)
		{
			DialogHelper.$showErrorMessage("Onbekende speler: " + spelerNaam);
		}
		else
		{
			// TODO Spelrondes van de speler in een overzicht tonen
			// bv Vector<SpelerDeelname> spelerDeelnames =  overzichtSpeler.geefDeelnames()
			
		}
	}


	
	/**
	 * Voor het vullen van de Combo met rondes
	 * 
	 * @return rondes
	 */
	public String[] GeefSpelrondes() 
	{
		String[] rondes = null;
		
		if (Spel.geefGespeeldeSpelrondes() != null) 
		{
			Vector<Spelronde> toonSpelronde = Spel.geefGespeeldeSpelrondes();
			rondes = new String[toonSpelronde.size()];
			rondes[0] = "Selecteer ronde.";
		
			for (int i = 1; i <= toonSpelronde.size(); i++) {
				rondes[i] = "Spelronde " + (i);
			}
			
		}
		else 
		{
			rondes = new String[1];
			rondes[0] = "Geen Rondes";
		}
		
		return rondes;
	
	} // public String[] GeefSpelrondes()

	
	
	/**
	 * Voor het vullen van de Combo Spelers
	 * 
	 * @param ronde
	 * @return spelers
	 */
	@SuppressWarnings("static-access")
	public String[] GeefSpelers(int ronde) 
	{
		String[] spelers = null;
		int i = 0;
		int index = ronde - 1;
		Spelronde spelronde = Spel.geefGespeeldeSpelrondes().get(index);
		Vector<Speler> speler = Speler.$geefAlleSpelers();
		spelers = new String[speler.size()];
		
		for (Iterator<Speler> sp = speler.iterator(); sp.hasNext();) {
			Speler speler1 = sp.next();
			spelers[i] = speler1.getNaam();
		}
		
		return spelers;
	
	} // public String[] GeefSpelers(int ronde)


	
	/**
	 * Vult de tabel met gegevens voor de spelronde In data zitten: Spelernaam,
	 * Resultaat, Totaal punten en Totaal kaarten
	 * 
	 * @param ronde
	 * @return data
	 */
	public String[][] VulTabelRonde(int ronde) 
	{
		String[][] rondeGegevens = null;
		int index = ronde - 1;
		int i = 0;
	
		if (Spel.geefGespeeldeSpelrondes() == null) 
		{
			rondeGegevens = new String[1][4];
			rondeGegevens[i][0] = "";
			rondeGegevens[i][1] = "";
			rondeGegevens[i][2] = "";
			rondeGegevens[i][3] = "";
		}
		else 
		{
			Spelronde spel = Spel.geefGespeeldeSpelrondes().get(index);
			Vector<SpelerDeelname> deelname = spel.geefAlleSpelerDeelnames();
			rondeGegevens = new String[deelname.size()][4];
			for (SpelerDeelname sd : deelname)
			{
				rondeGegevens[i][0] = sd.getTheSpeler().getNaam();
				rondeGegevens[i][1] = Integer.toString(sd.geefPuntenTotaal());
				rondeGegevens[i][2] = Double.toString(sd.getResultaat());
				rondeGegevens[i][3] = Integer.toString(sd.geefDeelnameKaarten().size());
				i++;
			}
		}
		
		return rondeGegevens;
		
	} // public String[][] VulTabelRonde(int ronde)
	
	
	
	public String[][] VulTabelRonde(int ronde, String naam) 
	{
		String[][] spelerGegevens = null;
		return spelerGegevens;
		
	} // public String[][] VulTabelRonde(int ronde, String naam)

	
	
}
