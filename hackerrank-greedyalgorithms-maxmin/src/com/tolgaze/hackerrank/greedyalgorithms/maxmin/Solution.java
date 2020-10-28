package com.tolgaze.hackerrank.greedyalgorithms.maxmin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
        Integer minDiff = Integer.MAX_VALUE;

        Arrays.sort(arr);
        for (int i = 0; i < arr.length-k+1; i++) {
            if(arr[i+k-1] - arr[i] < minDiff){
                minDiff = arr[i+k-1] - arr[i];
            }
        }

        System.out.println(minDiff);
        return minDiff;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\DEVEL\\Workspaces\\java\\hackerrank-greedyalgorithms-maxmin\\files/output.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}













