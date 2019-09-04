package IOswing;

import java.awt.BorderLayout;
import comm.example.model.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import comm.example.dao.*;

import comm.example.service.*;
public class EntryApp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntryApp frame = new EntryApp();
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
	public EntryApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 414, 162);
		contentPane.add(textArea);
		
		JButton btnEnterEmployee = new JButton("Enter Employee");
		btnEnterEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=textArea.getText().toString();
				File file=new File("Info.txt");
				PrintWriter bf;
				try {
					bf=new PrintWriter(new FileWriter(file));
					bf.println(s);
					bf.flush();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedReader reader;
				try {
					 reader=new BufferedReader(new FileReader("Info.txt"));
	
				String l;
				while((l=reader.readLine())!=null) {
				String[] data=l.split("\\s+",4);
				for(String d:data) {
					System.out.println(d);
				}
				try {
					EmployeeServiceImpl esi=new EmployeeServiceImpl();
					String[] info=new String[4];
					int i=0;
					for(String a:data) {
					//esi.createEmployee(new Employee(Integer.parseInt(data[0]),data[1],data[2],data[3]));
						info[i]=a;
						System.out.println(info[i]);
						i++;
					}
					esi.createEmployee(new Employee(Integer.parseInt(info[0]),info[1],info[2],info[3]));
			  }
				catch (SQLException e) {

					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
 				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				
		});
		btnEnterEmployee.setBounds(10, 194, 118, 23);
		contentPane.add(btnEnterEmployee);
	}

}
