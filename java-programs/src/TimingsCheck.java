import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TimingsCheck {
	
	static boolean checkPalindrome(String sub) {
		if(sub.equals(new StringBuilder(sub).reverse().toString())) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String s="madam";
		
		if(s.equals(new StringBuilder(s).reverse().toString())) {
			System.out.println("is palindrome ..." );
		}
		else {
			System.out.println("is not palindrome ..." );
		}
// sub string
	int k =3;
	String subArr[] = new String[s.length()-k +1];
	 for(int i=0;i<=s.length()-k;i++)
	 {
		subArr[i]  =s.substring(i,k+i);
		System.out.println(subArr[i]);
	 }
	 Arrays.sort(subArr);
	 System.out.println("largestSubString .." + subArr[subArr.length-1]);
	 System.out.println("smalleseSubString .." + subArr[0]);
	 
	// first non-repeating character
		String fo ="masestxvx".toLowerCase();
		char ch[] = fo.toCharArray();
		Map<String,Integer> charMap = new HashMap<>();
		List<String> chrRepeatList = new ArrayList<>();
		List<String> chrNonRepeatList = new ArrayList<>();
		int count =0;
		for(char a :ch) {
			if(charMap.containsKey(Character.toString(a))) {
				count = charMap.get(Character.toString(a));
				System.out.println("count..." +count);
				charMap.put(Character.toString(a),count +1);
				chrRepeatList.add(Character.toString(a));
				chrNonRepeatList.remove(Character.toString(a))
;			}
			else {
				charMap.put(Character.toString(a),1);
				chrNonRepeatList.add(Character.toString(a));
			}
		}
		Map<String,Integer> sortedMap =charMap.entrySet().stream().
				sorted(Map.Entry.comparingByKey()).collect(
				Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, HashMap::new));
		System.out.println("sortedMap...." +sortedMap);
		for(Map.Entry<String, Integer> entry : charMap.entrySet()) {
				System.out.println("map value .... " + entry.getKey());
			
		}
		System.out.println("first-NOn-repeating character.." + chrNonRepeatList.get(0));
		System.out.println("first-NOn-repeating characterMAp.." + 
				charMap);
		

		//supalindrome
		List<String> plaindromeList = new ArrayList<>();
		for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<s.length();j++) {
				String subStr =s.substring(i,j);
				if(checkPalindrome(subStr)) {
					if(subStr.length() >1) {
						plaindromeList.add(subStr);	
					}
				}
			}
		}
		System.out.println("sub palindrome strings" + plaindromeList);
		
	// all permutation
		
		String per ="abc";
			permuations(per.toCharArray(),0);
		
	}
	
	static void permuations(char [] ch,int currentIndex) {
		
		if(currentIndex == ch.length-1) {
			System.out.println("possible string.." + String.valueOf(ch));
			
		}
		for(int i=currentIndex;i<ch.length;i++) {
			swap(ch,currentIndex,i);
			permuations(ch,currentIndex +1);
			swap(ch,currentIndex,i);
			
		}
	}
	static void swap(char[] ch,int i,int j) {
		char temp =ch[i];
		ch[i] =ch[j];
		ch[j]=temp;
	}
	

}
