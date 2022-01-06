// 13706342
// SamClendenan@iCloud.com

import java.io.*;
import java.util.*;

public class Between { 

	public static String between( int a, int b )
	{
		Boolean Desc = true;
		int start = 0;
		int end= 0;
		String str ="";

		if( a < b){
			Desc = false;
			start = a;
			end = b;
			for(int i = start + 1; i < end; i++){
				if(i%2 == 1 || i%2 == -1){ str += String.valueOf(i) + " "; }
				else {}
			}
		}
		else {
			Desc = true;
			start = a;
			end = b;
			for(int i = start -1; i > end; i--){
				if(i%2 == 1){ str += String.valueOf(i) + " "; }
				else {}
			}
		}
		return str.trim();
	}

    public static void main( String[] args ) 
	{
    }
}
