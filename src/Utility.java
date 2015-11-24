
public class Utility {
	
	private static final int MAX_BIT_LENGTH = 24;
	

	public static int isEmpty() {
		
	 
		
		return length;
	}
	
	public static Object convertFromBinaryToDecimal(String binary ) {
		controlLegalDigit(binary);
		char[] numbers = binary.toCharArray();
		int result = 0;
		

		for ( int i = numbers.length - 1; i >= 0; i-- )
			if ( numbers[i] == '1' )
				result += Math.pow( 2, ( numbers.length - i - 1 ) );
	
		return result;
		 
	}


	private static void controlLegalDigit(String binary) {
		char [] numbers = binary.toCharArray();
		
//		for (int i = 0; i < numbers.length; i++)
		if (numbers.length > MAX_BIT_LENGTH || !binary.matches("[01]+"))
			throw new IllegalArgumentException();
		
	}
	
	
	
}
