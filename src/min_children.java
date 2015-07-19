	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.Arrays;


public class min_children {

	// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

	   static BufferedReader in = new BufferedReader(new InputStreamReader(
	         System.in));
	   static StringBuilder out = new StringBuilder();

	   public static void main(String[] args) throws NumberFormatException, IOException {
	      int numPackets = Integer.parseInt(in.readLine());
	      int numKids = Integer.parseInt(in.readLine());
	      int[] packets = new int[numPackets];
	      
	      for(int i = 0; i < numPackets; i ++)
	      {
	         packets[i] = Integer.parseInt(in.readLine());
	      }
	      
	      int unfairness = Integer.MAX_VALUE;
	      Arrays.sort(packets);
	      unfairness=packets[numKids-1]-packets[0];
	      for(int i=0;i<packets.length-numKids-1;i++){
	    	  int unfair=packets[numKids+i-1]-packets[i];
		      if(unfair<unfairness)
		    	  unfairness=unfair;
	      }
	      System.out.println(unfairness);
	   }
	}


