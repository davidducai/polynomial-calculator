package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import model.Monomial;
import operations.MonomialOperations;

public class TestMonomialInt {

	Monomial m = new Monomial();

	@Test
	public void test() {
		m.setCoefficient(3);
		m.setPower(2);
		
		Monomial expected = new Monomial(1,3);
		Monomial result = MonomialOperations.integrate(m);
		
		assertEquals(result.getCoefficient(),expected.getCoefficient());
		assertEquals(result.getPower(),expected.getPower());
	}

}
