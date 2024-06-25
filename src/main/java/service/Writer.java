package service;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Writer {
	
	private static String  path = "src\\main\\resources\\svg.out";

	public static void write(String toSave) throws Exception {
	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
	bufferedWriter.write(toSave);
	bufferedWriter.close();
	
	}
}
