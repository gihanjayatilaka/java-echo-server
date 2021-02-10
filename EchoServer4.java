import java.net.*;
import java.io.*;
import java.util.*;

class EchoServer4{
	public static void main(String[] args) throws Exception{
		ServerSocket ss=new ServerSocket(5555);
		System.out.println("SS local socket add: "+ss.getLocalSocketAddress());

		for(int sId=0;sId<5;sId++){
			Socket s= ss.accept();
			Worker w=new Worker(s);
			w.start();
		}	

	}
}
