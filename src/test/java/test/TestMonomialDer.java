package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import model.Monomial;
import operations.MonomialOperations;

public class TestMonomialDer {

	Monomial m = new Monomial();
	@Test
	public void test() {
		m.setCoefficient(3);
		m.setPower(2);
		
		Monomial expected = new Monomial(6,1);
		Monomial result = MonomialOperations.derivate(m);
		
		assertEquals(result.getCoefficient(),expected.getCoefficient());
		assertEquals(result.getPower(),expected.getPower());
	}

}
