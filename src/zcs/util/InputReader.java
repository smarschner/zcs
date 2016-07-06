package zcs.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
	
	BufferedReader br;
	
	public InputReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public String readLine() {
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
