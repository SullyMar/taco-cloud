package tacos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller // defining the controller
public class HomeController {
	
	//GetMapping indicates if an HTTP get request is done on the specified path then the method will handle the request
	@GetMapping("/") //handling requests to this path
	public String Home() {
		return "home"; // return the views name
	}
	//the home view will be stored in the src/main/resources/templates/home.html
}
