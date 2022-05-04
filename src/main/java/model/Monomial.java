package model;

import java.util.*;

public class Monomial implements Comparable {

	private double coefficient;
	private int power;
	
	public Monomial(){};
	
	public Monomial(double coefficient, int power){
		this.coefficient = coefficient;
		this.power = power;
	}
	
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		if(coefficient > 0) {
			output.append("+");
		}

		switch(power) {
			case 0:
				output.append(coefficient);
				break;
			case 1:
				if(coefficient == 1) {
					output.append("x");
				}
				else {
					output.append(coefficient + "x");
				}
				break;
			default:
				if(coefficient == 1) {
					output.append("x^" + power);
				}
				else {
					output.append(coefficient + "x^" + power);
				}	
		}
		
		return output.toString();
	}
	
	public double getCoefficient() {
		return coefficient;
	}
	
	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	
	public int getPower() {
		return power;
	}
	
	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public int compareTo(Object o) {
		Monomial m = (Monomial) o;	
		return m.power - power; // pentru sortare descrescatoare
	}
}
