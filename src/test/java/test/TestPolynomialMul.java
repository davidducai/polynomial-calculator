package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import model.Monomial;
import model.Polynomial;
import operations.PolynomialOperations;

public class TestPolynomialMul {

	Polynomial p = new Polynomial();
	Polynomial q = new Polynomial();
	
	@Test
	public void test() {
		p.getTerms().add(new Monomial(2,2));
		p.getTerms().add(new Monomial(3,1));
		p.getTerms().add(new Monomial(3,0));
		
		q.getTerms().add(new Monomial(1,1));
		q.getTerms().add(new Monomial(4,0));
		
		Polynomial result = PolynomialOperations.multiply(p, q);
		assertEquals(result.toString(),"+2.0x^3 +11.0x^2 +15.0x +12.0 ");
	}

}
