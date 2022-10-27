import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ThreadRipper {

	//Code below sets concurrent operation to be done on 1 thread
	public static int findSum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
		sum += arr[i];
		}
		return sum;
	}
	

	public static void main(String[] args) {
		
		//Code below sets the array to 200 million random numbers between 1 and 10
		Random rand = new Random ();
		int arr[] = new int[200000000];
				for (int i = 0; i < arr.length; i++) {
				arr[i] = rand.nextInt(10) + 1;	
				}
		
		/*code below finds the sum of the parallel array by using multiple threads. 
		 The partial results from the processing of each substring are combined into a final result.
		 Parallel streams in JAVA 8 have systematically implemented the Fork/Join framework for executing these tasks (parallel). */
		int sum = 0;
		long startTime = System.nanoTime();
		
		sum = Arrays.stream(arr).parallel().sum();
		
		System.out.println("Parallel Thread Answer: " + sum + " Parallel time(ns): " + (System.nanoTime() - startTime));
		
		ThreadRipper.findSum(arr);
		System.out.println("Single Thread Answer: " + sum + " Single time(ns): " + (System.nanoTime() - startTime));
	}
	
}
