package com.tolgaze.hackerrank.search.triplesum;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
    	int aIndex = 0;
        int bIndex = 0;
        int cIndex = 0;
        long counter = 0;
        
    	Arrays.sort(a);
        a=Arrays.stream(a).distinct().toArray();
        Arrays.sort(b);
        b=Arrays.stream(b).distinct().toArray();
        Arrays.sort(c);
        c=Arrays.stream(c).distinct().toArray();

        while(bIndex < b.length){
            while(aIndex < a.length && a[aIndex] <= b[bIndex])
                aIndex++;

            while(cIndex < c.length && c[cIndex] <= b[bIndex])
                cIndex++;
						
            counter += ((long)aIndex) * ((long)cIndex);
            bIndex++;
        }
        
        System.out.println(counter);
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\DEVEL\\Workspaces\\java\\hackerrank-search-triplesum\\files/output.txt"));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
