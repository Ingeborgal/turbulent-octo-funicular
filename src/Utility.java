
public class Utility {
	
	private static final int 


	public static int isEmpty() {
	 int length = 0;
		
		return length;
	}

	public static Object convertFromBinaryToDecimal(String binary ) {
		char[] numbers = binary.toCharArray();
		int result = 0;

		for ( int i = numbers.length - 1; i >= 0; i-- )
			if ( numbers[i] == '1' )
				result += Math.pow( 2, ( numbers.length - i - 1 ) );

		return result;
	}
	

}
