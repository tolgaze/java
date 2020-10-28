package com.tolgaze.hackerrank.arrays.minimumswaps2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

	// Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        Integer count = 0;
        int i = 0;
        
        while(i < arr.length-1) {
            if(arr[i] != i+1) {
                int temp = arr[(arr[i]-1)];
                arr[(arr[i]-1)] = arr[i];
                arr[i] = temp; 
                count++;
            }
            else {
                i++;
            }
        }
        
        System.out.println(count);
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\DEVEL\\Workspaces\\java\\hackerrank-arrays-minimumswaps2\\files.output.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}













