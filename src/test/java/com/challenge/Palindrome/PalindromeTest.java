package com.challenge.Palindrome;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PalindromeTest {

	
	@Test
	public void evenChars() {
		String s = "aabb";
		Solution solution = new Solution();
		assertEquals("abba", solution.generatePalindrome(s)); 
	}
	
	@Test
	public void oddChars() {
		String s = "abcd";
		Solution solution = new Solution();
		assertEquals("a", solution.generatePalindrome(s)); 
	}
	
	@Test
	public void notPalindrome() {
		String s = "aabbthn";
		Solution solution = new Solution();
		assertEquals("Is not a palindrome", solution.generatePalindrome(s)); 
	}
}
