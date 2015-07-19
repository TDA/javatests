
	import java.net.*; 
import java.io.*; 
import java.util.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

	public class socketget { 
	
	public static String getHeaderValue(ArrayList<String> al,String headerName){
		String value="";
		for(String elt : al){
			if(elt.contains(headerName)){
				value=elt.split(":",2)[1];
			}
			
		}
		
		return value;	
	}
	
	public static boolean isHexInteger(String string) {
	    try {
	    	Integer.parseInt(string,16);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}



	public static void main(String[] args) throws Exception { 
	try { 

	URL url1=new URL(args[1]);
	String method=args[0];
	String hostName=url1.getHost();
	String pathName=url1.getPath();
	Socket socket = new Socket(hostName,80);
	
	//System.out.println("HOST IS "+hostName);
	//System.out.println("PATH IS "+pathName);
	
	if(pathName.trim().length()==0)
		pathName="/";
	//pathName.replace('', '/');
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); 
	out.println(method+" "+pathName+" HTTP/1.1");
	out.println("Host:"+hostName);
	out.println("Connection: close");
	out.println("Cookie:cse591=xhY27bhdZBqJ7YBJQ29tmedqUwQj31YZwTb6awpg; session=eyJhbGlhcyI6InRkYSIsInVpZCI6MjR9.B9D_kQ.P012d4WssAMvT9zRi3uzwoo0S6k");
	out.println("User-Agent:Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.4");
	//out.println("Accept-encoding: gzip");
	out.println(); 
	out.flush(); 
	//out.close();
	
	//System.out.println(method+" "+pathName+" HTTP/1.1");

	InputStream sis=socket.getInputStream();
	Reader isr=new InputStreamReader(sis);
	BufferedReader in = new BufferedReader(isr); 
	
	String inputLine; 
	int count = 0; 
	//System.out.print(StatusShort);
	ArrayList<String> response_headers = new ArrayList<String>(); 
	int StatusCode,StatusShort;
	inputLine = in.readLine();
	String arr[]=inputLine.split("\\s");
	StatusCode=Integer.parseInt(arr[1]);
	StatusShort=StatusCode/100;
	response_headers.add(inputLine);
	while ((inputLine = in.readLine()) != null && inputLine.trim().length()>0) { 
	response_headers.add(inputLine.toString()); 
	} 
	

	//for(int i=0;i<response_headers.size();i++){
	//System.out.println(response_headers.get(i));
	//}

	while(StatusShort==3&&count<5){
	//System.out.print("redirecting");
		
	Boolean follow=false,newURI=false,oldURI=false;
	switch(StatusCode){
	case 301:follow=false;
			 newURI=true;
			 break;
	case 302:follow=false;
			 newURI=false;
			 break;
	case 303:newURI=false;
			 follow=true;
			 break;
	case 307:follow=false;
			 oldURI=true;
			 break;
			 
	}
	if(method.equals("PUT")||method.equals("POST")||method.equals("DELETE")&&follow==false)
	{
		//Do nothing
		System.exit(StatusShort);
	}
	if(method.equals("PUT")||method.equals("POST")||method.equals("DELETE")&&follow==true)
	{
		//Do nothing
		System.exit(StatusShort);
	}
	if((method.equals("GET")||method.equals("HEAD"))){
		String redirect_url=getHeaderValue(response_headers,"Location").trim();
		//System.out.println(redirect_url);		
		count++;
		URL url=new URL(redirect_url);
		hostName=url.getHost();
		pathName=url.getPath();
		socket=new Socket(hostName,80);
		sis=socket.getInputStream();
		out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
		out.println(method+" "+pathName+" HTTP/1.1");
		out.println("Host:"+hostName);
		out.println("Connection: close");
		out.println(); 
		out.flush();
		isr=new InputStreamReader(sis);
		in = new BufferedReader(isr); 
		inputLine = in.readLine();
		arr=inputLine.split("\\s");
		StatusCode=Integer.parseInt(arr[1]);
		StatusShort=StatusCode/100;
		response_headers.add(inputLine);
		while ((inputLine = in.readLine()) != null && inputLine.trim().length()>0) { 
		response_headers.add(inputLine.toString()); 
		} 
		

		//for(int i=0;i<response_headers.size();i++){
		//System.out.println(response_headers.get(i));
		//}

	}
	}
	
		ArrayList<String> response_body = new ArrayList<String>(); ;
	
	String c_encoding=getHeaderValue(response_headers,"Content-encoding").trim();
	if(c_encoding=="")
		c_encoding="none";
	//System.out.println("encoding found "+c_encoding);
	String chunked=getHeaderValue(response_headers,"Transfer-Encoding").trim();
	
	if(chunked==""){
		chunked="none";
		//System.out.println("chunked encoding? "+chunked);
	}
	if(chunked.equals("chunked")){
		//System.out.println("chunked encoding? "+chunked);
		int hex_value=0;
		while((inputLine=in.readLine()) != null){
			if(isHexInteger(inputLine)){
				if((hex_value=Integer.parseInt(inputLine,16))>0){
					//System.out.println(hex_value);
					//System.out.println(inputLine);
					char[] buffer=new char[hex_value];
					//in.read(buffer, 0, 2);
					in.read(buffer, 0, hex_value);
					//System.out.println("here i am");
					if(c_encoding.equals("gzip")){
						//System.out.println("here tpp");
						byte[] Bytes2 = new byte[hex_value*2];
						for(int i=0; i<hex_value; i++) {
							Bytes2[2*i] = (byte) ((buffer[i]&0xFF00)>>8); 
						    Bytes2[2*i+1] = (byte) (buffer[i]&0x00FF); 
						    }
						//System.out.println(Bytes2.toString());
						//System.out.println("here");
						GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(Bytes2));
						BufferedReader bf = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
						String line="";	
						//while ((line=bf.readLine())!=null) {
        				//System.out.println(line);
      					//}
					}
					String s=new String(buffer);
					response_body.add(s);
				}
				else{
					//System.out.println("terminated");
					//System.out.println(inputLine+ " is");
					break;
				}
			}
			
		}
	}
	else{
		//System.out.print("out");
	while((inputLine=in.readLine()) != null){
		response_body.add(inputLine);
	}
	}
	for(String line:response_body)
	System.out.println(line);
	
	in.close(); 
	out.close();
	socket.close();

	System.exit(StatusShort);
	
	} catch (Exception e) { 
	e.printStackTrace(); 
	} 
	
	} 
}