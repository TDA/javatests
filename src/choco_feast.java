import java.util.Arrays;
import java.util.Scanner;


public class choco_feast {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int t,n,c,m;
        long sum=0;
        long choci,wrappers,left,new_choci;
        Scanner s=new Scanner(System.in);
        t=(s.nextInt());
        s.nextLine();
        for(int i=0;i<t;i++){
        	n=s.nextInt();
        	c=s.nextInt();
        	m=s.nextInt();
        	
            choci=(int)n/c;
            left=wrappers=choci;
            new_choci=(int)wrappers/m;
            while(new_choci>0&&left>0){
            	left+=new_choci;
            	choci+=left/m;
                new_choci=left/m;
                left=left%m;
            	
              }
         
        System.out.println(choci);
        
        
            
        }
        
        
        int val=s.nextInt();
        int size=s.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<size;i++)
            arr[i]=s.nextInt();
        System.out.println(Arrays.binarySearch(arr,val));
        

	}

}
