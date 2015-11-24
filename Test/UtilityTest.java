import static org.junit.Assert.*;

import javax.rmi.CORBA.Util;

import org.junit.Test;


public class UtilityTest {

	Utility utility = new Utility();

	@Test
	public void convertFromBinaryToDecimal_convertsABinaryStringToDecimals_assertEquals(){ 
		assertEquals(6, utility.convertFromBinaryToDecimal("110"));
	}
	@Test (expected = IllegalArgumentException.class)
	public void convertFromBinaryToDecimal_exceedsMaximumLengthForBit_throwsIllegalArgumentException(){
		utility.convertFromBinaryToDecimal("10110101001100011100011100");
	}
	@Test (expected = IllegalArgumentException.class)
	public void convertFromBinaryToDecimal_illegalDigits_throwsIllegalArgumentExceptionException(){
		utility.convertFromBinaryToDecimal("65");
	}
	@Test
	public void convertFromBinaryToDecimal_isEmpty_shouldReturn0_assertEquals(){
		assertEquals(0, utility.convertFromBinaryToDecimal(""));
	}
	@Test
	public void convertFromDecimalToBinary_ConvertsDecimalsToABinaryString_assertEquals(){
		assertEquals("000000000000000000101101", utility.convertFromDecimalToBinary(45));
	}
	@Test
	public void convertFromHexToDecimal_convertsAHedecimalStringToDecimals_assertEquals(){
		assertEquals(255, utility.convertFromHexToDecimal("FF"));
	}
	@Test (expected = IllegalArgumentException.class)
	public void convertFromHexToDecimal_exceedsMaximumLengthForHex_throwsIllegalArgumentException(){
		utility.convertFromHexToDecimal("123456789");
	}
	@Test (expected = IllegalArgumentException.class)
	public void convertFromHexToDecimal_illegalDigits_throwsIllegalArgumentException(){
		utility.convertFromHexToDecimal("ndf788");
	}
	@Test
	public void convertFromHexToDecimal_emptyString_shouldReturn0(){
		assertEquals(0, utility.convertFromHexToDecimal(""));
	}
	@Test
	public void convertFromDecimalToHex_convertsDecimalsToHex_assertEquals(){
		assertEquals("000017", utility.convertFromDecimalToHex(23));
	}

	@Test
	public void bitwiseAndOperation_ifTheFirstNumberInBothStringsIs1_assertEquals(){
		String bitwiseString1 = "111111111111111111111111";
		String bitwiseString2 = "111111111111111111111111";
		assertEquals("111111111111111111111111", utility.bitwiseAndOperation(bitwiseString1, bitwiseString2));
	}
	@Test
	public void bitwiseAndOperation_ifTheFirstNumberInBothStringsIs0_assertEquals(){
		String bitwiseString1 = "000000000000000000000000";
		String bitwiseString2 = "000000000000000000000000";
		assertEquals("000000000000000000000000", utility.bitwiseAndOperation(bitwiseString1, bitwiseString2));
	}
	@Test
	public void bitwiseAndOperation_ifTheFirstNumberInTheFirstStringIs1AndTheSecondIs0_assertEquals(){
		String bitwiseString1 = "111111111111111111111111";
		String bitwiseString2 = "000000000000000000000000";
		assertEquals("000000000000000000000000", utility.bitwiseAndOperation(bitwiseString1, bitwiseString2) );
	}

	
	@Test
	public void bitwiseOrOperation_ifTheFirstNumberInBothStringsIs1_assertEquals(){
		String bitwiseString1 = "111111111111111111111111";
		String bitwiseString2 = "111111111111111111111111";
		assertEquals("111111111111111111111111", utility.bitwiseOrOperation(bitwiseString1, bitwiseString2));
	}
	@Test
	public void bitwiseOrOperation_ifTheFirstNumberInBothStringsIs0_assertEquals(){
		String bitwiseString1 = "000000000000000000000000";
		String bitwiseString2 = "000000000000000000000000";
		assertEquals("000000000000000000000000", utility.bitwiseOrOperation(bitwiseString1, bitwiseString2));
	}
	@Test
	public void bitwiseOrOperation_ifTheFirstNumberInTheFirstStringIs1AndTheSecondIs0_assertEquals(){
		String bitwiseString1 = "111111111111111111111111";
		String bitwiseString2 = "000000000000000000000000";
		assertEquals("111111111111111111111111", utility.bitwiseOrOperation(bitwiseString1, bitwiseString2));
	}

}
