package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import exceptions.DivisionWithZeroException;
import exceptions.PolynomialDegreeException;
import model.Monomial;
import model.Polynomial;
import model.PolynomialDivisionResult;
import operations.PolynomialOperations;

public class TestPolynomialDiv {

	Polynomial p = new Polynomial();
	Polynomial q = new Polynomial();
	
	@Test
	public void test() {
		p.getTerms().add(new Monomial(2,2));
		p.getTerms().add(new Monomial(3,1));
		p.getTerms().add(new Monomial(3,0));
		
		q.getTerms().add(new Monomial(1,1));
		q.getTerms().add(new Monomial(4,0));
		
		PolynomialDivisionResult result;
		try {
			result = PolynomialOperations.divide(p, q);
			assertEquals(result.getQuotient().toString(),"+2.0x -5.0 ");
			assertEquals(result.getRemainder().toString(),"+23.0 ");
		} catch (DivisionWithZeroException | PolynomialDegreeException e) {
			e.printStackTrace();
		}
	}
}
