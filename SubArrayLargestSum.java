/*
	[0,5,6,1,8,4,9,3,5]
	
	Write an efficient program to find the sum of contiguous subarray of size N within a one-dimensional array of numbers which has the largest sum. 
	In the above case,
	if N = 3
	result: 21 -- [8,4,9]
 */
public class SubArrayLargestSum {
	public static void main(String args[]){
		int[] inputArray = new int[]{0,5,6,1,8,4,9,3,5}; 
		int n=3;
		int maxSum = 0;int sum = 0;
		for(int i=0;i<inputArray.length;i++){
			if(i<=n-1){
				sum+=inputArray[i];
				maxSum = sum;
			}else{
				sum-=inputArray[i-n];
				sum+=inputArray[i];
				if(sum>maxSum)
					maxSum = sum;
			}
		}
		System.out.println("Maximum sum of contiguous subarray: " + maxSum);
	}
}
