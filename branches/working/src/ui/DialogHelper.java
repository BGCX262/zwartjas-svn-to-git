package ui;

import javax.swing.JOptionPane;
/**
Zorgt voor een uniforme afhandeling van dialogen
 */
public class DialogHelper {
	
	
	
	public static void $showErrorMessage(String errorMessage)
	{
		JOptionPane.showMessageDialog(null,errorMessage,"Fout",JOptionPane.ERROR_MESSAGE);
		
	} // public static void ShowErrorMessage(String errorMessage)
	
	
	
	public static String $showInputDialog(String inputMessage)
	{
		return JOptionPane.showInputDialog(null, inputMessage, "Verkeerde ingave", JOptionPane.ERROR_MESSAGE);
		
	} // public static String ShowInputDialog(String inputMessage)

	public static void $showInfoMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message, "Informatie", JOptionPane.INFORMATION_MESSAGE);
	}
}
