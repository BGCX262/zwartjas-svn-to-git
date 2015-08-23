//Source file: H:\\Studie\\ZwartJas\\Workspace\\ZwartJas\\src\\domein\\Spel.java
package domein;

import java.util.Vector;

public class Spel {

	private double minimumInzet = 0;
	
	private double maximumInzet = 0;

	private static Spel actiefSpel;
	
	private KaartStapel theKaartStapel;
	
	public static Vector<Spelronde> theSpelronde = new Vector<Spelronde>();
	
	private Bank theBank;
	
	
	
	public double geefMinimumInzet() throws IllegalStateException
	{
		if (minimumInzet > 0)
			return minimumInzet;
		throw new IllegalStateException("Minimuminzet is nog niet ingesteld");
		
	} // public double geefMinimumInzet() throws IllegalStateException
	
	
	
	public double geefMaximumInzet() throws IllegalStateException
	{
		if (maximumInzet > 0)
			return maximumInzet;
		throw new IllegalStateException("Maximuminzet is nog niet ingesteld");
	
	} // public double geefMaximumInzet() throws IllegalStateException
	
	
	
	public double geefBankSaldo() throws IllegalStateException
	{
		return theBank.geefSaldo();
	
	} // public double geefBankSaldo() throws IllegalStateException

	
	
	/**
	 * @roseuid 4929736100C3
	 */
	public Spel() 
	{

	} // public Spel()

	
	
	/**
	 * Stelt de minimum- en maximuminzet voor de duur van het spel in. Methode
	 * zal een IllegalArgumentException gooien als de minimum- en maximuminzet
	 * niet met elkaar kloppen (min > max || min <= 0 || max <= 0).
	 * 
	 * @param minimumInzet
	 * @param maximumInzet
	 * @throws java.lang.IllegalArgumentException
	 * @roseuid 492977650049
	 */
	public void zetInzet(double minimumInzet, double maximumInzet) throws IllegalArgumentException {
		
		if (minimumInzet < 0)
			throw new IllegalArgumentException(
					"Minimuminzet is kleiner of gelijk aan 0");
		
		if (maximumInzet < 0)
			throw new IllegalArgumentException(
					"MaximumInzet is kleiner of gelijk aan 0");
		
		if (maximumInzet < minimumInzet)
			throw new IllegalArgumentException(
					"MaximumInzet is kleiner dan minimuminzet");
		
		this.minimumInzet = minimumInzet;
		this.maximumInzet = maximumInzet;
	
	} //public void zetInzet(double minimumInzet, double maximumInzet)

	
	
	/**
	 * Stelt het startsaldo van de bank in. Deze methode zal een
	 * IllegalArgumentException gooien als het StartSaldo van de bank te laag
	 * is: (bankSaldo < 10 * maxinzet)
	 * 
	 * @param bankSaldo
	 * @throws java.lang.IllegalArgumentException
	 * @roseuid 492978C603A8
	 */
	public void zetStartSaldo(double bankSaldo) throws IllegalArgumentException, IllegalStateException {
		
		// Die gooit een IllegalStateException als maximuminzet nog niet is gezet
		double maxInzet = geefMaximumInzet();
		
		if (bankSaldo < maxInzet * 10) 
		{
			throw new IllegalArgumentException(
					"Banksaldo moet minimaal 10 x de maximuminzet bedragen");
		}
		
		theBank.zetBankSaldo(bankSaldo);
	
	} // public void zetStartSaldo(double bankSaldo) throws IllegalArgumentException, IllegalStateException

	
	
	/**
	 * Geeft het actieve spel terug
	 * 
	 * @return Spel
	 * @roseuid 492987A8002D
	 */
	public static Spel $geefActiefSpel() 
	{
		return Spel.actiefSpel;
	
	} //public static Spel $geefActiefSpel()

	
	
	/**
	 * Creëert een nieuw Spel, voegt er een Bank aan toe en stelt dat in als
	 * actief spel
	 * 
	 * @roseuid 4929883501F1
	 */
	public static void $maakNieuwSpel() 
	{
		Spel nieuwSpel = new Spel();
		nieuwSpel.theBank = new Bank();
		actiefSpel = nieuwSpel;
		nieuwSpel.theKaartStapel = KaartStapel.$maakKaartStapel();

	} // public static void $maakNieuwSpel()
	
	
	
	// $zetActiefSpel moest private zijn en voegde niets toe dus is vervallen

	/**
	 * @return BankDeelname
	 * @roseuid 49299CAB0241
	 */
	public BankDeelname maakBankDeelname() 
	{
		return theBank.maakDeelname();
	
	} // public BankDeelname maakBankDeelname()

	
	
	/**
	 * @param ronde
	 * @roseuid 49299D7B0089
	 */
	public void SpelrondeToevoegen(Spelronde ronde) 
	{
		theSpelronde.add(ronde);
		ronde.zetKaartStapel(theKaartStapel);
	} // public void SpelrondeToevoegen(Spelronde ronde)

	
	
	/**
	 * Geeft alle gespeelde spelrondes terug, zodat er een overzicht van kan
	 * worden gemaakt
	 * 
	 * @return Vector<Spelronde>
	 * @roseuid 492B0CD30057
	 */
	public static Vector<Spelronde> geefGespeeldeSpelrondes() 
	{
		if (theSpelronde.isEmpty()) { return null; }
		
		return theSpelronde;
	
	} // public static Vector<Spelronde> geefGespeeldeSpelrondes()

	
	
	/**
	 * Geeft de laatst gespeelde spelronde terug
	 * 
	 * @return Spelronde
	 * @roseuid 492B1190017D
	 */
	public Spelronde geefLaatsteSpelronde() 
	{
		if (theSpelronde.isEmpty()) { return null; }
		return theSpelronde.lastElement();
	} // public static Spelronde geefLaatsteSpelronde()



	public KaartStapel getKaartStapel() {
		return theKaartStapel;
	}
	
	
	
}
