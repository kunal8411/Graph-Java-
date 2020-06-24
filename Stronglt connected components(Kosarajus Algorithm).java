package graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//This algorithm is for strongly connected components in Directed acyclic graph


public class Kosarajus_Algorithm {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int vertices= scan.nextInt();
		int edges= scan.nextInt();
		int arr[][]= new int[vertices][vertices];
		for(int i=0;i<edges;i++) {
			int fv=scan.nextInt();
			int sv= scan.nextInt();
			arr[fv][sv]=1;
			
			
		}
		
		firstpass(arr);
		
	}

	private static void firstpass(int[][] arr) {
		boolean visited[]= new boolean [arr.length];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<arr.length;i++) {
			if(!visited[i]) {
				firstHelper(arr,i,visited,stack);
				
			}
		}
		//call for reverse of graph 
		
//		System.out.println("value of stack is");
//		while(!stack.isEmpty()) {
//			System.out.println(stack.pop());
//		}
		reverseOfGraph(arr,stack);
		
		
	}

	private static void reverseOfGraph(int[][] arr, Stack<Integer> stack) {
		boolean visited[]=new boolean[arr.length];
		int n= arr.length;
		int reversearr[][]=new int [n][n];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]==1) {
					reversearr[j][i]=1;
					
				}
			}
		}
		
//		for(int x=0;x<reversearr.length;x++) {
//			for(int y=0;y<reversearr[x].length;y++) {
//				System.out.println("Graph Elements are");
//				System.out.println(reversearr[x][y]);
//			}
//			System.out.println();
//		}
//		
		ArrayList<ArrayList<Integer>>result= new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<reversearr.length;i++) {
			if(!visited[i]) {
				ArrayList<Integer>list= new ArrayList<Integer>();
				
				dfsAgain(reversearr,i,visited,stack,list);
				
				result.add(list);
				
			}
		} 
		
		for(int k=0;k<result.size();k++) {
			for(int i=0;i<result.get(k).size();i++) {
				System.out.println(result.get(k).get(i));
			}
		}
	}

	private static void dfsAgain(int[][] arr, int sv, boolean[] visited, Stack<Integer> stack, ArrayList<Integer> list) {
		//does we really need starting vertex ?
		
		while(!stack.isEmpty()) {
			int top=stack.pop();
			if(!visited[top]) {
				
			visited[top]= true;
			for(int i=0;i<arr.length;i++) {
				if(arr[top][i]==1  && !visited[i]) {
					visited[i]=true;
					list.add(i);
					
				}
			}
			}
		}
		
	}

	private static void firstHelper(int[][] arr, int sv, boolean[] visited,Stack<Integer>stack) {
		visited[sv]=true;
		for(int i=0;i<arr.length;i++) {
			if(arr[sv][i]==1&& !visited[i]) {
				firstHelper(arr,i,visited,stack);
				
			}
		}
		stack.push(sv);
	}
}
