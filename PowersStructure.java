

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;

public class PowersStructure {

	HashMap<BigInteger, BigInteger> hashTable(int numBits) {
		HashMap<BigInteger, BigInteger> squaresTable = new HashMap<BigInteger, BigInteger>();
		BigInteger two = new BigInteger("2");
		BigInteger maxNumber = two.pow(numBits - 1).subtract(BigInteger.ONE);
		BigInteger next = BigInteger.ZERO;
		BigInteger base = BigInteger.ZERO; // new BigInteger("2");
		while (maxNumber.compareTo(next) > 0) {
			next = base.pow(2);
			if (maxNumber.compareTo(next) < 0)
				break;
			squaresTable.put(next, base);
			base = base.add(BigInteger.ONE);

		}
		return squaresTable;

	}

	ArrayList<BigInteger> squaresList(int numBits) {
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

	

}
