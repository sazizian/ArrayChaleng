package com.sasan.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ReadFromArray {
    private static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("please enter how many number you need: ");
        int numbers=scanner.nextInt();

        int[] myArray=readArray(numbers);
        int[] mySortArray=sortArray(Arrays.copyOf(myArray, myArray.length));
        System.out.println("The original item in array is:");
        printAray(myArray);
        System.out.println("The sorted item in array is: ");
        printAray(mySortArray);



    }

    private static void printAray(int[] mySortArray) {
        for(int num:mySortArray)
            System.out.println(num);
    }

    private static int[] sortArray(int[] myArray) {
       Arrays.sort(myArray);
        return myArray;
    }

    private static int[] readArray(int num){
        int[] myArray=new int[num];
        for(int i=0;i<myArray.length;++i){
            System.out.print("Plese enter the "+i+1 +"th number: ");
            myArray[i]=scanner.nextInt();
      //      System.out.println("\n");
        }
        return myArray;
    }
}
