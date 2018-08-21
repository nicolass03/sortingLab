package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sorting {

	public Sorting(){

	}

	public float[] convertArray(String[] a) {
		float[] newArray = new float[a.length];

		try {
			for (int i = 0; i < newArray.length; i++) {
				newArray[i] = Float.parseFloat(a[i]);
			}
		}
		catch(Exception e) {
			System.out.println("Failed to sort the numbers");
		}

		return newArray;
	}

	public void sort(String[] data, int code) {
		switch(code) {
		case 1:
			float[] numbers = convertArray(data);
			break;

		case 2:

			break;
		}

	}

	public int[] generateArrayInteger(int form, boolean dif, int size, int range, double percentage) {
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

	public int[] arrayRandom(boolean dif, int size, int range) {
		int[] array = new int[size];
		Random rnd = new Random();
		if(dif) {
			array[0] = rnd.nextInt(range);
			for (int i = 1; i < array.length; i++) {
				array[i] =  rnd.nextInt(range);
				for (int j = 0; j < i; j++) {
					if(array[i] == array[j]) {
						i--;
					}
				}
			}
		}else {
			for (int i = 0; i < array.length; i++) {
				array[i] =  rnd.nextInt(range);
			}
		}
		return array;
	}

	public int[] arraySorted(boolean dif, int size, int range) {
		int[] array = arrayRandom(dif, size, range);
		Arrays.sort(array);
		return array;

	}




	public int[] arraySortReverse(boolean dif, int size, int range) {
		int[] array = arraySorted(dif, size, range);

		return array;
	}

	public int[] arrayPercentage(boolean dif, int size, int range, double percentage) {
		int[] array = new int[size];
		Random rnd = new Random();
		if(dif) {
			array[0] = rnd.nextInt(range);
			for (int i = 1; i < array.length; i++) {
				array[i] =  rnd.nextInt(range);
				for (int j = 0; j < i; j++) {
					if(array[i] == array[j]) {
						i--;
					}
				}
			}
		}else {
			for (int i = 0; i < array.length; i++) {
				array[i] =  rnd.nextInt(range);
			}
		}
		array = selectionSort(array);

		int k = (int) (array.length * percentage);
		int contador = 0; 
		while(contador < k){
			int pos1 = rnd.nextInt(range);
			int pos2 = rnd.nextInt(range);
			if(pos1 != pos2) {
				int aux = array[pos2];
				array[pos1] = array[pos2];
				array[pos2] = aux;
				contador++;
			}
		}

		return array;
	}


	public static int[] selectionSortReverse(int[] arr){
		for (int i = 0; i < arr.length - 1; i++)
		{
			int index = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] > arr[index]) 
					index = j;

			int smallerNumber = arr[index];  
			arr[index] = arr[i];
			arr[i] = smallerNumber;
		}
		return arr;
	}

	public static int[] selectionSort(int[] arr){
		for (int i = 0; i < arr.length - 1; i++)
		{
			int index = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] < arr[index]) 
					index = j;

			int smallerNumber = arr[index];  
			arr[index] = arr[i];
			arr[i] = smallerNumber;
		}
		return arr;
	}

	///////////////////////// SORTING METHODS BEGIN ////////////////////////////////////////

	public static int[] countingSort(int[] array) {    
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

	public void heapSort(int arr[]) {
		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		// One by one extract an element from heap
		for (int i=n-1; i>=0; i--)
		{
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	public void heapify(int arr[], int n, int i) {
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
		if (largest != i)
		{
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}

	/////////////////////////////// RADIX ////////////////////////////////
	
	public int getMax(int arr[], int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	public void countSort(int arr[], int n, int exp) {
		int output[] = new int[n]; // output array
		int i;
		int count[] = new int[10];
		Arrays.fill(count,0);

		// Store count of occurrences in count[]
		for (i = 0; i < n; i++)
			count[ (arr[i]/exp)%10 ]++;

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		// Build the output array
		for (i = n - 1; i >= 0; i--)
		{
			output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
			count[ (arr[i]/exp)%10 ]--;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to curent digit
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}

	// The main function to that sorts arr[] of size n using
	// Radix Sort
	public void radixSort(int arr[], int n) {
		// Find the maximum number to know number of digits
		int m = getMax(arr, n);

		// Do counting sort for every digit. Note that instead
		// of passing digit number, exp is passed. exp is 10^i
		// where i is current digit number
		for (int exp = 1; m/exp > 0; exp *= 10)
			countSort(arr, n, exp);
	}


	//Added by Nicolas

	public List<Integer> randomArray(boolean dif, int size, int range) {
		List<Integer> array = new ArrayList<Integer>();
		Random rnd = new Random();
		if(dif) {
			array.add(rnd.nextInt(range));
			for (int i = 1; i < size; i++) {
				array.add(rnd.nextInt(range));
				for (int j = 0; j < i; j++) {
					if(array.get(i) == array.get(j)) {
						i--;
					}
				}
			}
		}else {
			for (int i = 0; i < array.size(); i++) {
				array.add(rnd.nextInt(range));;
			}
		}
		return array;
	}

	public int[] randomArraySorted(boolean dif, int size, int range) {
		List<Integer> array = randomArray(dif, size, range);
		Collections.sort(array);
		return listToArray(array);
	}


	public int[] randomArrayReverseSort(boolean dif, int size, int range) {
		List<Integer> array = randomArray(dif, size, range);
		Collections.sort(array, Collections.reverseOrder());
		return listToArray(array);
	}

	public int[] randomArrayPercentage(boolean dif, int size, int range, double percentage) {

		List<Integer> list = randomArray(dif, size, range);
		Collections.sort(list);
		int[] array = listToArray(list);

		int k = (int) (array.length * percentage);
		int contador = 0; 
		Random rnd = new Random();

		while(contador < k){
			int pos1 = rnd.nextInt(range);
			int pos2 = rnd.nextInt(range);
			if(pos1 != pos2) {
				int aux = array[pos2];
				array[pos1] = array[pos2];
				array[pos2] = aux;
				contador++;
			}
		}

		return array;
	}


	public static int[] listToArray(List<Integer> list) {
		return list.stream().mapToInt(i -> i).toArray();
	}
}
