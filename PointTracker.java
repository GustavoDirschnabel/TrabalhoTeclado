
public class PointTracker {
	private int erros = 0;
	
	public PointTracker() {
		
	}
	
	public boolean compareStrings(String currentString, String targetString) {
		if(currentString.charAt(currentString.length() - 1) != targetString.charAt(currentString.length() - 1))
			erros++;
		if(currentString.length() == targetString.length())
			return true;
		return false;
	}

	public int getAcertos(String targetString) {
		return targetString.length() - this.erros;
	}

	public int getErros() {
		return erros;
	}

	public void setErros(int erros) {
		this.erros = erros;
	}
	
	public static void main(String[] args) {
		PointTracker pontit = new PointTracker();
		String referenceString = "abbaa";
		String test = "";
		for(int i = 0; i < 5; i++) {
			test += "a";
			pontit.compareStrings(test, referenceString);
		}
		
		System.out.println(pontit.getAcertos(referenceString));
		System.out.println(pontit.getErros());
	}
	
}
