import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class employee{
	private String firstName;
	private String LastName;
	private String countryName;
	private String countryId;
	
	public employee(String firstName, String LastName, String countryName,String countryId) {
		this.firstName =firstName;
		this.LastName =LastName;
		this.countryName = countryName;
		this.countryId =countryId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	
	
}


public class ComparatorSort {
	
	
	
	public static void main(String args[]) {
		List<employee> employeeList = Arrays.asList(
				new employee("bsa", "cnom", "india", "23"),
		      new employee("asa", "cnom", "bndia", "23"),
	     new employee("xsa", "cnom", "aindia", "23"));
		
		
//		Comparator<employee> employebyname = (employee a,employee b) ->
//		a.getFirstName().compareTo(b.getFirstName());
//		Comparator<employee> employebycountry = (employee a,employee b) ->
//		a.getCountryName().compareTo(b.getCountryName());
		Comparator<employee> employebyname =Comparator.comparing(employee::getFirstName);
		Comparator<employee> employebycountry =Comparator.comparing(employee::getCountryName);
		
		
	Comparator<employee> full =employebyname.thenComparing(employebycountry);
		Collections.sort(employeeList, full);
		employeeList.sort((employee s1,employee s2) -> s1.getCountryName().compareTo(s2.getCountryName()));
		for(employee e: employeeList) {
			System.out.println(e.getFirstName()+ "|" +e.getLastName() +"|"+ e.getCountryName() +"|"+
		"|" +e.getCountryId());	
			System.out.println("\n");
		}
		
		
		
		
		
		
	}
	

}
