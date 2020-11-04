package com.tolgaze.hackerrank.search.swapnodes;

import java.io.*;
import java.util.*;

class Node {
	Node left;
	Node right;
	int depth;
	int value;
	
	Node(int depth, int value) {
		this.depth = depth;
		this.value = value;
	}
	
	public void addNode(Node left, Node right) {
		if(left != null) {
			this.left = left;
		}
		if(right != null) {
			this.right = right;
		}
	}
	
}


public class Solution {
	
    static int[][] swapNodes(int[][] indexes, int[] queries) {
    	int[][] result = new int[queries.length][indexes.length];
    	
		Node rootNode = new Node(1, 1);
		Queue<Node> nodes = new LinkedList<>();
		Node rightNode = null ,leftNode = null;
		int j=0;
	   	 
	   	 nodes.add(rootNode);
	   	 while (!nodes.isEmpty()) {
			rightNode = null;
			leftNode = null;
			Node node = nodes.remove();
			
			if(indexes[j][0] != -1) {
				leftNode = new Node(node.depth+1, indexes[j][0]);
				nodes.add(leftNode);
			}
			
			if(indexes[j][1] != -1) {
				rightNode = new Node(node.depth+1, indexes[j][1]);
				nodes.add(rightNode);
			}
			
			node.addNode(leftNode, rightNode);
			j++;
	   	 }
	   	 
	   	 for (int k = 0; k < queries.length; k++) {
   	        swap(rootNode, queries[k], 1);
   	        List<Integer> temp = new ArrayList<>();
   	        inorder(rootNode, temp);
   	        result[k] = temp.stream().mapToInt(n -> n).toArray();
   	        temp.stream().forEach(item -> System.out.print(item + " "));
   	        System.out.println();
	   	 }
	   	 
	   	return result;
    }
    
    static void swap(Node node, int k, int level) {
        if (node == null) return;
        if (level%k == 0) {
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        swap(node.left, k, level+1);
        swap(node.right, k, level+1);
    }

    static void inorder(Node node, List<Integer> lst) {
        if (node != null) {
            inorder(node.left, lst);
            lst.add(node.value);
            inorder(node.right, lst);
        }
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\DEVEL\\Workspaces\\java\\hackerrank-search-swapnodes\\files/output.txt"));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}














