import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class Solution {
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner s= new Scanner(System.in);
		String a=s.nextLine();
		String b=s.nextLine();
		Boolean flag=false;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
		
		if(a.length()!=b.length())
			flag=false;
		for(int i=0;i<a.length();i++){
			char key=a.charAt(i);
			if(map.containsKey(key)){
				int x=map.get(key);
				map.put(key, ++x);
			}
			else{
				map.put(key, 1);
			}
		}
		
		for(int i=0;i<b.length();i++){
			char key=b.charAt(i);
			if(map1.containsKey(key)){
				int x=map1.get(key);
				map1.put(key, ++x);
			}
			else{
				map1.put(key, 1);
			}
		}
		
		
		Iterator i=map.entrySet().iterator();
		while(i.hasNext()){
			Map.Entry<Character, Integer> pairs= (Map.Entry<Character, Integer>)i.next();
			
			System.out.println(pairs.getKey()+" : "+pairs.getValue());
		}
		
		
		Iterator i1=map1.entrySet().iterator();
		while(i1.hasNext()){
			Map.Entry<Character, Integer> pairs= (Map.Entry<Character, Integer>)i1.next();
			System.out.println(pairs.getKey()+" : "+pairs.getValue());
		}
		
		//for(int j=0;j<b.length();j++)
		if(map1.equals(map))
			flag=true;
		
		if(flag==false)
			System.out.print("Not anagrams!");
		else if (flag==true)
			System.out.print("Anagrams!");
		
    }

}
