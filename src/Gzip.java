import java.io.*;

import java.util.zip.*;



public class Gzip {
      public void compress() throws IOException {
            // first compress inputfile.txt into out.gz
            BufferedReader in = new BufferedReader(new FileReader("inputfile.txt"));
            BufferedOutputStream out = new BufferedOutputStream(
                  new GZIPOutputStream(new FileOutputStream("out.gz")));
            int c;
            while ((c = in.read()) != -1) 
            	out.write();
            in.close();
            out.close();
            
            // now decompress our new file
            BufferedReader in2 = new BufferedReader( new InputStreamReader(new GZIPInputStream(new FileInputStream("out.gz"))));
            String s;
            while ((s = in2.readLine()) != null)
                  System.out.println(s);
      }

}