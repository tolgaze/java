package com.tolgaze.hackerrank.arrays.newyearchaos;

import java.util.*;

public class Solution {

	// Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int bribe = 0;
        int expected = 1;
        int oneBribe = 2;
        int twoBribe = 3;
        boolean chaotic = false;
        
        for (int i = 0; i < q.length; i++) {
            if(q[i] == expected) {
                expected = oneBribe;
                oneBribe = twoBribe;
                twoBribe++;
            }
            else if (q[i] == oneBribe) {
                bribe++;
                oneBribe = twoBribe;
                twoBribe++;
            }
            else if (q[i] == twoBribe) {
                bribe += 2;
                twoBribe++;
            }
            else {
                chaotic = true;
                break;
            }
        }
        
        if(chaotic) {
            System.out.println("Too chaotic");
        }
        else {
            System.out.println(bribe);
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}













