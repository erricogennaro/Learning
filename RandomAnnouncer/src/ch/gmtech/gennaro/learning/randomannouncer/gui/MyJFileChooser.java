package ch.gmtech.gennaro.learning.randomannouncer.gui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import ch.gmtech.gennaro.learning.randomannouncer.util.WriteFile;

/**
 *
 * @author erricoge
 */
public class MyJFileChooser {

    private String fileOpened = null;

    public MyJFileChooser(String fileOpened) {
        this.fileOpened = fileOpened;
    }//end MyJFileChooser constructor

    public boolean loadFileWithFilechooser(CallerNameSpeaker gui) {
        //  System.out.println(textArea.getText());
        JFileChooser fileChooser = new JFileChooser(fileOpened);
        fileChooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
        fileChooser.setSelectedFile(new File(fileOpened));
        int resultOpen = fileChooser.showOpenDialog(null);
        if (resultOpen == JOptionPane.OK_OPTION ){
    	  
        File fileName = fileChooser.getSelectedFile();
        String filen = fileName.toString();

        fileOpened = filen;

    	return true;
        }else{
        	
        return false;
        }

    }//end public loadFileWithFilechooser method

    public boolean saveFileWithFilechooser(String Tosave) {
        
        JFileChooser fileChooser = new JFileChooser(fileOpened);
        fileChooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
        fileChooser.setSelectedFile(new File(fileOpened));
        int resultSave = fileChooser.showDialog(null, "Salva File");
                        
        if (resultSave == JOptionPane.OK_OPTION){
        	

        File fileName = fileChooser.getSelectedFile();
        String filen = fileName.toString();

        WriteFile fileWrite = new WriteFile();
        
       if ( fileWrite.CheckIfFileExist(filen) == true ){
    	   
           int dialogResult = JOptionPane.showConfirmDialog (null, "Il File esiste già. Vuoi sovrascriverlo?","Warning",JOptionPane.YES_OPTION);
           
           if (dialogResult == JOptionPane.OK_OPTION){
           
           if ( dialogResult == JOptionPane.YES_OPTION){
        	   fileWrite.DeleteFile(filen);
           }
           }else
        	   return false;
    	       	   
       }
       
        fileWrite.WriteInAppendMode(filen, Tosave);

        fileOpened = filen;
        
        return true;
        }
        else
        return false;
        
  }//end public saveFileWithFilechooser method

    /**
     * @return the fileOpened
     */
    public String getFileOpened() {
        return fileOpened;
    }
}//end Class MyJFileChooser