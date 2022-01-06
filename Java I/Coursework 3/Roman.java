// 13706342
// SamClendenan@iCloud.com

import java.io.*;
import java.util.*;

public class Roman {

    public static String convert( int num )
    {
        int yearNum =  num;

        int M = yearNum / 1000;
        int D = (yearNum - M*1000) / 500;
        int C = (yearNum - M*1000 - D*500) / 100;
        int L = (yearNum - M*1000 - D*500 - C*100) / 50;
        int X = (yearNum - M*1000 - D*500 - C*100 - L*50) / 10;
        int V = (yearNum - M*1000 - D*500 - C*100 - L*50 - X*10) / 5;
        int I = (yearNum - M*1000 - D*500 - C*100 - L*50 - X*10 - V*5) / 1;
        String RomanNum = "";

        String showRomanM = "";
        for (int i = M; i>0; i--){showRomanM+="M";}
        String showRomanD = "";
        for (int i = D; i>0; i--){showRomanD+="D";}
        String showRomanC = "";
        for (int i = C; i>0; i--){showRomanC+="C";}
        String showRomanL = "";
        for (int i = L; i>0; i--){showRomanL+="L";}
        String showRomanX = "";
        for (int i = X; i>0; i--){showRomanX+="X";}
        String showRomanV = "";
        for (int i = V; i>0; i--){showRomanV+="V";}
        String showRomanI = "";
        for (int i = I; i>0; i--){showRomanI+="I";}


        if (D == 1 && C ==4){ showRomanD = "CM"; }
        if (C == 4){ showRomanC = "CD"; }
        if (L == 1 && X == 4) {showRomanL = "XC"; }
        if (X == 4){showRomanX = "XL";}
        if (V == 1 && I == 4) {showRomanV = "IX";}
        if (I == 4){showRomanI = "IV";}

        if (showRomanV == "IX" && showRomanI == "IV"){showRomanI = "";}
        if (showRomanL == "XC" && showRomanX == "XL"){showRomanX = "";}
        if (showRomanD == "CM" && showRomanC == "CD"){showRomanC = "";}

        RomanNum = showRomanM+showRomanD+showRomanC+showRomanL+showRomanX+showRomanV+showRomanI;

        //for i = v-1, num = IV
        // for i = x-i, num = IX
        // for D = M-C, num = CM
        return RomanNum;
    }

    public static void main(String[] args) {
    }

}