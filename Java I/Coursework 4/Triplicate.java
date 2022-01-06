// 13706342
// SamClendenan@icloud.com

import java.io.*;
import java.util.*;

public class Triplicate {

	public static void triplicate( ArrayList<Integer> list )
	{
		ArrayList<Integer> holdList = new ArrayList<Integer>();
		for( int i =0; i < list.size(); i++){
			int dub = list.get(i);
			holdList.add(dub);
			holdList.add(dub);
			holdList.add(dub);
		}
		list.clear();
		list.addAll(holdList);

	}

    public static void main(String[] args) {

	}
}
