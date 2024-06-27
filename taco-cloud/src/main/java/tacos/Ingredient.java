package tacos;
//lombok generates all methods(Getters, Equals and more) and constructors that accepts all final properties as arguements
//lombok is libaray
import lombok.Data;

//A domain class is used to map data from a data store into a object storable in memory
@Data
public class Ingredient {
	
	private final String id;
	private final String name;
	private final Type type;
	
	public enum Type{
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
}
