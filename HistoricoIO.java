
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

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
				JOptionPane.showMessageDialog(null, "Arquivo de Histórico não encontrado, um novo foi criado","Historico.ser Não Encontrado", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e1) {
				System.err.println(e.toString());
				JOptionPane.showMessageDialog(null, "Erro ao criar um novo arquivo serializado","Historico.ser Não Encontrado", JOptionPane.ERROR_MESSAGE);
			}
		}
		catch (EOFException e) {
			
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo Serializado corrompido ou mal-formado","Erro ao ler Historico.ser", JOptionPane.ERROR_MESSAGE);
		}
		catch(ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível criar a String durante a leitura","Erro ao ler Historico.ser", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void openFileOutput() {
		
		try {
			output = new ObjectOutputStream(new FileOutputStream(saveFile));
		}
		catch (FileNotFoundException e){
			try {
				saveFile.createNewFile();
				JOptionPane.showMessageDialog(null, "Um novo arquivo serializado foi criado","Historico.ser Não Encontrado", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e1) {
				System.err.println(e.toString());
				JOptionPane.showMessageDialog(null, "Erro ao criar um novo arquivo serializado","Historico.ser Não Encontrado", JOptionPane.ERROR_MESSAGE);
			}
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo Serializado corrompido ou mal-formado","Erro ao ler Historico.ser", JOptionPane.ERROR_MESSAGE);
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
			if(this.historico != "")
				output.writeObject(newString + "\n" + this.historico);
			else
				output.writeObject(newString);
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro Ao escrever em historico.ser","Erro", JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "Erro ao fechar historico.ser","Erro", JOptionPane.ERROR_MESSAGE);
			System.err.println(e.toString());
		}
	}
	
}
