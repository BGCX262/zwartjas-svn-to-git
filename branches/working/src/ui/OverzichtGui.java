package ui;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.SwingUtilities;

import controller.*;
import domein.Speler;

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
public class OverzichtGui extends javax.swing.JFrame {

	private JLabel lStart;
	
	private JLabel lMax;
	
	private JButton bStart;
	
	private JComboBox cbSpelRonde;
	
	private JTable tKaarten;
	
	private JScrollPane spKaarten;
	
	private JComboBox cbSpeler;
	
	private JLabel lMin;
	
	private JPanel pInzet;
	
	private TableColumn naamKolom;
	
	private TableColumn inzetKolom;

	private TableColumn resKolom;
	
	private TableColumn kaartKolom;

	public OverzichtController oc;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	/*
	 * public static void main(String[] args) { SwingUtilities.invokeLater(new
	 * Runnable() { public void run() { OverzichtGui inst = new OverzichtGui();
	 * inst.setLocationRelativeTo(null); inst.setVisible(true); } }); }
	 */
	public OverzichtGui() 
	{
		super();
		initGUI();
		SpelersCombo(0); // aanroepen Spelerscombo
		GegevensTabel(1);
	
	} // public OverzichtGui()

	
	
	@SuppressWarnings("serial")
	private void initGUI() 
	{
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Overzicht");
			this.setVisible(true);
			{
				lStart = new JLabel();
				getContentPane().add(lStart);
				lStart.setText("Overzicht");
				lStart.setHorizontalAlignment(SwingConstants.CENTER);
				lStart.setBackground(new java.awt.Color(54, 190, 54));
				lStart.setFont(new java.awt.Font("Arial", 1, 36));
				lStart.setForeground(new java.awt.Color(0, 128, 64));
				lStart.setOpaque(true);
				lStart.setBounds(0, 0, 336, 49);
			}
			{
				pInzet = new JPanel();
				getContentPane().add(pInzet);
				pInzet.setBorder(BorderFactory.createTitledBorder(null, "Selectie", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma",1,11)));
				pInzet.setLayout(null);
				pInzet.setBounds(14, 63, 308, 105);
				pInzet.setFont(new java.awt.Font("Tahoma",1,12));
				{
					lMin = new JLabel();
					pInzet.add(lMin);
					lMin.setText("Speler");
					lMin.setFont(new java.awt.Font("Arial", 0, 12));
					lMin.setBounds(17, 59, 62, 27);
				}
				{
					lMax = new JLabel();
					pInzet.add(lMax);
					lMax.setText("Spelronde");
					lMax.setFont(new java.awt.Font("Arial", 0, 12));
					lMax.setBounds(17, 26, 62, 25);
				}
				// Combo voor Spelrondes. Deze wordt eerst geladen. Na selectie
				// wordt de speler gevuld.
				{
					oc = new OverzichtController(this);
					String[] rondes = oc.GeefSpelrondes();
					ComboBoxModel cbSpelRondeModel = new DefaultComboBoxModel(
							rondes);
					cbSpelRonde = new JComboBox();
					pInzet.add(cbSpelRonde);
					cbSpelRonde.setModel(cbSpelRondeModel);
					cbSpelRonde.setBounds(91, 29, 156, 21);
					cbSpelRonde.setToolTipText("Maak een keuze uit de gespeelde speelronden.");
				}
				{
					bStart = new JButton();
					getContentPane().add(bStart);
					bStart.setText("Sluiten");
					bStart.setFont(new java.awt.Font("Arial", 0, 12));
					bStart.setBounds(196, 303, 75, 23);
					bStart.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							bStartActionPerformed(evt);
						}
					});
				}
			}
			pack();
			this.setSize(352, 364);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	} // private void initGUI()

	
	
	public void SpelersCombo(int ronde) 
	{
		String[] spelers = null;
		if (ronde == 0) 
		{
			spelers = new String[1];
			spelers[0] = "Geen Spelers";
		}
		else 
		{
			spelers = oc.GeefSpelers(ronde);
		}
		
		ComboBoxModel cbSpelerModel = new DefaultComboBoxModel(spelers);
		cbSpeler = new JComboBox();
		pInzet.add(cbSpeler);
		cbSpeler.setModel(cbSpelerModel);
		cbSpeler.setBounds(91, 63, 156, 21);
		cbSpeler.setToolTipText("Maak een keuze uit een van de (meespelende) spelers.");
		cbSpeler.addItemListener(new ItemListener() {
		
			public void itemStateChanged(ItemEvent evt) {
				cbSpelerItemStateChanged(evt);
			}
		
		});
	
	} // public void SpelersCombo(int ronde)

	
	
	@SuppressWarnings("serial")
	public void GegevensTabel(int i) 
	{
    	String[] header = {"Spelernaam", "Pnt", "Res", "Krt"};
		String[][] data = null;
		data = oc.VulTabelRonde(i);
		spKaarten = new JScrollPane();
		getContentPane().add(spKaarten);
		spKaarten.setBounds(14, 168, 308, 126);
		spKaarten.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 0, false));
		spKaarten.setFont(new java.awt.Font("Arial", 0, 12));
		{

			tKaarten = new JTable(data, header) {
				
				public Component prepareRenderer(TableCellRenderer renderer,
						int rowIndex, int vColIndex) {
					Component c = super.prepareRenderer(renderer, rowIndex,
							vColIndex);
					if (rowIndex % 2 == 0
							&& !isCellSelected(rowIndex, vColIndex)) {
						c.setBackground(new java.awt.Color(202, 240, 202));
					}
					else 
					{
						// If not shaded, match the table's
						// background
						c.setBackground(getBackground());
					}
				
					return c;

				}
			};
			
			naamKolom = tKaarten.getColumn(header[0]);
			naamKolom.setPreferredWidth(150);
			inzetKolom = tKaarten.getColumn(header[1]);
			inzetKolom.setPreferredWidth(30);
			resKolom = tKaarten.getColumn(header[2]);
			resKolom.setPreferredWidth(50);
			kaartKolom = tKaarten.getColumn(header[3]);
			kaartKolom.setPreferredWidth(30);
			spKaarten.setViewportView(tKaarten);
			tKaarten.setPreferredSize(new java.awt.Dimension(301, 126));
			tKaarten.setGridColor(new java.awt.Color(255, 255, 255));
			tKaarten.setBorder(new LineBorder(new java.awt.Color(90, 90, 90), 1, false));
			FlowLayout tKaartenLayout = new FlowLayout();
			tKaartenLayout.setAlignment(FlowLayout.LEFT);
			tKaarten.setLayout(tKaartenLayout);
			tKaarten.setFont(new java.awt.Font("Tahoma",0,12));
		
		}
	
	} // public void GegevensTabel(int i)
	
	

	public void setOverzichtController(OverzichtController oc) 
	{
		this.oc = oc;
	
	} // public void setOverzichtController(OverzichtController oc)

	
	
	private void cbSpelRondeItemStateChanged(ItemEvent evt) 
	{
		int i = cbSpelRonde.getSelectedIndex();
		SpelersCombo(i);
		
	} // private void cbSpelRondeItemStateChanged(ItemEvent evt)

	
	
	private void bStartActionPerformed(ActionEvent evt) 
	{
		this.dispose();
		new VoorbereidingController().registreerSpeler();
	
	} // private void bStartActionPerformed(ActionEvent evt)

	
	
	private void cbSpelerItemStateChanged(ItemEvent evt) 
	{
		System.out.println("cbSpeler.itemStateChanged, event=" + evt);
		// TODO add your code for cbSpeler.itemStateChanged
	
	} // private void cbSpelerItemStateChanged(ItemEvent evt)

	
	
	private void cbSpelRondeActionPerformed(ActionEvent evt) 
	{
		System.out.println("cbSpelRonde.actionPerformed, event=" + evt);
		// TODO add your code for cbSpelRonde.actionPerformed
	
	} // private void cbSpelRondeActionPerformed(ActionEvent evt)

	
	
}
