/**
 * 
 */
package edu.buffalo.util;

/**
 * @author Praveen Kumar Bellam
 * @EmailAddress pbellam@buffalo.edu
 */
public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Is 4 a prime number: "+Util.isPrimeNumber(4));
		System.out.println("Is 5 a prime number: "+Util.isPrimeNumber(5));
		System.out.println("Is 9 a prime number: "+Util.isPrimeNumber(9));
		System.out.println("Prime number next to 4: "+Util.getNextPrime(4));
		System.out.println("Prime number next to 3: "+Util.getNextPrime(3));
		System.out.println("Prime number next to 23: "+Util.getNextPrime(23));

	}

}
