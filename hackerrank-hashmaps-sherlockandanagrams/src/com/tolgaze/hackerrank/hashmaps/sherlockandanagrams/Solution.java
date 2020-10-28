package com.tolgaze.hackerrank.hashmaps.sherlockandanagrams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

	// Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        List<String> anagMap = new ArrayList<>();
        List<HashMap<Character, Integer>> anagHashMaps = new ArrayList<>();
        int count=0;
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                    anagMap.add(s.substring(i,j));
            }
        }
        
        for (int i = 0; i < anagMap.size(); i++) {
            HashMap<Character , Integer> tempMap = new HashMap<>();
            anagMap.get(i).chars().forEach(a -> {
                if(tempMap.containsKey((char) a)) {
                    tempMap.replace((char) a, tempMap.get((char) a)+1);
                }
                else {
                    tempMap.put((char) a, 1);
                }
            });
            anagHashMaps.add(tempMap);
        }
        
        for (int i = 0; i < anagHashMaps.size(); i++) {
            for (int j = i+1; j < anagHashMaps.size(); j++) {
                if(anagHashMaps.get(i).equals(anagHashMaps.get(j))) {
                    count++;
                }
            }
        }
        
        System.out.println(count);
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\DEVEL\\Workspaces\\java\\hackerrank-hashmaps-sherlockandanagrams\\files/output.txt"));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}













