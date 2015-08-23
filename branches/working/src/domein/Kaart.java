//Source file: H:\\Studie\\ZwartJas\\Workspace\\ZwartJas\\src\\domein\\Kaart.java

package domein;

/**
 * Kent alle eigenschappen van een kaart: kleur, naam en plaatje Kent de waarde
 * niet, omdat die van het Spel afhankelijk is
 */
public class Kaart {

    /**
     * Geeft de kleur van de kaart aan, de mogelijke waarden zijn
     * Harten
     * Schoppen
     * Klaveren
     * Ruiten
     */
    private KaartKleur kleur;

    /**
    Mogelijke waarden:
    Aas
    (2,3,4,5,6,)7,8,9,10,Boer,Vrouw,Heer
    2 t/m 6 worden niet gebruikt bij 21
     */
    private KaartNaam naam;

    
    /**
	 * Verwijzing naar de locatie van het plaatje dat getoond moet worden als
	 * deze kart wordt getoond
     */
    private String afbeelding;
    
    private KaartStapel theKaartStapel;
    
    private PiketSpel piketSpel;
    
    private Deelname theDeelname;

    

	/**
	 * @roseuid 4947EC740006
     */
    public Kaart(KaartKleur kleur, KaartNaam naam, PiketSpel spel ) 
    {
      this.kleur = kleur;
      this.naam = naam;
      this.piketSpel = spel;
      
    } // public Kaart(KaartKleur kleur, KaartNaam naam, PiketSpel spel )
    
    
    /** 
     * Zorgt ervoor dat de properties van de kaart naar een bruikbaar plaatjesnaam worden vertaald 
     * @return
     */
    public String geefNaamPlaatje()
    {
      return "img/" + getKleur() + getNaam() + ".png";
    }
    /**
     * Geeft de naam van het plaatje dat de achterkant van de kaart moet voorstellen
     * @return
     */
    public static String geefNaamAchterkantPlaatje()
    {
     return	"img/KaartAchterkant.png";
    }
    
    /**
     * Geeft de naam van de kaart op een goed leesbare manier
     */
    public String toString()
    {
    	return this.kleur.toString() + " " + this.naam;
    	
    } // public String toString()
    
    
    
    /**
     * @return the kleur
     */
    public KaartKleur getKleur() 
    {
    	return kleur;
    }
    
    
    
    /**
     * @return the naam
     */
    public KaartNaam getNaam() 
    {
    	return naam;
    }
    
}


