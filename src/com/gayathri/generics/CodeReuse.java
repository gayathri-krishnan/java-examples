package com.gayathri.generics;

public class CodeReuse {
	public static void main(String args[]) {
		System.out.println(coalesce(null, "two"));
		System.out.println(coalesce("one", "two"));
		System.out.println(coalesce("one", null));

	}

	/**
	 * Returns first non null value or null , if all values are null
	 * 
	 * @param args
	 * @return
	 */
	public static String coalesce(String a, String b) {
		return isEmpty(a) ? b : a;

	}

	/**
	 * Identifies if a String is null or empty, i.e. ""
	 * 
	 * @param a
	 * @return
	 */
	private static boolean isEmpty(String a) {
		return a == null || a.trim().length() == 0;
	}
}
