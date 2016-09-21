package ch.gmtech.gennaro.learning.seminarenrollment;

import java.io.*;

public class WriteFile {

    private FileWriter fstream;

    public WriteFile() {
        fstream = null;
    }

    public boolean CheckIfFileExist(String path) {
        File file = new File(path);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }//end DeleteIfFileExists
    
    public void DeleteFile (String path) {
    	File file = new File(path);
    	file.delete();
    }

    public void WriteInAppendMode(String path, String append) {

    //	Writer writer = null;
    	try {
    	FileWriter fw = new FileWriter(path,true); //the true will append the new data
  	
    	   String filename= "MyFile.txt";
    	   fw.write(append);//appends the string to the file
    	   fw.close();
 //   	try {
//    	    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "utf-8"));
//    	    writer.write(append);
    	    
    	} catch (IOException ex) {
    	  // report
    	} 
    	
    }
}//end Class WriteFile
