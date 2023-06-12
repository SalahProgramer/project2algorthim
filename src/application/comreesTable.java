package application;

public class comreesTable {

	char character;
	int asci;
	String length;
	int frequancy;

	public comreesTable(char character, int asci, String length, int frequancy) {
		super();
		this.character = character;
		this.asci = asci;
		this.length = length;
		this.frequancy = frequancy;
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public int getAsci() {
		return asci;
	}

	public void setAsci(int asci) {
		this.asci = asci;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public int getFrequancy() {
		return frequancy;
	}

	public void setFrequancy(int frequancy) {
		this.frequancy = frequancy;
	}
	
}
