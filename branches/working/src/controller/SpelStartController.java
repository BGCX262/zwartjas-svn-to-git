//Source file: H:\\Studie\\ZwartJas\\Workspace\\ZwartJas\\src\\controller\\SpelStartController.java
package controller;

import ui.*;
import domein.*;
import controller.*;

/**
 * Klein regeltje om te kunnen comitten
 * Verantwoordelijk voor het uitvoeren van Use Case Spel Starten
 */
public class SpelStartController {

	private InzetGui startScherm;
	
	private static MainGui mg;
	
	private SpelrondeController sc;
	
	private static VoorbereidingController vc;// = new VoorbereidingController()
	
	
	/**
	 * @roseuid 492972CF0241
	 */
	public SpelStartController() {
		
	} // public SpelStartController()
	
	
	/**
	 * Zorgt ervoor dat het spel wordt gemaakt het hoofdscherm wordt getoond en dat de startinvoer wordt gedaan
	 */
	public void spelVoorbereiden()
	{
		mg = MainGui.$getGui();
		

		Spel.$maakNieuwSpel();
		startScherm = new InzetGui(this);
		startScherm.setVisible(true);

	} // public void spelVoorbereiden()
	
	
	
	public void zetSpelers() 
	{
		mg.Spelers();
	
	} // public void zetSpelers()

	
	
	/**
	 * Stelt de minimum- en maximuminzet voor de duur van het programma in.
	 * Stelt ook het beginsaldo in. Het Spel zal een exception gooien als er een
	 * probleem is met de min- maxinzet of het banksaldo.
	 * 
	 * @param minimumInzet
	 * @param maximumInzet
	 * @param bankSaldo
	 * @return boolean
	 * @throws java.lang.IllegalArgumentException
	 * @roseuid 492975DE0037
	 */
	public void bepaalStartWaardes(double minimumInzet, double maximumInzet, double bankSaldo) throws IllegalArgumentException 
	{
		Spel spel = Spel.$geefActiefSpel();
		spel.zetInzet(minimumInzet, maximumInzet);
		spel.zetStartSaldo(bankSaldo);
	
	} // public void bepaalStartWaardes(double minimumInzet, double maximumInzet, double bankSaldo) throws IllegalArgumentException

	
	
	/**
	 * Controleer of de begininstellingen correct zijn gedaan en start het spel:
	 * Use Case Overzicht wordt gestart
	 * Gooit een exception als minimumInzet, maximumInzet en bankSaldo nog niet zijn gezet op het Spel
	 * @roseuid 49297A290140
	 */
	public void startSpel() throws IllegalStateException 
	{
		Spel spel = Spel.$geefActiefSpel();
		double test;
		// Alle drie de methodes zouden een IllegalStateException moeten gooien als de waarde nog niet goed is gezet
		test = spel.geefMinimumInzet();
		test = spel.geefMaximumInzet();
		test = spel.geefBankSaldo();
		startScherm.setVisible(false);
		startScherm.dispose();
		vc = new VoorbereidingController();
		vc.toonOverzicht();
	
	} // public void startSpel() throws IllegalStateException
	
	
	
	/**
	 * @return the vc
	 */
	public static VoorbereidingController $geefVoorbereidingController() {
		return vc;
	}


	/**
	 * @return the mainGui
	 */
	public static MainGui $getMainGui() 
	{
		return mg;
	} // public static MainGui getMainGui()
	
	
	
}
