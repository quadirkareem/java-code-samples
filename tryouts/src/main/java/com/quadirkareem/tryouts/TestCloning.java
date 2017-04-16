package com.quadirkareem.tryouts;
import java.util.HashMap;
import java.util.Map;

public class TestCloning {

	/*public static void main(String arg[]) {
		Employee jwz = new Employee();
		jwz.setName("Jamie Zawinski");
		jwz.setAddress(new Address("tolichowki", "hyderabad"));
		
		try {
			Employee joel = (Employee) jwz.clone();
			
			System.out.println("BEFORE:");
			System.out.println("jwz = " + jwz);
			System.out.println("joel = " + joel);
			
			joel.setName("Joel Spolsky");
			joel.setId(399);
			//joel.setAddress(new Address("abids", "atlanta"));
			joel.getAddress().setCity("ATLANTA");
			
			System.out.println("AFTER:");
			System.out.println("jwz = " + jwz);
			System.out.println("joel = " + joel);

		} catch (CloneNotSupportedException cnse) {
			System.out.println("Cloneable should be implemented. " + cnse);
		}
	}*/

	public static void main(String arg[]) {
		String key = "abids";

		HashMap<String, String> map = new HashMap<String, String>();
		map.put(key, "hyderabad");
		
		//Map<String, String> m2 = (HashMap<String, String>) map.clone();
		Map<String, String> m2 = new HashMap<String, String>();
		m2.putAll(map);
		
		System.out.println("BEFORE:");
		System.out.println("map: " + map.get(key));
		System.out.println("m2: " + m2.get(key));
				
		m2.put(key, "ATLANTA");
		
		String key2 = "ap";
		m2.put(key2, "ANNAPOLIS");

		System.out.println("AFTER:");
		System.out.println("map: " + map.get(key));
		System.out.println("m2: " + m2.get(key));

		System.out.println("map: " + map.get(key2));
		System.out.println("m2: " + m2.get(key2));
		
	}
}

class Address implements Cloneable {
	private String city;
	private String street;
	
	public Address(String street, String city) {
		this.setStreet(street);
		this.setCity(city);
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public String getStreet() {
		return this.street;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "street = " + street + "; city = " + city;
	}


}

class Employee implements Cloneable {

	private String name;
	private long id;
	private Address address;

	public Employee() {
		this.setId(System.currentTimeMillis());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return this.address;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		
		 Employee copyObj = new Employee();
		 copyObj.setId(this.id);
		 copyObj.setName(this.name);
		 copyObj.setAddress((Address) address.clone());
		 return copyObj;
		 
		
		//return super.clone();
	}

	@Override
	public String toString() {
		return "id = " + id + "; name = " + name + "; address = " + address;
	}

}

