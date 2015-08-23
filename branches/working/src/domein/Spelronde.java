//Source file: H:\\Studie\\ZwartJas\\Workspace\\ZwartJas\\src\\domein\\Spelronde.java
package domein;


import java.util.Vector;
import java.lang.Math;



import ui.*;


/**
 * Zorgt ervoor dat iedere ronde wordt gespeeld volgens de regels van het spel
 */
public class Spelronde {
	
	private Vector<SpelerDeelname> alleSpelerDeelnames = new Vector<SpelerDeelname>();
	/**
	 * Geeft alle spelerdeelnames
	 * @return
	 */
	public Vector<SpelerDeelname> geefAlleSpelerDeelnames()
	{
		return alleSpelerDeelnames;
	}
	
	private BankDeelname bankDeelname;
	/**
	 * Geeft de bankdeelname
	 * @return
	 */
	public BankDeelname geefBankDeelname()
	{
		return bankDeelname;
	}
	
	
	/**
	 * Geeft alle deelnames terug, eerst de spelers dan de bank
	 * @return
	 */
	public Vector<Deelname> geefAlleDeelnames()
	{
		Vector<Deelname> alle = new Vector<Deelname>();
		for (SpelerDeelname sd : alleSpelerDeelnames)
			alle.add(sd);
		alle.add(bankDeelname);
		return alle;
	}
	
	//private SpelerDeelname spelerDeelname;
	
	
	/**
	 * De kaarstapel waar de spelronde z'n kaartne vandaan haalt
	 */
	private KaartStapel kaartStapel;
	
		
	/**
	 * @roseuid 4947EC7401E7
	 */
	public Spelronde() 
	{

	} // public Spelronde()
	
	

	/**
	 * - Maakt een nieuwe spelronde aan 
	 * - Voegt deelnames aan de spelronde toe 
	 * - Voegt de spelronde aan het spel toe 
	 * 
	 * Gooit een illegalstateexception als
	 * er geen deelnemers zijn die zijn geregistreerd om mee te doen aan de
	 * volgende ronde, of als één van de deelnemers
	 * 
	 * niet genoeg saldo heeft om de minimuminzet te voldoen, of als er meer dan
	 * 4 spelers willen meedoen
	 * 
	 * @author 	Jeroen Sen <jeroensen@planet.nl>
	 * @version	20081218
	 * @param		viod
	 * @return		Spelronde
	 * @throws 	java.lang.IllegalStateException
	 * @roseuid 	4929992D00AB
	 * 
	 */
	
	public static Spelronde $maakNieuweSpelRonde() throws IllegalStateException {
		
		// maakt een nieuwe spelronde
		Spelronde spelronde = new Spelronde();
		
		// voegt deelnames aan de spelronde toe
		Vector<Speler> geregistreerdeSpelers = Speler.$geefGeregistreerdeSpelers();
		
		if (geregistreerdeSpelers.size() == 0)
		{
			DialogHelper.$showErrorMessage("Er zijn geen spelers die mee willen doen");
			throw  new IllegalStateException("Er zijn geen spelers die mee willen doen");
		}
		else if (geregistreerdeSpelers.size() > 4)
		{
			DialogHelper.$showErrorMessage("Er zijn teveel spelers die mee willen doen");
			throw  new IllegalStateException("Er zijn teveel spelers die mee willen doen");
		}
		
		// verkrijg het actieve spel
		Spel spel = Spel.$geefActiefSpel();
	
		// spelerdeelnames maken
		for (Speler s : geregistreerdeSpelers )
		{
			Deelname sd = s.maakDeelname();
			sd.setTheSpelronde(spelronde);// nodig?
			spelronde.deelnameToevoegen(sd);
		}	
		
		// weghalen
		// zet eerste speler als actieve deelname
		//spelronde.spelerDeelname = (SpelerDeelname)spelronde.geefDeelname().firstElement();
		
		// maak bankdeelname en voeg bankdeelname toe
		BankDeelname bank = spel.maakBankDeelname();
		spelronde.bankDeelnameToevoegen(bank);
		
		// spelronde toevoegen
		spel.SpelrondeToevoegen(spelronde);
		
	
		
		
		return spelronde;
	} // public static Spelronde $maakNieuweSpelRonde() throws IllegalStateException

	
	
	/**
	 * @param deelname
	 * @roseuid 49299C1E0229
	 */
	public void deelnameToevoegen(Deelname deelname) 
	{
		alleSpelerDeelnames.add((SpelerDeelname)deelname);
	} // public void deelnameToevoegen(Deelname deelname)

	
	
	/**
	 * @param deelname
	 * @roseuid 49299D4E00FF
	 */
	public void bankDeelnameToevoegen(BankDeelname deelname) 
	{
		bankDeelname = deelname;
	} // public void bankDeelnameToevoegen(BankDeelname deelname)

	
	
	/**
	 * @param stapel
	 * @roseuid 49299FD400D6
	 */
	public void zetKaartStapel(KaartStapel stapel) 
	{
		kaartStapel = stapel;
	} // public void zetKaartStapel(KaartStapel stapel)

	
	
//	/**
//	 * Vervalt, oud ontwerp
//	 * Controleert of de deelname op dit moment een kaart mag ontvangen. De bank
//	 * mag bijvoorbeeld niet meer dan twee kaarten hebben zolang alle andere
//	 * deelnames nog niet uitgespeeld zijn
//	 * 
//	 * @roseuid 492AE789001D
//	 */
//	public void magEenKaart() 
//	{
//
//	} // public void magEenKaart()
	
	

	/**
	 * Controleert of er ingezet mag worden en of de inzet voldoet aan de
	 * minimum en maximuminzet
	 * 
	 * @param inzet
	 * @throws java.lang.IllegalArgumentException
	 * @roseuid 492AEA7603AF
	 */
	public void inzetten(double inzet, SpelerDeelname spelerDeelname) throws IllegalArgumentException
	{
		Spel spel = Spel.$geefActiefSpel();
		
		// rekening houden met de totale inzet
		
		double nieuweInzet = 0;
		boolean inzetOK = false;
		while (!inzetOK)
		{
			nieuweInzet = spelerDeelname.geefInzet() + inzet;
			String foutMelding = null;
			if (inzet < 0)
				foutMelding = "Foutieve invoer"; //Zie verderop bij de try catch 
			else if (nieuweInzet < spel.geefMinimumInzet()  )
			{
				foutMelding = "Inzet is kleiner dan minimuminzet. Geef een waarde hoger dan "+ spel.geefMinimumInzet();
			}
			else if (nieuweInzet > spel.geefMaximumInzet())
			{
				foutMelding =  "Inzet is groter dan maximuminzet. Geef een waarde lager dan  " + spel.geefMaximumInzet();
				if (spelerDeelname.geefInzet() > 0)
					foutMelding += " u heeft al " + spelerDeelname.geefInzet() + " ingezet";
			}
			else if (nieuweInzet > spelerDeelname.getTheSpeler().getSaldo())
			{
				foutMelding = "Inzet is groter dan huidig saldo. Geef een totale waarde lager dan  "+ spelerDeelname.getTheSpeler().getSaldo();
				if (spelerDeelname.geefInzet() > 0)
					foutMelding += " u heeft al " + spelerDeelname.geefInzet() + " ingezet";
			}
			else 
				inzetOK = true;
			
			if (!inzetOK )
			{
				String s = DialogHelper.$showInputDialog("Inzet is groter dan maximuminzet. Geef een waarde lager dan  "+ spel.geefMaximumInzet());
				try
				{
					inzet = Double.parseDouble(s);
				}
				catch (Exception x)
				{
					// Wordt in de volgende ronde gecontroleerd
					inzet = -1;
				}
			}			
		}	

		spelerDeelname.wijzigInzet(nieuweInzet);
		
		spelerDeelname.geefKaart(spel.getKaartStapel().pakBovensteKaart());
		MainGui.$getGui().toonDeelnameKaarten(spelerDeelname);
		//Geef een melding indien nodig
		toonSpelerStatus(spelerDeelname);
		
		spelerDeelname.zetResultaat(bepaalResultaat(spelerDeelname));

		if(spelerDeelname.geefZwartjas())
			System.out.println("ZWARTJAS!");		

		if(spelerDeelname.getDood())
			System.out.println("Dood");
		
		if(spelerDeelname.gePast())
			System.out.println("Gepast");

		if(spelerDeelname.geefPuntenTotaal() < 21 && !spelerDeelname.geefZwartjas() && !spelerDeelname.getDood()) 
		{
			System.out.println("Terug naar speler!");
		}
	} // public void inzetten(double inzet, Speler speler) throws IllegalArgumentException
	
	/**
	 * Zorgt ervoor dat een melding wordt getoond met de spelerstatus indien dat zinvol is
	 * Dus bij dood en zwartjas
	 * @param deelname
	 */
	private void toonSpelerStatus(SpelerDeelname deelname)
	{
		if (deelname.geefZwartjas())
			DialogHelper.$showInfoMessage("ZWARTJAS!!!!!");
		else if (deelname.getDood())
			DialogHelper.$showInfoMessage("Dood (misschien moet je minder risico nemen)");
	}


	/**
	 * Een speler heeft een vuile was gehaald, zijn moeten worden weggehaald en
	 * hij krijgt twee nieuwe kaartenn
	 * 
	 * @roseuid 492AEF4A0338
	 */
	public void vuileWas(SpelerDeelname spelerDeelname) 
	{	
		if (!spelerDeelname.getHeeftVuileWas())
		{
			DialogHelper.$showErrorMessage("Zo vuil is die was niet!!!!");
			return;
		}
		
		spelerDeelname.verwijderAlleKaarten();
	
		for (int i=0; i <= 1; i++) {
			spelerDeelname.geefKaart(kaartStapel.pakBovensteKaart());
		}
	
		spelerDeelname.zetResultaat(bepaalResultaat(spelerDeelname));
	
	} // public void vuileWas()

	
	
	/**
	 * Deze methode rond de spelronde af: - zorgt ervoor dat duidelijk wordt wie
	 * er wint en verliest - zorgt voor de verdeling van de inzet
	 * 
	 * @roseuid 492AF2970375
	 */
	public void afsluiten() 
	{ 	
		String rondeResultaat = "Resultaten:\n";
		
		for (SpelerDeelname deelname : alleSpelerDeelnames) 
		{		
			double resultaat = bepaalResultaat(deelname);
			deelname.zetResultaat(resultaat);
			deelname.getTheSpeler().saldoAanpassen(resultaat); 
			bankDeelname.getTheBank().saldoAanpassen(-1*resultaat);	
			rondeResultaat += "\nSpeler: " + deelname.getTheSpeler().getNaam() + "\t    Resultaat: " + deelname.getResultaat();
		}
		DialogHelper.$showInfoMessage(rondeResultaat);
		
		// Werkt nog even niet: geen tijd dus even met textbox
//		EindeSpelGui inst = new EindeSpelGui(geefAlleSpelerDeelnames());
//		inst.setVisible(true);
		
	} // public void afsluiten()

		
	/**
	 * Controleert of de speler gewonnen of verloren heeft en zorgt ervoor dat
	 * het resultaat can de speler eventueel wordt aangepast
	 * 
	 * @return double
	 * @roseuid 492AF3CD038B
	 */
	public double bepaalResultaat(SpelerDeelname spelerDeelname) 
	{		
		if (spelerDeelname.geefZwartjas())
		{
			// Gewonnen
			return spelerDeelname.geefInzet();
		}
		else if (!spelerDeelname.wilNogEenBeurt() && !geefBankDeelname().wilNogEenBeurt())
		{
			// Gepast en de Bank is ook uitgespeeld
			if (geefBankDeelname().geefZwartjas())
				// Verloren
				return spelerDeelname.geefInzet() * -1;
			else if (geefBankDeelname().getDood() && spelerDeelname.getDood())
			{
				// Allebei dood dus resultaat = 0
				return 0;
			}
			else if (geefBankDeelname().getDood() && !spelerDeelname.getDood())
			{
				// Bank dood speler niet
				return spelerDeelname.geefInzet();
			}
			else if (!geefBankDeelname().getDood() && spelerDeelname.getDood())
			{
				// Bank niet dood speler wel
				return spelerDeelname.geefInzet() * -1;
			}
			else
			{
				if (spelerDeelname.geefPuntenTotaal() > geefBankDeelname().geefPuntenTotaal())
				{
					// Speler gewonnen
					return spelerDeelname.geefPuntenTotaal();
				}
				else
				{
					return spelerDeelname.geefPuntenTotaal() * -1;
				}
			}		
		}
		// Nog geen resultaat
		return 0;
	
	} // public double bepaalResultaat()

	
	
	/**
	 * Iedere deelname ontvangt z'n eerste kaart.
	 * Ook de Bank!
	 * 
	 * @roseuid 4947DAEE01B2
	 */
	public void deelEersteKaart() 
	{
		for(Deelname dn : geefAlleDeelnames() ) 
		{
			dn.geefKaart(kaartStapel.pakBovensteKaart());
    	}

	} // public void deelEersteKaart()

	
		
	/**
	 * Bepaald wie de volgende speler is. Moet daarbij controleren of een speler
	 * gepast heeft of gewonnen/verloren is. Is dat laatste het geval, dan moet
	 * de winst worden overgemaakt
	 * 
	 * @return Deelname
	 * @roseuid 4947DC6F0005
	 */
	public SpelerDeelname geefVolgendeDeelname() 
	{
		for (SpelerDeelname sd : geefAlleSpelerDeelnames())
			if (sd.wilNogEenBeurt())
				return sd;
		
		return null;
	}// public Deelname geefVolgendeDeelname()

	
	
	/**
	 * Geeft de deelname een kaart
	 * 
	 * @param deelname
	 * @roseuid 4947E61C01D6
	 */
	public void geefKaart(SpelerDeelname deelname) 
	{
		deelname.geefKaart(kaartStapel.pakBovensteKaart());
		MainGui.$getGui().toonDeelnameKaarten(deelname);
		// Geef een melding indien nodig
		toonSpelerStatus(deelname);
		
		deelname.zetResultaat(bepaalResultaat(deelname));
	
	} // public void geefKaart(Deelname deelname)

	
	
	/**
	 * Wordt aangeroepen door de spelrondecontroller zodra hij van SpelRonde de
	 * BankDeelname terugkrijgt Roept in een loop pakBovenstKaart en geefKaart
	 * aan totdat de bank meer punten als 17 punten heeft(en gepast heeft) of kapot is
	 * 
	 * @roseuid 4947E9600250
	 */
	public void speelMetBank() 
	{
		while (bankDeelname.wilNogEenBeurt() && bankDeelname.geefPuntenTotaal() < 18 ) {
			bankDeelname.geefKaart(kaartStapel.pakBovensteKaart());
			MainGui.$getGui().toonBankKaarten();
			
			System.out.println("Bankpunten " + bankDeelname.geefPuntenTotaal());		
		}
		String bankInfo = "De bank "; 
		if (bankDeelname.geefZwartjas())
			bankInfo += " heeft ZWARTJAS";
		else if (bankDeelname.getDood())
			bankInfo += " is DOOD";
		else 
		{
			bankDeelname.pas();
			bankInfo += " heeft " + bankDeelname.geefPuntenTotaal() + " punten";
		}
		
		DialogHelper.$showInfoMessage(bankInfo);
		
		System.out.println("Punten Bank = " + bankDeelname.geefPuntenTotaal());
		
	} // public void speelMetBank()
	
		
}