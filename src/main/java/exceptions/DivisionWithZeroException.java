package exceptions;

@SuppressWarnings("serial")
public class DivisionWithZeroException extends Exception {

	public DivisionWithZeroException(){
		super("Nu se poate împărți cu 0!");
	}
}
