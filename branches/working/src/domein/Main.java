package domein;

public class Main {

	
	
	public static void main(String[] args) {
		//Bank b = new Bank();
		KaartStapel ks = KaartStapel.$maakKaartStapel();
			
		for (int i = 0 ; i < 64; i++)
		{
			String s = ks.pakBovensteKaart().toString();
			if (i > 40)
			{
				String b = s;
				String a = b;
			}
			
		}
	
	} // public static void main(String[] args)

	

}
