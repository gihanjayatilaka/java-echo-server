import java.net.*;
import java.io.*;
import java.util.*;

class WorkerLazy extends Thread{
	Socket s;

	WorkerLazy(Socket s){
		this.s=s;
		System.out.println("S remote socket add: "+s.getRemoteSocketAddress());
		System.out.println("S local socket add: "+s.getLocalSocketAddress());
	}



	public void run(){
		try{
			BufferedReader s_In=new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter s_Out=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

			for(int i=0;i<2;i++){
				String r = s_In.readLine();
				r = "ES: "+r;
				s_Out.println(r);
				s_Out.flush();
			}

			System.out.print("Worker STOPPING>>>>");
		}
		catch(Exception e){
			//
		}
	}
}