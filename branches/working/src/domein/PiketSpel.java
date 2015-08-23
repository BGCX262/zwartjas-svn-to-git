//Source file: H:\\Studie\\ZwartJas\\Workspace\\ZwartJas\\src\\domein\\PiketSpel.java
package domein;
import java.util.HashSet;
import java.util.Vector;

/**
Creëert een volledig piket-kaartspel : 4 kleuren 7 t/m aas en houdt het bij.
 */
public class PiketSpel 
{
    private KaartStapel kaartStapel;
    
    private Vector<Kaart> alleKaarten;
    
    
    
    /**
    @roseuid 4947EC730349
     */
    public PiketSpel(KaartStapel stapel) 
    {
    	kaartStapel = stapel;
    	alleKaarten = new Vector<Kaart>();
    	Vector<KaartKleur> kleuren = new Vector<KaartKleur>();
    	kleuren.add(KaartKleur.Harten);
    	kleuren.add(KaartKleur.Ruiten);
    	kleuren.add(KaartKleur.Schoppen);
    	kleuren.add(KaartKleur.Klaveren);
    	// Het betreft een piketspel, dus kaarten 2-6 moeten niet worden meegenomen
    	Vector<KaartNaam> namen = new Vector<KaartNaam>();
     	namen.add(KaartNaam.Aas );
    	namen.add(KaartNaam.Zeven );
    	namen.add(KaartNaam.Acht );
    	namen.add(KaartNaam.Negen );
    	namen.add(KaartNaam.Tien );
    	namen.add(KaartNaam.Boer );
    	namen.add(KaartNaam.Vrouw );
    	namen.add(KaartNaam.Heer );    	
    	
    	for (KaartKleur kleur :  kleuren) {
    		for (KaartNaam naam : namen)
    		{
    			alleKaarten.add(new Kaart(kleur,naam,this));
    		}
    	}
    
    } // public PiketSpel(KaartStapel stapel)
    
    
    
    public Vector<Kaart> geefKaarten()
    {
    	return alleKaarten;
    	
    } // public Vector<Kaart> geefKaarten()
    
    
    
}
