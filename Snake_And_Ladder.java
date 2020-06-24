package graph;

import java.util.LinkedList;
import java.util.Queue;
class QueueEntry{
	int vertes;
	int distance;
	
}
public class Snake_And_Ladder {
	

	public static void main(String[] args) {
		int n =30;
		int [] board = new int[n];
		for(int i =0;i<n;i++) {
			board[i]=-1;
			
		}
		
		//ladder 
		board[2]=21;
		board[4]=7;
		board[10]=25;
		board[19]=28;
		
		
		//snake
		board[26]=0;
		board[20]=8;
		board[16]=3;
		board[18]=6;
		
	System.out.println(getMinThrows(board,n));

	}
	public static  int getMinThrows(int [] board,int n) {
		QueueEntry s = new QueueEntry();
		Queue<QueueEntry> q= new LinkedList<QueueEntry>();  //This problem is same like BFS so store each adjacent vertex in Queue 
		boolean visited[]= new boolean[n];
		
		s.vertes=0;  //initially set first vertex to S
		s.distance=0;
		q.add(s);   //add first vertex in Queue
		
		visited[0]=true;
		QueueEntry qe= new QueueEntry();
		
		while(!q.isEmpty()) {
			qe=q.remove();
			int vertex= qe.vertes;
			if(vertex==n-1) {       //if we reach to last vertex end there and return result 
				break;                //imp condition
			}
			
			for(int i=vertex+1;i<=vertex+6&&i<n;i++) {
				if(!visited[i]) {
					QueueEntry cell = new QueueEntry();
					cell.distance=qe.distance+1;
					visited[i]=true;
					if(board[i]!=-1) {           //if there is ladder or 
						cell.vertes=board[i];
						
					}
					else {
						cell.vertes=i;          //there is no ladder or snake 
						
					}
					q.add(cell);
					
				}
			}
		}
		return qe.distance;
		
	}

}
