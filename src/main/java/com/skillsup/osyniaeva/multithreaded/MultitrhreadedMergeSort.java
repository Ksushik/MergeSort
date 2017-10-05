package main.java.com.skillsup.osyniaeva.multithreaded;

public class MultitrhreadedMergeSort {

	public static void mergeSort(int[] arr) {

		mergeSort(arr, 0, arr.length - 1, new int[arr.length]);

	}

	public static class MergeSortWorker implements Runnable {
		int[] arr, buffer;
		int low, high;

		public MergeSortWorker(int[] arr, int low, int high, int[] buffer) {
			this.arr = arr;
			this.buffer = buffer;
			this.high = high;
			this.low = low;
		}

		@Override
		public void run() {
			mergeSort(arr, low, high, buffer);
		}
	}

	static void mergeSort(int[] arr, int low, int high, int[] buffer) {

		//Выполняем разделение

		if (low >= high) {

			return;

		}

		int mid = (low + high) / 2;

		new Thread(new MergeSortWorker(arr, low, mid, buffer)).start();
		new Thread(new MergeSortWorker(arr, mid + 1, high, buffer)).start();

		//Вызываем метод слияния

		merge(arr, low, high, mid, buffer);

	}

	static void merge(int[] arr, int low, int high, int mid, int[] buff) {

		int left = low, right = mid + 1;

		//Выполняем слияние

		for (int i = low; i <= high; i++) {

			if (right > high || left <= mid && arr[left] <= arr[right])

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