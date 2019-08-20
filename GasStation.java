/* 
 	Url: https://leetcode.com/problems/gas-station/
 	
	There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
	You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
	Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
	
	Input: 
	gas  = [1,2,3,4,5]
	cost = [3,4,5,1,2]
	
	Output: 3
	
	Input: 
	gas  = [2,3,4]
	cost = [3,4,3]
	
	Output: -1
*/
public class GasStation {
	public static void main(String args[]){
		int[] gas = new int[]{1,2,3,4,5};
		int[] cost = new int[]{3,4,5,1,2};
		int outputIndex = -1;
		
		for(int startIndex=0;startIndex<gas.length;startIndex++){
			int currentIndex = startIndex;
			int gasFilled = gas[startIndex];
			boolean circuitComplete = true;
			do{
				if(gasFilled<cost[currentIndex]){
					circuitComplete = false;
					break;
				}
				int nextIndex = currentIndex==gas.length-1 ? 0: currentIndex+1;
				int nextFillup = gas[nextIndex];
				gasFilled = gasFilled - cost[currentIndex] + nextFillup;
				currentIndex=nextIndex;
			}while(currentIndex!=startIndex);
			
			if(circuitComplete){
				outputIndex = startIndex;
				break;
			}
		}
		System.out.println("Starting gas station's index if travel around the circuit completes : " + outputIndex);
	}
}
