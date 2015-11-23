import static org.junit.Assert.*;

//BitStrings
//Length of string: 0 - 24, if the string is empty, it should return 0, length of string < 24 => throw illegal argument exception
//If there is other tokens than 0 & 1, throw illegal argument exception. 
//you should be able to send in an bit string, and get an int value in return. 
//you should be able to send in an int value and get a bit string value back, with the length of 24. 

//Hex strings
//length og string 0 - 6, isEmpty should return 0.
//is lengt of string more than 6, throw illegal argument exception.
//if the string contains any other tokens than 0123456789ABCDEF, throw illegal argument exception.
//

import org.junit.Test;


public class UtilityTest {
	
	
	@Test
	public void startingTest2(){		
		assertEquals(0, Utility.isEmpty());
		}
	@Test
	public void converter(){ 
		assertEquals(6, Utility.convertFromBinaryToDecimal("110"));
		
	}
	
}
