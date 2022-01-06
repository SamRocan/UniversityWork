// 13706342
// SamClendenan@iCloud.com

import java.io.*;
import java.util.*;

public class Commas { 

	public static String separate( String s )
	{
		String commaStr = "";
		for(int i=0; i<s.length(); i++) {
			if(i == s.length() - 1){
				commaStr += s.charAt(i);
			}
			else{ commaStr += s.charAt(i)+ ",";}
		}

		return commaStr;
	}

    public static void main( String[] args ) 
    {
    }
}
