package SwingNet;

import java.awt.BorderLayout;

import java.io.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class ClientNetApp extends JFrame {

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
					ClientNetApp frame = new ClientNetApp();
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
	public ClientNetApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYourMessage = new JLabel("Enter Number");
		lblYourMessage.setBounds(25, 39, 67, 14);
		contentPane.add(lblYourMessage);
		
		textField = new JTextField();
		textField.setBounds(112, 36, 138, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(113, 108, 137, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Socket client;
				
				for(int i=0;i<5;i++) {
					try {
						client=new Socket(InetAddress.getLocalHost(),3030);
						System.out.println("Client socket is created " + client);
						
						OutputStream clientOut=client.getOutputStream();
						PrintWriter pw=new PrintWriter(clientOut,true);
						
						InputStream clientIn = client.getInputStream();
		                BufferedReader br = new BufferedReader(new
		                        InputStreamReader(clientIn));
		                
		                // Create BufferedReader for a standard input
						
						
						String msg=textField.getText().toString();
						
						pw.println(msg);

						textField_1.setText(br.readLine());
						
		                pw.close();
		                br.close();
		                client.close();
					}catch(IOException ie) {
						System.out.println("I/O error - Start server and turn off Firewall" + ie);
					}
				}
			}
		});
		btnSend.setBounds(260, 35, 89, 23);
		contentPane.add(btnSend);
		
		JLabel lblServerResponse = new JLabel("Factorial");
		lblServerResponse.setBounds(52, 111, 51, 14);
		contentPane.add(lblServerResponse);
	}

}
