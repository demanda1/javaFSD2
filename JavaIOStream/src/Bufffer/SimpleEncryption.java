package Bufffer;

import java.io.*;

public class SimpleEncryption {
 
	void encrypt(String source, String dest, int shiftSize) {
		BufferedReader reader;
		PrintWriter writer;
		
		try {
			reader=new BufferedReader(new FileReader(source));
			writer=new PrintWriter(new FileWriter(dest));
			String line =reader.readLine();
			int data;
			while(line !=null) {
				for(int i=0;i<line.length();i++){
					data=(int)line.charAt(i) +shiftSize;
					writer.print((char)data);
					writer.flush();
				}
				writer.write((int)'\n');
				line=reader.readLine();
			}
		}
		catch(IOException ie) {
			System.out.println("Failed Encrypting the file content");
		}
	}
	
	public void viewFileContent(String filename) {
		BufferedReader reader;
		try {
			reader=new BufferedReader(new FileReader(filename));
			String line=reader.readLine();
			while(line!=null) {
				System.out.println(line);
				line=reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
