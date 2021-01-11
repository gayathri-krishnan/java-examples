package com.gayathri.generics;

import java.util.ArrayList;
import java.util.List;

public class NonTypedListSolution {
	
	public static void main(String args[]) {
		List<Integer> randomList = new ArrayList<>();
		randomList.add(1);
		randomList.add(2);
		randomList.add(3);
		//The below line gives us a compilation error, 
		//protecting us from ClassCastException
		//randomList.add("four");
		
		printDoubed(randomList);
	}
	
	public static void printDoubed(List<Integer> list) {
		list.forEach(i->System.out.println(i*2));		
	}

}
