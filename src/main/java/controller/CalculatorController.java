package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

import exceptions.*;
import model.*;
import operations.PolynomialOperations;
import view.*;

public class CalculatorController implements ActionListener {

	Polynomial firstPolynomial, secondPolynomial;
	CalculatorView view;
	
	public CalculatorController(Polynomial firstPolynomial, Polynomial secondPolynomial, CalculatorView view){
		this.firstPolynomial = firstPolynomial;
		this.secondPolynomial = secondPolynomial;
		this.view = view;
		
		view.addButton.addActionListener(this);
		view.subButton.addActionListener(this);
		view.mulButton.addActionListener(this);
		view.divButton.addActionListener(this);
		view.intButton.addActionListener(this);
		view.derButton.addActionListener(this);
		view.clrButton.addActionListener(this);
		view.helpButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Polynomial resultPolynomial = new Polynomial();
		String firstPolynomialString = view.firstField.getText();
		String secondPolynomialString = view.secondField.getText();
		
		firstPolynomialString = firstPolynomialString.replaceAll("\\s","");
		secondPolynomialString = secondPolynomialString.replaceAll("\\s","");
		
		try {
			firstPolynomial = getPolynomial(firstPolynomialString);
			secondPolynomial = getPolynomial(secondPolynomialString);
			
			if(e.getSource() == view.addButton) {
				verifyIfEmpty(firstPolynomialString,secondPolynomialString);
				resultPolynomial = PolynomialOperations.add(firstPolynomial, secondPolynomial);
				view.resultField.setText(resultPolynomial.toString());
				view.resultPanel.setVisible(true);
			}
			if(e.getSource() == view.subButton) {
				verifyIfEmpty(firstPolynomialString,secondPolynomialString);
				resultPolynomial = PolynomialOperations.subtract(firstPolynomial, secondPolynomial);
				view.resultField.setText(resultPolynomial.toString());
				view.resultPanel.setVisible(true);
			}
			if(e.getSource() == view.mulButton) {
				verifyIfEmpty(firstPolynomialString,secondPolynomialString);
				resultPolynomial = PolynomialOperations.multiply(firstPolynomial, secondPolynomial);
				view.resultField.setText(resultPolynomial.toString());
				view.resultPanel.setVisible(true);
			}
			if(e.getSource() == view.divButton) {
				verifyIfEmpty(firstPolynomialString,secondPolynomialString);
				PolynomialDivisionResult divisionResult;
				try {
					divisionResult = PolynomialOperations.divide(firstPolynomial, secondPolynomial);
					view.resultField.setText(getDivisionResultString(divisionResult));
					view.resultPanel.setVisible(true);
				} catch (DivisionWithZeroException e1) {
					view.resultPanel.setVisible(false);
					JOptionPane.showMessageDialog(view,e1.getMessage(),"Eroare",JOptionPane.ERROR_MESSAGE);
				} catch (PolynomialDegreeException e3) {
					view.resultPanel.setVisible(false);
					JOptionPane.showMessageDialog(view,e3.getMessage(),"Eroare",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(e.getSource() == view.intButton) {
				verifyIfEmpty(firstPolynomialString);
				resultPolynomial = PolynomialOperations.integrate(firstPolynomial);
				view.resultField.setText(resultPolynomial.toString());
				view.resultPanel.setVisible(true);
			}
			if(e.getSource() == view.derButton) {
				verifyIfEmpty(firstPolynomialString);
				resultPolynomial = PolynomialOperations.derivate(firstPolynomial);
				view.resultField.setText(resultPolynomial.toString());
				view.resultPanel.setVisible(true);
			}
			if(e.getSource() == view.clrButton) {
				view.firstField.setText("");
				view.secondField.setText("");
				view.resultPanel.setVisible(false);
			}
			if(e.getSource() == view.helpButton) {
				HelpView helpView = new HelpView();
				@SuppressWarnings("unused")
				HelpController helpController = new HelpController(helpView);
			}
		} catch (PolynomialNotFoundException e2) {
			JOptionPane.showMessageDialog(view,e2.getMessage(),"Eroare",JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	private Polynomial getPolynomial(String imput) {
		Polynomial polynomial = new Polynomial();
		String format = "(-?\\b\\d+)([Xx](\\^(\\d+\\b))?)?";
		Pattern pattern = Pattern.compile(format);
		Matcher matcher = pattern.matcher(imput);

		while(matcher.find()) {
			if(matcher.group(1) != null) {
				polynomial.getTerms().add(new Monomial(Double.parseDouble(matcher.group(1)),0));
			}
			else {
				if(matcher.group(2) != null) {
					polynomial.getTerms().add(new Monomial(1,0));
				}
			}
		}
		int index = 0;
		matcher = pattern.matcher(imput);
		while(matcher.find()) {
			if(matcher.group(4) != null) {
				polynomial.getTerms().get(index).setPower(Integer.parseInt(matcher.group(4)));
			}
			else {
				if(matcher.group(2) != null) {
					polynomial.getTerms().get(index).setPower(1);
				}
			}
			index++;
		}
		polynomial.rearrange();
		return polynomial;
	}
	
	private static void verifyIfEmpty(String field1, String field2) throws PolynomialNotFoundException {
		if(field1.isEmpty() || field2.isEmpty()) {
			throw new PolynomialNotFoundException("Nu se poate realiza operația! Introduceți 2 polinoame!");
		}
	}
	
	private static void verifyIfEmpty(String field) throws PolynomialNotFoundException {
		if(field.isEmpty()) {
			throw new PolynomialNotFoundException("Nu se poate realiza operația! Introduceți un polinom în primul câmp!");
		}
	}
	
	private static String getDivisionResultString(PolynomialDivisionResult result) {
		StringBuilder output = new StringBuilder();
		
		output.append(result.getQuotient().toString());
		
		if(!result.getRemainder().getTerms().isEmpty()) {
			if(!result.getRemainder().isZeroPolynomial()) {
				output.append(" | Rest: " + result.getRemainder());
			}
		}
		
		return output.toString();
	}
}
