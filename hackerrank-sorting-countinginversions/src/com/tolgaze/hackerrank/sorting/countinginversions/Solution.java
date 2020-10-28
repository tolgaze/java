package com.tolgaze.hackerrank.sorting.countinginversions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

    public static long count = 0;

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        count = 0;
        mergeSort(arr, 0, arr.length-1);

        System.out.println(count);
        return count;
    }

    private static void mergeSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }

        mergeSort(arr, start, (start+end)/2);
        mergeSort(arr, (start+end)/2+1, end);
        mergeHalves(arr, start, end);
    }

    private static void mergeHalves(int[] arr, int leftStart, int rightEnd){
        int middle = (leftStart + rightEnd) / 2;
        int leftIndex = leftStart;
        int rightIndex = middle+1;
        int tempIndex = 0;
        int[] tempArray = new int[rightEnd-leftStart+1];

        while(leftIndex <= middle && rightIndex <= rightEnd){
            if(arr[leftIndex] > arr[rightIndex]){
                tempArray[tempIndex] = arr[rightIndex];
                count += rightIndex-leftStart-tempIndex;
                rightIndex++;
            }
            else{
                tempArray[tempIndex] = arr[leftIndex];
                leftIndex++;
            }
            tempIndex++;
        }
        System.arraycopy(arr,leftIndex, tempArray, tempIndex, middle-leftIndex+1);
        System.arraycopy(arr,rightIndex, tempArray, tempIndex, rightEnd-rightIndex+1);
        System.arraycopy(tempArray,0, arr, leftStart, tempArray.length);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\DEVEL\\Workspaces\\java\\hackerrank-sorting-countinginversions\\files/output.txt"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}













