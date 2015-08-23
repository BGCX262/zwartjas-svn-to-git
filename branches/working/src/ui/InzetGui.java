package ui;
import com.cloudgarden.resource.ArrayFocusTraversalPolicy;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.SwingUtilities;

import controller.SpelStartController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class InzetGui extends javax.swing.JFrame {
	
	private JLabel lStart;
	
	private JLabel lMax;
	
	private JTextField tMaxInzet;
	
	private JButton bStart;
	
	private JTextField tBank;
	
	private JLabel lBank;
	
	private JPanel jPanel1;
	
	private JTextField tMinInzet;
	
	private JLabel lMin;
	
	private JPanel pInzet;
	
	private SpelStartController controller;

	
	
	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InzetGui inst = new InzetGui(null);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}


	
	public InzetGui(SpelStartController controller) 
	{
		super();
		this.controller = controller;
		initGUI();
	
	} // public InzetGui(SpelStartController controller)
	
	

	private void initGUI() 
	{
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("img/kuser.png")).getImage());
			this.setTitle("Start spel");
			{
				lStart = new JLabel();
				getContentPane().add(lStart);
				lStart.setText("Start spel");
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
				pInzet.setBorder(BorderFactory
						.createTitledBorder(new LineBorder(new java.awt.Color(
								90, 90, 90), 1, true), "Inzet",
								TitledBorder.LEADING, TitledBorder.TOP,
								new java.awt.Font("Tahoma", 1, 11),
								new java.awt.Color(90, 90, 90)));
				pInzet.setLayout(null);
				pInzet.setBounds(14, 63, 308, 105);
				pInzet.setFont(new java.awt.Font("Tahoma",0,12));
				{
					lMin = new JLabel();
					pInzet.add(lMin);
					lMin.setText("Min.");
					lMin.setFont(new java.awt.Font("Arial", 0, 12));
					lMin.setPreferredSize(new java.awt.Dimension(32, 22));
					lMin.setSize(32, 22);
					lMin.setBounds(17, 24, 32, 27);
				}
				{
					lMax = new JLabel();
					pInzet.add(lMax);
					lMax.setText("Max.");
					lMax.setFont(new java.awt.Font("Arial", 0, 12));
					lMax.setPreferredSize(new java.awt.Dimension(34, 22));
					lMax.setSize(34, 22);
					lMax.setBounds(17, 57, 34, 25);
				}
				{
					tMinInzet = new JTextField();
					pInzet.add(tMinInzet);
					tMinInzet.setBounds(63, 21, 210, 21);
					tMinInzet.setFont(new java.awt.Font("Arial", 0, 12));
					tMinInzet.setToolTipText("Voer hier de minimale inzet in die een speler mag doen in het spel.");
				}
				{
					tMaxInzet = new JTextField();
					pInzet.add(tMaxInzet);
					tMaxInzet.setBounds(63, 56, 210, 21);
					tMaxInzet.setFont(new java.awt.Font("Arial", 0, 12));
					tMaxInzet.setToolTipText("Voer hier de maximale inzet in die een speler mag doen in het spel.");
				}
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBorder(BorderFactory
						.createTitledBorder(new LineBorder(new java.awt.Color(
								90, 90, 90), 1, false), "Bank",
								TitledBorder.LEADING,
								TitledBorder.DEFAULT_POSITION,
								new java.awt.Font("Tahoma", 1, 11),
								new java.awt.Color(90, 90, 90)));
				jPanel1.setLayout(null);
				jPanel1.setBounds(14, 182, 308, 63);
				jPanel1.setFont(new java.awt.Font("Tahoma",0,12));
				{
					lBank = new JLabel();
					jPanel1.add(lBank);
					lBank.setText("Bank");
					lBank.setFont(new java.awt.Font("Arial", 0, 12));
					lBank.setBounds(17, 27, 28, 14);
				}
				{
					tBank = new JTextField();
					jPanel1.add(tBank);
					tBank.setBounds(63, 21, 210, 21);
					tBank.setFont(new java.awt.Font("Arial", 0, 12));
					tBank.setToolTipText("Voer hier het startslado van de bank in.");
				}
			}
			{
				bStart = new JButton();
				getContentPane().add(bStart);
				bStart.setText("Start");
				bStart.setFont(new java.awt.Font("Arial", 0, 12));
				bStart.setBounds(224, 259, 98, 21);
				bStart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						spelerHeeftStartGedrukt();
					}
				});
			}
			this.setLocation(new java.awt.Point(200, 200));
			pack();
			this.setSize(352, 330);
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // private void initGUI()

	
	
	/**
	 * Methode die getriggerd word nadat een speler op de knop start gedrukt heeft.
	 * 
	 * 
	 */
	private void spelerHeeftStartGedrukt() 
	{
		double minInzet = 0, maxInzet = 0,bankSaldo = 0;
		
		try {
		
			// Om te voorkomen dat de methode niet twee keer achter elkaar wordt aangeroepen
			minInzet = Double.parseDouble(tMinInzet.getText());
			maxInzet = Double.parseDouble(tMaxInzet.getText());
			bankSaldo = Double.parseDouble(tBank.getText());	
			controller.bepaalStartWaardes(minInzet, maxInzet, bankSaldo);
			controller.startSpel();
		
		} catch (NumberFormatException numberEx) {
			
			// Afhandeling verkeerde invoer: bv tekst ipv nummers
			JTextField textVeld;
			String veld;
			
			if (minInzet == 0) 
			{
				veld = "'Minimum Inzet'";
				textVeld = tMinInzet;
			} 
			else if (maxInzet == 0) 
			{
				veld = "'Maximum Inzet'";
				textVeld=tMaxInzet;
			} 
			else 	
			{
				veld = "'Banksaldo'";
				textVeld = tBank;
			}
			
			DialogHelper.$showErrorMessage("Foutieve invoer in veld: " + veld);
			textVeld.setText("");
			textVeld.requestFocus();
			bStart.setEnabled(true);
			
		} catch (Exception ex) {

			DialogHelper.$showErrorMessage(ex.toString());
			bStart.setEnabled(true);
			
		}
			
	} // private void spelerHeeftStartGedrukt()



}
