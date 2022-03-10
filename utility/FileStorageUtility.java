package com.dollarsbank.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileStorageUtility {
	
	public int fileCount = 0;
	
	public boolean fileSave(String custFName, String custLName, String userText) {
		
		try {
			++fileCount;
			String name = "Bank Stub for Customer - " + custFName +  custLName + " .txt";
			File myFile = new File(name);
			if(myFile.createNewFile()) {
				if(!FileWriter(name, userText)) 
					System.out.println("Failed to write to file.");
				return true;
				
			} else {
				return false;
			}
			
		} catch (IOException e) {
			return false;
		}
//		return false;
	}

	private boolean FileWriter(String name, String userText) {
		
		try {
			FileWriter myWriter = new FileWriter(name);
			myWriter.write(userText);
			myWriter.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
