import static org.junit.Assert.*;

import org.junit.Test;


public class UtilityTest {
	
	@Test
	public void checkLengthOfString(){
		
	}

	@Test
	public void convertFromBinaryToDecimal_assertEquals(){ 
		assertEquals(6, Utility.convertFromBinaryToDecimal("110"));
	}
	@Test (expected = IllegalArgumentException.class)
	public void convertFromBinaryToDecimal_exceedsMaximumLengthForBit_assertEquals(){
		assertEquals(47499036, Utility.convertFromBinaryToDecimal("10110101001100011100011100"));
	}
	@Test (expected = IllegalArgumentException.class)
	public void checkForIllegalArguments_castsException(){
		Utility.convertFromBinaryToDecimal("65");
	}
	@Test
	public void isEmpty_BitString_Returns0_assertEquals(){
		Utility.convertFromBinaryToDecimal("");
	}
	@Test
	public void convertFromDecimalToBinary(){
		assertEquals("000000000000000000101101", Utility.convertFromDecimalToBinary(45));
	}
	@Test
	public void convertFromHexToDecimal(){
		assertEquals(255, Utility.convertFromHexToDecimal("FF"));
	}
	@Test (expected = IllegalArgumentException.class)
	public void convertFromHexToDecimal_exceedsMaximumLengthForHex_throwsIllegalArgumentException(){
		Utility.convertFromHexToDecimal("123456789");
	}
	@Test (expected = IllegalArgumentException.class)
	public void convertFromHexToDecimal_IllegalDigits_throwsIllegalArgumentException(){
		Utility.convertFromHexToDecimal("ndf788");
	}
	@Test
	public void convertFromHexToDecimal_emptyString_throwsIllegalArgumentException(){
		assertEquals(0, Utility.convertFromHexToDecimal(""));
	}
	
//	@Test
//	public void bitwiseAndOperation(){
//		
//	}


}
