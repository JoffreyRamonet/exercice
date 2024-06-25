package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

	private static String path = "src\\main\\resources\\svg.out";

	public static void read() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
		String line = bufferedReader.readLine();
		while (line != null) {
			System.out.println(line);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
	}
}
