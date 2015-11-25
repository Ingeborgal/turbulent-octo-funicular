
public class Utility {
	
	private static final int MAX_BIT_LENGTH = 24;
	private static final int MAX_HEX_LENGTH = 6;
	private static final String LEGAL_DIGITS_HEX = "0123456789ABCDEF";
	
	
	public int convertFromBinaryToDecimal(String binary ) {
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

	private void controlLegalDigitForBit(String binary) {
		char [] numbers = binary.toCharArray();
		
		if (numbers.length > MAX_BIT_LENGTH || !binary.matches("[01]+"))
			throw new IllegalArgumentException();
	}
	
	private void controlLegalDigitForHex(String hexadecimalArray){
		char [] numbers = hexadecimalArray.toCharArray();
		
		if(numbers.length > MAX_HEX_LENGTH || !hexadecimalArray.matches("[0123456789ABCDEF]+"))
			throw new IllegalArgumentException();
	}
	
	public String convertFromDecimalToBinary(int integer) {
		StringBuilder strBuild = new StringBuilder("");
		
		for(int i = 0; i < MAX_BIT_LENGTH; i++, integer /= 2)
			strBuild.append(integer % 2);
		
		return strBuild.reverse().toString();
	}

	public int convertFromHexToDecimal(String hexadecimalArray) {
		
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

	public String convertFromDecimalToHex(int integer) {
		
		StringBuilder strBuild = new StringBuilder("");
		
		for (int i = 0; i < MAX_HEX_LENGTH; i++, integer /= 16)
			strBuild.append(LEGAL_DIGITS_HEX.charAt(integer % 16));
		
		return strBuild.reverse().toString();
	}

	public String bitwiseAndOperation(String bitwiseString1, String bitwiseString2) {
		StringBuilder strBuild = new StringBuilder("");
		
		for(int i = 0; i < MAX_BIT_LENGTH; i++)
			if(bitwiseString1.charAt(i) == '1'&& bitwiseString2.charAt(i) == '1')
				strBuild.append('1');
			else
				strBuild.append('0');
			
		return strBuild.reverse().toString();
	}

	public String bitwiseOrOperation(String bitwiseString1, String bitwiseString2) {
		StringBuilder strBuild = new StringBuilder("");
		for(int i = 0; i < MAX_BIT_LENGTH; i++)
			 if(bitwiseString1.charAt(i) == '1' || bitwiseString2.charAt(i) == '1')
				strBuild.append('1');
			else
				strBuild.append('0');
				
		return strBuild.reverse().toString();
	}
}
