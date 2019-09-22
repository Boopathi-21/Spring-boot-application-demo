import java.util.ArrayList;
import java.util.List;

public class Optimum {

	
	
	public static void main(String args[]) {
		List<String> newArr = new ArrayList<>();
		String arg[] = {"good","bad","good","hoo"};
		for(int i=0;i<arg.length;i++) {
			for(int j=i+1;j<arg.length;j++) {
		if(arg[i].equals(arg[j])) {
			System.out.println(arg[i]);	
		}
			}
		}
	
	int i= '3' ;
	System.out.println(i);
		
		
	}
}
