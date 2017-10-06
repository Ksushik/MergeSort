package main.java.com.skillsup.osyniaeva.multithreaded;

public class MultitrhreadedMergeSort {

	public static void mergeSort(int[] arr) {

		int mid = (0 + arr.length - 1) / 2;
		int[] buffer = new int[arr.length];

		Thread thread = new Thread(new MergeSortWorker(arr, 0, mid, buffer));
		Thread thread1 = new Thread(new MergeSortWorker(arr, mid + 1, arr.length - 1, buffer));
		thread.start();
		thread1.start();

		try {
			thread.join();
			thread1.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		merge(arr, 0, arr.length-1, mid, buffer);
	}

	static void mergeSort(int[] arr, int low, int high, int[] buffer) {

		//Выполняем разделение

		if (low >= high) {
			return;
		}

		int mid = (low + high) / 2;

		mergeSort(arr, low, mid, buffer);
		mergeSort(arr, mid + 1, high, buffer);

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
}