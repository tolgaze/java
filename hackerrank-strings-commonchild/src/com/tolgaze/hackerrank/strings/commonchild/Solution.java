package com.tolgaze.hackerrank.strings.commonchild;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        int[][] matrix = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    matrix[i+1][j+1] = matrix[i][j] + 1;
                } else {
                    matrix[i+1][j+1] = Math.max(matrix[i+1][j], matrix[i][j+1]);
                }
            }
        }

        System.out.println(matrix[s1.length()][s2.length()]);
        return matrix[s1.length()][s2.length()];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\DEVEL\\Workspaces\\java\\hackerrank-strings-commonchild\\files/output.txt"));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}













