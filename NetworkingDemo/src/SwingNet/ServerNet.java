package SwingNet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerNet {

	public static void main(String[] args) {
		ServerSocket server=null;
		Socket client;
		int portnumber=3030;
		try {
			server=new ServerSocket(portnumber);
		}catch (IOException ie) {
            System.out.println("Cannot open socket." + ie);
            System.exit(1);
        }
		System.out.println("Server Socket is created"+ server);
		
		while(true) {
			try {
				 System.out.println("Waiting for connect request...");
				client=server.accept();
				
				 System.out.println("Connect request is accepted...");
				 String clientHost = client.getInetAddress().getHostAddress();
	                int clientPort = client.getPort();
	                System.out.println("Client host = " + clientHost + " Client port = " + clientPort);
	                
				InputStream clientIn=client.getInputStream();
				BufferedReader bf=new BufferedReader(new InputStreamReader(clientIn));
				
				String msg=bf.readLine();
				System.out.println("Message received from client = " + msg);
				
				if(msg!=null && !msg.equalsIgnoreCase("bye")){
					OutputStream clientOut=client.getOutputStream();
					PrintWriter pw=new PrintWriter(clientOut, true);
					
					int num=Integer.parseInt(msg);
					int fact=factorial(num);
					
					pw.println(String.valueOf(fact));
					System.out.println("msg send"+fact);
				}
				 if (msg!=null && msg.equalsIgnoreCase("bye")) {
	                    server.close();
	                    client.close();
	                    break;
	                }
			}
			catch(IOException ie) {
				
			}
		}
	}
	
	public static int factorial(int num) {
		int prod=1;
		if(num==1) {
			return 1;
		}
		else {
			prod=num*factorial(num-1);
			return prod;
		}
		
	}
}
