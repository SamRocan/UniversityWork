// 13706342
// SamClendenen@iCloud.com

import java.io.*;
import java.util.*;

public class StringSum { 

	public static int sum( String s )
	{
		int len = s.length();
		int sumVal = 0;
		for (int i = 0; i <len; i++ ) {
			char ch = s.charAt(i);
			int castAcii = (int) ch;
			if((65 <= castAcii && 90>= castAcii) || (97 <= castAcii && 122>= castAcii)) {
				if ( castAcii < 91){
					sumVal = sumVal + castAcii - 64;
				}
				else {
					sumVal = sumVal + castAcii - 96;
				}
			}
			else {}
		}
		return sumVal;
	}

    public static void main( String[] args ) 
    {
    }
}
