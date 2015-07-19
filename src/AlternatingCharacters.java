import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AlternatingCharacters {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s=new Scanner(System.in);
        int t=Integer.parseInt(s.nextLine());
        for(int i=0;i<t;i++){
        	int count=0;
            
            String temp=s.nextLine();
            String temp1="";
            if(temp.matches("(ab)+a*"))
            	count=0;
            else{
            	for(int j=0;j<temp.length()-1;j++)
            		if(temp.charAt(j)==(temp.charAt(j+1))){
            			//temp1+=temp.charAt(j);
            			//temp1+=temp.substring(j+1,temp.length());
            			count++;	
            		}
            }
            System.out.println(count);
        }
        
    }
}