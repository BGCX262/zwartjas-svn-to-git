package ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.BorderFactory;

import javax.swing.*;

import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
import javax.swing.SwingUtilities;

import domein.*;

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
public class EindeSpelGui extends javax.swing.JFrame {
	
	private JLabel lStart;
	
	private JScrollPane spEind;
	
	private JTable tEind;
	
	private JButton bVolgende;
	
	private JButton bStart;
	
	private TableRowSorter<TableModel> sorter;
	
	TableColumn naamKolom = new TableColumn();
	
	TableColumn puntKolom = new TableColumn();
	
	TableColumn kaartKolom = new TableColumn();
	
	Object[][] data;
	
	String[] header = { "Spelersnaam", "Punten", "Kaarten" };

	
	
	public EindeSpelGui(Vector<SpelerDeelname> deelnames) 
	{
		super();
		MijnData(deelnames);
		initGUI();
	
	} // public EindeSpelGui(Vector<Deelname> deelname)
	

	
	private void initGUI() 
	{
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Eindstand Spel");
			this.setLocationRelativeTo(null);
			this.setAlwaysOnTop(true);
			this.setVisible(true);
			{
				lStart = new JLabel();
				getContentPane().add(lStart);
				lStart.setText("Eindstand Spel");
				lStart.setHorizontalAlignment(SwingConstants.CENTER);
				lStart.setBackground(new java.awt.Color(54, 190, 54));
				lStart.setFont(new java.awt.Font("Arial", 1, 36));
				lStart.setForeground(new java.awt.Color(0, 128, 64));
				lStart.setOpaque(true);
				lStart.setBounds(0, 0, 268, 48);
			}
			{
				bStart = new JButton();
				getContentPane().add(bStart);
				bStart.setText("Sluiten");
				bStart.setFont(new java.awt.Font("Arial", 0, 12));
				bStart.setBounds(182, 153, 75, 23);
				bStart.setMargin(new java.awt.Insets(1, 1, 1, 1));
				bStart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						bStartActionPerformed(evt);
					}
				});
			}
			{
				bVolgende = new JButton();
				getContentPane().add(bVolgende);
				bVolgende.setText("Spel");
				bVolgende.setBounds(102, 153, 75, 23);
				bVolgende.setFont(new java.awt.Font("Arial", 0, 12));
				bVolgende.setMargin(new java.awt.Insets(1, 1, 1, 1));
				bVolgende.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						bVolgendeActionPerformed(evt);
					}
				});
			}
			{
				spEind = new JScrollPane();
				getContentPane().add(spEind);
				spEind.setBounds(12, 60, 243, 87);
				spEind.setBorder(new LineBorder(new java.awt.Color(212, 208,
						200), 0, false));
				{
					TableModel tEindModel = new DefaultTableModel();
					sorter = new TableRowSorter<TableModel>(tEindModel);
					tEind = new JTable(tEindModel) {
						public Component prepareRenderer(
								TableCellRenderer renderer, int rowIndex,
								int vColIndex) {
							Component c = super.prepareRenderer(renderer,
									rowIndex, vColIndex);
							if (rowIndex % 2 == 0
									&& !isCellSelected(rowIndex, vColIndex)) {
								c.setBackground(new java.awt.Color(215, 251,
										255));
							} else {
								// If not shaded, match the table's background
								c.setBackground(getBackground());
							}
							return c;

						}
					};

					spEind.setViewportView(tEind);
					tEind.setModel(tEindModel);
					tEind.setPreferredSize(new java.awt.Dimension(243, 64));
					tEind.setGridColor(new java.awt.Color(255, 255, 255));
					tEind.setBorder(new LineBorder(new java.awt.Color(90, 90,
							90), 1, false));
					tEind.setCellSelectionEnabled(true);
//					naamKolom = tEind.getColumn("Spelernaam");
//					naamKolom.setPreferredWidth(120);
//					puntKolom = tEind.getColumn("Punten");
//					puntKolom.setPreferredWidth(30);
//					kaartKolom = tEind.getColumn("Kaarten");
//					kaartKolom.setPreferredWidth(30);
				}
			}
			pack();
			this.setSize(276, 215);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // private void initGUI()
	
	
	
	public void MijnData(Vector<SpelerDeelname> deelname) 
	{
		data = new Object[deelname.size()][3];
		int i = 0;
		for (SpelerDeelname sd : deelname)
		{
			
			data[i][0] = sd.getTheSpeler().getNaam();
			data[i][1] = sd.geefPuntenTotaal();
			data[i][2] = sd.getResultaat();
			i++;
		}
				
	} // public void MijnData(Vector<Deelname> deelname)
	
	
	
	private void bStartActionPerformed(ActionEvent evt) 
	{
		this.dispose();
	
	} // private void bStartActionPerformed(ActionEvent evt)
	
	
	
	private void bVolgendeActionPerformed(ActionEvent evt) 
	{
		System.out.println("bVolgende.actionPerformed, event="+evt);
		//TODO add your code for bVolgende.actionPerformed
	
	} // private void bVolgendeActionPerformed(ActionEvent evt)

	
	
}
