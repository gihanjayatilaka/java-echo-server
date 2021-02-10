import java.net.*;
import java.io.*;
import java.util.*;

class EchoServer2{
	public static void main(String[] args) throws Exception{
		ServerSocket ss=new ServerSocket(5555);
		System.out.println("SS local socket add: "+ss.getLocalSocketAddress());

		Socket s1= ss.accept();
		System.out.println("S1 remote socket add: "+s1.getRemoteSocketAddress());
		System.out.println("S1 local socket add: "+s1.getLocalSocketAddress());

		Socket s2= ss.accept();
		System.out.println("S2 remote socket add: "+s2.getRemoteSocketAddress());
		System.out.println("S2 local socket add: "+s2.getLocalSocketAddress());


		BufferedReader s1_In=new BufferedReader(new InputStreamReader(s1.getInputStream()));
		PrintWriter s1_Out=new PrintWriter(new OutputStreamWriter(s1.getOutputStream()));

		BufferedReader s2_In=new BufferedReader(new InputStreamReader(s1.getInputStream()));
		PrintWriter s2_Out=new PrintWriter(new OutputStreamWriter(s1.getOutputStream()));

		String r1 = s1_In.readLine();
		System.out.println("S1 says: "+r1);
		r1 = "ES: "+r1;
		System.out.println("Server says: "+r1);
		s1_Out.println(r1);
		s1_Out.flush();


		String r2 = s2_In.readLine();
		System.out.println("S2 says: "+r2);
		r2 = "ES: "+r2;
		System.out.println("Server says: "+r2);
		s2_Out.println(r2);
		s2_Out.flush();

	}
}