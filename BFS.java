package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

	public static void main(String[] args) {
		int vertices;
		int edges; 
		Scanner s= new Scanner(System.in);
		vertices= s.nextInt();
		edges= s.nextInt();
		
		int array[][]= new int [vertices][vertices];
		for(int i =0;i<edges;i++) {
			int fv=s.nextInt();
			int sv=s.nextInt();
			array[fv][sv]=1;
			array[sv][fv]=1;
			
		}
		print(array);
		
	}
	public static void print(int array[][]) {
		boolean[] visited = new boolean[array.length];
		for(int i= 0;i<array.length;i++) {
			if(!visited[i]) {
				printHelper(array,i,visited);
			}
		}
	}
	public static void printHelper(int[][] array, int sv, boolean[] visited) {
		Queue queue = new LinkedList<Integer>();
		queue.add(sv);
		visited[sv]= true;
		
				
		while(!queue.isEmpty()) {
			int top= (int) queue.remove();
			System.out.println(top);
			for(int i=0;i<array.length;i++) {
				if(array[top][i]==1&&!visited[i]) {
					queue.add(i);
					visited[i]=true;
					
					//printHelper(array, i, visited);
				}
			}
		}
		
		
	}
	
}
