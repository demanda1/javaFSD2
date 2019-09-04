package SwingDbase;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ReqDataApp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReqDataApp frame = new ReqDataApp();
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
	public ReqDataApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(106, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 414, 198);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblEnterEmployeeId = new JLabel("Enter employee ID:");
		lblEnterEmployeeId.setBounds(10, 14, 102, 14);
		contentPane.add(lblEnterEmployeeId);
		JButton btnSearch = new JButton("Search ");
		btnSearch.addActionListener(new ActionListener() {
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

						//textField_1.setText(br.readLine());
						 //textArea.setText(br.readLine());
						 String[] employee= br.readLine().split("#",4);
						 for(String str:employee) {
							 System.out.println(str);
						 }
						 DefaultTableModel d=new DefaultTableModel();
						 d.addColumn("id");
						 d.addColumn("FullName");
						 d.addColumn("LastName");
						 d.addColumn("Email");
						 
						 Vector<String> data=new Vector<String>();
						 for(String str:employee) {
							 data.add(str);
						 }
						 d.addRow(data);
						 table.setModel(d);
			
						 
		                pw.close();
		                br.close();
;		                client.close();
					}catch(IOException ie) {
						System.out.println("I/O error - Start server and turn off Firewall" + ie);
					}
				}
			}
		});
		btnSearch.setBounds(202, 10, 89, 23);
		contentPane.add(btnSearch);
		
		
	}
}
