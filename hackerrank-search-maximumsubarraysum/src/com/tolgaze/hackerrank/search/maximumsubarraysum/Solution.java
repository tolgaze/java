package com.tolgaze.hackerrank.search.maximumsubarraysum;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {
        long max = 0;
        TreeSet<Long> modulusTree = new TreeSet<Long>();
        long current = 0;

        for(int i=0;i<a.length;i++){
            current = (current + a[i] % m) % m;
            max = Math.max(max, current);

            Long higher = modulusTree.higher(current);
            if(higher != null){
                max = Math.max(max, (current - higher + m) % m);
            }
            modulusTree.add(current);
        }

        System.out.println(max);
        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\DEVEL\\Workspaces\\java\\hackerrank-search-maximumsubarraysum/output.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

