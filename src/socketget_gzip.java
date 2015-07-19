
	import java.net.*; 
import java.io.*; 
import java.util.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

	public class socketget_gzip { 
	
	public static String getHeaderValue(ArrayList<String> al,String headerName){
		String value="";
		for(String elt : al){
			if(elt.contains(headerName)){
				value=elt.split(":")[1];
			}
			
		}
		
		return value;
		
	}
	
	public static int arrayIndexOf(byte[] haystack, int offset, int length, byte[] needle) {
	    for (int i=offset; i<offset+length-needle.length; i++) {
	        boolean match = false;
	        for (int j=0; j<needle.length; j++) {
	            match = haystack[i + j] == needle[j];
	            if (!match)
	                break;
	        }
	        if (match)
	            return i;
	    }
	    return -1;
	}



	public static void main(String[] args) throws Exception { 
	try { 

	URL url1=new URL(args[1]);
	String method=args[0];
	String hostName=url1.getHost();
	String pathName=url1.getPath();
	Socket socket = new Socket(hostName,80);
	
	System.out.println("HOST IS "+hostName);
	System.out.println("PATH IS "+pathName);
	
	if(pathName.trim().length()==0)
		pathName="/";
	//pathName.replace('', '/');
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); 
	out.println(method+" "+pathName+" HTTP/1.1");
	out.println("Host:"+hostName);
	out.println("Connection: close");
	out.println("Accept-encoding: gzip");
	out.println(); 
	out.flush(); 
	
	System.out.println(method+" "+pathName+" HTTP/1.1");
	
	InputStream sis=socket.getInputStream();
	Reader isr=new InputStreamReader(sis);
	BufferedReader in = new BufferedReader(isr); 
	
	//byte[] data = new byte[10*2048];
	//int ct = sis.read(data);

	byte[] headEnd = {13, 10, 13, 10}; // \r \n \r \n
	byte[] buffer = new byte[20 * 1024];
	int length = 0;

	// Read bytes to the buffer until you find `\r\n\r\n` in the buffer. 
	int bytes = 0;
	int pos;
	while ((pos = arrayIndexOf(buffer, 0, length, headEnd)) == -1 && (bytes = sis.read(buffer, length, buffer.length - length)) > -1) {
	    length += bytes;

	    // buffer is full but have not found end siganture
	    if (length == buffer.length)
	        throw new RuntimeException("Response header too long");
	}

	// pos contains the starting index of the end signature (\r\n\r\n) so we add 4 bytes
	pos += 4;

	// When you encounter the end of header, create a strinform the first *n* bytes
	String header = new String(buffer, 0, pos);

	System.out.println(header);
	
	System.out.write(buffer, pos, length - pos);

	// process the rest until connection is closed
	while ((bytes = sis.read(buffer, 0, buffer.length))>-1) {
	    System.out.write(buffer, 0, bytes);
	}
	
	
	//System.out.println(data);
	//System.out.println(ct);
	
	
	/*
	String inputLine; 
	int count = 0; 

	inputLine = in.readLine();
	String arr[]=inputLine.split("\\s");
	//int StatusCode=Integer.parseInt(arr[1])/100;
	System.out.println(inputLine); 
	ArrayList<String> response_headers = new ArrayList<String>(); 

	ArrayList<Byte> response = new ArrayList<Byte>();
	
	while ((inputLine = in.readLine()) != null && inputLine.trim().length()>0) { 
	response_headers.add(inputLine.toString());
	count++; 
	} 
	

	
	System.out.println("PRINTING HERE!!!");
	System.out.println();
	System.out.println(args[0]);
	System.out.println(args[1]);
	for(int i=0;i<response_headers.size();i++){
	//System.out.println(i);
	System.out.println(response_headers.get(i));
	}
	
	String encoding=getHeaderValue(response_headers,"Content-encoding").trim();
	System.out.println("encoding found "+encoding);
	String response_body="";
	if((inputLine=in.readLine()) != null){
		response_body=inputLine;
	}
	//System.out.println(response_body);
	System.out.println(response_body.getBytes("UTF-8"));
	

	
    //BufferedReader in2 = new BufferedReader( new InputStreamReader(new GZIPInputStream(sis)));
    //System.out.println(in2.readLine());
    /*
	String line;
	if(encoding.contains("gzip")){
	//GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(obj.toByteArray()));
    //BufferedReader bf = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
	
	/*while ((line=bf.readLine())!=null) {
        System.out.println(line);
      }*/
	//} 
	in.close(); 
	
	//System.out.println(count); 
	
	//System.exit(StatusCode);
	
	} catch (Exception e) { 
	e.printStackTrace(); 
	} 
	
	} 
}