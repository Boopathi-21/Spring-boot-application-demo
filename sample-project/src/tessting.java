import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class tessting {
	
	public  static void main(String [] args)
	{
		List<String> colorNames = Arrays.asList("blue","orange");
		
  List<String> finalColor=colorNames.stream().filter( a-> a.contains("u")).collect(Collectors.toList());
		
		System.out.println(finalColor);
		
		
		
		 // TODO Auto-generated method stub
		
		        String str = "This this is is done by Saket Saket";
		
		        String[] split = str.split(" ");
		
		        HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		        for (int i=0; i<split.length-1; i++) {
		
		            if (map.containsKey(split[i])) {
		
		                int count = map.get(split[i]);
		
		                map.put(split[i], count+1);
		
		            }
		
		            else {
		
		                map.put(split[i], 1);
		
		            }
		
		        }
		
		        System.out.println(map);

		
	}

}
