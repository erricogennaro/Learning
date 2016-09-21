package ch.gmtech.gennaro.learning.randomannouncer;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    	Writer writer = null;

    	try {
    	    writer = new BufferedWriter(new OutputStreamWriter(
    	          new FileOutputStream(path), "utf-8"));
    	    writer.write(append);
    	} catch (IOException ex) {
    	  // report
    	} finally {
    	   try {writer.close();} catch (Exception ex) {/*ignore*/}
    	}
    }
}//end Class WriteFile
