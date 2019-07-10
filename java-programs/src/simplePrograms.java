
public class simplePrograms {

	public static void main(String[] args) {
		String htmlText="<h1>Nayeem loves counseling</h1>	<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";
		// TODO Auto-generated method stub
		String stripped = htmlText.replaceAll("<[^>]*>", "");
		System.out.println(stripped);
		
		
	}

}
