// sclend01
// SamClendenan@iCloud.com


import java.io.*;
import java.util.*;

public class AddSecond { 

	public static String addSecond( int h, int m, int s )
	{
		int h1 = h;
		int m1 = m;
		int s1 = s;

		String hours = "";
		String mins = "";
		String secs = "";

		s1++;

		if (s1 >= 60) {
			s1 =  0;
			m1 ++;
		}
		if (m1 >= 60) {
			m1 = 0;
			h1++;
		}
		if (h1 >=24) {
			h1 = 0;
		}

		if (h1 < 10){ hours = "0" + String.valueOf(h1); }
		if (h1 >= 10){ hours = String.valueOf(h1); }
		if (m1 < 10){ mins = "0" + String.valueOf(m1); }
		if (m1 >= 10){ mins = String.valueOf(m1); }
		if (s1 < 10){ secs = "0" + String.valueOf(s1); }
		if (s1 >= 10){ secs = String.valueOf(s1); }
		return hours + ":"+ mins + ":"+secs;
	}

    public static void main( String[] args ) 
    { 
    }
}
