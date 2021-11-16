package fibonacci;

public class Fibonacci {

	/**
	 * Below copy your solution to recursive Fibonacci from studio
	 * 
	 * @param n
	 * @return the nth Fibonacci number, computed recursively
	 */
	public static int recursive(int n) {
		if(n == 0) {
			return 0;
		}
		else if(n == 1) {
			return 1;
		}
		else {
			return recursive(n-1) + recursive(n-2); // FIXME
		}
	}
	/**
	 * Below write your solution to Fibonacci, using iteration
	 * 
	 * @param n
	 * @return the nth Fibonacci number, computed iteratively
	 */
	public static int iterative(int n) {

		int[] fibonacci = new int[n+1];
		
		if(n == 0) {
			return 0;
		}
		else if(n == 1) {
			return 1;
		}
		
		for(int i = 0; i < fibonacci.length; i++) {
			fibonacci[i] = i;
		}
		
		for(int i = 2; i < fibonacci.length; i++) {		
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
		}	
		
		return fibonacci[n];

		
		// FIXME


	}

}
