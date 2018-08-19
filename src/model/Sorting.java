package model;

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
	
}
