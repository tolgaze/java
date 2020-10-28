package com.tolgaze.hackerrank.strings.sherlockandthevalidstring;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        HashMap<Character, Long> hashMap = new HashMap<>();
        HashMap<Long, Integer> refHashMap = new HashMap<>();
        long prevValue = 0;
        int index=0;

        int counter =0;
        long ref=0;


        for (int i=0; i<s.length(); i++){
            hashMap.put(s.charAt(i),  Long.valueOf(hashMap.getOrDefault(s.charAt(i),Long.valueOf(0))+1));
        }

        for (Map.Entry<Character, Long> item: hashMap.entrySet()) {
            if(prevValue == 0){
                prevValue = item.getValue();
            }
            else if(prevValue == 1){
                prevValue = item.getValue();
                counter++;
            }
            else if(prevValue != item.getValue()){
                if(item.getValue() > prevValue){
                    if (item.getValue() - prevValue > 1){
                        System.out.println("NO");
                        return "NO";
                    }
                    else{
                        counter++;
                    }
                }
                else{
                    if(item.getValue() == 1){
                        counter++;
                    }
                    else{
                        System.out.println("NO");
                        return "NO";
                    }
                }
            }

            if(counter > 1){
                System.out.println("NO");
                return "NO";
            }
        }

        System.out.println("YES");
        return "YES";


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\DEVEL\\Workspaces\\java\\hackerrank-strings-sherlockandthevalidstring\\files/output.txt"));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}













