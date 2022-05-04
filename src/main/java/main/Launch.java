package main;
import controller.CalculatorController;
import model.Polynomial;
import view.CalculatorView;

public class Launch {

	public static void main(String[] args) {
		Polynomial p = new Polynomial();
		Polynomial q = new Polynomial();
		CalculatorView view = new CalculatorView();
		@SuppressWarnings("unused")
		CalculatorController controller = new CalculatorController(p,q,view);
	}
}
