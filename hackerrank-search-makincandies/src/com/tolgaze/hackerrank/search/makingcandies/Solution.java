package com.tolgaze.hackerrank.search.makingcandies;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the minimumPasses function below.
    static long minimumPasses(long m, long w, long p, long n) {
        Long minCost = Long.MAX_VALUE;
        Long candyCount = new Long(0);
        long passCount = 0;
        long produced = 0;

        while(true){
            passCount++;
            try{
                produced = Math.multiplyExact(m,w) ;
            }catch (ArithmeticException ar){
                minCost = passCount;
                break;
            }
            candyCount += produced;

            if(candyCount >= n){
                if(minCost > passCount)
                    minCost = passCount;
                break;
            }
            double remainingCost = Math.ceil((double) (n - candyCount) / (double) produced);
            long cost = passCount + (long) remainingCost;
            if(cost <= minCost){
                minCost = cost;
            }

            if(candyCount >= p){
                long spend = candyCount / p;
                long total = spend + m + w;
                if(w >= total/2){
                    m += spend;
                }
                else if(m >= total/2){
                    w += spend;
                }
                else{
                    if(m > w){
                        m += spend / 2;
                        w += spend - spend/2;
                        if(m > total/2 && m - w > 1){
                            long temp = m - total/2;
                            m -= temp;
                            w += temp;
                        }
                    }
                    else{
                        w += spend / 2;
                        m += spend - spend/2;
                        if(w > total/2 && w - m > 1){
                            long temp = w - total/2;
                            w -= temp;
                            m += temp;
                        }
                    }
                }
                candyCount %= p;
            }
            else{
                long passesNeeded =(long) Math.ceil( (double)(p - candyCount) / (double) produced) - 1;
                passCount += passesNeeded;
                candyCount += produced * passesNeeded;
            }
        }

        System.out.println(minCost);
        return minCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\DEVEL\\Workspaces\\java\\hackerrank-search-makincandies/output.txt"));

        String[] mwpn = scanner.nextLine().split(" ");

        long m = Long.parseLong(mwpn[0]);

        long w = Long.parseLong(mwpn[1]);

        long p = Long.parseLong(mwpn[2]);

        long n = Long.parseLong(mwpn[3]);

        long result = minimumPasses(m, w, p, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


