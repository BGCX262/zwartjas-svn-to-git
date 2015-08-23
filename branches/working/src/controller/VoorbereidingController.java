//Source file: H:\\Studie\\ZwartJas\\Workspace\\ZwartJas\\src\\controller\\VoorbereidingController.java

package controller;

import java.util.Vector;

import domein.*;
import ui.*;

/**
 * Verantwoordelijk voor de afhandeling van de momenten tussen de verschillende
 * spelrondes. Hier kunnen spelers zich registreren, maar bijvoorbeeld ook
 * overzichten oproepen en aangeven of ze mee willen doen aan de volgende rond
 */
public class VoorbereidingController 
{
	
	
	
	/**
	 * In de constructor moet deze controller ervoor zorgen dat hij alle
	 * benodigde gegevens om het tussenscherm te laten zien en om alle functies
	 * goed uit te voeren bij elkaar harkt.
	 * 
	 * @roseuid 492B10E203E4
	 */
	public VoorbereidingController() 
	{
		Spelronde laatstGespeeldeRonde = Spel.$geefActiefSpel().geefLaatsteSpelronde();
		Vector<Speler> geregistreerdeSpelers = Speler.$geefGeregistreerdeSpelers();
		// TODO ergens de resultaten van de laatste spelronde laten zien
		// TODO ergens laten zien wie de geregistreerde spelers zijn 
		
		
	} // public VoorbereidingController() 

	
	
	
	/**
	 * Zorgt ervoor dat de overzichtcontroller de Use Case OverzichtTonen cia de
	 * methode geefSpelerOverzicht kan uitvoeren
	 * 
	 * @param naam
	 * @roseuid 492B11E500C2
	 */
	public void toonOverzichtVoorSpeler(String naam) 
	{
		OverzichtController overzichtController = new OverzichtController(new OverzichtGui());
		overzichtController.toonOverzichtVoorSpeler(naam);
	} // public void toonOverzichtVoorSpeler(String naam)
	
	

	

	
	
	
	/**
	 * Roept methode toonoverzicht op de overzichtcontroller aan.
	 *  Als er nog niet is gespeeld wordt use case registreerspelers gestart
	 * 	 * @roseuid 492B12CF01D3
	 */
	public void toonOverzicht() 
	{
		if (Spel.geefGespeeldeSpelrondes() == null)
		{
			registreerSpeler();
		}
		else
		{
			new OverzichtController(new OverzichtGui());
		}
	
	} // public void toonOverzicht()

	
	
	/**
	 * Zorgt ervoor dat de SpelerRegistreren use case wordt afgehandeld
	 * Tevens worden ze hier op actif (meedoen)gezet.
	 * 
	 * @roseuid 492B12F300EB
	 */
	public void registreerSpeler() 
	{
        new RegistratieController(new SpelersGui());
	
	} // public void registreerSpeler()

	
	
	/**
	 * Speler geeft aan dat hij wel of niet wil meedoen aan de volgende ronde
	 * 
	 * @param meedoen
	 * @roseuid 492B13550144
	 */
	// wijzigDeelname komt te vervallen doorat dit in de registratie wordt verwerkt.
//	public void wijzigDeelname(boolean meedoen) 
//	{
//	
//	}

	
	
	/**
	 * Zorgt ervoor dat de Use Case SpelrondeSpelen wordt uitgevoerd door de
	 * SpelrondeController
	 * 
	 * @roseuid 492B142C0052
	 */
	
	public void startSpelronde() 
	{
		SpelrondeController.$getController().startSpelronde();		
	} // public void startSpelronde()





	
	
	
}

