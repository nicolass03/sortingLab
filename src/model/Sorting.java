package model;

import java.util.Arrays;
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
				array = arraySort(dif, size, range);
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
	
	public int[] arraySort(boolean dif, int size, int range) {
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
	
	public int[] arraySortReverse(boolean dif, int size, int range) {
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
		array = selectionSortReverse(array);
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
	
	public static int[] coutingSort(int[] array) {    
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
	
	 hola
}
