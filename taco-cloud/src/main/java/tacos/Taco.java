package tacos;
import java.util.List;
import lombok.Data;

//A domain object for the taco containing a name for the taco and a list of ingredients
@Data
public class Taco {
	private String name;
	private List<Ingredient> ingredients;
}
