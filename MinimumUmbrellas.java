/*
	Given an array which represents a list of umbrella capacity and each umbrella can be used indefinite times.
	Find the minimum (Y) number of umbrellas required to protect X number of people.

	Note: Function should return '-1' if people covered in a possible particular set are less than or greater than X.  

	Array: [6,2,5,4,1]
	X:8
	Y:2 -- (2,6)

	X:9
	Y:2 -- (5,4)
	
	X:14
	Y:3 -- (6,6,2)
*/


public class MinimumUmbrellas {
	public static void main(String args[]){
		int[] umbrellaCapactiy = new int[]{6,2,5,4,1};;
		int numberOfPeople = 13;
		int miniumUmbrellasRequired = -1;
		for(int j=0;j<umbrellaCapactiy.length;j++){
			int umbrellasUsed = 0;
			int remainingCapacity = numberOfPeople;
			
			boolean allPeopleCovered = false;
			boolean peopleExceeded = false;
			
			remainingCapacity = remainingCapacity-umbrellaCapactiy[j];
			umbrellasUsed++;
			
			umbrellasUsed = FindNearestNumber(remainingCapacity, umbrellaCapactiy, umbrellasUsed, allPeopleCovered, peopleExceeded);
			
			if(miniumUmbrellasRequired == -1 || (umbrellasUsed!=-1 && umbrellasUsed<miniumUmbrellasRequired)){
				miniumUmbrellasRequired = umbrellasUsed;
			}
		}
		 
		 System.out.println("Minimum number of Umbrellas required to cover "+ numberOfPeople + " People: " + miniumUmbrellasRequired);
	}
	
	public static int FindNearestNumber(int remainingCapacity, int[] umbrellaCapactiy, int umbrellasUsed, boolean allPeopleCovered, boolean peopleExceeded){
		if(remainingCapacity==0){
			allPeopleCovered = true;
		}
		else if(remainingCapacity<0){
			peopleExceeded = true;
			 umbrellasUsed = -1;
		}
		
		if((!allPeopleCovered && !peopleExceeded)){
			umbrellasUsed++;
			int nearestNumber = umbrellaCapactiy[0];
			int minimumDifference = remainingCapacity - umbrellaCapactiy[0];
			for(int i=1;i<umbrellaCapactiy.length;i++){
				int currentDifference = remainingCapacity - umbrellaCapactiy[i];
				if(minimumDifference<0 || (currentDifference>=0 && currentDifference<minimumDifference)){
					minimumDifference = currentDifference;
					nearestNumber = umbrellaCapactiy[i];
				}
			}
			remainingCapacity = remainingCapacity-nearestNumber;
			umbrellasUsed = FindNearestNumber(remainingCapacity, umbrellaCapactiy, umbrellasUsed, allPeopleCovered, peopleExceeded);
		}
		return umbrellasUsed;
	}
}