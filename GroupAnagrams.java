/*
	Given an array of strings, group anagrams together.

	Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
	Output:
	[
	  ["ate","eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {
	public static void main(String args[]){
		String[] inputArray = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		HashMap<String, ArrayList<String>> anagramGroups = new HashMap<>();
		for(int i=0;i<inputArray.length;i++){
			char[] allChars = inputArray[i].toLowerCase().toCharArray();Arrays.sort(allChars);
			String sortedCharacters = String.valueOf(allChars);
			ArrayList<String> list = anagramGroups.containsKey(sortedCharacters) ? anagramGroups.get(sortedCharacters) : new ArrayList<>(); 
			list.add(inputArray[i]);	
			anagramGroups.put(sortedCharacters, list);
		}
		
		System.out.print("Anagram Groups : " + anagramGroups.values());
	}
}
