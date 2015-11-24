import static org.junit.Assert.*;

import org.junit.Test;


public class UtilityTest {

	//	
	//	@Test
	//	public void startingTest2(){		
	//		assertEquals(0, Utility.isEmpty());
	//		}
	@Test
	public void convertFromBinaryToDecimal(){ 
		assertEquals(6, Utility.convertFromBinaryToDecimal("110"));
	}

	@Test (expected = IllegalArgumentException.class)
	public void convertFromBinaryToDecimal_MaximumLengthForBit_assertEquals(){
		assertEquals(47499036, Utility.convertFromBinaryToDecimal("10110101001100011100011100"));
	}
	@Test(expected = IllegalArgumentException.class)
	public void checkForIllegalArguments(){
		Utility.convertFromBinaryToDecimal("65");
	}
	@Test
	public void Empty(){
		assertEquals(0, Utility.convertFromBinaryToDecimal(""));
	}


}
