package ch.gmtech.gennaro.learning.randomannouncer.gui;
import javax.swing.*;

import ch.gmtech.gennaro.learning.randomannouncer.RandomValue;
import ch.gmtech.gennaro.learning.randomannouncer.util.ReadFile;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.LinkedList;

public class Gui extends JFrame implements ActionListener {
   
		private JTextArea leftDisplay, rightDisplay;
        private JButton loadButton,loadButton2, lastButton,searchButton, saveButton,saveButton2;
        private LinkedList<String> listaNomi;
		private MyJFileChooser filechooser = new MyJFileChooser("C:");;
        final ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/announcer.png"));
		private HashMap<String, String> nameMapping;
		private File fileFoto;
            
    public Gui() {
        super("Caller Name Speaker");
                
        setDisplays();
                
        photoMapping();
                
        setContent();
      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
    }//fine costruttore



	private void setContent() {
		JPanel buttonPanel = new JPanel();
        JPanel buttonPanel2 = new JPanel();
                
        //Set buttons
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel2.setLayout(new GridLayout(3, 0));
        
        loadButton = new JButton("Load", new ImageIcon(getClass().getClassLoader().getResource("resources/IconaFolder.png")));
        loadButton2 = new JButton("Load", new ImageIcon(getClass().getClassLoader().getResource("resources/IconaFolder.png")));
        saveButton = new JButton("Save",new ImageIcon(getClass().getClassLoader().getResource("resources/IconaSalva.png")));
        saveButton2 = new JButton("Save",new ImageIcon(getClass().getClassLoader().getResource("resources/IconaSalva.png")));
        lastButton = new JButton("Last List");        
        searchButton = new JButton("The Winner is..");
                                
        loadButton.addActionListener(this);
        loadButton2.addActionListener(this);
        saveButton.addActionListener(this);
        saveButton2.addActionListener(this);
        lastButton.addActionListener(this);
        searchButton.addActionListener(this);
        
        
        //setMnemonics
        loadButton.setMnemonic('L');
        loadButton2.setMnemonic('o');
        saveButton.setMnemonic('S');
        saveButton2.setMnemonic('v');
        searchButton.setMnemonic('W');
        lastButton.setMnemonic('a');
        
        //setToolTipText
        loadButton.setToolTipText("Open the list of partecipants.");
        loadButton2.setToolTipText("Open the list of excluded partecipants.");
        saveButton.setToolTipText("Save the list of partecipants.");
        saveButton2.setToolTipText("Save the list of excluded partecipants.");
        searchButton.setToolTipText("Choose a random announcer from the loaded list.");
        lastButton.setToolTipText("Load the last list opened of partecipants.");        
        
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(lastButton);
                      
        JScrollPane scrollPane = new JScrollPane(leftDisplay);
        JScrollPane scrollPane2 = new JScrollPane(rightDisplay);
        
           
        buttonPanel2.add(scrollPane2);
        buttonPanel2.add(loadButton2);
        buttonPanel2.add(saveButton2);
  
               
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
        getContentPane().add(buttonPanel2, BorderLayout.EAST);
	}



	private void setDisplays() {
		leftDisplay = new JTextArea(){
            
			Image image = imageIcon.getImage();

            Image grayImage = GrayFilter.createDisabledImage(image);
            {
              setOpaque(false);
            }

            public void paint(Graphics g) {

              super.paint(g);
              
              Graphics2D g2d = (Graphics2D) g;
              int x = (this.getWidth() - grayImage.getWidth(null)) / 2;
              int y = (this.getHeight() - grayImage.getHeight(null)) / 2;
              g2d.drawImage(grayImage, x, y, null);
              repaint();
              
            }
          };
          
          rightDisplay = new JTextArea();
          
      	//Set Font
      	Font font = new Font("Verdana", Font.BOLD, 14);
      	leftDisplay.setFont(font);
      	leftDisplay.setForeground(Color.BLUE);        
        leftDisplay.setEditable(true);
        
        rightDisplay.setFont(font);
      	rightDisplay.setForeground(Color.RED);        
        rightDisplay.setEditable(true);
	}
    
    
    
    public static void main(String[] args) {
        new Gui();
    }//fine main

    public void actionPerformed(ActionEvent e) {
        
    	//********** LOAD BUTTON************
    	if (e.getSource() == loadButton) {
    		
        	if ( filechooser.loadFileWithFilechooser(this) == true)     {        	
        	getTextArea().setText(new ReadFile(filechooser.getFileOpened()).getText());
        	}
        	
        }
    	
    	//********** LOAD BUTTON 2 ************
    	if (e.getSource() == loadButton2) {
    		
        	if ( filechooser.loadFileWithFilechooser(this) == true)     {        	
        	getTextArea2().setText(new ReadFile(filechooser.getFileOpened()).getText());
        	}
        	
        }
        
    	//********** LAST BUTTON************
        if (e.getSource() == lastButton) {
        
        	try{
        	        	 
        	 getTextArea().setText(new ReadFile(filechooser.getFileOpened()).getText());
        
        	} catch (Exception ex){
    		JOptionPane.showMessageDialog(null, "Nessun file caricato! Carica una lista di presenti cliccando su 'Load Lista'", "Message", JOptionPane.INFORMATION_MESSAGE);
        	}
        }
        
    	//********** SEARCH BUTTON************        
        if (e.getSource() == searchButton) {
        	
        	searchButtonAction();
        	
        }
        
    	//********** SAVE BUTTON************        
        if (e.getSource() == saveButton) {
        	       	     	
    	 	filechooser.saveFileWithFilechooser(getTextArea().getText());
        }
           
    	//********** SAVE BUTTON 2************        
        if (e.getSource() == saveButton2) {
        	       	     	
    	 	filechooser.saveFileWithFilechooser(getTextArea2().getText());
        }

        
    }//fine actionPerformed



	private void searchButtonAction() {
		try{
		
		listaNomi = new LinkedList<String>();
        
        String[] lines = leftDisplay.getText().split("\\n");
		        
        for(int i = 0 ; i < lines.length; i++)
		  if( !lines[i].equalsIgnoreCase(""))
		listaNomi.add(i, lines[i]);
		
		RandomValue randomperson = new RandomValue(listaNomi.size());
      
		if (listaNomi.size() > 1 ){
			String winnerIs = listaNomi.get(randomperson.getValue());
		leftDisplay.setText(" THE WINNER IS ..... : \n\n"        			+ winnerIs);
			
		
		photoLoader(winnerIs);
		
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



	private void photoLoader(String winnerIs) throws IOException {
		File file;
		if ( nameMapping.containsKey( winnerIs.toLowerCase() )){      	        	        	
			file = new File( nameMapping.get( winnerIs.toLowerCase()));
		}
		else
			file = new File( nameMapping.get( "anonimo" ));
			      		 
		
		Desktop.getDesktop().open(file);
	}



	private void photoMapping() {
			
     	nameMapping = new HashMap<String,String>();
	   	
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		
		URL[] urls = ((URLClassLoader) cl).getURLs();
		for (URL url: urls) {
			//display.setText(url.getFile());
			 File file = new File( url.getPath() );

		        // get the parent of the file
		        String parentPath = file.getParent();
		        fileFoto = new File(parentPath, "Photo");
		        //display.setText(fileFoto.getPath());
		}
		
		     	
     	File[] files = new File( fileFoto.getPath()).listFiles();
     	//If this pathname does not denote a directory, then listFiles() returns null. 

     	for (File file : files) {
		if (file.isFile()) {
		    		    
		    String str1 = file.getName().toLowerCase();
     		if (str1.contains(".")) {
     			str1 = str1.substring(0, str1.lastIndexOf("."));         	
         	}
     		
     		nameMapping.put( str1,file.getPath());
		    
		}
     	}
   
	}
    
    
    /**
     * @return the textArea
     */
    public JTextArea getTextArea() {
        return leftDisplay;
    }
    /**
     * @return the textArea
     */
    public JTextArea getTextArea2() {
        return rightDisplay;
    }
    
}//fine classe Gui