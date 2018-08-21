package model;

public class Test {

	public static void main(String[] args) {
		Sorting s = new Sorting();
	
////////////////////////////////////////////////////////////////////////////
		long befor = System.nanoTime();
		int[] array2 = s.arraySorted(false, 10, 60);
		long after = System.nanoTime();
		
		System.out.println("Took "+(after-befor)+" create Santi array"+ "\n");

		for (int i = 0; i < array2.length; i++) {
			System.out.println(array2[i]);
		}
		System.out.println("\n");

		long bef2 = System.nanoTime();
		int[] counting = s.countingSort(array2);
		long af2 = System.nanoTime();

		System.out.println("It took "+(af2-bef2)+" nanoseconds to counting");
		
		for (int i = 0; i < counting.length; i++) {
			System.out.println(counting[i]);
		}
		
		System.out.println("\n");
		int[] cl = array2.clone();
		
		long bef3 = System.nanoTime();
		s.heapSort(cl);
		long af3 = System.nanoTime();

		System.out.println("It took "+(af3-bef3)+" nanoseconds to heap");
		for (int i = 0; i < cl.length; i++) {
			System.out.println(cl[i]);
		}
		
		System.out.println("\n");
		int[] cl2 = array2.clone();
		
		long bef4 = System.nanoTime();
		s.radixSort(cl2, cl2.length);
		long af4 = System.nanoTime();
		
		System.out.println("It took "+(af4-bef4)+" nanoseconds to RADIX");
		for (int i = 0; i < cl2.length; i++) {
			System.out.println(cl[i]);
		}

	}

}
