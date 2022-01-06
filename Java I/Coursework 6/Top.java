// 13706342
// SamClendenan@iCloud.com

import java.util.*;


public class Top implements Sequence
{
    ArrayList<String> list;
    ArrayList<String> allList;
    //size limit set here
    int sizeLimit = 100;

    Top(){
        //Creates the array list, holds current tracked list
        list = new ArrayList<String>();
        //Creates the array list, holds all list values while size <=100
        allList = new ArrayList<String>();
    }

    public void push( String st ){

        // If there is nothing in the list, add first value
        if(list.size()<1){ list.add(0, st); }
        else{
            // Loop through list to see if word exists, if not, it is added
            // at position of first string its value is lower than
            for(int i = 0; i < list.size(); i++){
                int compare = st.compareTo(list.get(i));
                if(compare < 0){
                    if(list.contains(st) == false){ list.add(i, st); }
                    break;
                }
            }
            // If list is higher than all values, and size of list is less than
            // the size limit, it's added to end of list.
            if(list.contains(st) == false && list.size() < sizeLimit){ list.add(st); }
        }
        // If list is greater than the size limit, it is reduced to only its lowest
        // strings below the sizeLimit
        if(list.size()>sizeLimit){ list.subList(sizeLimit,list.size()).clear();}

    }


    public ArrayList<String> getTopThree() {
        ArrayList topThree = new ArrayList<>();
        int retVal;
        if (list.size() < 3){ retVal = list.size(); }
        else{ retVal = 3; }
        for(int i=0; i<retVal; i++){
            topThree.add(list.get(i));
        }
        return topThree;
    }


    public void reset(){
        int i = 0;
        //Adds all values to allList (containing all unique values so far, while under size limit)
        while(i < list.size()){
            if(allList.size()<1){ allList.add(0,list.get(i)); }
            else{
                for(int z = 0; z<allList.size(); z++){
                    int compare = list.get(i).compareTo(allList.get(z));
                    if(compare<0){
                        if(allList.contains(list.get(i)) == false){ allList.add(i, list.get(i)); }
                        break;
                    }
                }
                if(allList.contains(list.get(i))==false && allList.size() < sizeLimit){allList.add( list.get(i)); }
                // If list is greater than the size limit, it is reduced to only its lowest
                // strings below the sizeLimit
                if(allList.size()>sizeLimit){ allList.subList(sizeLimit,allList.size()).clear();}
            }
            i++;
        }

        list.clear();
    }

}