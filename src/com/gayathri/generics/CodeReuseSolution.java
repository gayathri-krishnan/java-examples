package com.gayathri.generics;

public class CodeReuseSolution {
	public static void main(String args[]) {
		System.out.println(coalesce(null, "two"));
		System.out.println(coalesce("one", "two"));
		System.out.println(coalesce("one", null));
		System.out.println(coalesce(null, new Integer(2)));
		System.out.println(coalesce(new Integer(1), new Integer(2)));
		System.out.println(coalesce(new Integer(1), null));
	}

	/**
	 * Returns first non null value or null , if all values are null
	 * 
	 * @param args
	 * @return
	 */
	public static <T> T coalesce(T a, T b) {
		if (a instanceof String) {
			return isEmpty((String) a) ? b : a;
		}
		return a == null ? b : a;
	}

	private static boolean isEmpty(String a) {
		return a == null || a.trim().length() == 0;
	}
}
