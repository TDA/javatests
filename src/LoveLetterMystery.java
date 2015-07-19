import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LoveLetterMystery {

	/**
	 * @param args
	 */
	public static boolean isDownable(char a){
		if((a-1)>96)
		return true;
		return false;
	}
	public static char down(char a){
		return (char) (a-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner s=new Scanner(System.in);
	     int t=Integer.parseInt(s.nextLine());
	     for(int i=0;i<t;i++){
	       	int count=0;     
	        String temp=s.nextLine();
	        String temp1="";
	        StringBuilder sb=new StringBuilder();
	        sb.append(temp);
	        int len=temp.length();
	        for(int j=0;j<len/2;){
	        	if(sb.charAt(j)==sb.charAt(len-j-1)){
	        		j++;

		        	//System.out.println("wrong "+sb);	
	        		continue;
	        	}
	        	else{
	        		if(sb.charAt(j)<sb.charAt(len-j-1)){
	        		if(isDownable(sb.charAt(len-1-j))){
	        			sb.setCharAt(len-1-j, down(sb.charAt(len-1-j)));
	        		}
	        		}
	        		else{ 
	        			if(isDownable(sb.charAt(j))){
	        			sb.setCharAt((j), down(sb.charAt(j)));	
	        			}
	        		}
		        	//System.out.println(sb);	
	        		count++;
	        		}
	        }
	     System.out.println(count);
	     }

	}

}
