package ui;

import java.text.*;
import java.util.*;
import javax.swing.table.*;
import domein.*;

public class MijnTableModel extends AbstractTableModel {
	
	Object[][] data = {{new Boolean(false),"",0.0}};
	
	String[] kolomkoppen = { "Spel", "Spelersnaam", "Saldo" };
	
	DecimalFormat nf = new DecimalFormat("###.00");

	
	
	public MijnTableModel(Vector<Speler> spelers) 
	{
		if (spelers.isEmpty()) 
		{
		
		} 
		else 
		{
			int i = 0;
			Iterator<Speler> gegevens = spelers.iterator();
			data = new Object[spelers.size()][3];
		
			while (gegevens.hasNext()) {
				Speler speler = gegevens.next();
				StringTokenizer sNaam = new StringTokenizer(speler.getNaam());
				String capNaam = "";
			
				while(sNaam.hasMoreTokens()) {
				    String s=sNaam.nextToken();
				    capNaam += s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase()+" ";
				}
				
				data[i][0] = new Boolean(speler.volgendeRondeMeedoen);
				data[i][1] = capNaam;
				data[i][2] = nf.format(speler.getStartSaldo());
				i++;
			}
		
		}
	
	} // public MijnTableModel(Vector<Speler> spelers) 

	
	
	public int getColumnCount() 
	{
		return kolomkoppen.length;
	
	} // public int getColumnCount()

	
	
	public int getRowCount() 
	{
		return data.length;
	
	} //public int getRowCount()

	
	
	public String getColumnName(int col) 
	{
		return kolomkoppen[col];
	
	} // public String getColumnName(int col)

	
	
	public Object getValueAt(int row, int col) 
	{
		return data[row][col];
	
	} // public Object getValueAt(int row, int col)

	
	
	/*
	 * wordt gebruikt voor een default renderer voor een cell hierdoor worden bv
	 * de booleans weergegeven door aankruisvakjes
	 */
	public Class getColumnClass(int c) 
	{
		return getValueAt(0, c).getClass();
		
	} // public Class getColumnClass(int c)

	
	
	// data is editeerbaar
	public boolean isCellEditable(int row, int col) 
	{
		// eerste kolom in het model is te editten
		if (col < 0) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	
	} // public boolean isCellEditable(int row, int col)

	
	
	// data kan worden aangepast
	public void setValueAt(Object value, int row, int col) 
	{
		data[row][col] = value;
		fireTableCellUpdated(row, col);
	
	} // public void setValueAt(Object value, int row, int col)

	
	
}
