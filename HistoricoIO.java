
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HistoricoIO {
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private File saveFile = new File("Historico.ser");
	private String historico = "";
	
	private void openFileInput() {
		try {
			input = new ObjectInputStream(new FileInputStream(saveFile));
			historico = (String) input.readObject();
		}
		catch (FileNotFoundException e){
			try {
				saveFile.createNewFile();
			} catch (IOException e1) {
				System.err.println(e.toString());
			}
		}
		
		catch (IOException e) {
			System.err.println(e.toString());
		}
		catch(ClassNotFoundException e) {
			System.err.println(e.toString());
		}
	}
	
	private void openFileOutput() {
		
		try {
			output = new ObjectOutputStream(new FileOutputStream(saveFile));
		}
		catch (FileNotFoundException e){
			try {
				saveFile.createNewFile();
			} catch (IOException e1) {
				System.err.println(e.toString());
			}
		}
		catch (IOException e) {
			System.err.println(e.toString());
		}
	}
	
	public String readFile() {
		openFileInput();
		closeFile();
		return historico;	
	}
	
	public void writeFile(String newString) {
		openFileInput();
		openFileOutput();
		
		try {
			output.writeObject(this.historico + newString);
		}
		catch (IOException e) {
			System.err.println(e.toString());
		}
		
		closeFile();
	}
	
	private void closeFile() {
		
		try {
			if(output != null && input != null) {
				output.close();
				input.close();
			}		
		}
		
		catch(IOException e) {
			System.err.println(e.toString());
		}
	}
	
}
