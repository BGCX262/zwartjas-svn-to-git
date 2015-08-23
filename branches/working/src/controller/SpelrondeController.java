//Source file: H:\\Studie\\ZwartJas\\Workspace\\ZwartJas\\src\\controller\\SpelrondeController.java

package controller;


import java.util.ListIterator;
import java.util.Vector;

import domein.*;
import ui.*;

public class SpelrondeController 
{
	
	private static SpelrondeController $controllerInstance;
	
	/**
	 * Geeft toegang tot singleton spelrondecontroller
	 * Moet hem ook maken
	 * @return
	 */
	public static SpelrondeController $getController()
	{
		if ($controllerInstance == null)
			$controllerInstance = new SpelrondeController();
		return $controllerInstance;
	}
	
	
	/**
	 * Is de spelronde die nu wordt gespeeld
	 * Als er geen spelronde wordt gespeeld is deze dus null
	 */
	private static Spelronde $actieveSpelRonde;

	private Spelronde $geefActieveSpelRonde()
	{
		return $actieveSpelRonde;
	}
	
	public Spelronde geefActieveSpelRonde()
	{
		return $actieveSpelRonde;
	}

	
	private SpelerDeelname spelerDeelname;
	
//	private KaartStapel kaartStapel;
	
	private Vector<Speler> spelers;	
		
	/**
	 * @roseuid 49299414005F
	 */
	private SpelrondeController() 
	{
	} // public SpelrondeController()

	
	
	/**
	 * Start een nieuwe spelronde
	 * 
	 * @roseuid 492996D7022C
	 */
	public void startSpelronde() 
	{
		if ($actieveSpelRonde != null)
			DialogHelper.$showErrorMessage("Er is nog een spelronde actief");
		else
		{
			MainGui.$refreshGui();
			try
			{
			$actieveSpelRonde = Spelronde.$maakNieuweSpelRonde();
			// eerste kaart delen.
			$actieveSpelRonde.deelEersteKaart();
			
			// voegt spelers toe aan gui en laat deze zien			
			MainGui.$getGui().Spelers();
			
			// Maak de eerste speler actief
			//geefvolgende wordt in de activeer aangeroepen
			speelMetVolgendeSpeler();
			}
			catch (IllegalStateException ex)
			{
				// Mislukt: de Spelronde heeft een foutmelding gegooid
			}
		}
		
	} // public void startSpelronde()

	
	
	/**
	 * Wordt aangeroepen zodra er een beurt wordt gespeeld waarbij geen
	 * deelnames een kaart willen hebben (iedereen dus klaar is). Deze methode
	 * is uitgewerkt in UseCase SpelRondeAfsluiten en bepaald het uiteindelijke
	 * resultaat van de SpelRonde
	 * 
	 * @roseuid 492AE4CF00BC
	 */
	public void spelrondeAfsluiten() 
	{
		// Zorgt ervoor dat de buit wordt verdeeld
		$actieveSpelRonde.afsluiten();
		
		// Kijken of er winnaars en verliezers zijn
		bepaalWinnaarEnVerliezer();
		
		// Zorgt ervoor dat er een nieuwe spelronde gestart kan worden
		$actieveSpelRonde = null;
	
	} // public void spelrondeAfsluiten()

	
	
	/**
	 * @roseuid 492AE63E02A7
	 */
	public void pas(Deelname d) {
		d.pas();
		System.out.println("GEPAST via knop!");	
		//geefvolgende wordt in de activeer aangeroepen
		speelMetVolgendeSpeler();		
	} // public void pas()

	
	
	/**
	 * Speler bepaalt na zijn eerste kaart hoeveel hij gaat inzetten.
	 * Deze inzet wordt doorgegeven aan de spelronde.
	 * @param inzet
	 * @roseuid 492AE69F009C
	 */
	public void inzetten(SpelerDeelname deelname, Double inzet) 
	{
		$actieveSpelRonde.inzetten(inzet, deelname);
		
		
		//geefvolgende wordt in de activeer aangeroepen
		speelMetVolgendeSpeler();
	}


	
	/**
	 * @roseuid 492AEF38008D
	 */
	public void vuileWas(SpelerDeelname dn) 
	{
		$actieveSpelRonde.vuileWas(dn);
		speelMetVolgendeSpeler();
	
	} // public void vuileWas()

	
	
	/**
	 * De speler geeft aan dat hij nog een kaart wil en dus niet past of de
	 * inzet verhoogt
	 * 
	 * @roseuid 492AEFBC0011
	 */
	public void nogEenKaart(SpelerDeelname dn) {
		
		$actieveSpelRonde.geefKaart(dn);
	
		// geefvolgende wordt in de activeer aangeroepen
		speelMetVolgendeSpeler();
	
	} // public void nogEenKaart()

	
	
	/**
	 * Methode controleert of er verliezers zijn (spelers die failliet zijn), of
	 * de bank failliet is en als de bank failliet is wie dan de winnaar is
	 * (speler met het hoogste saldo)
	 * 
	 * @roseuid 492B0B5C032A
	 */
	public void bepaalWinnaarEnVerliezer() 
	{
		if (Spel.$geefActiefSpel().geefBankSaldo() < Spel.$geefActiefSpel().geefMinimumInzet())
		{
			// De bank is stuk
			Speler rijksteSpeler = null;
			for (Speler s : Speler.$geefAlleSpelers())
			{
				if (rijksteSpeler == null || rijksteSpeler.getSaldo() < s.getSaldo())
					rijksteSpeler = s;
			}
			
			DialogHelper.$showInfoMessage("De bank is kapot\n" + rijksteSpeler.getNaam() + " heeft gewonnen");
			System.exit(0);
		}
		else
		{
			String failliet = "Failissement:\n";
			boolean mensenFailliet = false;
			boolean mensenMetGelAanwezig = false;
			for (Speler s : Speler.$geefAlleSpelers())
			{
				if (s.getSaldo() < Spel.$geefActiefSpel().geefMinimumInzet())
				{
					// Failliet
					failliet += "\n" + s.getNaam();
					mensenFailliet = true;
				}
				else
				{
					mensenMetGelAanwezig = true;
				}
			}
			if (!mensenMetGelAanwezig)
			{
				DialogHelper.$showInfoMessage("Alle spelers zijn failiet, de bank heeft gewonnen");
				System.exit(0);
			}
			else if (mensenFailliet)
			{
				DialogHelper.$showInfoMessage(failliet);
			}
			
		}


	} // public void bepaalWinnaarEnVerliezer()

	
	
	/**
	 * Zorgt ervoor dat de Use Case OverzichtTonen wordt uitgevoerd en dat er
	 * een overzicht voor één speler wordt getoond
	 * 
	 * @param naam
	 * @roseuid 492B15A1027D
	 */
	public void toonOverzichtVoorSpeler(String naam) 
	{

	} // public void toonOverzichtVoorSpeler(String naam)

	
	
	/**
	 * Zorgt ervoor dat de use case OverzichtTOnen wordt uitgevoerd
	 * 
	 * @roseuid 492B15EF027F
	 */
	public void toonOverzicht() 
	{

	} // public void toonOverzicht()

	
	
	/**
	 * Iedere deelname ontvangt z'n eerste kaart van de spelRonde
	 * 
	 * @roseuid 4947D9D003A0
	 */
	public void deelEersteKaart() 
	{
		$actieveSpelRonde.deelEersteKaart();
	
	} // public void deelEersteKaart()

	
	
	/**
	 * Als deze speler niet meer mag (gepast of dood), moet deze methode ervoor zorgen dat de
	 * volgende speler wordt geactiveerd. Dit moet gebeuren als: 
	 * - Iedere speler één kaart heeft gehad en iedere speler om de beurt moet inzetten 
	 * - Een speler aan het spelen was en heeft gewonnen/verloren of gepast 
	 * Activeren houdt in dat de knoppen van de juiste speler moeten
	 * worden geactiveerd of dat de bank opdracht krijgt om te gaan spelen
	 * Als er geen spelers meer zijn om mee te spelen, wordt met de bank gespeeld en daarna
	 * wordt spelrondeAfsluiten aangeroepen
	 * 
	 * @roseuid 4947DE450380
	 */
	public void speelMetVolgendeSpeler() 
	{
		// TODO voorlopig moet eerst speler 1 inzetten enz en daarna speler 2, later misschien nog wisselen bij inzetten
		SpelerDeelname volgendeSpeler = $actieveSpelRonde.geefVolgendeDeelname();
		// MainGui aanroepen en de volgendespeler meegeven
		MainGui.$getGui().activeerSpeler(volgendeSpeler);
		if (volgendeSpeler == null)
		{
			// De spelers zijn klaar, nu mag de bank
			$actieveSpelRonde.speelMetBank();
			spelrondeAfsluiten();
		}
		
		
	
	} // public void activeerVolgendeSpeler()

	public SpelerDeelname getSpelerDeelname() {
		return spelerDeelname;
	}

	public void setSpelerDeelname(SpelerDeelname spelerDeelname) {
		this.spelerDeelname = spelerDeelname;
	}

	
	public Vector<Speler> getSpelers() {
		this.spelers = Speler.$geefAlleSpelers();
		return spelers;
	}

	

	
}
