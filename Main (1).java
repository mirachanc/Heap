package MinHeap;
import java.util.Scanner;

public class Main {

	static int arraySize = 0;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Enter numbers: ");
		
		String numberText = scanner.nextLine();
		
		String[] arrOfStr = numberText.split(",");
		int[] arrOfNumbers = new int[arrOfStr.length];
		arraySize = arrOfStr.length;

		for(int i=0; i<arrOfStr.length; i++) {
			arrOfNumbers[i] = Integer.parseInt(arrOfStr[i]);
		}
	
		int index = 0;
        if (checkMinHeap(arrOfNumbers, index)) {
            System.out.println("Array is a min-heap");
        }
        else {
            System.out.println("Array is not a min-heap");
        }
        
        

        for (int i = arraySize; i >= 0; i--) { 
    		heapify(arrOfNumbers, i); 
    	} 
   
        for (int i = 0; i <arrOfNumbers.length; i++) { 
        	System.out.print(arrOfNumbers[i]);
    	}
        
        
	}
	
	
	
	static boolean checkMinHeap(int[] numbers, int i)
    {
        if (2*i + 2 > numbers.length) {
            return true;
        }
        boolean left = (numbers[i] <= numbers[2*i + 1]) && checkMinHeap(numbers, 2*i + 1);

        boolean right = (2*i + 2 == numbers.length) || (numbers[i] <= numbers[2*i + 2] && checkMinHeap(numbers, 2*i + 2));
 
        return left && right;
    }
	
	static void heapify(int arr[], int i) 
	{ 
		int smallest = i;
		int l = 2 * i + 1; 
		int r = 2 * i + 2;

		
		if (l < arraySize && arr[l] < arr[smallest]) 
			smallest = l; 

		
		if (r < arraySize && arr[r] < arr[smallest]) 
			smallest = r; 

		
		if (smallest != i) {
			int keep = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = keep;

			heapify(arr, smallest); 
		} 
	} 
	
	
}
