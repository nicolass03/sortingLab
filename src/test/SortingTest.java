package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

import model.Sorting;

class SortingTest {
	
	private Sorting sort;
	
	private void stage() {
		sort = new Sorting();
	}
	
	// Test counting sort
	@Test
	public void testCountingSort() {
		stage();
		// Array Random (Case Standard)
		int[] arrayInput = {20, 10, 15, 18, 19, 5, 1, 14, 16};
		int[] arrayOutput = {1, 5, 10, 14, 15, 16, 18, 19, 20};
		assertArrayEquals(arrayOutput, sort.countingSort(arrayInput));
		// Array ordered backwards (Case limit)
		int[] arrayInput2 = {30, 28, 21, 20, 15, 14, 11, 10, 9, 0};
		int[] arrayOutput2 = {0, 9, 10, 11, 14, 15, 20, 21, 28, 30};
		assertArrayEquals(arrayOutput2, sort.countingSort(arrayInput2));
		// Array big with cycle and conditional (Case interesting)
		int[] arrayInteresting = new int[30];
		Random rnd = new Random();
		arrayInteresting[0] = rnd.nextInt(50);
		for (int i = 1; i < arrayInteresting.length; i++) {
			arrayInteresting[i] =  rnd.nextInt(50);
			for (int j = 0; j < i; j++) {
				if(arrayInteresting[i] == arrayInteresting[j]) {
					i--;
				}
			}
		}
		int[] arrayInput3 = sort.countingSort(arrayInteresting);
		Arrays.sort(arrayInteresting);
		assertArrayEquals(arrayInteresting, arrayInput3);
		
	}
	
	
	// Test heap sort
	@Test
	public void testHeapSort() {
		stage();
		// Array Random (Case Standard)
		int[] arrayInput = {20, 10, 15, 18, 19, 5, 1, 14, 16};
		int[] arrayOutput = {1, 5, 10, 14, 15, 16, 18, 19, 20};
		sort.heapSort(arrayInput);
		assertArrayEquals(arrayOutput, arrayInput);
		// Array ordered backwards (Case limit)
		int[] arrayInput2 = {30, 28, 21, 20, 15, 14, 11, 10, 9, 0};
		int[] arrayOutput2 = {0, 9, 10, 11, 14, 15, 20, 21, 28, 30};
		sort.heapSort(arrayInput2);
		assertArrayEquals(arrayOutput2, arrayInput2);
		// Array big with cycle and conditional (Case interesting)
		int[] arrayInteresting = new int[30];
		Random rnd = new Random();
		arrayInteresting[0] = rnd.nextInt(50);
		for (int i = 1; i < arrayInteresting.length; i++) {
			arrayInteresting[i] =  rnd.nextInt(50);
			for (int j = 0; j < i; j++) {
				if(arrayInteresting[i] == arrayInteresting[j]) {
					i--;
				}
			}
		}
		sort.heapSort(arrayInteresting);
		int[] orderHeap = arrayInteresting;
		Arrays.sort(arrayInteresting);
		assertArrayEquals(arrayInteresting, orderHeap);
		
	}
	
	// test quick sort
	@Test
	public void testQuickSort() {
		stage();
		// Array Random (Case Standard)
		int[] arrayInput = {20, 10, 15, 18, 19, 5, 1, 14, 16};
		int[] arrayOutput = {1, 5, 10, 14, 15, 16, 18, 19, 20};
		sort.quickSort(arrayInput, 0, arrayInput.length-1);
		assertArrayEquals(arrayOutput, arrayInput);
		// Array ordered backwards (Case limit)
		int[] arrayInput2 = {30, 28, 21, 20, 15, 14, 11, 10, 9, 0};
		int[] arrayOutput2 = {0, 9, 10, 11, 14, 15, 20, 21, 28, 30};
		sort.quickSort(arrayInput2, 0, arrayInput2.length-1);
		assertArrayEquals(arrayOutput2, arrayInput2);
		// Array big with cycle and conditional (Case interesting)
		int[] arrayInteresting = new int[30];
		Random rnd = new Random();
		arrayInteresting[0] = rnd.nextInt(50);
		for (int i = 1; i < arrayInteresting.length; i++) {
			arrayInteresting[i] =  rnd.nextInt(50);
			for (int j = 0; j < i; j++) {
				if(arrayInteresting[i] == arrayInteresting[j]) {
					i--;
				}
			}
		}
		sort.quickSort(arrayInteresting,  0, arrayInteresting.length-1);
		int[] orderQuick = arrayInteresting;
		Arrays.sort(arrayInteresting);
		assertArrayEquals(arrayInteresting, orderQuick);
		
	}



}
