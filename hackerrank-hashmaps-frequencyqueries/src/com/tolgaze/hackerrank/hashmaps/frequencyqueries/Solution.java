package com.tolgaze.hackerrank.hashmaps.frequencyqueries;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> resultList = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> countsMap = new HashMap<>();
        
        for (List<Integer> operation : queries) {
            switch (operation.get(0)) {
            case 1:
                if(map.containsKey(operation.get(1))) {
                    Integer count = map.get(operation.get(1));
                    map.put(operation.get(1), count+1);
                    
                    //countsMap
                    if(countsMap.get(count) == 1) {
                        countsMap.remove(count);
                    }
                    else {
                        countsMap.put(count, Optional.ofNullable(countsMap.get(count)).orElse(0)-1);
                    }
                    countsMap.put(count+1, Optional.ofNullable(countsMap.get(count+1)).orElse(0)+1);
                }
                else {
                    map.put(operation.get(1), 1);
                    countsMap.put(1, Optional.ofNullable(countsMap.get(1)).orElse(0)+1);
                }
                break;
                
            case 2:
                if(map.containsKey(operation.get(1))) {
                    Integer count = map.get(operation.get(1));
                    if(count.intValue() == 1) {
                        map.remove(operation.get(1));
                    }
                    else {
                        map.put(operation.get(1), count-1);
                    }
                    
                    //countsMap
                    if(countsMap.get(count) == 1) {
                        countsMap.remove(count);
                    }
                    else {
                        countsMap.put(count, Optional.ofNullable(countsMap.get(count)).orElse(0)-1);
                    }
                    countsMap.put(count-1, Optional.ofNullable(countsMap.get(count-1)).orElse(0)+1);
                }
                break;
                
            case 3:
                if(countsMap.containsKey(operation.get(1))) {
                    resultList.add(1);
                }
                else {
                    resultList.add(0);
                }
                break;

            default:
                break;
            }
            
            
        }
        
        System.out.print(resultList);
        return resultList;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\DEVEL\\Workspaces\\java\\hackerrank-hashmaps-frequencyqueries\\files/output.txt"));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
            ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}













