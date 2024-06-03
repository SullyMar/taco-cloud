package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  
/*
 * The above '@SpringBootApplication' is a composite annotiation
 * That is, it combines 3 different annotations that do different things.
 * 1) @SpringBootConfiguration
 * 		- This designates the class as a configuration class
 * 
 * 2) @EnableAutoConfiguration
 * 		- This enables Spring Boots auto configuration, it tells Spring Boot to auto 
 * 			configure any component that it thinks you might need. (More about this later)
 * 
 * 3) @ComponentScan
 * 		- This allows you to declare other classes with annotations such as (@Component, @Controller, @Service)
 * 		- This will let Spring automatically discover and register them as components in the Spring Application Contenxt
 **/

//this is considered a 'bootstrap class'
public class TacoCloudApplication { 
	/*
	 *The application will be ran from an executable JAR file so the main class is important to have.
	 *As it will be executed when the JAR file is ran.
	 */
	public static void main(String[] args) { 
		// This is configuration that will 'bootstrap' the app
		//Passing the configuration class 'TacoCloudApplication.class' and the cmd line arguement 'args'
		//the 'run' method takes 2 arguements
		SpringApplication.run(TacoCloudApplication.class, args); 
		
	}

}
