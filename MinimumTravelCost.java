/*
	[
	  [ 1 , 0 , 0 , 0 , 0 ],
	  [ 0 , 0 , 0 , 0 , 1 ],
	  [ 0 , 0 , 0 , 0 , 0 ],
	  [ 0 , 0 , 0 , 1 , 0 ]
	]
	
	1: Car
	0: Intersection point
	
	Find a intersection point such that that the TOTAL cost to travel at that point by all three cars will be minimum
	In the above case,
	Intersection point: [1,3]
	Cost: 7
 */

import java.util.ArrayList;
public class MinimumTravelCost {
	public static void main(String args[]){
		int[][] inputArray = new int[][]{
			{ 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 1, 0 }
		};
		
		ArrayList<String> allOnesPosition = new ArrayList<String>();
		ArrayList<String> allZerosPosition = new ArrayList<String>();
		int maxRowLength = inputArray.length;
		for (int i = 0; i < maxRowLength; i++) { 
			int columnLength = inputArray[i].length;
	        for(int j=0;j<columnLength;j++){
	        	if(inputArray[i][j] == 1){
	        		allOnesPosition.add(i+"-"+j);
	        	}else{
	        		allZerosPosition.add(i+"-"+j);
	        	}
	        }
	    }
		
		String intersectionPoint = "";
		int minimumTravelCost = Integer.MAX_VALUE;
		
		for(int i=0;i<allZerosPosition.size();i++){
			int currentZeroRowIndex = Integer.valueOf(allZerosPosition.get(i).split("-")[0]);
			int currentZeroColumnIndex = Integer.valueOf(allZerosPosition.get(i).split("-")[1]);
			int travelCost = CalculateTravelCost(allOnesPosition, currentZeroRowIndex, currentZeroColumnIndex);
			
			if(travelCost<minimumTravelCost){
				minimumTravelCost = travelCost;
				intersectionPoint = allZerosPosition.get(i);
			}
				
		}
		
		System.out.println("Intersection point with minimum travel cost: " + intersectionPoint);
	}
	
	public static int CalculateTravelCost(ArrayList<String> allOnesPosition, int currentRowIndex, int currentColumnIndex){
		int travelCost = 0;
		for(int i=0;i<allOnesPosition.size();i++){
			int currentOneRowIndex = Integer.valueOf(allOnesPosition.get(i).split("-")[0]);
			int currentOneColumnIndex = Integer.valueOf(allOnesPosition.get(i).split("-")[1]);
			
			travelCost+= Math.abs(currentRowIndex-currentOneRowIndex)+ Math.abs(currentColumnIndex-currentOneColumnIndex);
		}
		return travelCost;
	}
}
