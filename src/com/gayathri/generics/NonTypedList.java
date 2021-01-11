package com.gayathri.generics;

import java.util.ArrayList;
import java.util.List;

public class NonTypedList {
	
	public static void main(String args[]) {
		ArrayList randomList = new ArrayList();
		randomList.add(1);
		randomList.add(2);
		randomList.add(3);
		randomList.add("four");
		
		printDoubed(randomList);
	}
	
	public static void printDoubed(List list) {
		list.forEach(i->System.out.println((Integer)i*2));		
	}

}
