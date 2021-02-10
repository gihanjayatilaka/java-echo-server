import java.net.*;
import java.io.*;
import java.util.*;

class EchoServer3{
	public static void main(String[] args) throws Exception{
		ServerSocket ss=new ServerSocket(5555);
		System.out.println("SS local socket add: "+ss.getLocalSocketAddress());

		Socket s1= ss.accept();
		Worker w1=new Worker(s1);
		w1.start();


		Socket s2= ss.accept();
		Worker w2=new Worker(s2);
		w2.start();
	}
}
