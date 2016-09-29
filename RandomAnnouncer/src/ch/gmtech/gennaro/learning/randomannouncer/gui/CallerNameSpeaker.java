package ch.gmtech.gennaro.learning.randomannouncer.gui;
import javax.swing.*;

import ch.gmtech.gennaro.learning.randomannouncer.RandomValue;
import ch.gmtech.gennaro.learning.randomannouncer.util.PhotoMapping;
import ch.gmtech.gennaro.learning.randomannouncer.util.ReadFile;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class CallerNameSpeaker extends JFrame implements ActionListener {
   
		MyDisplays mydisplays;
		MyButtonsAndPanels mybuttons;
		private MyJFileChooser filechooser = new MyJFileChooser("C:");;
		PhotoMapping photo;
		LinkedList<String> listaNomi = new LinkedList<String>();
            
    public CallerNameSpeaker() {
        super("Caller Name Speaker");
                
        mydisplays = new MyDisplays();
                
        photo = new PhotoMapping();
                        
        mybuttons = new MyButtonsAndPanels(this, this, mydisplays);
        //setContent();
      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
    }

    
    public static void main(String[] args) {
        new CallerNameSpeaker();
    }//fine main

    public void actionPerformed(ActionEvent e) {
        
    	//********** LOAD BUTTON************
    	if (e.getSource() == mybuttons.loadButton) {
    		
        	if ( filechooser.loadFileWithFilechooser(this) == true)     {        	
        		mydisplays.getLeftDisplay().setText(new ReadFile(filechooser.getFileOpened()).getText());
        	}
        	
        }
    	
    	//********** LOAD BUTTON 2 ************
    	if (e.getSource() == mybuttons.loadButton2) {
    		
        	if ( filechooser.loadFileWithFilechooser(this) == true)     {        	
        		mydisplays.getRightDisplay().setText(new ReadFile(filechooser.getFileOpened()).getText());
        	}
        	
        }
        
    	//********** LAST BUTTON************
        if (e.getSource() == mybuttons.lastButton) {
        
        	try{
        	        	 
        		mydisplays.getLeftDisplay().setText(new ReadFile(filechooser.getFileOpened()).getText());
        
        	} catch (Exception ex){
    		JOptionPane.showMessageDialog(null, "Nessun file caricato! Carica una lista di presenti cliccando su 'Load Lista'", "Message", JOptionPane.INFORMATION_MESSAGE);
        	}
        }
        
    	//********** SEARCH BUTTON************        
        if (e.getSource() == mybuttons.searchButton) {
        	
        	searchButtonAction();
        	
        }
        
    	//********** SAVE BUTTON************        
        if (e.getSource() == mybuttons.saveButton) {
        	       	     	
    	 	filechooser.saveFileWithFilechooser(mydisplays.getLeftDisplay().getText());
        }
           
    	//********** SAVE BUTTON 2************        
        if (e.getSource() == mybuttons.saveButton2) {
        	       	     	
    	 	filechooser.saveFileWithFilechooser(mydisplays.getRightDisplay().getText());
        }

        
    }//fine actionPerformed



	private void searchButtonAction() {
		try{		
        
        String[] lines = mydisplays.getLeftDisplay().getText().split("\\n");
		        
        for(int i = 0 ; i < lines.length; i++)
		  if( !lines[i].equalsIgnoreCase(""))
		listaNomi.add(i, lines[i]);
		
		RandomValue randomperson = new RandomValue(listaNomi.size());
      
		if (listaNomi.size() > 1 ){
			String winnerIs = listaNomi.get(randomperson.getValue());
			mydisplays.getLeftDisplay().setText(" THE WINNER IS ..... : \n\n" + winnerIs);
		
		Desktop.getDesktop().open(photo.getPhotoToLoad(winnerIs));
		
		}
		
		} catch (IllegalArgumentException ex){
			JOptionPane.showMessageDialog(null, "Carica una lista di presenti cliccando su 'Load Lista' o 'Last Lista'", "Message", JOptionPane.INFORMATION_MESSAGE);
		}catch ( IndexOutOfBoundsException e2){
			JOptionPane.showMessageDialog(null, "Carica una lista di presenti cliccando su 'Load Lista' o 'Last Lista'", "Message", JOptionPane.INFORMATION_MESSAGE);
		
		}        	
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
   
 
    
}