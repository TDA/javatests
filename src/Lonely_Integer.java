import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Lonely_Integer {
static int lonelyinteger(int[] a) {
    int l_i=0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i=0;i<a.length;i++){
    	int key=a[i];
    	if(map.containsKey(key)){
			int x=map.get(key);
			map.put(key, ++x);
		}
		else{
			map.put(key, 1);
		}
    }
    Iterator i=map.entrySet().iterator();
	while(i.hasNext()){
		Map.Entry<Integer, Integer> pairs= (Map.Entry<Integer, Integer>)i.next();
		if(pairs.getValue()==1)
			l_i=pairs.getKey();
	}
	
    return l_i;

    }
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = lonelyinteger(_a);
        System.out.println(res);
        
    }
}

