// 13706342
// SamClendenan@iCloud.com

import java.io.*;
import java.util.*;


// class Card { 
// }

public class Hand
{
    String[] condensedStr;
    String retString = "";
 
    Hand( String str )
    {
        this.condensedStr = str.split("\\s+");

    }


    public String toString()
    {

        for(int i = 0; i< this.condensedStr.length; i++){
            int num = Integer.parseInt(this.condensedStr[i]);
            if ((num <= 10 && num > 1) && (i % 2 == 0)){
                retString += num + " of ";
            }
            if ((num == 1) && (i % 2 == 0)){
                retString += "Ace of ";
            }
            if ((num == 11) && (i % 2 == 0)){
                retString += "Jack of ";
            }
            if ((num == 12) && (i % 2 == 0)){
                retString += "Queen of ";
            }
            if ((num == 13) && (i % 2 == 0)){
                retString += "King of ";
            }
            if (i % 2 == 1){
                if (num == 0){
                    retString += "Clubs, ";
                }
                if (num == 1){
                    retString += "Diamonds, ";
                }
                if (num == 2){
                    retString += "Hearts, ";
                }
                if (num == 3){
                    retString += "Spades, ";
                }
            }
        }
        retString = retString.trim();
        retString = retString.substring(0, retString.length() -1);
        return retString;
    }


    public String status() // return "straight flush", "straight", "flush", or "none"
    {
        Boolean flush = true;
        Boolean straight = true;
        int counter = 1;
        String retString = "none";
        ArrayList<Integer> numList = new ArrayList<Integer>();
        ArrayList<Integer> suitList = new ArrayList<Integer>();
        for(int i = 0; i< this.condensedStr.length; i++) {
            if(i%2 == 0){
                numList.add(Integer.parseInt(this.condensedStr[i]));
            }
            if(i%2 ==1){
                suitList.add(Integer.parseInt(this.condensedStr[i]));
            }
        }
        Collections.sort(numList);

        for (int i = 0; i < suitList.size(); i++){
            if (suitList.get(0) - suitList.get(i) == 0){}
            else{flush = false;}
        }
        for (int i = 1; i < numList.size(); i++){
            if (numList.get(0) - (numList.get(i) - counter) == 0){}
            else{straight = false;}
            counter++;
        }
        //Special Case for royal straight (10,J,Q,J,A
        if(numList.get(0) == 1 && numList.get(1) == 10 && numList.get(2) == 11 && numList.get(3) == 12 && numList.get(4) == 13){
            straight = true;
        }
        if(straight == true) {retString = "straight";}
        if(flush == true) {retString = "flush";}
        if(straight == true && flush == true) {retString = "straight flush";}
        return(retString);
    }



    public static void main(String[] args) {
        // sample testing code
        Hand h = new Hand( "1 1 2 1 3 1 4 1 5 1" );
        Hand g = new Hand( "12 3 13 0 1 2 11 1 10 0" );
        System.out.println( h.toString() );
        System.out.println( g.toString() );
        System.out.println( h.status() );
        System.out.println( g.status() );
    }
    
}

