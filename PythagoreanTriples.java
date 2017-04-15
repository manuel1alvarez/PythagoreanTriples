

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class PythagoreanTriples {
	public static void main(String[] args) {
		
		PowersStructure datagetter = new PowersStructure();
		int numBits = 32; // find pythagorean triples up to number of bits.
		ArrayList<BigInteger> squaresList = datagetter.squaresList(numBits);
		HashMap<BigInteger, BigInteger> squaresTable = datagetter.hashTable(numBits);
		
		System.out.println("squaresList: " + squaresList);
		
		BigInteger sum, s1, s2; int counter = 0;
		for (int b = 0; b < squaresList.size(); b++) {
			s1 = squaresList.get(b);
			for (int c = b +1; c < squaresList.size(); c++) {
				s2 = squaresList.get(c);
				sum = s1.add(s2);
				if (squaresTable.containsKey(sum)){
					counter++;
					printAns(counter, numBits, b+3, c+3, squaresTable.get(sum), s1,  s2, sum);
					
				}
			}

		}
		System.out.println("\nFound " + counter +" pythagorean triples up to 2^" + numBits);
		
	}
	
	private static void printAns(int counter, int numBits, int b, int c, BigInteger hashSum, BigInteger s1, BigInteger s2, BigInteger sum){
		System.out.println("Solution #: " + counter +",  " + b + "^2" + " + " + c + "^2 = " + hashSum+ "^2    =      " +		s1 + " + " + s2 + " = " + sum);
	}
	
		
	}

