package com.gayathri.lambdas;
/**
 * 
 * @author krga9002
 * Replace Anonymous classes
 */
public class HelloLambda {
	/**
	 * Refer {@link java.lang.Runnable}
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new CodeToRun()).start();
		new Thread(new Runnable() {		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Printing from Anonymous Class");
			}
		});
		//Syntax - Empty Argument list() arrow token -> and the body that needs to be executed
		//Java is able to match the body with the only method that Runnable has which is run()
		//Runnable is hence a functional interface
		new Thread(()->System.out.println("Hello Lambda!!")).start();
		new Thread(()->{
			System.out.println("Hello Lambda!!");
			System.out.println("Second Line!!");
		}).start();
		
		
	}

}

class CodeToRun implements Runnable{

	@Override
	public void run() {
		System.out.println("Printing from Code To Run");
		
	}
	
}