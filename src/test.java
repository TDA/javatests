import java.io.*;
import java.util.*;

class test {

    static int solveMeSecond(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int no=Integer.parseInt(in.nextLine());
        
        for(int i=0;i<no;i++){
        
        long t;
        t=Long.parseLong(in.nextLine());
        if(t<0||t>10000000000L){
        	System.out.println(0);
        	break;
        }
        t=~t;
        
        t=(long)Integer.MAX_VALUE*2+2+t;
        System.out.println(t);
        }
    }
}
