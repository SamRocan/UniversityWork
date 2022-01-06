// sclend01
// SamClendenan@iCloud.com

import java.io.*;
import java.util.*;

public class Intervals {

	public static String intersect( int a1, int b1, int a2, int b2 )

	{
		String retVal = "";
		if (b1 > a2) {
			if (a2 < a1) {
				retVal = "["+String.valueOf(a1)+","+String.valueOf(b1)+"]";
				return retVal;
			}
			else {
				retVal = "[" + String.valueOf(a2) + "," + String.valueOf(b1) + "]";
				return retVal;
			}
		}
		else { return "[]"; }
	}

    public static void main( String[] args ) 
    {
    	System.out.println(intersect(2,9,1,5));
    }
}
