package SerializationJavaObjectToJSON;

import java.util.List;

/*
{
	"Id": "1",
	"Name": "Anchita",
	"Address": {
		"Phone number": "831*******",
		"home": "street 21 near CR , mumbai",
		"Email": "anchita.sharma@codingninjas.com"
	},
	"Education": {
		"School": "delhi public school mumbai",
		"College": "st.xaviers mumbai"
	},
	"Skills": [
		"Java",
		"Python",
		"JavaScript"
	],
	"Hobbies": [
		"Reading",
		"Traveling",
		"Photography"
	]
}
*/

public class Person {
	
	private int id;
	private String name;
	private Address address;
	private Education education;
	private List<String> skills;
	private List<String> hoobbies;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}
	
	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public List<String> getHoobbies() {
		return hoobbies;
	}

	public void setHoobbies(List<String> hoobbies) {
		this.hoobbies = hoobbies;
	}

}
