// 13706342
// SamClendenen@iCloud.com

import java.io.*;
import java.util.*;

public class Classify { 

	public static String classify( char c )
	{
		String output = "";
		int aciiVal = (int) c;
		if (aciiVal <=90 && aciiVal >=65){output += "uppercase";}
		if (aciiVal <=122 && aciiVal >=97){output += "lowercase";}
		if (aciiVal == 65 || aciiVal == 69 || aciiVal == 73 || aciiVal == 79 || aciiVal == 85){output += " vowel";}
		if ((65 < aciiVal && aciiVal < 69) || (69 < aciiVal && aciiVal < 73) || (73 < aciiVal && aciiVal < 79) || (79 < aciiVal && aciiVal < 85) || (85 < aciiVal && aciiVal < 91)){output += " consonant";}
		if (aciiVal == 97 || aciiVal == 101 || aciiVal == 105 || aciiVal == 111 || aciiVal == 117){output += " vowel";}
		if ((97 < aciiVal && aciiVal < 101) || (101 < aciiVal && aciiVal < 105) || (105 < aciiVal && aciiVal < 111) || (111 < aciiVal && aciiVal < 117) || (117 < aciiVal && aciiVal < 123)){output += " consonant";}
		return output;
	}

    public static void main( String[] args ) 
    {
    }
}
