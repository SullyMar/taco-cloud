package web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.Taco;
import tacos.TacoOrder;

@Slf4j //logging provided by lombok
@Controller //marks this class as a candidate for component scanning and Spring will create an instance of this as a bean in the Spring application context
@RequestMapping("/design") //specifies the request this controller is handling
@SessionAttributes("tacoOrder") //will maintin the tacoOrder object throughout the session
public class DesignTacoController {

	//model is an object that ferries data between a controller and whatever view is charged with rendering that data
	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		List<Ingredient> ingredients = Arrays.asList(
				new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
				new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
				new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
				new Ingredient("CARN", "Carnitas", Type.PROTEIN),
				new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
				new Ingredient("LETC", "Lettuce", Type.VEGGIES),
				new Ingredient("CHED", "Cheddar", Type.CHEESE),
				new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
				new Ingredient("SLSA", "Salsa", Type.SAUCE),
				new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
				);
		Type[] types = Ingredient.Type.values();
		for(Type type : types) {
			model.addAttribute(type.toString().toLowerCase(),
				filterByType(ingredients, type));
		}
	}
	
	
	//objects to be placed into the model
	@ModelAttribute(name = "tacoOrder") //the model key is defined as -> name = "tacoOrder" (tacoOrder) is the key
	public TacoOrder order() {
		return new TacoOrder();
	}
	
	@ModelAttribute(name = "taco")
	public Taco taco() {
		return new Taco();
	}
	
	//handles all get request to the "design" page
	@GetMapping
	public String showDesignForm() {
		return "design";
	}
	
	//helper method
	private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients
				.stream() // pass the ingredients into the stream
				.filter(x -> x.getType().equals(type)) //filter by type
				.collect(Collectors.toList()); //any ingredient that matches out type is added to the list
	}
	
}

