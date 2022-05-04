package model;

import java.util.ArrayList;
import java.util.Collections;

import operations.MonomialOperations;

public class Polynomial {

	private ArrayList<Monomial> terms = new ArrayList<Monomial>();

	public ArrayList<Monomial> getTerms() {
		return terms;
	}
	
	/** Sorteaza descrescator termenii polinomului in functie de exponent **/
	public void rearrange() {
		Collections.sort(terms);
	}
	
	/** Simplifica polinomul **/
	public void simplify() {
		int termsIndex = 0, simplifiedIndex = 0, skip = 0;
		ArrayList<Monomial> simplified = new ArrayList<Monomial>();
		
		rearrange();
		
		for(Monomial m : terms) {
		    if(skip == 0) {
		    	simplified.add(m); // daca am terminat de simplificat termeni cu aceeasi putere sau suntem la inceput, adaugam un nou termen in polinomul ireductibil
		    }
		    else {
		    	skip--; // sarim peste termenii adunati anterior
		    	continue;
		    }
			for(Monomial n : terms.subList(termsIndex + 1, terms.size())) { // Pentru fiecare termen din polinom, se cauta in lista, dupa el, termeni cu acceasi putere
				if(m.getPower() == n.getPower()) {
					simplified.set(simplifiedIndex, MonomialOperations.add(simplified.get(simplifiedIndex), n)); // se aduna termenii cu aceeasi putere
					skip++; // numara cati termeni vor fi exclusi de la introducere in polinomul ireductibil
				} else {
					break;
				}
			}
			termsIndex += skip + 1;
			simplifiedIndex++;
		}
		terms = simplified;
	}
	
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		if(isZeroPolynomial()) {
			output.append("0");
		}
		else {
			for(Monomial m : terms) {
				if(m.getCoefficient() != 0) {
					output.append(m.toString() + " ");
				}
			}
		}
		return output.toString();
	}
	
	/** Determina deca polinomul este polinomul nul (zero) **/
	public boolean isZeroPolynomial() {
		//rearrange();
		return ((terms.get(0).getCoefficient() == 0) && (terms.get(0).getPower() == 0));
	}
	
	/** Returneaza gradul polinomului **/
	public int getDegree() {
		rearrange();
		return terms.get(0).getPower();
	}
	
	/** Returneaza primul termen al polinomului **/ // metoda utilizata la operatia de impartire
	public Monomial getLead() {
		return terms.get(0);
	}
}
