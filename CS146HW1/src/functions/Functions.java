package functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Functions {
	/*
	 * Given a string and a character, find the number of times the character   
	 * appears in the string. Matches area case sensitive. 
	 * Give a recursive implementation. 
	 */
	public static int countChar(String str, char c) {
		int total = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c)
				total++;
		}
		return total;
	}

	/*
	 * Problem 1
	 */
	public static int recurseCountChar(String str, char c) {
		int total = 0;
		if (str.length() < 1)
			return 0;
		if (str.charAt(0) == c) {
			total++;
		}
		return total + recurseCountChar(str.substring(1), c);
	}

	public static int recursiveMax(List<Integer> li) {
		return recursiveMaxHelper(li, 0, li.size());
	}

	/*
	 * Problem 2
	 */
	public static int recursiveMaxHelper(List<Integer> li, int lo, int hi) {
		if (lo == hi)
			return 0;
		int x = li.get(lo);
		int temp = recursiveMaxHelper(li, lo + 1, hi);
		if (x < temp)
			x = temp;
		return x;
	}

	/*
	 * Problem 3
	 */

	public static List<Integer> recursivePrimeFactors(int n) {
		
		ArrayList<Integer> list = new ArrayList<>();
		if(n == 1) return list;
		int temp = findAPrimeFactor(n);
		list.add(temp);
		list.addAll(recursivePrimeFactors(n/temp));
		return list;
	}

	public static int findAPrimeFactor(int n) {
		for (int f = 2; f < n; f++) {
			if(n % f == 0) return f;
		}
			return n;
	}

	

	public static void main(String[] args) {
		ArrayList<Integer> li = new ArrayList<>();
		Random gen = new Random();
		for (int i = 0; i < 24; i++) {
			li.add(gen.nextInt(100));
		}
		System.out.println(Functions.countChar("TEST", 't'));
		System.out.println(Functions.recurseCountChar("TEST", 't'));
		for (int e : li) {
			System.out.print(e + " ");
		}
		System.out.println();
		System.out.println(Functions.recursiveMax(li));
		
		ArrayList<Integer> primeFactors = new ArrayList<>();
		primeFactors = (ArrayList<Integer>) Functions.recursivePrimeFactors(40);
		System.out.println(primeFactors);
	}
}
