import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubStringPalindrom {
	
	static boolean checkIspalindrome(String sub) {
		if(sub.equals(new StringBuilder(sub).reverse().toString())) {
			return true;
		}
		return false;
	}
	
	static String longestSubString(List<String> pal) {
		String longStr =null;
		int len =0;
		for(String lonSub :pal) {
		if(lonSub.length()>len) {
			longStr =lonSub;
			len =lonSub.length();
		}
		}
		return longStr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> pal = new ArrayList<>();
		String s ="madam";
		for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<s.length();j++) {
				String subString =s.substring(i,j);
				if(checkIspalindrome(subString)) {
					pal.add(subString);
				}
			}
		}
		String longestPalindrome=null;
			longestPalindrome = longestSubString(pal);
		System.out.println(longestPalindrome);
	

	}

}
