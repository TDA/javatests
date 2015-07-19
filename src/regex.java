import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class regex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		s.nextLine();
		String h="hackerrank";
		for(int i=0;i<n;i++){
			String temp=s.nextLine();
			int x=-1;
			/*if((temp.startsWith(h))&&(temp.endsWith(h)))
				x=0;
			else if(temp.startsWith(h))
				x=1;
			else if(temp.endsWith(h))
				x=2;
			System.out.println(x);
			*/
			if(temp.matches(h))
				x=0;
			else if(temp.startsWith(h))
				x=1;
			else if(temp.endsWith(h))
				x=2;
			System.out.println(x);
		}
		

	}

}

