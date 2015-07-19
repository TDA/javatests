import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class Solution1 {
	public static boolean isIdenticalCols(char[] mat){
		
		char first=mat[0];
		//System.out.print(mat);
		Boolean same=false;
		for(int i=1;i<mat.length;i++){
				if(mat[i]==first)
					same=true;
				else{
					same=false;
					break;
				}
			
		}
		return same;
	}
	
	public static char flipChar(char c){
		if(c=='p')
			return 't';
		else
			return 'p';
	}
	public static void main(String[] args) {
		int i,j,k;
		Scanner s= new Scanner(System.in);
		int m=s.nextInt();
		int n=s.nextInt();
		String[] temp=new String[m];
		Boolean flag=false;
		Map<Integer, Integer> row_val = new HashMap<Integer, Integer>();
		Map<Integer, Integer> col_val = new HashMap<Integer, Integer>();
		Map<Integer, Integer> col_weight = new HashMap<Integer, Integer>();
		
		char[][] matrix=new char[m][n];
		s.nextLine();
		for(i=0;i<m;i++){
			temp[i]=s.nextLine();
		}
		for(i=0;i<m;i++){
			for(j=0;j<n;j++)
			matrix[i][j]=temp[i].charAt(j);
		}
		
		char[][] copy_matrix=matrix.clone();
		for(i=0;i<m;i++){
			if(!col_val.containsKey(i)){
				col_val.put(i, 1);
		}
		//find no of rows with same characters, and update a count	
		for(i=0;i<m;i++)
			if(isIdenticalCols(matrix[i]))
				row_val.put(i, 1);
		int count=0;
		Iterator it=row_val.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer, Integer> pairs= (Map.Entry<Integer, Integer>)it.next();
			//System.out.println(pairs.getKey()+" : "+pairs.getValue());
			if(pairs.getValue()==1)
			count++;
		}		
		//Condition for flipping columns
		//I think a good way would be to check how many matches each line has, store it in count above
		// Now we flip each column by bruteforce and check if it results in more than count rows being similar
		//the condition obviously is not yet fully correct, and pretty inefficient 
		//Flip columns based on condition
		Iterator it1=col_val.entrySet().iterator();
		int new_count=0;
		while(it1.hasNext()){
			Map.Entry<Integer, Integer> pairs= (Map.Entry<Integer, Integer>)it1.next();
			//System.out.println(pairs.getKey()+" : "+pairs.getValue());
			if(pairs.getValue()==1)
				for(i=0;i<m;i++)
					copy_matrix[i][pairs.getKey()]=flipChar(copy_matrix[i][pairs.getKey()]);
				
			for(i=0;i<m;i++)
				if(isIdenticalCols(matrix[i]))
				row_val.put(i, 1);
			//find no of rows with same characters, and update a count
			Iterator it2=row_val.entrySet().iterator();
			while(it2.hasNext()){
				Map.Entry<Integer, Integer> pairs2= (Map.Entry<Integer, Integer>)it2.next();
				//System.out.println(pairs.getKey()+" : "+pairs.getValue());
				if(pairs2.getValue()==1)
					new_count++;
			}		
				if(new_count>count)
					count=new_count;
		}
		System.out.println(count);		
	}
}
}
