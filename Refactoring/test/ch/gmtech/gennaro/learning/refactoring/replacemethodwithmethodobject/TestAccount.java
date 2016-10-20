package ch.gmtech.gennaro.learning.refactoring.replacemethodwithmethodobject;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAccount {

	@Test
	public void test() {
		
		assertEquals(1010,new Account().gamma(5, 2, 10));
		
	}

}
