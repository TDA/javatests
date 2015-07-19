import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class GoT {

	/**
	 * @param args
	 */
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner s= new Scanner(System.in);
		String a=s.nextLine();
		Boolean flag=false;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		String b,c = "";
		long len=a.length();
		for(int i=0;i<len;i++){
			char key=a.charAt(i);
			if(map.containsKey(key)){
				int x=map.get(key);
				map.put(key, ++x);
			}
			else{
				map.put(key, 1);
			}
			//if(i==len-1)
				//break;
		}
		
		int sum=0,
			count=0;
		Iterator i=map.entrySet().iterator();
		while(i.hasNext()){
			Map.Entry<Character, Integer> pairs= (Map.Entry<Character, Integer>)i.next();
			if(pairs.getValue()%2==1)
			count++;
			//System.out.println(pairs.getKey()+" : "+pairs.getValue());
		}
		if(count>1)
			flag=false;
		else{
			flag=true;	
		}
		if(flag==false)
			System.out.print("NO");
		else if (flag==true)
			System.out.print("YES");
		
    }

}
