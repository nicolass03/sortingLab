package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sorting {

	/**
	 * Constant for INPUT option.
	 */
	public static final int INPUT = 0;
	
	/**
	 * Constant for Generate option.
	 */
	public static final int GENERATE = 1;

	
	/**
	 * Constructor of the class
	 */
	public Sorting(){

	}

	/**
	 * Converts String array into int array
	 * @param a - the string array to convert
	 * @return the array converted to int[]
	 * @throws NumberFormatException
	 */
	public int[] convertArrayToInt(String[] a) throws NumberFormatException{
		int[] newArray = new int[a.length];

		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = Integer.parseInt(a[i]);
		}
		
		return newArray;
	}

	/**
	 * Converts String array into double array
	 * @param a - the string array to convert
	 * @return the array converted to double[]
	 * @throws NumberFormatException
	 */
	public double[] convertArrayToDouble(String[] a)  throws NumberFormatException{
		double[] newArray = new double[a.length];

		try {
			for (int i = 0; i < a.length; i++) {
				newArray[i] = Double.parseDouble(a[i]);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return newArray;
	}

	/**
	 * Sorts the int array given.
	 * @param data the array to sort.
	 * @param code 1 for generate, 0 for input.
	 * @return the information including sorted array with different sorting methods and their time.
	 * @throws NumberFormatException
	 */
	public ArrayList sortInt(String[] data, int code)  throws NumberFormatException{

		ArrayList text = new ArrayList();

		int[] arr;

		if(code == INPUT) {
			arr = convertArrayToInt(data);
		}

		else {

			///////////////

			int range = Integer.parseInt(data[0]);

			///////////////

			int size = Integer.parseInt(data[1]);

			/////////////////
			int form;

			if(data[2].equals("Ordered")){
				form =  1;

			}
			else if(data[2].equals("Ordered backwards")) {
				form =  2;

			}
			else if(data[2].equals("Random")) {
				form =  3;

			}
			else {
				form =  4;

			}

			//////////////////

			boolean dif;
			if(data[3].equals("true"))
				dif = true;
			else
				dif = false;

			///////////////////

			int percentage = 0;
			if(!data[4].equals(""))
				percentage = Integer.parseInt(data[4]);

			//////////////////

			arr = generateArray(form, dif, size, range, percentage);

		}
		//Quick Sort
		int[] quick = arr.clone();
		long t1 = System.nanoTime();
		quickSort(quick, 0, quick.length-1);
		long t2 = System.nanoTime();
		String rQuick = "It took "+(t2-t1)+" nanoseconds to Quick Sort";

		//Counting Sort
		t1 = System.nanoTime();
		int[] counting = countingSort(arr);
		t2 = System.nanoTime();
		String rCounting = "It took "+(t2-t1)+" nanoseconds to Counting Sort";

		//Heap Sort
		int[] heap = arr.clone();
		t1 = System.nanoTime();
		heapSort(heap);
		t2 = System.nanoTime();
		String rHeap = "It took "+(t2-t1)+" nanoseconds to Heap Sort";

		text.add("This is the array to sort:");
		text.add(arr);
		text.add(rQuick);
		text.add(quick);
		text.add(rCounting);
		text.add(counting);
		text.add(rHeap);
		text.add(heap);

		return text;
	}
	
	/**
	 * Sorts the double array given.
	 * @param data the array to sort.
	 * @param code 1 for generate, 0 for input.
	 * @return the information including sorted array with different sorting methods and their time.
	 * @throws NumberFormatException
	 */
	public ArrayList sortDouble(String[] data, int code)  throws NumberFormatException{

		ArrayList text = new ArrayList();

		double[] arr;

		if(code == INPUT) {
			arr = convertArrayToDouble(data);
		}

		else {

			///////////////

			int range = Integer.parseInt(data[0]);

			///////////////

			int size = Integer.parseInt(data[1]);

			/////////////////
			int form;

			if(data[2].equals("Ordered")){
				form =  1;

			}
			else if(data[2].equals("Ordered backwards")) {
				form =  2;

			}
			else if(data[2].equals("Random")) {
				form =  3;

			}
			else {
				form =  4;

			}

			//////////////////

			boolean dif;
			if(data[3].equals("true"))
				dif = true;
			else
				dif = false;

			///////////////////

			int percentage = 0;
			if(!data[4].equals(""))
				percentage = Integer.parseInt(data[4]);

			//////////////////

			arr = generateArrayDouble(form, dif, size, range, percentage);

		}
		//Quick Sort
		double[] quick = arr.clone();
		long t1 = System.nanoTime();
		quickSortDouble(quick, 0, quick.length-1);
		long t2 = System.nanoTime();
		String rQuick = "It took "+(t2-t1)+" nanoseconds to Quick Sort";

		//Counting Sort
		double[] counting = new double[1];
		counting[0] = 0;
		String rCounting = "Couldn´t sort the array with Counting Sort";

		//Heap Sort
		double[] heap = arr.clone();
		t1 = System.nanoTime();
		heapSortDouble(heap);
		t2 = System.nanoTime();
		String rHeap = "It took "+(t2-t1)+" nanoseconds to Heap Sort";

		text.add("This is the array to sort:");
		text.add(arr);
		text.add(rQuick);
		text.add(quick);
		text.add(rCounting);
		text.add(counting);
		text.add(rHeap);
		text.add(heap);

		return text;
	}

	/**
	 * Generates an integer array according to the parameters
	 * @param form - the way the array is going to be created
	 * @param dif - if the  numbers can be repeated
	 * @param size - the size of the array
	 * @param range - the range of each number
	 * @param percentage - the percentage of order
	 * @return
	 */
	public int[] generateArray(int form, boolean dif, int size, int range, double percentage) {
		int[] array = new int[size];
		switch(form) {
		case 1:
			array = arraySorted(dif, size, range);
			break;
		case 2:
			array = arraySortReverse(dif, size, range);
			break;
		case 3:
			array = arrayRandom(dif, size, range);
			break;
		case 4:
			array = arrayPercentage(dif, size, range, percentage);
		}

		return array;

	}

	/**
	 * Generates a double array according to the parameters
	 * @param form - the way the array is going to be created
	 * @param dif - if the  numbers can be repeated
	 * @param size - the size of the array
	 * @param range - the range of each number
	 * @param percentage - the percentage of order
	 * @return
	 */
	public double[] generateArrayDouble(int form, boolean dif, int size, int range, double percentage) {
		double[] array = new double[size];
		switch(form) {
		case 1:
			array = arraySortedDouble(dif, size, range);
			break;
		case 2:
			array = arraySortReverseDouble(dif, size, range);
			break;
		case 3:
			array = arrayRandomDouble(dif, size, range);
			break;
		case 4:
			array = arrayPercentageDouble(dif, size, range, percentage);
		}

		return array;

	}

	/**
	 * Generates a random integer array with no specific order
	 * @param dif - if the numbers can be repeated 
	 * @param size - the size of the array
	 * @param range - the range of each number
	 * @return - the integer array according to the parameters
	 */
	public int[] arrayRandom(boolean dif, int size, int range) {
		int[] array = new int[size];
		Random rnd = new Random();
		if(!dif) {
			array[0] = rnd.nextInt(range);
			for (int i = 1; i < array.length; i++) {
				array[i] =  rnd.nextInt(range);
				for (int j = 0; j < i; j++) {
					if(array[i] == array[j]) {
						i--;
					}
				}
			}
		}
		else {
			for (int i = 0; i < array.length; i++) {
				array[i] =  rnd.nextInt(range);
			}
		}
		return array;
	}

	/**
	 * Replaces "," char with "." on the string given.
	 * @param s - the string to replace
	 * @return - the string with char replaced 
	 */
	public String replace(String s) {
		return s.replace(",", ".");
	}

	/**
	 * Generates a random double array with no specific order
	 * @param dif - if the numbers can be repeated 
	 * @param size - the size of the array
	 * @param range - the range of each number
	 * @return - the double array according to the parameters
	 */
	public double[] arrayRandomDouble(boolean dif, int size, int range) {
		double[] array = new double[size];
		Random rnd = new Random();
		DecimalFormat df = new DecimalFormat("#.##");
		if(!dif) {
			array[0] = Double.valueOf(replace(df.format(range * rnd.nextDouble())));
			for (int i = 1; i < array.length; i++) {
				array[i] = Double.valueOf(replace(df.format(range * rnd.nextDouble())));

				for (int j = 0; j < i; j++) {
					if(array[i] == array[j]) {
						i--;
					}
				}
			}
		}
		else {
			for (int i = 0; i < array.length; i++) {
				array[i] =  Double.valueOf(replace(df.format(range * rnd.nextDouble())));
			}
		}
		return array;
	}

	/**
	 * Generates a random ordered array
	 * @param dif - if the numbers can be repeated 
	 * @param size - the size of the array
	 * @param range - the range of each number
	 * @return - the integer array according to the parameters
	 */
	public int[] arraySorted(boolean dif, int size, int range) {
		int[] array = arrayRandom(dif, size, range);
		Arrays.sort(array);
		return array;

	}

	/**
	 * Generates a random ordered array.
	 * @param dif - if the numbers can be repeated 
	 * @param size - the size of the array
	 * @param range - the range of each number
	 * @return - the double array according to the parameters
	 */
	public double[] arraySortedDouble(boolean dif, int size, int range) {
		double[] array = arrayRandomDouble(dif, size, range);
		Arrays.sort(array);
		return array;

	}

	/**
	 * Generates a random sorted backwards integer array.
	 * @param dif - if the numbers can be repeated 
	 * @param size - the size of the array
	 * @param range - the range of each number
	 * @return - the integer array according to the parameters
	 */
	public int[] arraySortReverse(boolean dif, int size, int range) {
		int[] array = arrayRandom(dif, size, range);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] >= array[j]) {
					int x = array[i];
					array[i] = array[j];
					array[j] = x;
				}
			}
		}
		return array;
	}
	
	/**
	 * Generates a random sorted backwards double array.
	 * @param dif - if the numbers can be repeated 
	 * @param size - the size of the array
	 * @param range - the range of each number
	 * @return - the double array according to the parameters
	 */
	public double[] arraySortReverseDouble(boolean dif, int size, int range) {
		double[] array = arrayRandomDouble(dif, size, range);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] >= array[j]) {
					double x = array[i];
					array[i] = array[j];
					array[j] = x;
				}
			}
		}
		return array;
	}
	
	/**
	 * Generates a random integer array partially sorted.
	 * @param dif - if the numbers can be repeated 
	 * @param size - the size of the array
	 * @param range - the range of each number
	 * @param percentage - the percentage to be ordered
	 * @return - the integer array according to the parameters
	 */
	public int[] arrayPercentage(boolean dif, int size, int range, double percentage) {

		int[] array = arraySorted(dif,size,range);

		Random rnd = new Random();
		int k = (int) (array.length * percentage);
		int contador = 0; 
		while(contador < k){
			int pos1 = rnd.nextInt(size);
			int pos2 = rnd.nextInt(size);
			if(pos1 != pos2) {
				int aux = array[pos2];
				array[pos2] = array[pos1];
				array[pos1] = aux;
				contador++;
			}
		}

		return array;
	}
	
	/**
	 * Generates a random double array partially sorted.
	 * @param dif - if the numbers can be repeated 
	 * @param size - the size of the array
	 * @param range - the range of each number
	 * @param percentage - the percentage to be ordered
	 * @return - the double array according to the parameters
	 */
	public double[] arrayPercentageDouble(boolean dif, int size, int range, double percentage) {

		double[] array = arraySortedDouble(dif,size,range);

		int k = (int) (array.length * (percentage/100));
		System.out.println(k);
		int contador = 0; 
		while(contador < k){
			int pos1 = 0;
			int pos2 = array.length-1;
			if(pos1 != pos2) {
				double aux = array[pos2];
				array[pos2] = array[pos1];
				array[pos1] = aux;
				contador++;
				pos2--;
				pos1++;
			}
		}

		return array;
	}

	///////////////////////// SORTING METHODS BEGIN ////////////////////////////////////////

	/**
	 * Counting sort integer implementation
	 * @param array - the integer array to sort
	 * @return - the integer array sorted
	 */
	public int[] countingSort(int[] array) {    
		int[] aux = new int[array.length];

		int min = array[0];
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			} else if (array[i] > max) {
				max = array[i];
			}
		}
		int[] counts = new int[max - min + 1];

		for (int i = 0;  i < array.length; i++) {
			counts[array[i] - min]++;
		}

		counts[0]--;
		for (int i = 1; i < counts.length; i++) {
			counts[i] = counts[i] + counts[i-1];
		}
		for (int i = array.length - 1; i >= 0; i--) {
			aux[counts[array[i] - min]--] = array[i];
		}

		return aux;
	}

	//////////////////////////////////// HEAP //////////////////////////////////////////

	/**
	 * Heap sort integer implementation
	 * @param array - the integer array to sort
	 * @return - the integer array sorted
	 */
	public void heapSort(int arr[]) {

		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			auxHeap(arr, n, i);

		// One by one extract an element from heap
		for (int i=n-1; i>=0; i--){
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			auxHeap(arr, i, 0);
		}
	}

	/**
	 * Heapifys a subtree rooted with node i 
	 * @param arr
	 * @param n - is size of heap
	 * @param i - is an index in arr[]
	 */
	public void auxHeap(int arr[], int n, int i) {
		int largest = i;  // Initialize largest as root
		int l = 2*i + 1;  // left = 2*i + 1
		int r = 2*i + 2;  // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i){
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			auxHeap(arr, n, largest);
		}
	}
	
	/**
	 * Heap sort double implementation
	 * @param array - the double array to sort
	 * @return - the double array sorted
	 */
	public void heapSortDouble(double arr[]) {

		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			auxHeapDouble(arr, n, i);

		// One by one extract an element from heap
		for (int i=n-1; i>=0; i--)
		{
			// Move current root to end
			double temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			auxHeapDouble(arr, i, 0);
		}
	}

	/**
	 * Heapifys a subtree rooted with node i 
	 * @param arr
	 * @param n - is size of heap
	 * @param i - is an index in arr[]
	 */
	public void auxHeapDouble(double arr[], int n, int i) {
		int largest = i;  // Initialize largest as root
		int l = 2*i + 1;  // left = 2*i + 1
		int r = 2*i + 2;  // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i){
			double swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			auxHeapDouble(arr, n, largest);
		}
	}
	
	//////////////////////////////////////// QUICK SORT /////////////////////////////////////////////////////////////

	/**
	 * Divides the integer array
	 * @param arr array to be divided
	 * @param left - first position
	 * @param right - last position
	 * @return - the position of the new half
	 */
	public int partition(int arr[], int left, int right){

		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];

		while (i <= j) {
			while (arr[i] < pivot)
				i++;

			while (arr[j] > pivot)
				j--;

			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}

	/**
	 * Quicksort implementation for integer array 
	 * @param arr - the array to be sorted
	 * @param left - the first position
	 * @param right - the last position
	 */
	public void quickSort(int arr[], int left, int right) {

		int index = partition(arr, left, right);

		if (left < index - 1)
			quickSort(arr, left, index - 1);
		if (index < right)
			quickSort(arr, index, right);

	}

	/**
	 * Divides the double array
	 * @param arr array to be divided
	 * @param left - first position
	 * @param right - last position
	 * @return - the position of the new half
	 */
	public int partitionDouble(double arr[], int left, int right){

		int i = left, j = right;
		double tmp;
		double pivot = arr[(left + right) / 2];

		while (i <= j) {
			while (arr[i] < pivot)
				i++;

			while (arr[j] > pivot)
				j--;

			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}
	
	/**
	 * Quicksort implementation for double array 
	 * @param arr - the array to be sorted
	 * @param left - the first position
	 * @param right - the last position
	 */
	public void quickSortDouble(double arr[], int left, int right) {

		int index = partitionDouble(arr, left, right);

		if (left < index - 1)
			quickSortDouble(arr, left, index - 1);
		if (index < right)
			quickSortDouble(arr, index, right);

	}
}
