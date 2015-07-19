import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
public static void main (String[] args) throws java.lang.Exception
{
double[] array=get(4);
print(array);
computations(array);
double[] newarray=reverse(array);
Prin(newarray);
}
public static double[] get(int a)
{
int row=a;
double[] myList = new double[row];
//myList = new double [row];
//row=a;
Scanner key = new Scanner(System.in);
for(int i=0;i<4;i++)
myList[i]=key.nextDouble();
return myList;
}
public static void print(double[] myList)
{
//for(int i=0;i<myList.length;i++)
//System.out.println(myList+" ");
for(double element:myList)
System.out.println("the" +element);
}
public static void computations(double[] myList)
{
//finding the total
double total = 0;
for (int i = 0; i < myList.length;i++)
total += myList[i];
System.out.println("total is" +total);
// Finding the largest element
double max = myList[0];
for (int i = 1; i < myList.length; i++)
{
if (myList[i] > max)
max = myList[i];
}
System.out.println("Max is " + max);
}
public static double[] reverse(double[] myList)
{
double[] revar= new double[myList.length];
for(int i=0,j=revar.length-1;i<myList.length;i++,j--)
{
revar[i]=myList[j];
 
}
return revar;	
}
public static void Prin(double [] revar)
{
for (int j = 0; j < revar.length;j++)
{
System.out.println(revar[j]+" ");
}
}
 
 
 
 
 
}