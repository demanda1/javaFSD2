package Multicast;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class MulticastServer extends JFrame {

	private JPanel contentPane;
	private String message;
	private JButton btnStopServer;
	private MulticastSocket serverMulticastSocket;
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public MulticastServer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 414, 174);
		contentPane.add(textArea);
		
		JButton btnStartServer = new JButton("Start Server");
		btnStartServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int portnumber=1236;
				try {
				//Create a MulticastSocket
				 serverMulticastSocket=
						new MulticastSocket(portnumber);
				 System.out.println("MulticastSocket is created.");
				message+="MulticastSocket is created.";
				textArea.setText(message);
				
				InetAddress group=InetAddress.getByName("225.0.0.1");
				
				serverMulticastSocket.joinGroup(group);
				message+="JoinGroup method is called";
				textArea.setText(message);
				
				while(true) {
					byte buf[]= new byte[1024];
					DatagramPacket data = new DatagramPacket(buf,buf.length);
					serverMulticastSocket.receive(data);
					String msg=new String(data.getData()).trim();
					System.out.println(msg);
					
				}
				
				}
				catch(IOException ie) {
					ie.printStackTrace();
				}
				
			}
		});
		btnStartServer.setBounds(0, 195, 89, 23);
		contentPane.add(btnStartServer);
		
		btnStopServer = new JButton("Stop Server");
		btnStopServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serverMulticastSocket.close();
			}
		});
		btnStopServer.setBounds(0, 229, 89, 23);
		contentPane.add(btnStopServer);
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MulticastServer frame = new MulticastServer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}