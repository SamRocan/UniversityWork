// 13706342
// SamClendenan@iCloud.coms

import java.util.ArrayList;

class Replace<T> {

    static <T> void replace(ArrayList<T> list, T item1, T item2){
        for (int i =0; i <list.size(); i++){
            T hold = list.get(i);
            if(hold == null){
                
            }
            else{
                if(list.get(i)==item1){
                    list.set(i,item2);
                }
            }  
        }
    }

}