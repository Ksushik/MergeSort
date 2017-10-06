package main.java.com.skillsup.osyniaeva.tester;

import java.util.Arrays;
import java.util.Random;

import main.java.com.skillsup.osyniaeva.multithreaded.MultitrhreadedMergeSort;
import main.java.com.skillsup.osyniaeva.singlethreaded.MergeSort;

/**
 * Created by osyniaeva on 10/5/17.
 */
public class Main {
	public static void main(String[] args) {
		int[] arr = new int[50000];
		Random random = new Random();
		for (int i = 0; i< arr.length; i++) {
			arr[i] = random.nextInt(1000);

		}

		System.out.println("*********************************************************************** ");
		System.out.println("       Single-threaded");
		System.out.println("Original array: " + java.util.Arrays.toString(arr));
		int [] arr2 = Arrays.copyOf(arr, arr.length);
		long startTime = System.currentTimeMillis();
		MergeSort.mergeSort(arr);
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;

		System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
		System.out.println("Duration of sorting process: " + duration);

		System.out.println("*********************************************************************** ");
		System.out.println("         Multy-threaded ");
		System.out.println("Original array: " + java.util.Arrays.toString(arr2));
		long startTimeMultithreaded = System.currentTimeMillis();
		MultitrhreadedMergeSort.mergeSort(arr2);
		long endTimeMultithreaded = System.currentTimeMillis();
		long durationMultithreaded = endTimeMultithreaded - startTimeMultithreaded;

		System.out.println("Sorted array: " + java.util.Arrays.toString(arr2));
		System.out.println("Duration of sorting process: " + durationMultithreaded);

	}
}
