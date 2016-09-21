package ch.gmtech.gennaro.learning.randomannouncer;
import java.util.Random;


public class RandomValue {
	private int value;
 
	public RandomValue(int pvalue){
	Random rand = new Random(); 
	value = rand.nextInt(pvalue);
	}
	
	public int getValue(){
		return value;
	}
	
}
