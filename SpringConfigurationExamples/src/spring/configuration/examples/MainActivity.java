package spring.configuration.examples;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainActivity {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationConfiguration.xml");
		
// Example of constructor Injection
		System.out.println("<------ constructor injection starts here ----->\n\n");
//		Default constructor
		Employee empConst1 = applicationContext.getBean("empConst1", Employee.class );
		empConst1.showData("empConst1");
		
//		only one argument in the constructor by default it will be treated as String, as the argument
//		will be treated as String thats why it will fire up the constructor whose argument is type of String
		Employee empConst2 = applicationContext.getBean("empConst2",Employee.class);
		empConst2.showData("empConst2");
		
//		argument type defined in the configurations as integer
		Employee empConst3 = applicationContext.getBean("empConst3",Employee.class);
		empConst3.showData("empConst3");
		
//		argument type defined in the configurations as String
		Employee empConst4 = applicationContext.getBean("empConst4",Employee.class);
		empConst4.showData("empConst4");
		
//		both the arguments are defined configurations
		Employee empConst5 = applicationContext.getBean("empConst5",Employee.class);
		empConst5.showData("empConst5");
		
		Employee empConst6 = applicationContext.getBean("empConst6",Employee.class);
		empConst6.showData("empConst6");
		
		Employee empConst7 = applicationContext.getBean("empConst7",Employee.class);
		empConst7.showData("empConst7");
		
		System.out.println("\n<------ constructor injection ends here ----->\n\n");
		//constructor injection ends here
		
		//Setter Injection starts here
		
		System.out.println("<------ setter injection starts here ----->\n\n");
		
//		setting only employeeId
		Employee empSetter1 = applicationContext.getBean("empSetter1",Employee.class);
		empSetter1.showData("empSetter1");
		
//		setting only employeeName
		Employee empSetter2 = applicationContext.getBean("empSetter2",Employee.class);
		empSetter2.showData("empSetter2");
		
//		setting both employeeId and employeeName
		Employee empSetter3 = applicationContext.getBean("empSetter3",Employee.class);
		empSetter3.showData("empSetter3");
		
//		setting both employeeId and employeeName and address
		Employee empSetter4 = applicationContext.getBean("empSetter4",Employee.class);
		empSetter4.showData("empSetter4");
		
//		setting both employeeId and employeeName and address and list of projects
		Employee empSetter5 = applicationContext.getBean("empSetter5",Employee.class);
		empSetter5.showData("empSetter5");
		
		
		
		
		
		applicationContext.close();
	}

}
