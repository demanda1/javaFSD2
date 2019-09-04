package SwingDbase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comm.example.dao.*;
import comm.example.model.Employee;
import comm.example.service.*;

public class SendDataNet {
	public static void main(String[] args) {
		List<Employee> list=new ArrayList<Employee>();
		String id = null;
		String fname=null;
		String lname=null;
		String email=null;
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
					
					EmployeeServiceImpl service=new EmployeeServiceImpl();
					Employee emp=new Employee();
					list=service.getEmployeeById(num);
					for(Employee e:list) {
						id= String.valueOf(e.getId());
						fname=e.getFirstName();
						lname=e.getLastName();
						email=e.getEmail();
						System.out.println(id+fname+lname+email);
					}
					System.out.println(id+fname+lname+email);
					String data=id+"#"+fname+"#"+lname+"#"+email;
							
					
					pw.println(data);
					System.out.println("msg send"+data);
				}
				 if (msg!=null && msg.equalsIgnoreCase("bye")) {
	                    server.close();
	                    client.close();
	                    break;
	                }
			}
			catch(IOException ie) {
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
