package controller;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
	
	public String makeLog(String stringa) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("GameLog.txt",true);
			fw.write(stringa);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringa;
	}
	
}
