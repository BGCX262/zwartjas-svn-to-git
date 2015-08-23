package ui;
import com.cloudgarden.resource.ArrayFocusTraversalPolicy;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import controller.*;

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
@SuppressWarnings("serial")
public class SpelersGui extends javax.swing.JFrame {
	private JPanel pInzet;
	
	private JLabel lStart;
	
	private JLabel lMax;
	
	private JTextField tSaldo;

	private JLabel lSaldo;

	private JTextField tNaam;
	
	private JLabel lMin;

	private JComboBox jJaar;
	
	private JComboBox jMaand;
	
	private JComboBox jDag;
	

	public Object[] dag;
	
	public Object[] maand;
	
	private JLabel lSpAantal;
	
	private JPanel pSelecteer;
	
	public Object[] jaar;
	
	private JScrollPane jScrollPane1;
	
	private JScrollPane jScrollPane2;
	
	private JList lSpelers;
	
	private JList lActief;
	
	public static DefaultListModel mod1;
	
	public static DefaultListModel mod2;
	
	private JButton bVerwijder;
	
	private JButton bVoegToe;
	
	private JButton bKlaar;
	
	private JButton bVolgende;

	public RegistratieController regCntrl;

	public SpelrondeController sc;
	
	
	
	/**
	 * Auto-generated main method to display this JFrame
	 * 
	 * public static void main(String[] args) { SwingUtilities.invokeLater(new
	 * Runnable() { public void run() { SpelersGui inst = new SpelersGui();
	 * inst.setLocationRelativeTo(null); inst.setVisible(true);
	 * 
	 * // regCntrl = new RegistratieController(inst); } }); }
	 */
	public SpelersGui() 
	{
		super();
		initGUI();
		RegistratieController.zetSpelerTabel();
		SpelerAantal();
	
	} // public SpelersGui()

	
	
	public void initGUI() 
	{
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
//			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("img/kuser.png")).getImage());
			this.setTitle("Spelers toevoegen");
			this.setVisible(true);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("img/schoppenklein.png")).getImage());
			this.setLocation(new java.awt.Point(200, 200));
			// Titel scherm
			{
				lStart = new JLabel();
				getContentPane().add(lStart);
				lStart.setText("Spelers");
				lStart.setHorizontalAlignment(SwingConstants.CENTER);
				lStart.setBackground(new java.awt.Color(54, 190, 54));
				lStart.setFont(new java.awt.Font("Arial", 1, 36));
				lStart.setForeground(new java.awt.Color(0, 128, 64));
				lStart.setOpaque(true);
				lStart.setBounds(0, 0, 336, 49);
				lStart.setIcon(new ImageIcon(getClass().getClassLoader()
						.getResource("img/kuser.png")));
			}
			// Invoervelden
			{
				pInzet = new JPanel();
				getContentPane().add(pInzet);
				pInzet.setBorder(BorderFactory.createTitledBorder(null,
						"Speler", TitledBorder.LEADING, TitledBorder.TOP,
						new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(
								90, 90, 90)));
				pInzet.setLayout(null);
				pInzet.setBounds(14, 56, 308, 161);
				{
					lMin = new JLabel();
					pInzet.add(lMin);
					lMin.setText("Naam");
					lMin.setFont(new java.awt.Font("Arial", 0, 12));
					lMin.setBounds(17, 24, 44, 27);
				}
				{
					lMax = new JLabel();
					pInzet.add(lMax);
					lMax.setText("Geb.datum");
					lMax.setFont(new java.awt.Font("Arial", 0, 12));
					lMax.setBounds(17, 57, 64, 25);
				}
				{
					tNaam = new JTextField();
					pInzet.add(tNaam);
					tNaam.setBounds(84, 21, 189, 21);
					tNaam.setFont(new java.awt.Font("Arial", 0, 12));
				}
				{
					lSaldo = new JLabel();
					pInzet.add(lSaldo);
					lSaldo.setText("Saldo");
					lSaldo.setBounds(17, 94, 57, 18);
					lSaldo.setFont(new java.awt.Font("Arial", 0, 12));
				}
				{
					tSaldo = new JTextField();
					pInzet.add(tSaldo);
					tSaldo.setBounds(84, 91, 189, 21);
					tSaldo.setFont(new java.awt.Font("Arial", 0, 12));
					tSaldo.setToolTipText("Voer het startsaldo van de toe te voegen speler in.");
				}
				{
					dag = new Object[31];
					for (int i = 0; i < 31; i++) {
						dag[i] = i + 1;
					}
					ComboBoxModel jDagModel = new DefaultComboBoxModel(dag);
					jDag = new JComboBox();
					pInzet.add(jDag);
					jDag.setModel(jDagModel);
					jDag.setBounds(84, 59, 39, 21);
				}
				{
					maand = new Object[12];
					for (int i = 0; i < 12; i++) {
						maand[i] = i + 1;
					}
					ComboBoxModel jMaandModel = new DefaultComboBoxModel(maand);
					jMaand = new JComboBox();
					pInzet.add(jMaand);
					jMaand.setModel(jMaandModel);
					jMaand.setBounds(123, 59, 43, 21);
				}
				{
					jaar = new Object[90];
					for (int i = 0; i < 90; i++) {
						jaar[i] = i + 1920;
					}
					ComboBoxModel jJaarModel = new DefaultComboBoxModel(jaar);
					jJaar = new JComboBox();
					pInzet.add(jJaar);
					jJaar.setModel(jJaarModel);
					jJaar.setSelectedIndex(70);
					jJaar.setBounds(167, 59, 63, 21);
				}
				{
					bVolgende = new JButton();
					pInzet.add(bVolgende);
					bVolgende.setText("Voeg toe");
					bVolgende.setBounds(217, 126, 77, 21);
					bVolgende.setFont(new java.awt.Font("Arial", 0, 12));
					bVolgende.setMargin(new java.awt.Insets(1, 1, 1, 1));
					bVolgende.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							bVolgendeActionPerformed(evt);
						}
					});
				}
				// List toevoegen
				// Buttons

				pInzet.setFocusCycleRoot(true);
				pInzet.setFocusTraversalPolicy(new ArrayFocusTraversalPolicy(new java.awt.Component[] {tNaam, jDag, jMaand, jJaar, tSaldo, bVolgende}));
				pInzet.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				pSelecteer = new JPanel();
				getContentPane().add(pSelecteer);
				pSelecteer.setBounds(14, 231, 308, 238);
				pSelecteer.setBorder(BorderFactory.createTitledBorder(null, "Selecteer Spelers", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma",1,11), new java.awt.Color(90,90,90)));
				pSelecteer.setLayout(null);
				{
					jScrollPane2 = new JScrollPane();
					pSelecteer.add(jScrollPane2);
					jScrollPane2.setBounds(14, 126, 280, 63);
					jScrollPane2.setBorder(new LineBorder(new java.awt.Color(0,
							0, 0), 0, false));
					{
						mod2 = new DefaultListModel();
						lActief = new JList(mod2);
						jScrollPane2.setViewportView(lActief);
						lActief.setVisibleRowCount(4);
						lActief.setBorder(new LineBorder(new java.awt.Color(90,
								90, 90), 1, false));
						lActief.setBounds(298, 333, 211, 56);
						lActief.setFont(new java.awt.Font("Tahoma",0,11));
						lActief.setPreferredSize(new java.awt.Dimension(0, 0));
						lActief.setSize(273, 77);
					}
				}
				{
					jScrollPane1 = new JScrollPane();
					pSelecteer.add(jScrollPane1);
					jScrollPane1.setBounds(14, 21, 280, 77);
					jScrollPane1.setBorder(new LineBorder(new java.awt.Color(0,
							0, 0), 0, false));
					{
						mod1 = new DefaultListModel();
						lSpelers = new JList(mod1);
						jScrollPane1.setViewportView(lSpelers);
						lSpelers
								.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						lSpelers.setVisibleRowCount(10);
						lSpelers.setBorder(new LineBorder(new java.awt.Color(
								90, 90, 90), 1, false));
						lSpelers.setBounds(376, 246, 211, 64);
						lSpelers.setFont(new java.awt.Font("Tahoma", 0, 11));
					}
				}
				{
					bVoegToe = new JButton();
					pSelecteer.add(bVoegToe);
					bVoegToe.setBounds(94, 103, 49, 21);
					bVoegToe.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("img/object_09.png")));
					bVoegToe.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							bVoegToeActionPerformed(evt);
						}
					});
				}
				{
					bVerwijder = new JButton();
					pSelecteer.add(bVerwijder);
					bVerwijder.setBounds(166, 103, 49, 21);
					bVerwijder.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource("img/object_08.png")));
					bVerwijder.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							bVerwijderActionPerformed(evt);
						}
					});
				}
				{
					bKlaar = new JButton();
					pSelecteer.add(bKlaar);
					bKlaar.setText("Klaar");
					bKlaar.setFont(new java.awt.Font("Arial", 0, 12));
					bKlaar.setBounds(217, 203, 77, 21);
					bKlaar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							bKlaarActionPerformed(evt);
						}
					});
				}
				{
					lSpAantal = new JLabel();
					pSelecteer.add(lSpAantal);
					lSpAantal.setText("text");
					lSpAantal.setBounds(14, 203, 154, 21);
					lSpAantal.setFont(new java.awt.Font("Tahoma",0,11));
					lSpAantal.setHorizontalTextPosition(SwingConstants.LEFT);
					lSpAantal.setHorizontalAlignment(SwingConstants.LEFT);
				}
				pSelecteer.setFocusCycleRoot(true);
				pSelecteer.setFocusTraversalPolicy(new ArrayFocusTraversalPolicy(new java.awt.Component[] {bVoegToe, bKlaar}));
				pSelecteer.setFont(new java.awt.Font("Tahoma",0,12));
			}
			pack();
			this.setSize(352, 526);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	} // void initGUI()

	
	/**
	 * Zorgt dat het crrecte aanral spelers wordt getoond op het scherm
	 */
	private void SpelerAantal() 
	{
		String s = null;
	
		if (mod2.getSize() == 0) 
		{
			s = "Geen spelers";
		}
		else if (mod2.getSize() == 1) 
		{
			s = "1 Speler";
		}
		else 
		{
			s = mod2.getSize() + " Spelers";
		}
		
		lSpAantal.setText(s);
		
	} // private void SpelerAantal()

	
	
	public void setRegistratieController(RegistratieController rc) 
	{
		this.regCntrl = rc;
	
	} // public void setRegistratieController(RegistratieController rc)

	
	
	private void bVoegToeActionPerformed(ActionEvent evt) 
	{
		// geselecteerde items lezen
		Object[] sel1 = lSpelers.getSelectedValues();

		// copieer deze naar lijst actief
		for (int i = 0; i < sel1.length; i++) {
	
			mod2.addElement(sel1[i]);
	
			if (mod2.getSize() == 4) 
			{
				bVoegToe.setVisible(false);
			}
			mod1.removeElement(sel1[i]);
		
		} 
		
		SpelerAantal();
	
	} // private void bVoegToeActionPerformed(ActionEvent evt)

	private void bVerwijderActionPerformed(ActionEvent evt) {
		// geselecteerde items lezen
		Object[] sel2 = lActief.getSelectedValues();
	
		// copieer deze naar lijst actief
		for (int i = 0; i < sel2.length; i++) {
		
			mod2.removeElement(sel2[i]);
			
			if (mod2.getSize() < 4) 
			{
				bVoegToe.setVisible(true);
			}
			mod1.addElement(sel2[i]);
		
		}
		
		SpelerAantal();
	
	} // private void bVerwijderActionPerformed(ActionEvent evt)

	
	
	private void bVolgendeActionPerformed(ActionEvent evt) throws NumberFormatException {
		
		try{
			int iDag = (Integer) jDag.getSelectedItem();
			int iMaand = (Integer) jMaand.getSelectedItem() - 1;
			int iJaar = (Integer) jJaar.getSelectedItem();
			// Gebruik van Calendar omdat hiermee makkelijker de leeftijd is te
			// controlleren.
			Calendar datum = new GregorianCalendar(iJaar, iMaand, iDag);
			RegistratieController.zetSpeler(tNaam.getText(), datum, Double.parseDouble(tSaldo.getText()), false);
			tNaam.setText("");
			jDag.setSelectedIndex(0);
			jMaand.setSelectedIndex(0);
			jJaar.setSelectedIndex(70);
			tSaldo.setText("");
		}
		catch(Exception e){ 
			DialogHelper.$showErrorMessage("Je hebt niet alle gegevens ingevuld!");
		}
	
	} // private void bVolgendeActionPerformed(ActionEvent evt) throws NumberFormatException

	
	
	private void bKlaarActionPerformed(ActionEvent evt)
	{
		if (mod2.isEmpty()){
			DialogHelper.$showErrorMessage("Er zijn geen geregistreerde spelers!");
		}
		else 
		{
		RegistratieController.MaakActief(mod2.toArray());
		SpelStartController.$geefVoorbereidingController().startSpelronde();
		this.dispose();
		}
	
	} // private void bKlaarActionPerformed(ActionEvent evt)



}
