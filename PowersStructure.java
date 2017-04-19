

import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class PowersStructure {

	HashMap<BigInteger, BigInteger> hashTable(int numBits) {// Map: square --> Base
		HashMap<BigInteger, BigInteger> squaresTable = new HashMap<BigInteger, BigInteger>();
		BigInteger two = new BigInteger("2");
		BigInteger maxNumber = two.pow(numBits - 1).subtract(BigInteger.ONE);
		BigInteger next = BigInteger.ZERO;
		BigInteger base = BigInteger.ZERO;
		while (maxNumber.compareTo(next) > 0) {
			next = base.pow(2);
			if (maxNumber.compareTo(next) < 0)
				break;
			squaresTable.put(next, base);
			base = base.add(BigInteger.ONE);

		}
		return squaresTable;

	}

	ArrayList<BigInteger> squaresList(int numBits) {// Put all squares up to Max number in Arraylist
		ArrayList<BigInteger> vectorList = new ArrayList<BigInteger>();
		BigInteger base = new BigInteger("2");
		BigInteger maxNumber = base.pow(numBits - 1).subtract(BigInteger.ONE);
		BigInteger next = BigInteger.ZERO; 
		base = new BigInteger("3");
		while (maxNumber.compareTo(next) > 0) {
			next = base.pow(2);
			if (maxNumber.compareTo(next) < 0)
				break;
			vectorList.add(next);
			base = base.add(BigInteger.ONE);
		}

		return vectorList;

	}
	
	
	void RunSearch(int numBits){
		final long startTime = System.currentTimeMillis();
		String fileName = "pytTriples.txt";
		ArrayList<BigInteger> squaresList = squaresList(numBits);
		HashMap<BigInteger, BigInteger> squaresTable = hashTable(numBits);
		abstract_functions test1 = new abstract_functions();
		BigInteger sum, s1, s2; int counter = 0;
		
		try {
			PrintWriter outputStream = new PrintWriter(fileName);
			
			for (int b = 0; b < squaresList.size(); b++) {
				s1 = squaresList.get(b);
				for (int c = b +1 ; c < squaresList.size(); c++) {
					s2 = squaresList.get(c);
					//if( (s2.subtract(squaresList.get(c-1)).compareTo(s1) >= 0)  )// s1 surpassed by gaps in B^2 and (B^2).next
						//break; // Doesn't save enough operations to warrant use. Approximately 1% saved.
					sum = s1.add(s2);
					if (squaresTable.containsKey(sum) && test1.coprimeTriple(  b+3, c+3, (squaresTable.get(sum)).longValue()) )  {
						counter++;
						String st = printAns(counter, numBits, b+3, c+3, squaresTable.get(sum), s1,  s2, sum);
						outputStream.println(printAns(counter, numBits, b+3, c+3, squaresTable.get(sum), s1,  s2, sum));
						System.out.println(st);
					}
				}
	
			}
			
			outputStream.println("\nFound " + counter +"  primitive pythagorean triples for numbers up to 2^" + numBits + ", Program runtime: " + ((long) System.currentTimeMillis()- startTime)
					+ " milliseconds." );	
			outputStream.close();
		} 
	
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
	}
		
	
	
	
	private static String printAns(int counter, int numBits, int b, int c, BigInteger hashSum, BigInteger s1, BigInteger s2, BigInteger sum){
			String st = ("#" + counter +",  " + b + "^2" + " + " + c + "^2 = " + hashSum+ "^2    =      " +		s1 + " + " + s2 + " = " + sum);
			return st;
		} 
		
	}
		
	
	
	


