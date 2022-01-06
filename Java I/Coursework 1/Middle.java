// sclend01
// SamClendenan@iCloud.com

import java.io.*;
import java.util.*;

public class Middle { 

	public static int middle( int a, int b, int c )
	{
		int largest = 0;
		int smallest =0;
		int mid = 0;
		if (a>=b && a>=c){ largest = a; }
		if (a<=b && a<=c){ smallest = a; }
		if (b>=a && b>=c){ largest = b; }
		if (b<=a && b<=c){ smallest = b; }
		if (c>=a && c>=b){ largest = c; }
		if (c<=a && c<=b){ smallest = c; }

		if ((smallest == a) & (largest == b) | (smallest == b) & (largest == a)) {mid = c;}
		if ((smallest == a) & (largest == c) | (smallest == c) & (largest == a)) {mid = b;}
		if ((smallest == c) & (largest == b) | (smallest == b) & (largest == c)) {mid = a;}
		return mid;
	}

    public static void main( String[] args )
    {
    }
}
