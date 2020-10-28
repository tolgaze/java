package com.tolgaze.hackerrank.hashmaps.counttriplets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Solution {

	// Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	HashMap<Long, Long> leftArray = new HashMap<Long, Long>();
        HashMap<Long, Long> rightArray = new HashMap<Long, Long>();
        long count=0;
        
        for (long val : arr) {
            if(rightArray.containsKey(val)) {
                Long valCount = rightArray.get(val);
                rightArray.put(val, valCount+1);
            }
            else {
                rightArray.put(val,1L);
            }
        }
        
        for (long val : arr) {
            long leftValCount = 0;
            long rightValCount = 0;
            long rightVal = val * r;
            long leftVal = 0;
            if (val % r == 0) {
              leftVal = val / r;
            }
            long valCount = rightArray.get(val);
            rightArray.put(val, valCount-1L);
            
            if(leftArray.containsKey(leftVal)) {
                leftValCount = leftArray.get(leftVal);
            }
            if(rightArray.containsKey(rightVal)) {
                rightValCount = rightArray.get(rightVal);
            }
            
            count += leftValCount*rightValCount;
            if(leftArray.containsKey(val)) {
                Long valCountLeft = leftArray.get(val);
                leftArray.put(val, valCountLeft+1);
            }
            else {
                leftArray.put(val,1L);
            }
        }
        System.out.println(count);
        return count;

    }

    public static void main(String[] args) throws IOException {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\DEVEL\\Workspaces\\java\\hackerrank-hashmaps-counttriplets\\files/output.txt"));
    	String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}













