package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	public String makeLog(String stringa) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("GameLog.txt", true);
			fw.write(stringa);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringa;
	}

	public void showLog() {
		FileReader fr = null;
		try {
			fr = new FileReader("GameLog.txt");
			int i = 0;
			while ((i = fr.read()) != -1) {
				System.out.print((char) i);
			}
			Runtime.getRuntime().exec("C:\\Windows\\System32\\notepad.exe GameLog.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteLog() {
		FileOutputStream writer;
		try {
			writer = new FileOutputStream("GameLog.txt");
			writer.write(("").getBytes());
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void renameLog() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date date = new Date();
		String ora = dateFormat.format(date);
		try {
			FileReader filereader = new FileReader ("GameLog.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileWriter fileriter = new FileWriter (ora+".txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//boolean renameTo = fSource.(fDest);
		//System.out.println(renameTo);
		
	}

}

