import java.util.Arrays;

public class SubStringSmallAndLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s ="wlecome";
		int k =3;
		String subString [] =new String[s.length()-k +1];
		for(int i=0;i<=s.length()-k;i++) {
			subString[i] =s.substring(i,i+k);
		}
		Arrays.sort(subString);
		String samell =subString[0] ;
		String large =subString[subString.length-1];
		System.out.println(samell + ""+ large);

	}

}
