import java.io.*;
import java.net.*;
import java.util.*;

class EchoServer1{
	public static void main(String[] args) throws Exception {
		ServerSocket ss=new ServerSocket(5555);
		System.out.println("SS local socket add: "+ss.getLocalSocketAddress());

		Socket s1= ss.accept();
		System.out.println("S1 remote socket add: "+s1.getRemoteSocketAddress());
		System.out.println("S1 local socket add: "+s1.getLocalSocketAddress());
		
		BufferedReader s1_In=new BufferedReader(new InputStreamReader(s1.getInputStream()));
		PrintWriter s1_Out=new PrintWriter(new OutputStreamWriter(s1.getOutputStream()));

		for(int i=0;i<3;i++){
			String r = s1_In.readLine();
			// System.out.println("S1 says: "+r);
			r = "ES: "+r;
			// System.out.println("Server says: "+r);
			s1_Out.println(r);
			s1_Out.flush();
		}
	}
}