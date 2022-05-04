package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import model.Monomial;
import model.Polynomial;
import operations.PolynomialOperations;

public class TestPolynomialDer {

	Polynomial p = new Polynomial();
	
	@Test
	public void test() {
		p.getTerms().add(new Monomial(3,2));
		p.getTerms().add(new Monomial(3,1));
		p.getTerms().add(new Monomial(3,0));
		
		Polynomial result = PolynomialOperations.derivate(p);
		assertEquals(result.toString(),"+6.0x +3.0 ");
	}
}
