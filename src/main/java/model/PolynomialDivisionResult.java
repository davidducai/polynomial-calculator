package model;

/** PolynomialDivisionResult este o clasa utlizata pentru a usura afisarea rezultatului impartirii a doua polinoame **/
public class PolynomialDivisionResult {

	private Polynomial quotient;
	private Polynomial remainder;
	
	public PolynomialDivisionResult(){
		quotient = new Polynomial();
		remainder = new Polynomial();
	}

	public Polynomial getQuotient() {
		return quotient;
	}

	public void setQuotient(Polynomial quotient) {
		this.quotient = quotient;
	}

	public Polynomial getRemainder() {
		return remainder;
	}

	public void setRemainder(Polynomial remainder) {
		this.remainder = remainder;
	}
	
	public String toString() {
		return quotient.toString() + " | " + remainder.toString();
	}
}
