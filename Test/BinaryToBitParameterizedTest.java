import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class BinaryToBitParameterizedTest {
	
	private int decimal;
	private String bit;
	
	public BinaryToBitParameterizedTest(String bit, String decimal){
		this.bit = bit;
		this.decimal = Integer.parseInt(decimal);
	}
	
	@Parameterized.Parameters
	public static java.util.Collection<String[]> input(){
		return java.util.Arrays.asList(new String[][]{
				
				{"000000000000000000000110", "6"},
				{"000000000000000000010011", "19"},
				{"000000000000000001010111", "87"},
				{"000000000000000000010110", "22"},
				{"000000000000000000111000", "56"},
				{"000000000000000001100011", "99"},
				{"000000000000000000000011", "3"}
			
		});
	}

	@Test
	public void DecimalToBit() {
		Utility utility = new Utility();
		String converted = utility.convertFromDecimalToBinary(decimal);
		assertEquals(bit, converted);
	
	}

}
