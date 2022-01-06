// 13706342
// SamClendenan@iCloud.com

import java.util.ArrayList;

class Append<T> {

    static <T> void append(ArrayList<T> first, ArrayList<T> second){
        for (int i =0; i <first.size(); i++){
            second.add(first.get(i));
        }
    }

}
