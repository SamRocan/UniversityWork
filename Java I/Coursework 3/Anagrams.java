// 13706342
// SamClendenan@iCloud.com

import java.io.*;
import java.util.*;

public class Anagrams {

	public static String convertStr(String str){
		String converted = "";
		for (int z = 0; z<str.length(); z++){
			if ((str.charAt(z) < 91) && (str.charAt(z) >64)){
				int num = str.charAt(z) + 32;
				char to = (char)num;
				converted += to;
			}
			else if ((str.charAt(z) < 123) && (str.charAt(z) >96)){
				converted += str.charAt(z);
			}
			else{}
		}
		return converted;
	}


	public static char anagrams( String a, String b )
	{
		int count = 0;
		int count2 = 0;
		int letCount = 0;
		int letCount2 = 0;
		if(a.length()<b.length()){}
		String aTemp = convertStr(a);
		String bTemp = convertStr(b);
		String aCon = "";
		String bCon = "";
		String retString = "";
		char retVal = ' ';
		boolean isAnagram = true;

		if(a.length()<b.length()){
			aCon = bTemp;
			bCon = aTemp;
		}
		else {
			aCon = aTemp;
			bCon = bTemp;
		}

		for (int i = 0; i < aCon.length(); i++ ){
			while(count < aCon.length()){
				if(aCon.charAt(count) == aCon.charAt(i)){
					letCount +=1;
				}
				count++;
			}
			while(count2<bCon.length()){
				if(bCon.charAt(count2)==aCon.charAt(i)){
					letCount2 +=1;
				}
				count2++;
			}
			//System.out.println(aCon.charAt(i)+": "+letCount);
			//System.out.println(aCon.charAt(i)+": "+letCount2);
			if (letCount != letCount2) {
				isAnagram = false;
				if (aCon.length() >= i) {retString += aCon.charAt(i);}
				if (bCon.length() > i) {retString += bCon.charAt(i);}
			}
			letCount = 0;
			letCount2 =0;
			count = 0;
			count2 =0;
		}
		//if yes, return !
		// if no, return last letter of the alphabet not in common
		//System.out.println(isAnagram);
		for(int z=0; z<retString.length(); z++){
			if(retString.charAt(z) > retVal){retVal = retString.charAt(z);}
		}
		//System.out.println(retString);
		if(isAnagram == true){retVal = '!';}
		else{}
		return retVal;
	}

    public static void main( String[] args ) 
    {
    }
}
