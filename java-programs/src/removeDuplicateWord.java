import java.util.HashMap;
import java.util.Map;

public class removeDuplicateWord {
 public static void main(String [] args) {
	 Map<String,Integer> count =new HashMap<>();
	 
	 String text ="you are not are good or good bad";
	 String [] arr = text.split(" ");
	 StringBuilder finText = new StringBuilder();
	 int counts =1;
	 for(String m :arr) {
		 if(count.containsKey(m)) {
 		 counts =count.get(m);
         count.put(m, counts+1);
//			 continue;
		 }
		 else {
			 count.put(m,1);
			 finText.append(m).append(" ");
			 
		 }
	 }
	 System.out.println(count);
	 System.out.println(finText);
 }
}
