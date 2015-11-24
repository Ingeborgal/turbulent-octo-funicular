
public class Utility {
	
	private static final int MAX_BIT_LENGTH = 24;
	private static final int MAX_HEX_LENGTH = 6;
	private static final String LEGAL_DIGITS_HEX = "0123456789ABCDEF";
	

	public static int isEmpty(String string) {
		if( string.length() == 0 ){
			return 0;
	 
	}
		return string.length();
	}
	
	public static int convertFromBinaryToDecimal(String binary ) {
		int result = 0;
		if( binary.length() == 0 ){
			result = 0;
		}else {
		controlLegalDigitForBit(binary);
		char[] numbers = binary.toCharArray();
		
		for ( int i = numbers.length - 1; i >= 0; i-- )
			if ( numbers[i] == '1' )
				result += Math.pow( 2, ( numbers.length - i - 1 ) );
		}
		return result;
		 
	}


	private static void controlLegalDigitForBit(String binary) {
		char [] numbers = binary.toCharArray();
		
		if (numbers.length > MAX_BIT_LENGTH || !binary.matches("[01]+"))
			throw new IllegalArgumentException();
	}
	
	private static void controlLegalDigitForHex(String hexadecimalArray){
		char [] numbers = hexadecimalArray.toCharArray();
		
		if(numbers.length > MAX_HEX_LENGTH || !hexadecimalArray.matches("[0123456789ABCDEF]+"))
			throw new IllegalArgumentException();
	}
	

	public static String convertFromDecimalToBinary(int integer) {
		StringBuilder strBuild = new StringBuilder("");
		
		for(int i = 0; i < MAX_BIT_LENGTH; i++, integer /= 2)
			strBuild.append(integer % 2);
		
		return strBuild.reverse().toString();
	}

	public static int convertFromHexToDecimal(String hexadecimalArray) {
		
		hexadecimalArray = hexadecimalArray.toUpperCase();
		int result = 0;
		if( hexadecimalArray.length() == 0){
			result = 0;
		}else {
		controlLegalDigitForHex(hexadecimalArray);
			
		for( char hexaDecimal : hexadecimalArray.toCharArray() )
			result = 16 * result + LEGAL_DIGITS_HEX.indexOf(hexaDecimal);
		}
		return result;
	}
	
	
	
}
