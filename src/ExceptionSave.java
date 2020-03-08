import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class ExceptionSave implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int line;
	String pack;
	String Meth;
	String Class;
	Date date;
	
	
	public ExceptionSave() {
		// TODO Auto-generated constructor stub
	}
	
	public ExceptionSave(String p, String c, String m, int l) {
		this.Class = c;
		this.line = l;
		this.Meth = m;
		this.pack = p;
		this.date = new Date();
	}
	
	void save(Exception exp) {
		//text file
		try {
			ExceptionSave exS = new ExceptionSave(
					exp.getStackTrace()[0].getClass().getPackage().getName(),
					exp.getStackTrace()[0].getClassName(),
					exp.getStackTrace()[0].getMethodName(),
					exp.getStackTrace()[0].getLineNumber()
				);
			File f = new File ("/home/houssam/workspace/projects/Java/Logs/Excpt.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
			bw.newLine();
			bw.write("Class: " + exS.Class + " Package: " + exS.pack + " Methode: " + exS.Meth + " line: " + exS.line + " AT: " + new Date());
			bw.close();
		} catch (IOException IOe) {
			// TODO: handle exception
			System.out.println("Erreur I/O fichier des Logs/Excpt text: " + IOe.toString());
			save(IOe);
		} catch (Exception e) {
			System.out.println(e.toString());
			save(e);
		}
	}
	
	void saveObj(Exception exp) {
		//binary file
		try {
			ExceptionSave exS = new ExceptionSave(
					exp.getStackTrace()[0].getClass().getPackage().getName(),
					exp.getStackTrace()[0].getClassName(),
					exp.getStackTrace()[0].getMethodName(),
					exp.getStackTrace()[0].getLineNumber()
				);
			File f = new File ("/home/houssam/workspace/projects/Java/Logs/Excpb.ser");
			FileOutputStream fs = new FileOutputStream(f);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(exS);
			os.close();
			fs.close();
		} catch (IOException IOe) {
			// TODO: handle exception
			System.out.println("Erreur I/O fichier des Logs/Excpb: " + IOe.toString());
			saveObj(IOe);
		} catch (Exception e) {
			System.out.println(e.toString());
			saveObj(e);
		}
	}
	
	void saveXml(Exception exp) {
		//write to XML file
		try {
			ExceptionSave exS = new ExceptionSave(
					exp.getStackTrace()[0].getClass().getPackage().getName(),
					exp.getStackTrace()[0].getClassName(),
					exp.getStackTrace()[0].getMethodName(),
					exp.getStackTrace()[0].getLineNumber()
				);
			
			File f = new File("/home/houssam/workspace/projects/Java/Logs/ExcpX.xml");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
			bw.write("<Exception>");
			bw.newLine();
			bw.write("<Package>");
			bw.newLine();
			bw.write(exS.pack);
			bw.newLine();
			bw.write("</Package>");
			bw.newLine();
			bw.write("<Class>");
			bw.newLine();
			bw.write(exS.Class);
			bw.newLine();
			bw.write("</Class>");
			bw.newLine();
			bw.write("<Methode>");
			bw.newLine();
			bw.write(exS.Meth);
			bw.newLine();
			bw.write("</Methode>");
			bw.newLine();
			bw.write("<LineNUM>");
			bw.newLine();
			bw.write(exS.line);
			bw.newLine();
			bw.write("</LineNUM>");
			bw.newLine();
			bw.write("<DATEndTIME>");
			bw.newLine();
			bw.write(exS.date.toString());
			bw.newLine();
			bw.write("</DATEndTIME>");
			bw.newLine();
			bw.write("</Exception>");
			bw.close();			
		} catch (IOException IOe) {
			// TODO: handle exception
			System.out.println("Erreur I/O fichier des Logs/ExcpX: " + IOe.toString());
			saveXml(IOe);
		} catch (Exception e) {
			System.out.println(e.toString());
			saveXml(e);
		}
	}
	
	void readSer() {
		//binary read
		try {
			String path = "/home/houssam/workspace/projects/Java/Logs/Excpb.ser";
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ExceptionSave exS = (ExceptionSave)ois.readObject();
			System.out.println("-> La désérialisation: ");
			System.out.println(exS.pack);
			System.out.println(exS.Class);
			System.out.println(exS.Meth);
			System.out.println(exS.line);
			System.out.println(exS.date);
			ois.close();
		} catch (IOException IOe) {
			// TODO: handle exception
			System.out.println("->Erreur I/O fichier des Logs-reading .ser: " + IOe.toString());
			saveObj(IOe);
			
		} catch (Exception e) {
			System.out.println(e.toString());
			saveObj(e);
		}
	}
}

