package com.tolgaze.hackerrank.greedyalgorithms.reverseshufflemerge;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {
    static List<Character> possibleCharsList = new ArrayList();
    static Character minCharacter = Character.MAX_VALUE;
    static char[] resultString;
    static int resultStringIndex = 0;
    static HashMap<Character, Integer> charCounts = new HashMap<Character, Integer>();
    static HashMap<Character, Integer> initialCharCounts = new HashMap<Character, Integer>();
    static HashMap<Character, Integer> usedCharCounts = new HashMap<Character, Integer>();
    static String inputString;

    // Complete the reverseShuffleMerge function below.
    static String reverseShuffleMerge(String s) {
        resultString = new char[s.length()/2];
        inputString = s;
        
        for (int i = 0; i < s.length(); i++) {
            charCounts.put(s.charAt(i), charCounts.getOrDefault(s.charAt(i),0)+1);
            initialCharCounts.put(s.charAt(i), initialCharCounts.getOrDefault(s.charAt(i),0)+1);
        }
        
        for (int i = s.length()-1; i >= 0; i--) {
            if(resultStringIndex >= s.length()/2) {
                break;
            }
            
            if(minCharacter > s.charAt(i) && usedCharCounts.getOrDefault(s.charAt(i),0) < initialCharCounts.get(s.charAt(i))/2) {
                minCharacter = s.charAt(i);
            }
            
            if(initialCharCounts.get(s.charAt(i))/2  < charCounts.get(s.charAt(i)) + usedCharCounts.getOrDefault(s.charAt(i), 0) ) {
                possibleCharsList.add(s.charAt(i));
            }
            else {
                if(minCharacter >= s.charAt(i)) {
                    addResultString(s.charAt(i));
                    if(resultStringIndex >= s.length()/2) {
                        break;
                    }
                    else {
                        if(minCharacter != Character.MAX_VALUE && minCharacter != s.charAt(i)) {
                            addResultString(minCharacter);
                        }
                    }
                }
                else {
                    if(possibleCharsList.size()>0) {
                        checkandAddPossibleChars(s,i);
                    }
                    
                    if(resultStringIndex >= s.length()/2) {
                        break;
                    }
                    else {
                        addResultString(s.charAt(i));
                    }
                }
                minCharacter = Character.MAX_VALUE;
                possibleCharsList.clear();
            }
            
            charCounts.put(s.charAt(i), charCounts.get(s.charAt(i))-1);
        }
        
        System.out.println(String.valueOf(resultString));
        return String.valueOf(resultString);


    }
    
    private static void checkandAddPossibleChars(String inputString ,int currentIndex) {
        if(addResultString(minCharacter)) {
            possibleCharsList = possibleCharsList.subList(possibleCharsList.indexOf(minCharacter)+1, possibleCharsList.size());
        }
        else {
            possibleCharsList.remove(minCharacter);
        }
        
        while(possibleCharsList.size() >= 1) {
            minCharacter = possibleCharsList.stream().min(Comparator.comparing(Character::valueOf)).get();
            if(minCharacter < inputString.charAt(currentIndex)) {
                addResultString(minCharacter);
                possibleCharsList = possibleCharsList.subList(possibleCharsList.indexOf(minCharacter)+1, possibleCharsList.size());
            }
            else {
                break;
            }
        }
        
    }
    
    private static boolean addResultString(Character character) {
        if(usedCharCounts.getOrDefault(character,0) < initialCharCounts.get(character)/2 && resultStringIndex < inputString.length() ) {
            resultString[resultStringIndex] = character;
            resultStringIndex++;
            usedCharCounts.put(character, usedCharCounts.getOrDefault(character, 0)+1);
            return true;
        }
        return false;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\DEVEL\\Workspaces\\java\\hackerrank-greedyalgorithms-reverseshufflemerge\\files/output.txt"));

        String s = scanner.nextLine();

        String result = reverseShuffleMerge(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}














