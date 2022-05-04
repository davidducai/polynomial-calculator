package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import model.Monomial;
import model.Polynomial;
import operations.PolynomialOperations;

public class TestPolynomialInt {

	Polynomial p = new Polynomial();
	
	@Test
	public void test() {
		p.getTerms().add(new Monomial(3,2));
		p.getTerms().add(new Monomial(3,1));
		p.getTerms().add(new Monomial(3,0));
		
		Polynomial result = PolynomialOperations.integrate(p);
		assertEquals(result.toString(),"+x^3 +1.5x^2 +3.0x ");
	}
}
