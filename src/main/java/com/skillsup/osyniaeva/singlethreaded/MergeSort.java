package main.java.com.skillsup.osyniaeva.singlethreaded;

public class MergeSort {

	public static void mergeSort(int[] arr) {

		mergeSort(arr, 0, arr.length - 1, new int[arr.length]);

	}

	static void mergeSort(int[] arr, int low, int high, int[] buffer){

		//Выполняем разделение

		if (low >= high) {

			return;

		}

		int mid = (low + high)/2;

		mergeSort(arr, low, mid, buffer);

		mergeSort(arr, mid+1, high, buffer);

		//Вызываем метод слияния

		merge(arr,low, high, mid, buffer);

	}

	static void merge(int[]arr, int low, int high, int mid, int[] buff) {

		int left = low, right = mid + 1;

		//Выполняем слияние

		for (int i = low; i <= high; i++) {

			if (right>high||left<=mid && arr[left]<=arr[right])

			{

				buff[i] = arr[left++];

			} else {

				buff[i] = arr[right++];

			}

		}

		//Копируем буфер в массив arr

		for (int i = low; i <= high; i++) {

			arr[i] = buff[i];

		}

	}
}