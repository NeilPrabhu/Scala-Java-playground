
public class p1_q1 {
	static int INPUT_SIZE = 10;
	public static void print(int[] arr)
	{
		for(int i = 0; i < INPUT_SIZE; i++)
		{
			System.out.print(arr[i]);
			System.out.print(" ");
		}
		System.out.println();
	}
	public static int partition(int[] arr, int p, int r)
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
	public static void quicksort(int[] arr, int p, int r)
	{
		if(p<r)
		{
			int j = partition(arr,p,r);
			quicksort(arr,p, j-1);
			quicksort(arr, j+1, r);
		}
	}
	public static void main(String args[])
	{
		int[] arr = {500, 700, 800, 100, 300, 200, 900, 400, 1000, 600};
		System.out.print("Input: ");
		print(arr);
		quicksort(arr,0,9);
		System.out.print("Output: ");
		print(arr);
	}
}
