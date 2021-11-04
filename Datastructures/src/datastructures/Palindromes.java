/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 *
 * @author shawn.ngutu
 */
public class Palindromes {

    // rearrange a string to make palindrome
public static String _getPalindrome(String str)
{    
    // Store counts of characters
    HashMap<Character, Integer> counting = new HashMap<>();
    for(char ch : str.toCharArray())
    {
        if (counting.containsKey(ch))
        {
            counting.put(ch, counting.get(ch) + 1);
        }
        else
        {
            counting.put(ch, 1);
        }
    }
     
    /* Find the number of odd elements. Takes O(n) */
    int oddCount = 0;
    char oddChar = 0;
     
    for(Entry<Character,Integer> itr : counting.entrySet())
    {
        if (itr.getValue() % 2 != 0)
        {
            oddCount++;
            oddChar = itr.getKey();
        }
    }
     
    /* odd_cnt = 1 only if the length of str is odd */
    if (oddCount > 1 || oddCount == 1 && str.length() % 2 == 0)
    {
        return "NO PALINDROME";
    }
     
    /* Generate first halh of palindrome */
    String firstHalf = "", lastHalf = "";
    for(Entry<Character, Integer> itr : counting.entrySet())
    {         
        // Build a string of floor(count/2) occurrences of current character
        String ss = "";
        for(int i = 0; i < itr.getValue() / 2; i++)
        {
            ss += itr.getKey();
        }
         
        // Attach the built string to end of and begin of second half
        firstHalf = firstHalf + ss;
        lastHalf = ss + lastHalf;
    }
     
    // Insert odd character if there is any
    return (oddCount == 1) ? (firstHalf + oddChar + lastHalf) : (firstHalf + lastHalf);
    }
}
