package com.tolgaze.hackerrank.sorting.fradulentactivitynotifications;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

	// Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) throws IOException {
        int[] medianArray = new int[d];
        int[] counts = new int[200];
        double medianValue = 0;
        int notificationCount = 0;

        for (int i=0; i<d ; i++){
            counts[expenditure[i]]++;
        }

        for (int i = d; i < expenditure.length; i++) {
            medianValue = findMedian(expenditure,counts, i-d, i, d);

            if(expenditure[i] >= medianValue*2) {
                notificationCount++;
            }
        }

        System.out.print(notificationCount);
        return notificationCount;

    }
    
    public static double findMedian(int[] expenditure, int[] counts, int removeIndex, int addIndex, int d){
        double median = 0;
        double median1 = 0;
        double median2 = 0;
        int sum = 0;

        for (int i=0; i<counts.length; i++){
            sum += counts[i];
            if(d % 2 == 0){
                if(sum == d/2){
                    median1 = i;
                }
                else if (median1 == 0 && sum >= d/2+1){
                    median = i;
                    break;
                }
                else if (median1 != 0 && sum >= d/2+1){
                    median2 = i;
                    median = (median1 + median2) / 2;
                    break;
                }
            }
            else{
                if(sum > d/2){
                    median = i;
                    break;
                }
            }

        }

        //Edit counts
        counts[expenditure[removeIndex]]--;
        counts[expenditure[addIndex]]++;

        return median;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\DEVEL\\Workspaces\\java\\hackerrank-sorting-fradulentactivitynotifications\\files/output.txt"));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}













