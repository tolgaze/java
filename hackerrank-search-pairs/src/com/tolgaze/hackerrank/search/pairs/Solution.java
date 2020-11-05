package com.tolgaze.hackerrank.search.pairs;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
    	int pairCount = 0;
    	
    	Arrays.sort(arr);
    	for (int i = arr.length-1; i > 0; i--) {
    		int j = 1;
			while(i-j >= 0 && arr[i] - arr[i-j] <= k) {
				if(arr[i] - arr[i-j] == k) {
					pairCount++;
				}
				
				j++;
			}
		}
    	
    	System.out.println(pairCount);
    	return pairCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\DEVEL\\Workspaces\\java\\hackerrank-search-pairs\\files/output.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}















