package com.challenge.Palindrome;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/*
 * 
From a given string S generate a string, that will be a palindrome of maximal length.
If there is more than one correct result, return any of them.

Examples
1. input: "aabb"
   output: "abba" or "baab"
2. input: "abcd"
   output: "a" or "b" or "c" or "d" - as we could use at most one character from the string to
generate max length palindrome.

 * 
 */
public class Solution {

	/*
	 * SOLUTION:
	 * Create a path with the characters of string and count the total of times that appear,
	 * after that I used a queue to put the half of characters because if the numbers of characters are pair
	 * then the other part of palindrome is the same but reverse.
	 * The Big-O complexity:
	 * O(n) - where n is the number of characters in the string.
	 * 
	 * The space complexity:
	 * n * n/2  - where n is the number of elements in a map and n/2 the elements in the queue
	 * 			 
	 */
	public String generatePalindrome(String s) {
		
		HashMap<Character, Integer> map =  new HashMap<Character, Integer>();
		for (char c: s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		LinkedList<Character> queuePair = new LinkedList<Character>();
		LinkedList<Character> queueOdd = new LinkedList<Character>();
		
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			if (entry.getValue() % 2 == 0) {
				for (int i = 0; i < entry.getValue() / 2; i++) {
					queuePair.add(entry.getKey());
				}
			} else {
				queueOdd.add(entry.getKey());
				
			}
		}
		
		if (queueOdd.size() > 1 && !queuePair.isEmpty() ) return "Is not a palindrome";
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		while(!queuePair.isEmpty()) {
			sb1.append(queuePair.poll());
		}
		sb2 = new StringBuilder(sb1);
		
		if (!queueOdd.isEmpty()) {
			sb1.append(queueOdd.poll());
		}
		sb1.append(sb2.reverse());
		
		return sb1.toString();
	}
	
	
	public String generatePalindrome2(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		int count = 1;
		StringBuilder odd = new StringBuilder();
		
		stack.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == stack.peek()) {
				count++;
				continue;
			} else {
				
				if (count % 2 > 0) {
					odd.append(stack.pop());
					
				} else  {
					stack.add(arr[i]);
					count = 0;
				}
			}
		}
		
		if (stack.isEmpty() && odd.length() % 2 > 0) return odd.substring(0, 1);
		
		StringBuilder res = new StringBuilder();
		for(Character c: stack) {
			res.append(c);
		}
		if (odd.length() > 0) res.append(odd);
		
		while(!stack.isEmpty()) {
			res.append(stack.pop());
		}
		
		
		return res.toString();
	}
	
	
	public static void main(String[] args) {
		String s = "aabbc";
		
		Solution solution = new Solution();
		System.out.println(solution.generatePalindrome(s));
		
		System.out.println("------------------------[Solution 2]--------------------------------");
		System.out.println(solution.generatePalindrome2(s));

	}

}
