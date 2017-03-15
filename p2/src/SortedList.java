import java.util.Random;
import java.util.Scanner;

class SortedList 
{
	private int array[]; 
	private int n;
	
	public SortedList() {
		// traditional constructor w/ no arguments
		n = 10;                        
		array = new int[n];
		Random rand = new Random();
    		
		for (int z = 0; z < n; z++) {           // initialize array with random numbers
			array[z] = rand.nextInt(500) + 1;
		} 
		quicksort(array,0,n-1);                 // sort the array
	}
	public SortedList(int[] arr, int size) {
		                                        // constructor with initialized arguments
		array = new int[size];                  // make array with argument (size)
		for(int x = 0; x < size; x++) {         // copy elements from argument (arr) to array
			array[x] = arr[x];
		}
		n = size;								// make n = argument (size) 
		quicksort(array,0,n-1);					// sort the array
	}
	public void print()
	{
		// function used for printing arrays
		for(int i = 0; i < n; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	public void addInt(int val) {
		// create new array with size plus 1
		int temp[] = new int[n+1];
		// copy all items from old array to temp and the new value
		for(int i = 0; i < n+1; i++) {
			if(i == n) {
				temp[i] = val;
				break;
			}
			temp[i] = array[i];
		}
		// increment size
		n = n + 1;
		// reinitialize array with new size
		array = new int[n];
		// copy values from temp back to array
		for(int i = 0; i < n; i++) {
			array[i] = temp[i];
		}
		// quick sort 
		quicksort(array,0,n-1);
	}
	public int partition(int[] arr, int p, int r)
	{
		int pivot = arr[r];
		while (p<r)
		{
			while(arr[p] < pivot)
				p++;
			while(arr[r] > pivot)
				r--;
			if(arr[p] == arr[r])
				p++;
			else if( p < r)
			{
				int temp = arr[p];
				arr[p] = arr[r];
				arr[r] = temp;
			}
		}
		return r;
	}
	public void quicksort(int[] arr, int p, int r)
	{
		if(p < r)
		{
			int j = partition(arr,p,r);
			quicksort(arr,p, j-1);
			quicksort(arr, j+1, r);
		}
	}
	
	public int binsearch(int search){
		int first, last, middle;
		first  = 0;
		last   = n - 1;
		middle = (first + last)/2;
		
		while( first <= last )
		{
			if ( array[middle] < search )
				first = middle + 1;    
			else if ( array[middle] == search ) 
			{	
				//System.out.println(search + " found at location " + (middle + 1) + ".");
				return middle+1; //+1 for the non-CS people who don't start counting at zero.	
			}	
			else
				last = middle - 1;
			middle = (first + last)/2;
		}
		return -1;
		//System.out.println(search + " is not present in the list.\n");	  
	}	
	public static void main(String args[])
	{
		int size = 15;
		int mainArr[] = new int[size];              // array to be initialized
		int value;                                // value user wants to search for
		int spot;                                 // index of where value is found
		Scanner in = new Scanner(System.in);   
		Random rand = new Random();               // random number generator
		
		// initialize array for the 2nd array
		for (int z = 0; z < size; z++) {
			mainArr[z] = rand.nextInt(500) + 1;
		}
		
		// create 1st list object 
		SortedList list = new SortedList();
		System.out.println("list with default constructor"+"...");
		list.print();
		System.out.println();
		
		// create 2nd list object WITH initialized array and size
		SortedList list2 = new SortedList(mainArr, size);
		System.out.println("list2 with arguements"+"...");
		list2.print();
		System.out.println();
		
		// get user input
	    System.out.println("Value to add to lists: ");
	    value = in.nextInt();
	    in.close();
	    
	    System.out.println();
	    
	    // add a integer to both lists
	    list.addInt(value);
		list2.addInt(value);
		
		// print lists to see results
		System.out.println("list after adding "+ value+"...");
		list.print();
		System.out.println();
		System.out.println("list2 after adding "+ value+"...");
		list2.print();
		
		System.out.println();
		System.out.println("Searching for the value "+ value+"...");
		System.out.println();
		
		spot = list.binsearch(value);
		System.out.println("In list, it's at spot " +spot);
		
		spot = list2.binsearch(value);
		System.out.println("In list2, it's at spot " +spot);   
	}
}
