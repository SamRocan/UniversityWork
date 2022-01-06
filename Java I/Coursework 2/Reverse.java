// 13706342
// SamClendenen@iCloud.com

import java.io.*;
import java.util.*;

public class Reverse { 

	public static String reverse( String s )
	{
		String backwards = "";
		for (int i = s.length() - 1; i >= 0; i-- ) {
			backwards += s.charAt(i);
		}

		return backwards;
	}

    public static void main( String[] args ) 
    {
    }
}
