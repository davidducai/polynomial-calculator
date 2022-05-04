package operations;

import model.Monomial;

public class MonomialOperations {

	/** Aduna 2 monoame cu acelasi exponent **/
	public static Monomial add(Monomial m, Monomial n) {
		Monomial result = new Monomial();
		
		result.setCoefficient(m.getCoefficient() + n.getCoefficient());
		result.setPower(m.getPower());
		
		return result;
	}
	
	/** Scade 2 monoame cu acelasi exponent **/
	public static Monomial subtract(Monomial m, Monomial n) {
		Monomial result = new Monomial();
		
		result.setCoefficient(m.getCoefficient() - n.getCoefficient());
		result.setPower(m.getPower());
		
		return result;
	}
	
	/** Inmulteste 2 monoame **/
	public static Monomial multiply(Monomial m, Monomial n) {
		Monomial result = new Monomial();
		
		if(m.getCoefficient() != 0 && n.getCoefficient() != 0) {
			result.setCoefficient(m.getCoefficient() * n.getCoefficient());
			result.setPower(m.getPower() + n.getPower());
		}
		
		return result;
	}
	
	/** Imparte 2 monoame **/
	public static Monomial divide(Monomial m, Monomial n) {
		Monomial result = new Monomial();
		
		if(n.getCoefficient() != 0) {
			result.setCoefficient(m.getCoefficient() / n.getCoefficient());
			result.setPower(m.getPower() - n.getPower());
		}
		
		return result;
	}
	
	/** Integreaza un monom **/
	public static Monomial integrate(Monomial m) {
		Monomial result = new Monomial();
		
		if(m.getCoefficient() != 0) {
			result.setPower(m.getPower() + 1);
			result.setCoefficient(m.getCoefficient() / result.getPower());
		}
		
		return result;
	}
	
	/** Deriveaza un monom **/
	public static Monomial derivate(Monomial m) {
		Monomial result = new Monomial();
		
		result.setCoefficient(m.getPower() * m.getCoefficient());
		if(m.getPower() > 0) {
			result.setPower(m.getPower() - 1);
		}
		
		return result;
	}
	
	/** Determina opusul unui monom **/
	public static Monomial negate(Monomial m) {
		Monomial result = new Monomial();
		
		result.setCoefficient(-m.getCoefficient());
		result.setPower(m.getPower());
		
		return result;
	}
}
