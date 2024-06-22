package SerializationJavaObjectToJSON;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

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
public class SerializationWithMultipleJSONObjectAndArray {

	public static void invokingUsingGetterAndSetterMethods() throws Exception {
		Address address;
		Education education;
		Faker faker;
		List<String> skils;
		List<String> hobies;
		Person person;
		ObjectMapper mapper;
		String jsonBody;
		try {
			address=new Address();
			education = new Education();
			person = new Person();
			faker=new Faker();
			
			//address.setEmail("Nwo@gmail.com");
			//address.setHome("Sangam Vihar, New Delhi, 110062");
			//address.setPhoneNumber("93829233");
			
			address.setEmail(faker.internet().emailAddress());
			address.setHome(faker.address().buildingNumber());
			address.setPhoneNumber(faker.phoneNumber().phoneNumber());
			person.setAddress(address);
			
			
			//education.setSchool("DPS, Delhi");
			//education.setCollege("IIT, Delhi");
			
			education.setSchool(faker.name().username());
			education.setCollege(faker.name().username());
			person.setEducation(education);
			
			//We can add multiple values in single line at below
			skils=Arrays.asList("Java", "Python", "JavaScript");
			hobies=Arrays.asList("Reading", "Traveling", "Photography");
			
			//person.setId(344);
			//person.setName("Dheeraj Pratap Singh");
			person.setId(faker.number().randomDigit());
			person.setName(faker.name().fullName());
			person.setAddress(address);
			person.setEducation(education);
			person.setSkills(skils);
			person.setHoobbies(hobies);
				
			mapper = new ObjectMapper();
			mapper.writeValueAsString(person);
			jsonBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
			System.out.println(jsonBody);

		} catch (Exception e) {
			throw e;
		}
	}

	public static void main(String[] args) throws Exception {
		
		invokingUsingGetterAndSetterMethods();
	}

}