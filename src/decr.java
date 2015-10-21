import java.util.HashMap;


public class decr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(decrString("FKIXAeIZYQg"));

	}
	public static String decrString(String paramString)
	  {
	    char[] arrayOfChar1 = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	    HashMap localHashMap = new HashMap(arrayOfChar1.length);
	    for (int i = 0; i < arrayOfChar1.length; i++) {
	      localHashMap.put(Character.valueOf(arrayOfChar1[i]), Integer.valueOf(i));
	    }
	    char[] arrayOfChar2 = new char[paramString.length()];
	    for (int j = 0; j < paramString.length(); j++)
	    {
	      int k = ((Integer)localHashMap.get(Character.valueOf(paramString.charAt(j)))).intValue();
	      if (j % 2 == 0)
	      {
	        int m = (k - j) % arrayOfChar1.length;
	        if (m < 0) {
	          m += arrayOfChar1.length;
	        }
	        arrayOfChar2[j] = arrayOfChar1[m];
	      }
	      else
	      {
	        arrayOfChar2[j] = arrayOfChar1[((k + j) % arrayOfChar1.length)];
	      }
	    }
	    String str = new String(arrayOfChar2);
	    return str;
	  }
	  

}
