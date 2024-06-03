package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // Spring boot application, self explanatory
public class TacoCloudApplication {

	/**
	 *The application will be ran from an executable JAR file so the main class is important to have.
	 *As it will be executed when the JAR file is ran.
	 ***/
	public static void main(String[] args) { 
		// This is configuration that will 'bootstrap' the app
		SpringApplication.run(TacoCloudApplication.class, args); 
		
	}

}
