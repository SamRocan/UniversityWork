// 13706342
// SamClendenen@iCloud.com

import java.io.*;
import java.util.*;

public class Remove { 

	public static void remove( ArrayList<String> lst )
	{
	    int size = lst.size();
        for (int i = 0; i < size ; i ++) {
            lst.remove(i);
            size --;
        }

	}

    public static void main( String[] args ) 
    {
    }
}
