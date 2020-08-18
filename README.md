
## Palindrome Challenge

From a given string S generate a string, that will be a palindrome of maximal length.
If there is more than one correct result, return any of them.
Examples
1. input: "aabb"
output: "abba" or "baab"
2. input: "abcd"
output: "a" or "b" or "c" or "d" - as we could use at most one character from the string to
generate max length palindrome.


##### SOLUTION
Create a path with the characters of string and count the total of times that appear,
after that I used a queue to put the half of characters because if the numbers of characters are pair
then the other part of palindrome is the same but reverse.
  
The Big-O complexity:
O(n) - where n is the number of characters in the string.
	 
  
The space complexity:
n * n/2  - where n is the number of elements in a map and n/2 the elements in the queue


###### Is the code ready for production?

I think more test cases are needed to evaluate the extremes before doing a production.



