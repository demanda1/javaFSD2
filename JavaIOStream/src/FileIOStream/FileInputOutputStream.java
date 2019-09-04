package FileIOStream;

import java.io.*;

public class FileInputOutputStream {

	public static void main(String[] args) throws IOException {
		
		FileInputStream in =new FileInputStream("Farrago.txt");
		FileOutputStream out =new FileOutputStream("Outagain.txt");
		int c;
		
		while((c=in.read())!=-1) {
			System.out.println(c);
			out.write(c);
		}
		System.out.println("FileInputStream is used to read and FileOutputStream is udsed to write a file");
		
		in.close();
		out.flush();
	}
}
