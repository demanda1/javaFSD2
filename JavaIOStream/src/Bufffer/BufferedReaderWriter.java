package Bufffer;

import java.io.*;

public class BufferedReaderWriter {

	public static void main(String[] args) {
		SimpleEncryption se=new SimpleEncryption();
		se.encrypt("words.txt","wordout.txt",1);
		System.out.println("Displaying encrypted words from wordsout.txt");
		se.viewFileContent("wordout.txt");
		
		
	}
}
