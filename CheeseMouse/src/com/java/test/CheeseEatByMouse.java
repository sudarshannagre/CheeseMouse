package com.java.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CheeseEatByMouse {

	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    int noOfTestCases=scanner.nextInt();//size of testCases
	    Integer[] inputArray =null;
	    
	    Map<Integer, Integer[]> collectionOfInputArray =new LinkedHashMap<Integer, Integer[]>();
	    
	    for(int i=0; i<noOfTestCases; i++) {
	    	Integer inputArraySize = (Integer)scanner.nextInt();
	    	inputArray = new Integer[inputArraySize];//size of array
	    	for(int j = 0; j<inputArraySize && scanner.hasNext(); j++) {
	    		inputArray[j]=scanner.nextInt();//actual elements of array
		    }
	    	collectionOfInputArray.put(inputArraySize, inputArray);
	    }
	    scanner.close();
	    System.out.println("o/p : ");
	    for(Integer i : collectionOfInputArray.keySet()) {
	    	System.out.println(maxEatenCheeseByMouse(i,collectionOfInputArray.get(i)));
	    }
	}

	/**
	 * 
	 * @param size
	 * @param inputArray
	 * @return actualEatenCheese
	 */
	public static int maxEatenCheeseByMouse(Integer size, Integer inputArray[]) {
		
		List<Integer> listOfCheese = Arrays.stream(inputArray).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		Integer actualEatenCheese=0;
		List<Integer> alreadyEaten = new ArrayList<>();
		
		for(int i=0; i<size; i++) {
			int eaten = listOfCheese.get(i);
			for(int j=0;j<size;j++) {
				if(inputArray[j]==eaten && !alreadyEaten.contains(j)) {
					actualEatenCheese += inputArray[j];
					alreadyEaten.add(j-1);
					alreadyEaten.add(j);
					alreadyEaten.add(j+1);
				}
			}
		}
		return actualEatenCheese;
	}
}
