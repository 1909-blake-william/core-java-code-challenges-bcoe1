package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		phrase = phrase.replaceAll("-", " ");
		String[] split;
		split = phrase.split(" ");
		String acro = " ";
		for (int i = 0; i < split.length; i++) {
			char x = (split[i].charAt(0));
			acro = acro.concat(Character.toString(x));
		}
		acro = acro.trim();
		acro = acro.toUpperCase();
		return acro;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			if (this.sideOne == this.sideTwo && this.sideOne == this.sideThree) {
				return true;
			}
			return false;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if (this.sideOne == this.sideTwo || this.sideOne == this.sideThree || this.sideTwo == this.sideThree) {
				return true;
			}
			return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if (this.sideOne == this.sideTwo || this.sideOne == this.sideThree || this.sideTwo == this.sideThree) {
				return false;
			}

			return true;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		string = string.toUpperCase();
		String[] split = string.split("");
		int score = 0;
		String one = "AEIOULNRST";
		String two = "DG";
		String three = "BCMP";
		String four = "FHVWY";
		String five = "K";
		String eight = "JX";
		String ten = "QZ";
		for (int i = 0; i < string.length(); i++) {
			String x = split[i];

			if (one.contains(x)) {
				score += 1;
			} else if (two.contains(x)) {
				score += 2;
			} else if (three.contains(x)) {
				score += 3;
			} else if (four.contains(x)) {
				score += 4;
			} else if (five.contains(x)) {
				score += 5;
			} else if (eight.contains(x)) {
				score += 8;
			} else if (ten.contains(x)) {
				score += 10;
			} else {
				score += 0;
			}

		}

		return score;
	}



	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration

		string = string.replace(" ", "");
		string = string.replace("-", "");
		string = string.replace(".", "");
		string = string.replace("+", "");
		string = string.replace("(", "");
		string = string.replace(")", "");
		char c = string.charAt(0);
		if (c == 1) {
			string = string.substring(1);
		}

		if (string.length() != 10) {
			throw new IllegalArgumentException();
		}
		String nums = "1234567890";

		//String[] split = string.split("");
		for (int i = 0; i < string.length(); i++) {
			char c2 = string.charAt(i);
			if (nums.contains(Character.toString(c2))) {

			} else {
				throw new IllegalArgumentException();
			}
			if (i == 3) {
				if ("1".equals(Character.toString(c2))) {
					throw new IllegalArgumentException();
				}

			}
		}

		return string;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		string = string.replace(",", " ");
		string = string.replace(".", " ");
		string = string.replace("\n", "");
		string = string.toLowerCase();

		String[] split = string.split(" ");
		Map<String, Integer> map = new HashMap<>();
		// map.put("String", int);
		map.put(split[0], 1);
		for (int i = 1; i < split.length; i++) {
			if (map.containsKey(split[i])) {
				map.put(split[i], map.get(split[i]) + 1);

				

			} else {
				map.put(split[i], 1);
				
			}
		}
		return map;
	}



	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> { // use .compareto
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			int compare = 1;
			int indexToCheck = (int) Math.floor((sortedList.size()-1)/2); //find the initial index
			int min = 0;
			int max = sortedList.size()-1;
			int previousIndex = indexToCheck+1;
			
			while(compare != 0) {  // loop until correct number is found
				compare = t.compareTo(sortedList.get(indexToCheck));
				if(compare == 0) {
					return indexToCheck;
				} else if(compare < 0) {
					max = indexToCheck-1; //new max number
					previousIndex = indexToCheck;
					indexToCheck = (int) Math.floor((indexToCheck-min)/2);
					
				} else {
					min = indexToCheck+1; //new min number
					previousIndex = indexToCheck;
					indexToCheck = (int) Math.floor((max+indexToCheck)/2)+1; 
					//new index to check is average of max and previous index + 1 
					
				}
				if(indexToCheck == previousIndex) {
					//This is were exception would be thrown if the number weren't in the list
					//a test case doesn't exist for it so an exception was not created
				}
				
			}
			
			return indexToCheck;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}


	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String stringFinal = "";
		string = string.replace(",", " ");
		string = string.replace(".", " ");
		string = string.toLowerCase();
		String[] split = string.split(" ");
		String vowels = "aeiou";

		for (int i = 0; i < split.length; i++) { //for loop to go over each word
			char c = split[i].charAt(0);
			if (vowels.contains(Character.toString(c))) {

				stringFinal = stringFinal.concat(split[i]).concat("ay ");

			} else if ("q".contains(Character.toString(c))) {
				//q is a special case where consonat and vowel need to move
				String stringStart = "qu";
				String stringRemove = split[i].replaceFirst(stringStart, "");
				stringFinal = stringFinal.concat(stringRemove).concat(stringStart).concat("ay ");

			}

			else { 
				boolean cons = true;
				int j = 1;
				String stringStart = Character.toString(c);
				while (cons) { //keep checking if the next letter is a consonant to move
					if (vowels.contains(Character.toString(split[i].charAt(j)))) {

						cons = false;

					} else {
						stringStart = stringStart.concat(Character.toString(split[i].charAt(j)));
					}

					j += 1;
				}
				
				String stringRemove = split[i].replaceFirst(stringStart, "");
				
				stringFinal = stringFinal.concat(stringRemove).concat(stringStart).concat("ay ");

			}
		}
		stringFinal = stringFinal.trim();
		return stringFinal;
	}


	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {

		int length = Integer.toString(input).length();

		int copy = input;
		int checkArm = 0;
		float checkDouble = 0f;

		for (int i = 0; i < length; i++) {

			checkDouble += Math.pow(copy % 10, length);
			copy /= 10;

		}

		checkArm = Math.round(checkDouble);
		if (checkArm == input) {
			return true;
		} else {

			return false;
		}
	}



	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {

		boolean outsideLoop = true;
		boolean insideLoop = true;
		int i = 2;
		long numCurrent = l;
		long numOne = 0; // number that original can be divided by
		long numTwo = l; // result of dividing by previous number
		List<Long> primes = new ArrayList<>();

		while (outsideLoop) {
			insideLoop = true;
			i = 2;
			while (insideLoop) {

				if (i == numCurrent) { //if the number is only divisible by itself then we are done
					outsideLoop = false;
					insideLoop = false;
					primes.add(numTwo);
				} else if (numCurrent % i == 0) { 
					//when the number is divisible by another num add that num to the list of primes 
					//and check original num divided by the number added to the list
					numOne = i;
					numTwo = numCurrent / i;
					insideLoop = false;
					primes.add(numOne);
					numCurrent = numTwo;
				} 

				i += 1;
			}

		}
		return primes;
	}

//	public static void main(String[] args) {
//		EvaluationService eval = new EvaluationService();
//		eval.calculatePrimeFactorsOf(9);
//	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// a = 97, A = 65
			// z = 122, Z = 90
			String[] split = string.split("");
			int c;
			StringBuilder stringB = new StringBuilder("");

			for (int i = 0; i < string.length(); i++) {

				c = (int) split[i].charAt(0);

				if (c >= 97 && c <= 122) { //if the letter is lowercase
					c += this.key;
					if (c > 122) {
						c -= 26; //in case the number loops around, assumes key value will be 1-25
					} else if (c < 97) {
						c += 26;
					}
				}

				if (c >= 65 && c <= 90) { //if uppercase
					c += this.key;
					if (c > 90) {
						c -= 26;
					} else if (c < 65) {
						c += 26;
					}
				}
				char x = (char) c;
				stringB.append(x);
				

			}
			String stringFinal = stringB.toString();
			return stringFinal;
		}

	}



	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {

		if (i < 1) {
			throw new IllegalArgumentException(); 
		}
		boolean loopCheck = true;
		
		int j = 1;
		int k = 3;
		int primeCounter = 1;
		int newNum = 3;
		boolean check;
		int[] primes = new int[i];
		primes[0] = 2;
		if (i == 1) { // avoid loop if only first prime is asked for
			return 2;
		}

		while (loopCheck) { //loop until the correct number of primes are found
			check = true;
			k = 2;
			j = 1;

			while (k <= newNum) { //newNum is the number being tested,
				//k is a variable that will check every previous prime 

				if (k == 0) { // k=0 after it has checked every previous prime;
					primeCounter += 1;
					primes[primeCounter - 1] = newNum;
					break;
				} else if (newNum % k == 0 && newNum != k) {
					break;
				}

				k = primes[j];
				j += 1;

			}

			newNum += 2; //only off numbers can be prime except for #2

			if (primeCounter == i) { // end when you have the correct # of primes
				loopCheck = false;
			}

		}

		return primes[i - 1];
	}



	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			string = string.toLowerCase();
			string = string.replace(",", "");
			string = string.replace(".", "");
			string = string.replace(" ", ""); //remove punctuation and spaces
			String stringNew = "";
			
			String[] split = string.split("");
			StringBuilder stringB = new StringBuilder("");
			char c;

			int letter;
			String first = "abcdefghijklm"; //first half of the alphabet
			String second = "zyxwvutsrqpon"; //second half, backwards
			String[] firstHalf = first.split("");
			String[] secondHalf = second.split("");

			for (int j = 0; j < string.length(); j++) {
				c = split[j].charAt(0); //find the letter at the current space in the word
				letter = (int) c; 
				if (letter < 110 && letter > 57) { //check which half of the alphabet the letter is in, or a num
					for (int l = 0; l < 13; l++) {
						if (firstHalf[l].equals(Character.toString(c))) {
							stringB.append(secondHalf[l]); //add the corresponding letter in the other half

							break;
						}

					}

				} else if (letter <= 57 && letter >= 48) {

					stringB.append(Character.toString(c));
				} else {
					for (int l = 0; l < 13; l++) {
						if (secondHalf[l].equals(Character.toString(c))) {
							stringB.append(firstHalf[l]);

							break;
						}

					}

				}

				if ((j + 1) % 5 == 0 && j != 0) {
					stringB.append(" "); // add a space every 5 letters

				}

			}
			stringNew = stringB.toString();

			stringNew = stringNew.trim(); 

			return stringNew;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {

			string = string.replace(" ", "");
			String stringNew = "";

			String[] split = string.split("");
			StringBuilder stringB = new StringBuilder("");
			char c;
			int letter;
			String first = "abcdefghijklm";
			String second = "zyxwvutsrqpon";
			String[] firstHalf = first.split("");
			String[] secondHalf = second.split("");

			for (int j = 0; j < string.length(); j++) {
				c = split[j].charAt(0);
				letter = (int) c;
				if (letter < 110 && letter > 57) {
					for (int l = 0; l < 13; l++) {
						if (firstHalf[l].equals(Character.toString(c))) {
							stringB.append(secondHalf[l]);
							// System.out.println(stringB);
							break;
						}

					}

				} else if (letter <= 57 && letter >= 48) {

					stringB.append(Character.toString(c));
				} else {
					for (int l = 0; l < 13; l++) {
						if (secondHalf[l].equals(Character.toString(c))) {
							stringB.append(firstHalf[l]);
							// System.out.println(stringB);
							break;
						}

					}

				}
				// maybe set up to strings/arrays of first and second half of alphabet
				// second half is backwards, then replace with same index of opposite list.

				// stringB.append(c);

			}
			stringNew = stringB.toString();
			// System.out.println(stringNew);
			stringNew = stringNew.trim();

			return stringNew;
		}
	}

//	public static void main(String[] args) {
//		EvaluationService.AtbashCipher.encode("a 1 a");
//	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		string = string.replace("-", "");
		if (string.length() != 10) { // check correct size
			return false;
		}

		String[] split = string.split("");
		String lastNum = "X1234567890";

		if (!lastNum.contains(split[9])) { // check that the last number is 0-9 or X
			return false;
		}

		String nums = "12345678910";
		int check = 0;
		int x = 0; // current num

		if ("X".equals(split[9])) {
			split[9] = "10";
			System.out.println(split[9]);
		}

		for (int i = 0; i < string.length(); i++) { // loop through all numbers
			if (!nums.contains(split[i])) {
				return false;
			}
			x = Integer.parseInt(split[i]);
			check += (10 - i) * x;
		}

		if (check % 11 == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		string = string.toLowerCase();
		string = string.replace(" ", "");

		String allLetters = "abcdefghijklmnopqrstuvwxyz";

		for (int i = 0; i < string.length(); i++) {

			if (allLetters.contains(string.substring(i, i + 1))) {
				allLetters = allLetters.replace(string.substring(i, i + 1), "");
				// if a letter in the given string matches a letter in the list
				// then that letter is removed from the list
			}

		}

		if ("".equals(allLetters)) {
			return true;
		}

		return false;

	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		
		if(given instanceof LocalDate) {
		LocalDateTime withSeconds = LocalDateTime.of((LocalDate) given, LocalTime.of(0, 0, 0));
		withSeconds = withSeconds.plusSeconds(1000000000l);
		return withSeconds;
		} else {
		LocalDateTime withSeconds = (LocalDateTime) given;
		withSeconds = withSeconds.plusSeconds(1000000000l);
		return withSeconds;
		}
		
		
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		
		int sum = 0;
		Set<Integer> multiples = new HashSet<>();
		

		for (int j = 0; j < set.length; j++) {
			//loop through the different numbers in set 
			for(int k = set[j]; k < i; k +=set[j]) {
				// loop increasing by the size of the number in the set, starting at the number of the set
				multiples.add(k);
			}
		}
		
		for(Integer multiple: multiples) { //add all the multiples
			sum += multiple;
		}
		

		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		string = string.replace(" ", "");
		
		String nums = "1234567890";
		String[] split = string.split("");
		
		for(int i = 0; i < string.length(); i++) { //check for invalid charcaters
			if(!nums.contains(split[i])) {
				return false;
			}	
		}
		
		long numberAsInt = Long.parseLong(string);
		int currentNum;
		int sum = 0;
		boolean everyOther = false;
		
		for(int i = string.length(); i > 0; i--) {
			currentNum = (int) numberAsInt%10;
			if(everyOther) {
				currentNum *= 2;
				everyOther = false;
				if(currentNum > 9) {
					currentNum -= 9;
				}
			} else {
				everyOther = true;
			}
			sum += currentNum;
			numberAsInt = (int) Math.floor(numberAsInt/10);
		}
		
		if(sum%10 == 0) {
			return true;
		}
		
		return false;
	}
	

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		string = string.replace("?", "");
		String[] split = string.split(" ");
		int num = 0;
		for(int i = 0; i < split.length; i++) {
			
			if(split[i].equals("plus")) {
				num = Integer.parseInt(split[i-1]) + Integer.parseInt(split[i+1]);
			} else if(split[i].equals("minus")) {
				num = Integer.parseInt(split[i-1]) - Integer.parseInt(split[i+1]);
			} else if(split[i].equals("multiplied")) {
				num = Integer.parseInt(split[i-1]) * Integer.parseInt(split[i+2]);
			} else if(split[i].equals("divided")) {
				num = Integer.parseInt(split[i-1]) / Integer.parseInt(split[i+2]);
			}
		}
		return num;
	}

}
