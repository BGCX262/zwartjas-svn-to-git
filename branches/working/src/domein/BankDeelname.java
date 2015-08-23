//Source file: H:\\Studie\\ZwartJas\\Workspace\\ZwartJas\\src\\domein\\BankDeelname.java
package domein;

/**
 * Zorgt voor de deelname van de bank aan het spel en houdt het puntentotaal van
 * de bank bij
 */
public class BankDeelname extends Deelname {
	
	private Bank theBank;

	
	
	/**
	 * @roseuid 4947EC74011E
	 */
	public BankDeelname() 
	{
	} // public BankDeelname()

	
	
	/**
	 * @return the theBank
	 */
	public Bank getTheBank() 
	{
		return theBank;
	}



	/**
	 * @param theBank the theBank to set
	 */
	public void setTheBank(Bank theBank) 
	{
		this.theBank = theBank;
	}

	/**
	 * Deze methode wordt aangeroepen als de Bank een kaart krijgt. Deze methode
	 * bepaalt in de superclass al het nieuwe puntentotaal etc. Deze methode
	 * voegt er de paslogica van de bank aan toe. Het IsGepast attribuut kan dus
	 * door deze methode worden gzet
	 * 
	 * @roseuid 492AEC110098
	 */
	public void bekijkKaarten() 
	{
		int waarde = 0;
		int aantalAzen = 0;
		for(Kaart k : geefDeelnameKaarten()) 
		{
			
			KaartNaam naam = k.getNaam();
			if (naam == KaartNaam.Aas)
			{
				waarde += 11;
				aantalAzen++;
			}
			else if (naam == KaartNaam.Heer)
				waarde += 3;
			else if (naam == KaartNaam.Vrouw)
				waarde += 2;
			else if (naam == KaartNaam.Boer)
				waarde +=1 ;
			else if (naam == KaartNaam.Tien)
				waarde +=10 ;
			else if (naam == KaartNaam.Negen)
				waarde +=9 ;
			else if (naam == KaartNaam.Acht)
				waarde +=8 ;
			else if (naam == KaartNaam.Zeven)
				waarde +=7 ;
		}
		if (waarde > 21)
		{
			while (aantalAzen > 0 && waarde > 21)
			{
				waarde -= 10;
				aantalAzen--;
			}
			if (waarde > 21)
				setDood(true);
		}
		// Waarschijnlijk wordt elders bepaald of de deelname heeft gewonnen
		if (waarde == 21)
			 isZwartjas(true);
		System.out.println("Puntentotaal Bank = " + waarde);
		setPuntenTotaal(waarde);

	} // public void bekijkKaarten()
	
	
}
