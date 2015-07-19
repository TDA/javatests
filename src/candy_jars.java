import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class candy_jars{

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        long n,m,a,b,k;
        long sum=0;
        Scanner s=new Scanner(System.in);
        n=(s.nextLong());
        m=(s.nextLong());
        s.nextLine();
        for(long i=0;i<m;i++){
        	a=s.nextLong();
        	b=s.nextLong();
        	k=s.nextLong();
        	sum+=k*(b-a+1);
        }
        System.out.print((long)Math.floor(sum/n));
    }
}