/*
	Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
	Input: S = "ADOBECODEBANC", T = "ABC"
	Output: "BANC"
	If there is no such window in S that covers all characters in T, return the empty string ""
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumWindowSubstring {
	public static void main(String args[]){
		String s = new String("ADOBQCAODEBAMNC");
		String t = "ABC";
		List<String> sCharacters = Arrays.asList(s.split(""));List<String> tCharacters = Arrays.asList(t.split(""));
		List<String> outputCharacters = new ArrayList<String>(); String output = "";
		
		for(int i=0;i<sCharacters.size();i++){
			outputCharacters.add(sCharacters.get(i));
			if(outputCharacters.containsAll(tCharacters)){
				if(output == "" || outputCharacters.size()<output.length())
					output = outputCharacters.toString().substring(1, 3 * outputCharacters.size() - 1) .replaceAll(", ", "");;
				outputCharacters.remove(0);
				i = i== sCharacters.size() ? i : i- outputCharacters.size() + tCharacters.size();
				outputCharacters = outputCharacters.size()>tCharacters.size() ? outputCharacters.subList(0, tCharacters.size()) : outputCharacters;
			}
		}
		
		System.out.println("Minimum String in "+ s + " which will contain all the characters in " + t + ": " + output);
	}
}
