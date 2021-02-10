import java.net.*;
import java.io.*;
import java.util.*;

class Worker extends Thread{
	Socket s;

	Worker(Socket s){
		this.s=s;
		System.out.println("S remote socket add: "+s.getRemoteSocketAddress());
		System.out.println("S local socket add: "+s.getLocalSocketAddress());
	}



	public void run(){
		try{
			BufferedReader s_In=new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter s_Out=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

			for(int i=0;i<10;i++){
				String r = s_In.readLine();
				System.out.println("Ssays: "+r);
				r = "ES: "+r;
				System.out.println("Server says: "+r);
				s_Out.println(r);
				s_Out.flush();
			}
		}
		catch(Exception e){
			//
		}
	}
}