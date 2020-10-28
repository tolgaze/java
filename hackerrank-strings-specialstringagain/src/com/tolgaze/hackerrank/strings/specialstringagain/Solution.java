package com.tolgaze.hackerrank.strings.specialstringagain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

	// Complete the substrCount function below.
	static long substrCount(int n, String s) {
	    long count = n;
	    long conse = 1;
	    char prevChar= s.charAt(0);
	
	    for(int i=1; i<s.length(); i++) {
	        if(prevChar == s.charAt(i)){
	            conse++;
	            count+= conse-1;
	        }
	        else if(i < s.length()-1){
	            for(int j=0; j<conse; j++){
	                if(i+1+j <s.length() && s.charAt(i-1-j) == s.charAt(i+1+j)){
	                    count++;
	                }
	                else{
	                    break;
	                }
	            }
	            conse=1;
	            prevChar = s.charAt(i);
	        }
	    }
	
	    System.out.println(count);
	    return count;
	}

	static boolean checkRules(String s){
	    int startIndex = 0;
	    int stopIndex = s.length()-1;
	    char first = s.charAt(0);
	
	    while (stopIndex>startIndex){
	        if(s.charAt(startIndex) != first || s.charAt(stopIndex) != first){
	            return false;
	        }
	        stopIndex--;
	        startIndex++;
	    }
	    return true;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\DEVEL\\Workspaces\\java\\hackerrank-strings-specialstringagain\\files/output.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}













