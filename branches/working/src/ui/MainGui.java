package ui;

import domein.*;
import controller.*;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;

import controller.SpelrondeController;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class MainGui extends javax.swing.JFrame {
	
	private static MainGui $mainGui;
	
	/**
	 * Acces voor singleton MainGui
	 * Zorgt ervoor dat als ie nog niet bestaat hij gemaakt wordt
	 */
	public static MainGui $getGui()
	{
		if ($mainGui == null)
		{
			$mainGui = new MainGui();
			$mainGui.setLocationRelativeTo(null);
			$mainGui.getJMenuBar().setBounds(-5, 0, 40, 25);
			$mainGui.setVisible(true);
		}
		return $mainGui;
	}
	
	public static void $refreshGui()
	{
		if ($mainGui != null)
		{
			$mainGui.setVisible(false);
			$mainGui = null;
		}
		$getGui().setVisible(true);
	}
	
	
	// bank
	private JLabel lBank;
	private JPanel pBank;
	
	// Spelersveld
	private JPanel pSpelers;
	private JPanel[] pSpeler;
	private JButton[] bInzet;
	private JButton[] bPass;
	private JButton[] bKaart;
	private JButton[] bVuile;
	private JLabel[] lSpelerNaam;
	private JPanel[] pInfo;
	private JLabel[] lSaldo;
	private JLabel[] lInzet;
	private JLabel[] lSpeler;
	// Kaarten
	private JLabel lBankKaart;
	private JLabel[] lSpelKaart = new JLabel[40];
	// menuitems
	private JMenuItem spelerMenuItem;
	private JMenuItem newSpel;
	private JMenuItem voortgangMenuItem;
	private JMenuItem closeFileMenuItem;
	private JMenuItem exitMenuItem;
	private JMenuItem helpMenuItem;
	private JMenuItem aboutMenuItem;
	private JMenu jMenu3;
	private JMenu jMenu5;
	private JMenuBar jMenuBar1;
	private JSeparator jSeparator1;
	private JSeparator jSeparator2;

	//
	private Deelname dn;
	public Speler sp;

	private Vector<Kaart> kn;
	public RegistratieController rc;
	public SpelersGui sg;
	public OverzichtGui og;
	private int i = 0;


	
	/**
	 * Auto-generated main method to display this JFrame
	 */
	/**
	 * public static void main(String[] args) { SwingUtilities.invokeLater(new
	 * Runnable() { public void run() { MainGui inst = new MainGui();
	 * inst.setLocationRelativeTo(null); inst.setVisible(true);
	 * inst.getJMenuBar().setBounds(-5, 0, 40, 25); } }); }
	 */

	
	
	private MainGui() 
	{
		super();
		// Spelers();
		initGUI();
	
	} // public MainGui()

	
	
	private void initGUI() 
	{
		try {
			{
				getContentPane().setBackground(new java.awt.Color(54, 190, 54));
				getContentPane().setLayout(null);
				this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("img/kuser.png")).getImage());
				this.setTitle("ZwartJas");
				this.setVisible(true);
				this.setJMenuBar(jMenuBar1);
				this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				{
					GridLayout SpeelveldLayout = new GridLayout(1, 1);
					SpeelveldLayout.setColumns(1);
					SpeelveldLayout.setHgap(5);
					SpeelveldLayout.setVgap(5);
				}
				{
					pBank = new JPanel();
					getContentPane().add(pBank);
					pBank.setBounds(205, 80, 599, 126);
					pBank.setBackground(new java.awt.Color(14, 168, 14));
					pBank.setBorder(new LineBorder(
							new java.awt.Color(9, 120, 9), 2, true));
				}
				{

				}
			}
			this.setSize(1000, 700);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				jMenuBar1.setPreferredSize(new java.awt.Dimension(4, 25));
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("Bestand");
					jMenu3.setPreferredSize(new java.awt.Dimension(65, 24));
					jMenu3.setSize(65, 24);
					jMenu3.setBorder(BorderFactory
							.createEmptyBorder(0, 0, 0, 0));
					jMenu3.setFont(new java.awt.Font("Arial", 0, 12));
					{
						newSpel = new JMenuItem();
						jMenu3.add(newSpel);
						newSpel.setText("Nieuwe ronde");
						newSpel.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								newSpelActionPerformed(evt);
							}
						});
					}
					{
						spelerMenuItem = new JMenuItem();
						jMenu3.add(spelerMenuItem);
						spelerMenuItem.setText("Spelers");
						spelerMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								newSpelerActionPerformed(evt);
							}
						});
					}
					{
						voortgangMenuItem = new JMenuItem();
						jMenu3.add(voortgangMenuItem);
						voortgangMenuItem.setText("Voortgang");
						voortgangMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								voortgangMenuItemActionPerformed(evt);
							}
						});
					}
					
					{
						jSeparator1 = new JSeparator();
						jMenu3.add(jSeparator1);
					}
					{
						exitMenuItem = new JMenuItem();
						jMenu3.add(exitMenuItem);
						exitMenuItem.setText("Exit");
						exitMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								exitMenuItemActionPerformed(evt);
							}
						});
					}
				}
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					jMenu5.setText("Help");
					jMenu5.setFont(new java.awt.Font("Arial", 0, 12));
					{
						helpMenuItem = new JMenuItem();
						jMenu5.add(helpMenuItem);
						helpMenuItem.setText("Help");
					}
					{
						jSeparator2 = new JSeparator();
						jMenu5.add(jSeparator2);
					}
					{
						aboutMenuItem = new JMenuItem();
						jMenu5.add(aboutMenuItem);
						aboutMenuItem.setText("Over");
						aboutMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								aboutMenuItemActionPerformed(evt);
							}
						});
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	} // private void initGUI()

	public void Spelers() 
	{
		DecimalFormat nf = new DecimalFormat("###.00");
		pSpelers = new JPanel();
		FlowLayout jpanelLayout = new FlowLayout(FlowLayout.CENTER, 25, 5);
		getContentPane().add(pSpelers);
		pSpelers.setBounds(0, 285, 992, 320);
		pSpelers.setLayout(jpanelLayout);
		pSpelers.setOpaque(false);
		{
			lBank = new JLabel();
			getContentPane().add(lBank);
			lBank.setText("Bank");
			lBank.setFont(new java.awt.Font("AlArabiya", 1, 24));
			lBank.setBounds(375, 37, 260, 39);
			lBank.setHorizontalAlignment(SwingConstants.CENTER);
		}
		{
			
Vector<SpelerDeelname> deelnames = SpelrondeController.$getController().geefActieveSpelRonde().geefAlleSpelerDeelnames();
			int p = deelnames.size();
			pSpeler = new JPanel[p];
			lSpeler = new JLabel[p];
			lSpelerNaam = new JLabel[p];
			pInfo = new JPanel[p];
			lSaldo = new JLabel[p];
			lInzet = new JLabel[p];
			bVuile = new JButton[p];
			bPass = new JButton[p];
			bKaart = new JButton[p];
			bInzet = new JButton[p];

			for (int t = 0; t < p; t++) 
			{ 

				dn = deelnames.get(t);
				sp = ((SpelerDeelname) dn).getTheSpeler();
				StringTokenizer sNaam = new StringTokenizer(sp.getNaam());
				String capNaam = "";
			
				while (sNaam.hasMoreTokens()) {
					String s = sNaam.nextToken();
					capNaam += s.substring(0, 1).toUpperCase()
							+ s.substring(1).toLowerCase() + " ";
				}
				
				pSpeler[i] = new JPanel();
				pSpelers.add(pSpeler[i]);
				pSpeler[i].setPreferredSize(new java.awt.Dimension(	220, 300));
				pSpeler[i].setBackground(new java.awt.Color(14,	168, 14));
				pSpeler[i].setBorder(new LineBorder(new java.awt.Color(9, 120, 9), 2, true));
				
				pSpeler[i].setLayout(null);
				{
					lSpeler[i] = new JLabel();
					pSpeler[i].add(lSpeler[i]);
					lSpeler[i].setText("Speler " + (i + 1));
					lSpeler[i].setFont(new java.awt.Font("Arial", 1, 20));
					lSpeler[i].setBounds(1, 1, 218, 23);
					lSpeler[i].setHorizontalAlignment(SwingConstants.CENTER);
				}
				{
					lSpelerNaam[i] = new JLabel();
					pSpeler[i].add(lSpelerNaam[i]);
					lSpelerNaam[i].setText(capNaam);
					lSpelerNaam[i].setBounds(1, 24, 218, 22);
					lSpelerNaam[i].setFont(new java.awt.Font("Arial", 1, 18));
					lSpelerNaam[i].setEnabled(false);
					lSpelerNaam[i]
							.setHorizontalAlignment(SwingConstants.CENTER);
					lSpelerNaam[i].setForeground(new java.awt.Color(0, 0, 0));
				}
				{
					pInfo[i] = new JPanel();
					pSpeler[i].add(pInfo[i]);
					pInfo[i].setBounds(13, 181, 194, 106);
					pInfo[i].setBackground(new java.awt.Color(54, 190, 54));
					pInfo[i].setBorder(new LineBorder(new java.awt.Color(9,
							120, 9), 1, false));
					pInfo[i].setLayout(null);
					{
						lInzet[i] = new JLabel();
						pInfo[i].add(lInzet[i]);
						lInzet[i].setText("Inzet: "
								+ nf.format(((SpelerDeelname)dn).geefInzet()));
						lInzet[i].setBounds(1, 7, 176, 25);
						lInzet[i].setFont(new java.awt.Font("Arial", 1, 16));
					}
					{
						lSaldo[i] = new JLabel();
						pInfo[i].add(lSaldo[i]);
						lSaldo[i].setText("Saldo: "
								+ nf.format(sp.getSaldo()));
						lSaldo[i].setBounds(1, 32, 176, 25);
						lSaldo[i].setFont(new java.awt.Font("Arial", 1, 16));
					}
					{
						bInzet[i] = new JButton();
						pInfo[i].add(bInzet[i]);
						bInzet[i].setText("Inzet");
						bInzet[i].setBounds(1, 63, 96, 22);
						bInzet[i].setAlignmentY(0.0f);
						bInzet[i].setMargin(new java.awt.Insets(1, 1, 1, 1));
						bInzet[i].setFont(new java.awt.Font("Arial", 0, 12));
						bInzet[i].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								InzetActionPerformed(evt);
							}
						});
					}
					{
						bKaart[i] = new JButton();
						pInfo[i].add(bKaart[i]);
						bKaart[i].setText("Kaart");
						bKaart[i].setBounds(97, 63, 96, 22);
						bKaart[i].setFont(new java.awt.Font("Arial", 0, 12));
						bKaart[i].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								KaartActionPerformed(evt);
							}
						});
					}
					{
						bPass[i] = new JButton();
						pInfo[i].add(bPass[i]);
						bPass[i].setText("Pass");
						bPass[i].setMargin(new java.awt.Insets(1, 1, 1, 1));
						bPass[i].setFont(new java.awt.Font("Arial", 0, 12));
						bPass[i].setAlignmentY(0.0f);
						bPass[i].setBounds(1, 85, 94, 22);
						bPass[i].setSize(96, 22);
						bPass[i].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								PassActionPerformed(evt);
							}
						});
					}
					{
						bVuile[i] = new JButton();
						JButton bv = bVuile[i];
						pInfo[i].add(bv);
						bVuile[i].setText("Vuile Was");
						bVuile[i].setBounds(97, 85, 96, 22);
						bVuile[i].setAlignmentY(0.0f);
						bVuile[i].setMargin(new java.awt.Insets(1, 0, 1, 0));
						bVuile[i].setFont(new java.awt.Font("Arial", 0, 12));
						bVuile[i].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								VuileWasActionPerformed(evt);
							}
						});
					}
					toonDeelnameKaarten(dn);
				}
				i++;

			}
		}
		toonBankKaarten();
	
	} // public void Spelers()

	/**
	 * Toont de kaarten van de spelerdeelname, moet aangeroepen worden als een spelerdeelname nieuwe kaarten heft gekregen
	 * @param dn
	 */
	public void toonDeelnameKaarten(Deelname dn) 
	{
		i = SpelrondeController.$getController().geefActieveSpelRonde().geefAlleDeelnames().indexOf(dn);
		kn = dn.geefDeelnameKaarten();
		int aant = 10 * i;
		if (kn==null) {
			System.out.println("geen kaarten");
		}
		else
		{
			int left = 10 + 20 * (kn.size()-1);
			for (int t = 0; t < kn.size() -1 ; t++) {
				pSpeler[i].remove(lSpelKaart[t + aant]);
			}
			// Achteruit loopen, naders vallen de kaarten niet mooi over elkaar
			for (int t = kn.size() -1 ; t >= 0; t--) {
				Kaart k = kn.get(t);
				String kaart = "img/" + k.getKleur() + k.getNaam() + ".png";
				Icon icon = (new ImageIcon(getClass().getClassLoader().getResource(kaart)));
				lSpelKaart[t + aant] = new JLabel();
				pSpeler[i].add(lSpelKaart[t + aant]);
				lSpelKaart[t + aant].setVisible(true);
				lSpelKaart[t + aant].setIcon(icon);
				lSpelKaart[t + aant].setBounds(left, 50, 75, 112);
				
				left -= 20;
			}
		}
		lInzet[i].setText("Inzet : " + ((SpelerDeelname)dn).geefInzet());
		repaint();
	}
	
	/**
	 * De geplaatste JLabels worden hierin bijgehouden, zodat ze de volgende keer weer kunnen worden opgeruimd
	 */
	Vector<JLabel> bankKaartLabels = new Vector<JLabel>();
	
	/**
	 * Zorgt ervoor dat de kaarten van de bankdeelname netjes worden getoond
	 */
	public void toonBankKaarten() 
	{
		// Eerst de oude kaarten opruimen
		if (bankKaartLabels.size()>0)
		{
			for (JLabel l : bankKaartLabels)
				pBank.remove(l);
			bankKaartLabels.clear();
		}
		
		dn = SpelrondeController.$getController().geefActieveSpelRonde().geefBankDeelname();
		kn = dn.geefDeelnameKaarten();
		
		if (kn==null) {
			System.out.println("geen kaarten");
		}
		else
		{
			// Hier wordt flowlayout gebruikt, dus we hoeven niets te doen om de kaarten mooi te paatsen
			for (int t = 0 ; t <  kn.size(); t++) {
				Kaart k = kn.get(t);
				// Zolang de bank nog maar één kaart heeft mag niemand die zien
				String kaartPlaatje = kn.size() == 1 ? Kaart.geefNaamAchterkantPlaatje() : k.geefNaamPlaatje();
				Icon icon = (new ImageIcon(getClass().getClassLoader().getResource(kaartPlaatje)));
				lBankKaart = new JLabel();
				pBank.add(lBankKaart);
				bankKaartLabels.add(lBankKaart);
				lBankKaart.setVisible(true);
				lBankKaart.setIcon(icon);
				lBankKaart.setBounds(5, 5, 75, 112);
			}
		}
	 this.repaint();

	}	
	
	public void SpelerNonActief(Deelname dn)
	{
		System.out.println(dn);
	} //public void SpelerNonActief(Deelname dn)

	private void voortgangMenuItemActionPerformed(ActionEvent evt) {
		og = new OverzichtGui();
		og.setVisible(true);
	
	} // private void voortgangMenuItemActionPerformed(ActionEvent evt)

	
	
	private void newSpelActionPerformed(ActionEvent evt) 
	{
	
		SpelrondeController.$getController().startSpelronde();
	
	} // private void newFileMenuItemActionPerformed(ActionEvent evt)

	
	
	private void exitMenuItemActionPerformed(ActionEvent evt) 
	{
		System.exit(0);
	
	} // private void exitMenuItemActionPerformed(ActionEvent evt)

	
	
	private void aboutMenuItemActionPerformed(ActionEvent evt) 
	{
		DialogHelper
				.$showInfoMessage("ZWARTJAS\n\nZwartJas is ontwikkeld door:\n\n- Nico Dros\n- Jeroen Sen\n- Erwin Goossen\n- Bas Elbers\n\nVeel Plezier!!");
	} // private void aboutMenuItemActionPerformed(ActionEvent evt)

	
	
	private void newSpelerActionPerformed(ActionEvent evt)
	{
		sg = new ui.SpelersGui();
		sg.setVisible(true);
		rc = new RegistratieController(sg);

	} // private void spelerMenuItemActionPerformed(ActionEvent evt)
	
	
	/**
	 * Afhandelen van de buttons Inzet voor de spelers.
	 * 
	 * @param evt
	 */
	private void InzetActionPerformed(ActionEvent evt) 
	{

	SpelerDeelname inzetter = null;
		
	// BUG gevonden, i wordt ergens op 0 gezet lang leve die fucking global variables
		//for (int t = 0; t < i; t++) {
		for (int t = 0; t < SpelrondeController.$getController().geefActieveSpelRonde().geefAlleSpelerDeelnames().size(); t++) {
			if (evt.getSource() == bInzet[t]) {
				inzetter = SpelrondeController.$getController().geefActieveSpelRonde().geefAlleSpelerDeelnames().get(t);
				break;			
			}
		}
		
		if (inzetter != null)
		{
			Double inzet = (double)0;
			try
			{
				inzet = Double.parseDouble(DialogHelper
						.$showInputDialog("Geef je inzet."));
			}
			catch (Exception x)
			{
				// Smerig en kort door de bocht, maar ik weet dat dit in de spelronde wordt opgelost op een mooiere manier
				inzet = (double)-1;
			}			
			SpelrondeController.$getController().inzetten(inzetter, inzet);
			
		}
	} //private void InzetActionPerformed(ActionEvent evt)


	/**
	 * Afhandelen van de buttons Kaart voor de spelers.
	 * 
	 * @param evt
	 */
	private void KaartActionPerformed(ActionEvent evt) 
	{
		SpelerDeelname kaartWenser = null;
		// BUG gevonden, i wordt ergens op 0 gezet lang leve die fucking global variables
		//for (int t = 0; t < i; t++) {
		for (int t = 0; t < SpelrondeController.$getController().geefActieveSpelRonde().geefAlleSpelerDeelnames().size(); t++) {
			if (evt.getSource() == bKaart[t]) {
				kaartWenser = SpelrondeController.$getController().geefActieveSpelRonde().geefAlleSpelerDeelnames().get(t);
				break;
			}
		}
			
		if (kaartWenser != null)
		{
			SpelrondeController.$getController().nogEenKaart(kaartWenser);
			
		}
		
	} //private void KaartActionPerformed(ActionEvent evt)

	
	/**
	 * Afhandelen van de buttons Pass voor de spelers.
	 * 
	 * @param evt
	 */
	private void PassActionPerformed(ActionEvent evt) 
	{
		SpelerDeelname pasMeneertje = null;
		// BUG gevonden, i wordt ergens op 0 gezet lang leve die fucking global variables
		//for (int t = 0; t < i; t++) {
		for (int t = 0; t < SpelrondeController.$getController().geefActieveSpelRonde().geefAlleSpelerDeelnames().size(); t++) {
			if (evt.getSource() == bPass[t]) {
				pasMeneertje = SpelrondeController.$getController().geefActieveSpelRonde().geefAlleSpelerDeelnames().get(t);
				break;
			}
		}
		if (pasMeneertje != null)
		{
			SpelrondeController.$getController().pas(pasMeneertje);
			
		}
		
	} //private void PassActionPerformed(ActionEvent evt)

	
	/**
	 *Afhandelen van de buttons Vuile Was voor de spelers.
	 * 
	 * @param e
	 */
	private void VuileWasActionPerformed(ActionEvent evt) 
	{
		SpelerDeelname wasvrouw = null;
		// BUG gevonden, i wordt ergens op 0 gezet lang leve die fucking global variables
		//for (int t = 0; t < i; t++) {
		for (int t = 0; t < SpelrondeController.$getController().geefActieveSpelRonde().geefAlleSpelerDeelnames().size(); t++) {
			if (evt.getSource() == bVuile[t]) {
				wasvrouw = SpelrondeController.$getController().geefActieveSpelRonde().geefAlleSpelerDeelnames().get(t);
				break;
				}
		}
		SpelrondeController.$getController().vuileWas(wasvrouw);
		
	} //private void VuileWasActionPerformed(ActionEvent evt) 


/**
 * Zorgt ervoor dat de gegevens speler de actieve speler is en dat de correcte knopjes voor die speler worden klaargezet
 * De knopjes van de andere spelers worden gedeactiveerd
 * @param volgendeSpeler
 */
	public void activeerSpeler(SpelerDeelname volgendeSpeler) {
		int actiefIndex = -1; // Geen actieve speler		
		if (volgendeSpeler != null)
		{
			actiefIndex = SpelrondeController.$getController().geefActieveSpelRonde().geefAlleSpelerDeelnames().indexOf(volgendeSpeler);
		}
		for (int i = 0 ; i < SpelrondeController.$getController().geefActieveSpelRonde().geefAlleSpelerDeelnames().size();i++)
		{
			if (i != actiefIndex)
			{
				bPass[i].setEnabled(false);
				bVuile[i].setEnabled(false);
				bKaart[i].setEnabled(false);
				bInzet[i].setEnabled(false);
			}
			else
			{
				bPass[i].setEnabled(volgendeSpeler.geefDeelnameKaarten().size()>=2);
				// Toch wel leuk om foutmelding te geven bij onterecht drukken
				bVuile[i].setEnabled(volgendeSpeler.geefDeelnameKaarten().size()== 2); 
				bKaart[i].setEnabled(volgendeSpeler.geefDeelnameKaarten().size()>=2);
				bInzet[i].setEnabled(volgendeSpeler.geefDeelnameKaarten().size()<=2);
			}
			
		}
		// TODO Auto-generated method stub
		
	}



}
