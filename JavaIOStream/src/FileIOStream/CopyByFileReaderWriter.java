package FileIOStream;

import java.io.*;

public class CopyByFileReaderWriter {

		public static void main(String[] args) throws IOException {
			
			FileInputStream in =new FileInputStream("Farrago.txt");
			FileOutputStream out =new FileOutputStream("Outagain.txt");
			int c;
			
			FileReader input=new FileReader("Farrago.txt");
			FileWriter output=new FileWriter("Outagain.txt");
			
			BufferedReader inputStream = new BufferedReader(input);
			PrintWriter outputStream=new PrintWriter(output);
			
			while((c=in.read())!=-1) {
				System.out.println(c);
				out.write(c);
			}
			
			String l;
			while((l=inputStream.readLine())!=null) {
				System.out.println(l);
				outputStream.println(l);
			}
			System.out.println("FileInputStream is used to read and FileOutputStream is udsed to write a file");
			
			in.close();
			out.flush();
		}

}
