package exceptions;

@SuppressWarnings("serial")
public class PolynomialDegreeException extends Exception {

	public PolynomialDegreeException(){
		super("Nu se poate realiza împărțirea!\nGradul primului polinom este mai mic decât gradul celui de-al doilea!");
	}
}
