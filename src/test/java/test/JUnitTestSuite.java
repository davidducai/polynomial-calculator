package test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	   TestMonomialAdd.class,
	   TestMonomialSub.class,
	   TestMonomialMul.class,
	   TestMonomialDiv.class,
	   TestMonomialInt.class,
	   TestMonomialDer.class,
	   TestPolynomialAdd.class,
	   TestPolynomialSub.class,
	   TestPolynomialMul.class,
	   TestPolynomialDiv.class,
	   TestPolynomialInt.class,
	   TestPolynomialDer.class,
	})

public class JUnitTestSuite {

}
