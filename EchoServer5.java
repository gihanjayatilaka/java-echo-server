import java.net.*;
import java.io.*;
import java.util.*;

class EchoServer5{
	public static void main(String[] args) throws Exception{
		ServerSocket ss=new ServerSocket(5555);
		System.out.println("SS local socket add: "+ss.getLocalSocketAddress());

		WorkerLazy[] ar=new WorkerLazy[2];
		for(int sId=0;sId<2;sId++){
			Socket s= ss.accept();
			ar[sId]=new WorkerLazy(s);
			ar[sId].start();
		}

		System.out.println("All threads started");

		for(int sId=0;sId<2;sId++){
			ar[sId].join();
		}	

		System.out.println("END of Program");	

	}
}
