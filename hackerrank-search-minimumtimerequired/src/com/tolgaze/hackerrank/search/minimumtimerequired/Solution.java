package com.tolgaze.hackerrank.search.minimumtimerequired;

import java.io.*;
import java.util.*;

public class Solution {
	
    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) { 	
        long slowestMachineDayCount = Arrays.stream(machines).max().getAsLong();
        long maxDaysNeeded = (long) Math.ceil( goal * slowestMachineDayCount / machines.length);
        long result = findRequiredDays(machines, goal, 1, maxDaysNeeded);
        System.out.println(result);
        return result;

    }
    
    static long findRequiredDays(long[] machines, long goal, long startDay, long endDay) {
        long middleDay = (endDay + startDay) / 2;
        long totalProduced = 0;
        
        totalProduced = Arrays.stream(machines).map(item -> middleDay / item).sum();
        if(totalProduced < goal) {
            return findRequiredDays(machines, goal, middleDay+1, endDay);
        }
        else {
        	if(startDay == middleDay) {
        		return middleDay;
        	}
        	else {
        		return findRequiredDays(machines, goal, startDay, middleDay);
        	}
        }
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\DEVEL\\Workspaces\\java\\hackerrank-search-minimumtimerequired/output.txt"));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
