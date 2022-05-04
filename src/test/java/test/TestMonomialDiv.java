package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import model.Monomial;
import operations.MonomialOperations;

public class TestMonomialDiv {

	Monomial m = new Monomial();
	Monomial n = new Monomial();
	@Test
	public void test() {
		m.setCoefficient(10);
		m.setPower(2);
		n.setCoefficient(5);
		n.setPower(2);
		
		Monomial expected = new Monomial(2,0);
		Monomial result = MonomialOperations.divide(m, n);
		
		assertEquals(result.getCoefficient(),expected.getCoefficient());
		assertEquals(result.getPower(),expected.getPower());
	}

}
