
public class PointTracker {
	private int erros = 0;
	private int acertos = 0;
	private int lastCorrectlyTypedIndex = -1;
	
	public PointTracker() {
		
	}
	
	public boolean compareStrings(String currentString, String targetString) {
		if(currentString.charAt(currentString.length() - 1) != targetString.charAt(currentString.length() - 1))
			erros++;
		else if (currentString.length() - 1 > lastCorrectlyTypedIndex) {
			acertos++;
			lastCorrectlyTypedIndex++;
		}
		if(currentString.length() == targetString.length())
			return false;
		return true;
	}

	public int getAcertos() {
		return acertos;
	}

	public int getErros() {
		return erros;
	}

	public void resetValuesToDefault() {
		this.erros = 0;
		this.acertos = 0;
		this.lastCorrectlyTypedIndex = -1;
	}
	
	
}
