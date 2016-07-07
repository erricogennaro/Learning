import java.util.Random;


public class RandomValue {
	private int value;
 
	public RandomValue(int persons){
	Random rand = new Random(); 
	value = rand.nextInt(persons);
	}
	
	public int getValue(){
		return value;
	}
	
}
