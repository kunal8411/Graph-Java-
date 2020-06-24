package graph;

import java.util.Set;
import java.util.Stack;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Deque;
import java.util.HashMap;
import java.util.ArrayDeque;

public class Topological_Sort {
	//boolean visited[]= new boolean
	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);
		System.out.println("ENter no of vetrex");
		int verex= scan.nextInt();
		System.out.println("Enter no of edges");
		int edges=scan.nextInt();
		int arr[][]= new int[verex][verex];
		
		for(int i=0;i<edges;i++) {
			System.out.println("first vertex");
			int fv=scan.nextInt();
			System.out.println("second vertex");
			int sv=scan.nextInt();
			arr[fv][sv]=1;
			
			
		}
		
		print(arr);
		
	}

	public static void print(int[][] arr) {
		boolean visited[]= new boolean[arr.length];
		Stack<Integer> stack= new Stack<Integer>();
		
		for(int i =0;i<arr.length;i++) {
			if(!visited[i]) {
				helper(arr,i,visited,stack);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		
		
	}
	public static void helper(int arr[][], int sv,boolean[] visited, Stack<Integer>stack) {
		visited[sv]=true;
		
		for(int i =0;i<arr.length;i++) {
			if(arr[sv][i]==1&&!visited[i]) {
				helper(arr,i,visited,stack);
			}
		}
		stack.push(sv);
		
	}
	
	
	
}

