//Source file: H:\\Studie\\ZwartJas\\Workspace\\ZwartJas\\src\\domein\\Deelname.java
package domein;

import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

import javax.swing.SwingUtilities;

import ui.InzetGui;

import controller.SpelrondeController;

public class Deelname {
	
	private int puntenTotaal;
	
	private boolean dood = false;
	
	private boolean zwartjas = false;
	
	private boolean heeftVuileWas = false;
	
	private boolean isGepast = false;
	
	/**
	 * Geeft aan of de speler nog behoefte heeft aan een beurt
	 * @return
	 */
	public boolean wilNogEenBeurt()
	{
		return !dood && !isGepast && !zwartjas;
	}
	
	private Spelronde theSpelronde;
	
	private Vector<Kaart> deelnameKaarten = new Vector<Kaart>();
	
//	private SpelrondeController sc;
	

	
	/**
	 * @roseuid 4947EC730249
	 */
	public Deelname() 
	{

	} // public Deelname()

	
	
	
	/**
	 * @return boolean
	 * @roseuid 4929A33C0093
	 */
	// Vervangen door een getter en setter voor dood
//	public  boolean isDood() 
//	{
//		return dood;
//	}

	
	
	/**
	 * @param theKaart the theKaart to set
	 */
	public void setTheKaart(Vector<Kaart> theKaart) 
	{
		this.deelnameKaarten = theKaart;
	}




	/**
	 * Voegt een kaart toe aan een deelname
	 * 
	 * @param kaart
	 * @roseuid 492AE34F03CC
	 */
	public void geefKaart(Kaart kaart) 
	{
		deelnameKaarten.add(kaart);
		bekijkKaarten();
	
	} // public void geefKaart(Kaart kaart)
	
	
	
	/**
	 * Geeft de vector met kaarten
	 * 
	 * @return Vector
	 */
	public Vector<Kaart> geefDeelnameKaarten()
	{
		return deelnameKaarten;
	
	} // public static Vector<Kaart> getKaart()

	
	
	/**
	 * Bekijkt welke kaarten de deelname nu heeft en bepaald het nieuwe
	 * puntenaantal, of er sprake is van vuile was, of de deelname 21 heeft
	 * behaald en of de deelname
	 * 
	 * kapot is gegaan (meer dan 21 punten heeft behaald)
	 * 
	 * @roseuid 492AE39500B9
	 */
	public void bekijkKaarten() 
	{
		int waarde = 0;
		int aantalAzen = 0;
		boolean zevenVuileWas = false;
		boolean achtVuileWas = false;
		for(Kaart k : deelnameKaarten) {
			
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
			{
				achtVuileWas = true;
				waarde +=8 ;
			}
			else if (naam == KaartNaam.Zeven)
			{
				zevenVuileWas = true;
				waarde +=7 ;
			}
		}
		if (zevenVuileWas && achtVuileWas && deelnameKaarten.size() == 2)
			this.heeftVuileWas = true;
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

		if (waarde == 21)
			 zwartjas = true;

		puntenTotaal = waarde;
		System.out.println("puntenTotaal (deelname) is " + puntenTotaal);
	
	} // public void bekijkKaarten()

	
	
	/**
	 * Past voor deze deelname. isGepast wordt waar, de deelname zal geen
	 * kaarten meer krijgen.
	 * @param d 
	 * 
	 * @roseuid 492AEB1E00A2
	 */
	public void pas() 
	{
		isGepast = true;

	} // public void pas()
	
	
	
	/**
	 * status van isGepast wordt geretourneerd.
	 */
	public boolean gePast() 
	{
		return isGepast;
	
	} // public boolean gePast()

	
	
	/**
	 * Geeft het huidige puntentotaal van de deelname terug
	 * static verwijderd door b@s, puntentotaal hoort bij de objecten zelf.
	 * @return int
	 * @roseuid 492AF3670246
	 */
	public int geefPuntenTotaal() 
	{
		return puntenTotaal;
	
	} // public static int geefPuntenTotaal()

	public boolean getHeeftVuileWas()
	{
		return heeftVuileWas;
	}

	/*
	 * Als Deelname 21 punten heeft dan wordt zwartjas op true gezet.
	 * zet de status op true.
	 */
	public void isZwartjas(boolean zwartjas) {
		this.zwartjas = zwartjas;
	}

	/*
	 * roept de status van zwartjas op.
	 */
	public boolean geefZwartjas() {
		return zwartjas;
	}
	
	/**
	 * @param dood the dood to set
	 * static weggehaald door b@s.
	 * is gewoon nodig per deelname!
	 */
	public void setDood(boolean dood) 
	{
		this.dood = dood;
	
	} // public void setDood(boolean dood)

	
	
	/**
	 * @return the dood
	 * static weggehaald door b@s.
	 */
	public boolean getDood() 
	{
		return dood;
	
	} // public boolean getDood()

	/**
	 * @param theSpelronde the theSpelronde to set
	 */
	public void setTheSpelronde(Spelronde theSpelronde) {
		this.theSpelronde = theSpelronde;
	}

	/**
	 * @return the theSpelronde
	 */
	public Spelronde getTheSpelronde() {
		return theSpelronde;
	}




	public void setPuntenTotaal(int puntenTotaal) {
		this.puntenTotaal = puntenTotaal;
	}

}
