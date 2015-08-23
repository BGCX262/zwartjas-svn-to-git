//Source file: H:\\Studie\\ZwartJas\\Workspace\\ZwartJas\\src\\domein\\KaartStapel.java
package domein;
import java.sql.Date;
import java.util.HashSet;
import java.util.Stack;
import java.util.Vector;
import java.util.Random;

import ui.DialogHelper;

import controller.*;

/**
Brengt de benodigde kaarten in het spel en zorgt voor het schudden en geven van 
de kaarten
 */
public class KaartStapel 
{
    private Spel theSpel;
    
    private Vector<PiketSpel> allePiketSpelen = new Vector<PiketSpel>();
    
    private Stack<Kaart> alleKaarten = new  Stack<Kaart>();
    
    
    
    /**
    @roseuid 4947EC74033D
     */
    public KaartStapel() 
    {
 
    } // public KaartStapel()
    
    
    
    /**
    Geeft de volgende kaart van de stapel 
    en verwijderd deze kaart uit de stapel
    Als de stapel leeg blijkt te zijn zorgt deze methode er ook voor
    dat er weer nieuwe kaarten worden toegevoegd
    @return Kaart
    @roseuid 4929A19C0041
     */
    public Kaart pakBovensteKaart()
    {
       	String s ="";
    	if (alleKaarten.empty()) // Stapel op dus schudden...
    		vullen();
    	Kaart k =  alleKaarten.pop();
    	System.out.println("kaart is " + k);
    	return k;
    	
    } // public Kaart pakBovensteKaart() throws EmptyStackExceptionException
    
    
    
    /**
    Er moet een nieuwe kaartstapel worden gemaakt bestaande uit 6 PiketSpelen
    @return KaartStapel
    @roseuid 492B178301CA
     */
    public static KaartStapel $maakKaartStapel() 
    {
    	KaartStapel nieuweStapel = new KaartStapel();
    	nieuweStapel.vullen();
    	return nieuweStapel;
    	
    } // public static KaartStapel $maakKaartStapel()
    
    // Gooit de oude piketspelen en eventuele overgebeleven kaarten weg en vult de stapel
    private void vullen()
    {
    	allePiketSpelen.clear();
    	alleKaarten.clear();
    	
    	//for (int i = 0; i < 6; i++) // Voor als we later toch met 6 spelen zouden spelen
  		allePiketSpelen.add(new PiketSpel(this));
  		
    	Vector<Kaart> kaarten = new Vector<Kaart>();
    	for (PiketSpel spel : allePiketSpelen)
    		kaarten.addAll(spel.geefKaarten());
    	
    	// Schudden
    	// Zelf een seed maken is volgens de documentatie niet nodig 
    	// Bleek bij testen ook te kloppen
    	Random rnd = new Random();
    	while (!kaarten.isEmpty())
    	{
    		int volgendeKaartIndex = rnd.nextInt(kaarten.size());
    		alleKaarten.push(kaarten.elementAt(volgendeKaartIndex));
    		kaarten.remove(volgendeKaartIndex);
    	}
    }
}


