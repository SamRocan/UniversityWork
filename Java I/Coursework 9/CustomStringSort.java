// 13706342
// SamClendenan@iCloud.com

import java.io.*;
import java.util.*;


interface PredicateStringPair
{
    boolean better( String a, String b );
}


public class CustomStringSort {

    /*returns instance of Comparator<String> called pred, which receives 2 strings
    pred will return:
                      - negative when 'better' method true a, b
                      - positive when 'better' method true b, a
                      - 0 otherwise.
     */
    public static Comparator<String> createComparator( PredicateStringPair pred )
    {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(pred.better(o1, o2) == true){
                    return -1;
                }
                if(pred.better(o2, o1) == true){
                    return 1;
                }
                else{
                    return 0;
                }

            }
        };

    }

    /* Calls createComparator on pred to obtain instance of Comparator<String>
       then calls Collections.sort, passing it both lst and Comparator<String>
     */
    public static void sortStrings( ArrayList<String> lst, PredicateStringPair pred )
    {
        Comparator<String> hold = createComparator(pred);
        Collections.sort(lst,hold);
 
    }

    /* Using lambda expressions, defines instance PredicateStringPair whose
    method returns on a pair of Strings a, b if and only if the length of a
    is strictly greater than the length of b.
    Calls sortString on lst and created instance of PredicateStringPair
    */
    public static void sortStringsLonger( ArrayList<String> lst )
    {
        PredicateStringPair lambda = ((a, b) -> {
            if(a.length()>b.length()) {return true;}
            else {
                return false;
            }
        });

        sortStrings(lst, lambda);

    }

    /* using lambda expression, defines an instance of PredicateStringPair whose
       method returns true on Pair of strings s1, s2 if the number of occurences
       of the letter a (upper or lower case) in s1 > s2.
       Then calls sort strings on list and the created instance of
       PredicateStringPair

    */
    public static void sortStringsNumAs( ArrayList<String> lst )
    {
        PredicateStringPair lambda =((a, b) -> {
            int s1Count = 0;
            int s2Count = 0;
            for(int i=0;i<a.length();i++){
                if( a.charAt(i)==65 || a.charAt(i)==97){
                    s1Count++;
                }
            }
            for(int i=0;i<b.length();i++){
                if( b.charAt(i)==65 || b.charAt(i)==97){
                    s2Count++;
                }
            }
            if(s1Count>s2Count){
                return true;
            }
            else{
                return false;
            }
        });
        sortStrings(lst,lambda);
    }

    /*
        Using lambda expressions, defines an instance of predicateStringPair
          whose methods return true on a pair of strings s1, s2 if s1 comes
          before s2 according to dictionary ordering.
          --> Calls sortString on lst and the created instance PredicateStringPair
          --> Dictionary ordering: if all the same, s1 before  s2
              else a<A<b<B..... etc
          --> if word starts with non letters, it instantly after anything with letters.
          --> ignore non-letters unless both contain only non-letters, then just
              use standard ordering defined by char values
     */
    public static void sortStringsDictionary( ArrayList<String> lst )
    {
        PredicateStringPair pred = (s1,s2) -> {
            int strLength;
            if(s2.length()<s1.length()){
                strLength=s2.length();
            }
            else{
                strLength=s1.length();
            }

            for(int i=0; i<strLength; i++){
                //if characters arent the same
                if(s1.charAt(i)!=s2.charAt(i)){
                    //if s1 is lower case and s1 is equal to uppercase s2, return true
                    if((s1.charAt(i)>97 && s1.charAt(i)<122) && s1.charAt(i)==(s2.charAt(i)-32)){
                        return true;
                    }
                    if((s2.charAt(i)>97 && s2.charAt(i)<122) && s1.charAt(i)==(s2.charAt(i)-32)){
                        return false;
                    }
                    //if both are lower case or both are uppercase, return the letter than comes first alphabetically
                    if((s1.charAt(i)>65 && s1.charAt(i)<90) && (s2.charAt(i)>65 && s2.charAt(i)<90) || (s1.charAt(i)>97 && s1.charAt(i)<122) && (s2.charAt(i)>97 && s2.charAt(i)<122)){
                        //s1 comes before s2
                        if(s1.charAt(i)< s2.charAt(i)){
                            return true;
                        }
                        //s2 comes before s1
                        if(s1.charAt(i)> s2.charAt(i)){
                            return false;
                        }
                    }
                    if((Character.isLetter(s1.charAt(i))== true) && (Character.isLetter(s2.charAt(i))==false)){
                        return true;
                    }
                    if((Character.isLetter(s1.charAt(i))== false) && (Character.isLetter(s2.charAt(i))==true)){
                        return false;
                    }
                    if((Character.isLetter(s1.charAt(i))== false) && (Character.isLetter(s2.charAt(i))==false)){
                        if(s1.charAt(i)<s2.charAt(i)){
                            return true;
                        }
                        if(s1.charAt(i)>s2.charAt(i)){
                            return false;
                        }
                    }

                }
            }
            if(s1.length() <= s2.length()){
                return true;
            }
            else{
                return false;
            }

        };
        sortStrings(lst, pred);
    }

  
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<String>();

        fruits.add("Strawberry");
        fruits.add("strawberries");
        fruits.add("Kiwi");
        fruits.add("kiwis");
        fruits.add("Banana");
        fruits.add("bananas");

        System.out.println( fruits );
        sortStringsLonger( fruits);
        System.out.println( fruits );
        
        sortStringsNumAs( fruits );
        System.out.println( fruits );

        fruits.add( "@plum" );
        fruits.add( "@kumquat" );
        fruits.add( "banana" );
        fruits.add( "3 oranges" );
        fruits.add( "9 oranges" );
        fruits.add( "33 oranges" );
        System.out.println( fruits );
        sortStringsDictionary( fruits );
        System.out.println( fruits );
    }
}
