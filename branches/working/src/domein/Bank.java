//Source file: H:\\Studie\\ZwartJas\\Workspace\\ZwartJas\\src\\domein\\Bank.java
package domein;

import java.util.HashSet;

/**
 * Houd de gegevens van de bank bij
 */
public class Bank {
	
	// -1 betekend dat het saldo nog niet is ingesteld
	private double saldo = -1;
	
	public HashSet theBankDeelname;

	
	
	/**
	 * @roseuid 49297374018B
	 */
	public Bank() 
	{
	
	} // public Bank()

	
	
	/**
	 * @param saldo
	 * @roseuid 492978F70289
	 */
	public void zetBankSaldo(double saldo) 
	{
		this.saldo = saldo;
	
	} // public void zetBankSaldo(double saldo)

	
	
	/**
	 * Maakt een bankdeelname aan, voegt deze toe aan de lijst van deelnames en
	 * geeft deze terug aan de aanroeper.
	 * 
	 * @return BankDeelname
	 * @roseuid 49299CE40150
	 */
	public BankDeelname maakDeelname() 
	{
		BankDeelname bd = new BankDeelname();
		bd.setTheBank(this);
		return bd;
	} // public BankDeelname maakDeelname()

	
	
	/**
	 * Past het saldo van de bank aan met het gegeven bedrag
	 * 
	 * @param bedrag
	 * @roseuid 492AF4FF0277
	 */
	public void saldoAanpassen(double bedrag) 
	{

	} // public void saldoAanpassen(double bedrag)

	
	
	public double geefSaldo() throws IllegalStateException {
		
		if (saldo > -1)
			return saldo;
		
		throw new IllegalStateException("Banksaldo is nog niet ingesteld");
	
	} // public double geefSaldo() throws IllegalStateException

	
	
}
