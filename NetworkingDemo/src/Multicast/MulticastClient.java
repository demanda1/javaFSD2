package Multicast;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.awt.event.ActionEvent;

public class MulticastClient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MulticastClient frame = new MulticastClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MulticastClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(87, 11, 260, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblYou = new JLabel("You");
		lblYou.setBounds(31, 14, 46, 14);
		contentPane.add(lblYou);
		
		JButton btnSend = new JButton("send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int portnumber=1236;
				
				MulticastSocket chatMulticastSocket = 
						new MulticastSocket(portnumber);
				
				InetAddress group = InetAddress.getByName("225.0.0.1");
				
				chatMulticastSocket.joinGroup(group);
				
				String msg="";
				System.out.println("Type a message for the server");
				
				while(true) {
					BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
					msg=br.readLine();
					String message=textField.getText();
					DatagramPacket data= new DatagramPacket(msg.getBytes(),0,
							msg.length(),group,portnumber);
					chatMulticastSocket.send(data);
					
					byte buf[]= new byte[1024];
					data = new DatagramPacket(buf,buf.length);
					chatMulticastSocket.receive(data);
					msg=new String(data.getData()).trim();
					System.out.println( msg);
				}
				
			 }
			catch(IOException ie) {
				ie.printStackTrace();
			}
			}
		});
		btnSend.setBounds(258, 38, 89, 23);
		contentPane.add(btnSend);
		
		JLabel lblFriend = new JLabel("Friend");
		lblFriend.setBounds(31, 88, 46, 14);
		contentPane.add(lblFriend);
		
		textField_1 = new JTextField();
		textField_1.setBounds(87, 85, 260, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
