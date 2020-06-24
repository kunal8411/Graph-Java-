package graph;

import java.util.Scanner;

public class DFS {
	public static void main(String[] args) {
		int vertices; 
		int edges; 
		Scanner scan = new Scanner(System.in);
		vertices= scan.nextInt();
		edges= scan.nextInt();
		int array[] []= new int [vertices][vertices] ;
		
		for(int i = 0 ;i<edges;i++) {
			int fv= scan.nextInt();
			int sv= scan.nextInt();
			array[fv][sv]=1;
			array[sv][fv]=1;
			//scan.close();
		}
		print(array);
	}
	public static void print(int array[][]) {
		boolean visited[]= new boolean[array.length];
		for(int i=0;i<array.length;i++) {
			if(!visited[i]) {
				printhelper(array,i,visited);
			}
		}
	}
	public static void printhelper(int array[][],int sv,boolean visited[]) {
		System.out.println(sv);
		visited[sv]= true;
		for(int i=0;i<array.length;i++) {
			if(array[sv][i]==1&&!visited[i]) {
				printhelper(array, i, visited);
			}
		}
	}

}
