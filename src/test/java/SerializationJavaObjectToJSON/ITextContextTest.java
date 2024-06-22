package SerializationJavaObjectToJSON;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.Test;

public class ITextContextTest {
	
	
	 @Test
	    public void testMethod(ITestContext context) {
	        // Get current test name
	        String testName = context.getCurrentXmlTest().getName();
	        System.out.println("Current Test Name: " + testName);

	        // Get suite name
	        String suiteName = context.getSuite().getName();
	        System.out.println("Suite Name: " + suiteName);

	        // Get all test methods in the suite
	        System.out.println("All Test Methods:");
	        for (ITestNGMethod method : context.getSuite().getAllMethods()) {
	            System.out.println(method);
	        }

	        // Get and print failed tests
	        System.out.println("Failed Tests:");
	        context.getFailedTests().getAllMethods().forEach(testResult -> {
	            System.out.println(testResult.getMethodName());
	        });

	        // Set and get attribute
	        context.setAttribute("customAttribute", "attributeValue");
	        String customAttribute = (String) context.getAttribute("customAttribute");
	        System.out.println("Custom Attribute Value: " + customAttribute);
	    }

}
