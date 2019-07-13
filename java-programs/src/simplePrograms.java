import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.lang.model.element.Element;

public class simplePrograms {
	
	public static void foo(String s) {
		System.out.println("ssssss" + s);
	}
	public static void foo(Object s) {
		System.out.println("objects" + s);
	}
	

	public static void main(String[] args) {
		foo(null);
//		String htmlText="<h1>Nayeem loves counseling</h1>	<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";
//		// TODO Auto-generated method stub
//		String stripped = htmlText.replaceAll("<[^>]*>", "");
		
//		System.out.println(stripped);

		
		
		List<String> vowels = Arrays.asList("a","e"); 
		String checkVowels ="nazzf";
		for(int i=0;i< checkVowels.length();i++) {
			if(vowels.contains(String.valueOf(checkVowels.charAt(i)))) {
				System.out.println(checkVowels.charAt(i));
			}
		}
		
		String s[] = {"twt","sgrg"};
		int[] age = {12, 4, 5, 2, 5};
		int k=6;
		for(int i=0;i<age.length;i++) {
			for(int j=i+1;j<age.length;j++) {
				if(age[i] +age[j] ==k) {
					System.out.println("addition of the numbers" + age[i] + "another number" + age[j]);
				}
			}
		}
	}
	
	
	

	

}
