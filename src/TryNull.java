public class TryNull {
	public TryNull() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		int a = 10;
		int b = 7;
		int k =0;
		try {
			for (int i=1; i<=10; i++ ) {
				k = a/(b-i);
				System.out.println(k);
			}
		} catch (ArithmeticException e) {
			// TODO: handle exception
			ExceptionSave s = new ExceptionSave();
			//Read from binary object
			//s.readSer();
			//write to text file
			//s.save(e);
			//write to a binary file
			//s.saveObj(e);
			//write to XML file
			s.saveXml(e);			
		}
		catch (Exception ee) {
			System.out.println(ee.toString());
		}
		finally {
			System.out.println("Traitement terminé: " + k);
			
		}
		
	}
	
}
