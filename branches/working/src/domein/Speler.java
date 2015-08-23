//Source file: H:\\Studie\\ZwartJas\\Workspace\\ZwartJas\\src\\domein\\Speler.java
package domein;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

import controller.SpelrondeController;

/**
 * Houd de gegevens van een menselijke speler bij
 */
public class Speler {
	
	private static Vector<Speler> alleSpelers = new Vector<Speler>();
	
	public boolean volgendeRondeMeedoen;

	/**
	 * startSaldo = Het saldo waarmee de speler begonnen is
	 * saldo = Het huidige saldo van de speler
	 */
	private Double startSaldo;
	
	private Double saldo;
	
	private String naam;
	
	public Calendar gebDatum;
	
	private Vector<SpelerDeelname> deelnames = new Vector<SpelerDeelname>();

	public static Vector<Speler> theSpelerDeelname = new Vector<Speler>();
	
//	private Spelronde theSpelronde;

//	private SpelrondeController sc = new SpelrondeController(theSpelronde);
	
	/**
	 * @roseuid 492989CA0073
	 */
	public Speler() 
	{
	
	} // public Speler()

	
	
	/**
	 * Stelt de naam van een speler in, gooit een IllegalArgumentException als
	 * geen naam is opgegeven of als er al een speler met die naam aanwezig 
	 * 
	 * @param naam
	 * @throws java.lang.IllegalArgumentException
	 * @roseuid 49298A5C01A3
	 */
	public void zetNaam(String naam) throws IllegalArgumentException 
	{
		this.naam = naam;
		
	} // public void zetNaam(String naam) throws IllegalArgumentException

	
	
	/**
	 * Stelt de geboortedatum van een speler in. Gooit een exception als de
	 * speler jonger is dan 18 jaar.
	 * 
	 * @param datum
	 * @throws java.lang.IllegalArgumentException
	 * @roseuid 49298B0E0292
	 */
	public void zetGeboorteDatum(Calendar datum) throws IllegalArgumentException 
	{
		this.gebDatum = datum;
	
	} // public void zetGeboorteDatum(Calendar datum) throws IllegalArgumentException

	
	
	/**
	 * Stelt het startsaldo van een speler in. Het startsaldo moet minimaal 10
	 * euro zijn, anders wordt een exception gegooid.
	 * 
	 * @param saldo
	 * @throws java.lang.IllegalArgumentException
	 * @roseuid 49298C080305
	 */
	public void zetStartSaldo(double saldo) throws IllegalArgumentException 
	{
		this.startSaldo = saldo;
		this.saldo = saldo;
	
	} // public void zetStartSaldo(double saldo) throws IllegalArgumentException
	
	
	
	/**
	 * Wijzigt de meedoe-status van de speler
	 * 
	 * @param meedoen
	 * @roseuid 492B13A5033F
	 */
	public void zetMeedoenAanVolgendeRonde(boolean meedoen) 
	{
		this.volgendeRondeMeedoen = meedoen;
	
	} // public void zetMeedoenAanVolgendeRonde(boolean meedoen)

	
	
	/**
	 * Wijzigt het saldo van de speler met het gegeven bedrag. Het resultaat van
	 * deze operatie kan zijn dat de speler failliet raakt omdat hij niet meer
	 * aan de minimuminleg kan voldoen.
	 * 
	 * @param bedrag
	 * @roseuid 49298C5902DE
	 */
	public void saldoAanpassen(double bedrag) 
	{
		this.saldo += bedrag;
	
	} // public void saldoAanpassen(double bedrag)

	
	
	/**
	 * Voegt een nieuwe speler toe aan de lijst van actieve spelers
	 * 
	 * @param nieuweSpeler
	 * @roseuid 49298CDD0377
	 */
	public static void $spelerToevoegen(Speler nieuweSpeler) 
	{
		alleSpelers.add(nieuweSpeler);
	
	} // public static void $spelerToevoegen(Speler nieuweSpeler)

	public static void maakGeregistreerdeSpelers(){
		Iterator<Speler> sp = alleSpelers.iterator(); 
		while (sp.hasNext()) {
			Speler speler = sp.next();
			if (speler.volgendeRondeMeedoen == true){
				theSpelerDeelname.add(speler);
			}
		}

	}
	/**
	 * @return Vector<Speler>
	 * @roseuid 4929997801E7
	 */
	public static Vector<Speler> $geefGeregistreerdeSpelers() 
	{
		return theSpelerDeelname;
	}

	/**
	 * @return Vector<Speler>
	 * @roseuid 4929997801E7
	 */
	public static Vector<Speler> $geefAlleSpelers() {
		return alleSpelers;
	
	} // public static Vector<Speler> $geefGeregistreerdeSpelers()

	
	
	/**
	 * Maakt een nieuwe deelname voor de Speler aan, voegt deze aan de
	 * SpelerDeelnames toe en geeft de deelname terug aan de aanroeper (normaal
	 * gesproken de Spelronde)
	 * 
	 * @return SpelerDeelname
	 * @roseuid 49299B5F000A
	 */
	public SpelerDeelname maakDeelname() 
	{
		SpelerDeelname sd = new SpelerDeelname();
		deelnames.add(sd);
		sd.setTheSpeler(this);
		//sd.wijzigInzet(startSaldo); //Niks inzet is startsaldo! Weg ermee
		return sd;
	
	} // public SpelerDeelname maakDeelname()
	

	
	/**
	 * Geeft alle afgeronde deelnames (resultaat != 0) terug, zodat er een
	 * overzicht van kan worden gemaakt
	 * 
	 * @return Vector<SpelerDeelname>
	 * @roseuid 492B0DCF0205
	 */
	public Vector<SpelerDeelname> geefDeelnames() 
	{
		return deelnames;
	} // public Vector<SpelerDeelname> geefDeelnames()
	
	
	/**
	 * getters voor lokale variabelen
	 * 
	 */

	public Double getStartSaldo() 
	{
		return startSaldo;

	} // public Double getStartSaldo()
	
	
	
	public Double getSaldo() 
	{
		return saldo;
	
	} // public Double getSaldo()
	
	
	
	public String getNaam() 
	{
		return naam;
	
	} // public String getNaam()

	/**
	 * @return the volgendeRondeMeedoen
	 */
	public boolean isVolgendeRondeMeedoen() {
		return volgendeRondeMeedoen;
	}
}
