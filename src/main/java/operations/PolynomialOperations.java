package operations;

import exceptions.DivisionWithZeroException;
import exceptions.PolynomialDegreeException;
import model.*;

public class PolynomialOperations {

	/** Aduna 2 polinoame **/
	public static Polynomial add(Polynomial p, Polynomial q) {
		Polynomial result = new Polynomial();
		
		// se pun termenii ambelor polinoame intr-un singur polinom si se simplifica
		for(Monomial m : p.getTerms()) {
			result.getTerms().add(m);
		}
		
		for(Monomial n: q.getTerms()) {
			result.getTerms().add(n);
		}
		
		result.simplify();
		
		return result;
	}
	
	/** Se scade polinomul q din polinomul p **/
	public static Polynomial subtract(Polynomial p, Polynomial q) {
		Polynomial result = new Polynomial();
		
		// se pun termenii primului polinom si opusii termenilor din al doilea polinom intr-un singur polinom si se simplifica
		for(Monomial m : p.getTerms()) {
			result.getTerms().add(m);
		}
		
		for(Monomial n: q.getTerms()) {
			result.getTerms().add(MonomialOperations.negate(n));
		}
		
		result.simplify();
		
		return result;
	}
	
	/** Inmulteste 2 polinoame **/
	public static Polynomial multiply(Polynomial p, Polynomial q) {
		Polynomial result = new Polynomial();
		
		for(Monomial m : p.getTerms()) {
			for(Monomial n : q.getTerms()) {
				result.getTerms().add(MonomialOperations.multiply(m, n));
			}
		}
		result.simplify();

		return result;
	}
	
	/** Imparte 2 polinoame **/
	public static PolynomialDivisionResult divide(Polynomial p, Polynomial q) throws DivisionWithZeroException, PolynomialDegreeException {
		PolynomialDivisionResult result = new PolynomialDivisionResult();
		Polynomial temp = new Polynomial();
		temp.getTerms().add(new Monomial(-1,-1));
		
		if(!q.isZeroPolynomial()) { // Daca polinomul cu care se imparte este diferit de 0, se poate realiza impartirea
			if(!p.isZeroPolynomial()) {
				if(p.getDegree() < q.getDegree()) { // Daca primul polinom are grad mai mare sau egal cu gradul celui de-al doilea, se poate realiza impartirea
					throw new PolynomialDegreeException();
				}
				result.setRemainder(p);

				while(result.getRemainder().isZeroPolynomial() == false && result.getRemainder().getDegree() >= q.getDegree()) {
					temp.getTerms().set(0, MonomialOperations.divide(result.getRemainder().getLead(), q.getLead()));
					result.setQuotient(PolynomialOperations.add(result.getQuotient(), temp));
					result.setRemainder(PolynomialOperations.subtract(result.getRemainder(), PolynomialOperations.multiply(temp, q)));
					if(result.getRemainder().getLead().getCoefficient() == 0) { // daca primul termen din lista restului este 0, se elimina
						result.getRemainder().getTerms().remove(0);
					}
					if(result.getRemainder().getTerms().isEmpty()) { // lista restului devinea vida daca p si q erau monoame
						result.getRemainder().getTerms().add(new Monomial(0,0));
					}
				}
			}
			else {
				result.getQuotient().getTerms().add(new Monomial(0,0));
				result.getRemainder().getTerms().add(new Monomial(0,0));
			}
		}
		else {
			throw new DivisionWithZeroException();
		}
		
		return result;
	}
	
	/** Integreaza un polinom **/
	public static Polynomial integrate(Polynomial p) {
		Polynomial result = new Polynomial();
		
		for(Monomial m : p.getTerms()) {
			result.getTerms().add(MonomialOperations.integrate(m));
		}
		
		return result;
	}
	
	/** Deriveaza un polinom **/
	public static Polynomial derivate(Polynomial p) {
		Polynomial result = new Polynomial();
		
		for(Monomial m : p.getTerms()) {
			result.getTerms().add(MonomialOperations.derivate(m));
		}
		
		return result;
	}
}
