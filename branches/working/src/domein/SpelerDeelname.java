//Source file: H:\\Studie\\ZwartJas\\Workspace\\ZwartJas\\src\\domein\\SpelerDeelname.java

package domein;

/**
 * Zorgt voor de deelname van een speler aan het spel en houdt de inzet, het
 * puntentotaal en het financiële resultaat van een speler bij
 */
public class SpelerDeelname extends Deelname {
	
	private double inzet = 0;
	
	private double resultaat;
	
	private Speler theSpeler;
	
	/**
	 * @roseuid 4947EC730001
	 */
	public SpelerDeelname() 
	{
		
	} // public SpelerDeelname()

	
	
	/**
	 * Wijzigt de inzet van deze deelname
	 * 
	 * @param inzet
	 * @roseuid 492AEB8A007E
	 */
	public void wijzigInzet(double inzet) 
	{
		this.inzet = inzet;
		System.out.println("inzet spelerdeelname = " + inzet);
		
	} // public void wijzigInzet(double inzet)
	
	

	/**
	 * De deelname verwijdert alle aanwezige kaarten i.v.m. 'vuile was'
	 * 
	 * @roseuid 492AF0CA02F2
	 */
	public void verwijderAlleKaarten() 
	{

	} // public void verwijderAlleKaarten()

	
	
	/**
	 * Geeft de inzet van de SPelerDeelname terug
	 * 
	 * @return double
	 * @roseuid 492AF33B006A
	 */
	public double geefInzet() 
	{
		return inzet;
		
	} // public double geefInzet()
	
	

	/**
	 * Wijzigt het resultaat van de deelname, bij winst zal dit een positief
	 * getal zijn en bij verlies een negatief getal.
	 * 
	 * @param resultaat
	 * @roseuid 492AF4300231
	 */
	public void zetResultaat(double resultaat) 
	{
		this.setResultaat(resultaat);
	} // public void zetResultaat(double resultaat)

	
	
	/**
	 * @param theSpeler the theSpeler to set
	 */
	public void setTheSpeler(Speler speler) 
	{
		this.theSpeler = speler;
	
	} // public void setTheSpeler(Speler theSpeler)

	
	
	/**
	 * @return the theSpeler
	 */
	public Speler getTheSpeler()
	{
		return theSpeler;
	
	} // public static Speler getTheSpeler()

	
	
	/**
	 * @param resultaat the resultaat to set
	 */
	public void setResultaat(double resultaat) 
	{
		this.resultaat = resultaat;
	
	} // public void setResultaat(double resultaat)

	
	
	/**
	 * @return the resultaat
	 */
	public double getResultaat() 
	{
		return resultaat;
	
	} // public static double getResultaat()

	
	
}
