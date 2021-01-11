package com.gayathri.lambdas;

public class LambaUsage {
	public static void main() {
		
		
		DoStringStuff upperAndConcat = (s1,s2) -> s1.toUpperCase()+s2.toUpperCase();
		//Use Lambdas to pass behaviour
		System.out.println(process(upperAndConcat,  "first", "second"));
	}

	public static String process(DoStringStuff d,String s1, String s2) {
		return d.doStuff(s1, s2);
	}
}

interface DoStringStuff{
	public String doStuff(String s1, String s2);
}