package main.java.com.skillsup.osyniaeva.tester;

import java.util.Random;

import main.java.com.skillsup.osyniaeva.singlethreaded.MergeSort;

/**
 * Created by osyniaeva on 10/5/17.
 */
public class Main {
	public static void main(String[] args) {
		int[] arr = new int[10];
		Random random = new Random();
		for (int i = 0; i< arr.length; i++) {
			arr[i] = random.nextInt(1000);

		}
		System.out.println(java.util.Arrays.toString(arr));
		MergeSort.mergeSort(arr);
		System.out.println(java.util.Arrays.toString(arr));
	}
}
