import java.util.*;

public class banker {
	
	public static void print(String x, int value) {
		System.out.print("\n" + x + value);
	}
	public static void print(String x) {
		System.out.print("\n" + x);
	}
	
	public static void printArray(String str, int array[][], int n, int m) {
		System.out.println("\n"+str+":");
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}
	
	public static void printArray(String str, int array[], int n) {
		System.out.println("\n"+str);
		for(int i=0; i<n; i++) {
			System.out.print(array[i] + "\t");
		}
	}
	
	
	public void calculateNeed(int need[][], int maximum[][], int allocation[][], int N, int M) {
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++) {
				need[i][j] = maximum[i][j] - allocation[i][j];
			}
		}
	}
	
	public boolean ifNeedLessThanWork(int need[], int work[], int M) {
		for(int i=0; i<M; i++)
		{
			if(need[i]>work[i])
			{
				return false;
			}
		}
		return true;
	}
	
	
	public boolean safety(int maximum[][], int allocation[][], int available[], int N, int M) {
		int[][] need = new int[N][M];
		calculateNeed(need, maximum, allocation, N, M);
		
		int[] work = available.clone();
		int[] safeSequence = new int[N];
		
		boolean[] finish = new boolean[N];
		Arrays.fill(finish, false);
		
		int count=0;
		while(count < N){
		
			boolean complete = false;
			
			for(int process=0; process<N; process++) 
			{
			
				if(finish[process]==false && ifNeedLessThanWork(need[process], work, M)) 
				{
					
					
					for(int i=0; i<M; i++) 
					{
						work[i] += allocation[process][i];
					}
					
					safeSequence[count++] = process;
					finish[process] = true;
					complete = true;
				}
			}
			
			if(complete == false) {
				print("System is prone to deadlock.");
				return false;
			}
		}
		
		print("System is safe.");
		printArray("Safe Sequence is: ", safeSequence, N);
		return true;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int N = 0; 
		int M = 0;
		
		print("Enter Number of Processes(N): ");
		N = input.nextInt();
		
		print("Enter Number of Resources(M): ");
		M = input.nextInt();
		
		int[] available = new int[M];
		print("Enter Available Resources");
		for(int i=0; i<M; i++) {
			print("R" + i + ": ");
			available[i] = input.nextInt();
		}
		
		int[][] allocation = new int[N][M];
		print("Enter Allocation Matrix");
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				print("P" + i + " R" + j + ": ");
				allocation[i][j] = input.nextInt();
			}
		}
		
		int[][] maximum = new int[N][M];
		print("Enter Maximum Matrix");
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				print("P" + i + " R" + j + ": ");
				maximum[i][j] = input.nextInt();
			}
		}
		
		printArray("Available Resources", available, M);
		printArray("Allocation Matrix", allocation, N, M);
		printArray("Maximum Matrix", maximum,N, M);
		
		banker b = new banker();
		b.safety(maximum, allocation, available, N, M);
		
		input.close();
	}
}
