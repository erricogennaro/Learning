import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.LinkedList;

public class Gui extends JFrame implements ActionListener {
        /**
	 * 
	 */
		private JTextArea display;
        private JButton loadButton, lastButton,searchButton, saveButton;
        private LinkedList<String> listaNomi;
		private MyJFileChooser filechooser = new MyJFileChooser("C:");;
        final ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/announcer.png"));
		private HashMap<String, String> nameMapping;
		private File fileFoto;
            
    public Gui() {
        super("Caller Name Speaker");
                
        display = new JTextArea(){
            
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
                
          
        //Set Photo
       photoLoader();
          
      	//Set Font
      	Font font = new Font("Verdana", Font.BOLD, 14);
      	display.setFont(font);
      	display.setForeground(Color.BLUE);        
        display.setEditable(true);
        
        JPanel buttonPanel = new JPanel();
        new JPanel();
        
        //Set buttons
        buttonPanel.setLayout(new GridLayout(1, 2));
        loadButton = new JButton("Load", new ImageIcon(getClass().getClassLoader().getResource("resources/IconaFolder.png")));
        saveButton = new JButton("Save",new ImageIcon(getClass().getClassLoader().getResource("resources/IconaSalva.png")));
        lastButton = new JButton("Last List");        
        searchButton = new JButton("The Winner is..");
                                
        loadButton.addActionListener(this);
        saveButton.addActionListener(this);
        lastButton.addActionListener(this);
        searchButton.addActionListener(this);
        
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(lastButton);
               
        JScrollPane scrollPane = new JScrollPane(display);
        
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
    }//fine costruttore
    
    
    
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
        	
        	try{
        	
        	listaNomi = new LinkedList<String>();
          
          String[] lines = display.getText().split("\\n");
                    
          for(int i = 0 ; i < lines.length; i++)
        	  if( !lines[i].equalsIgnoreCase(""))
          	listaNomi.add(i, lines[i]);
        	
        	RandomValue randomperson = new RandomValue(listaNomi.size());
        
        	if (listaNomi.size() > 1 ){
        		String winnerIs = listaNomi.get(randomperson.getValue());
        	display.setText(" THE WINNER IS ..... : \n\n"        			+ winnerIs);
        		
        	
			File file;
			if ( nameMapping.containsKey( winnerIs.toLowerCase() )){      	        	        	
				file = new File( nameMapping.get( winnerIs.toLowerCase()));
			}
        	else
        		file = new File( nameMapping.get( "anonimo" ));
        		      		 
        	
        	Desktop.getDesktop().open(file);
        	
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
        
    	//********** SAVE BUTTON************        
        if (e.getSource() == saveButton) {
        	       	     	
    	 	filechooser.saveFileWithFilechooser(getTextArea().getText());
        }
           
    }//fine actionPerformed



	private void photoLoader() {
			
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
     		if (!str1.contains(".")) 
         	    System.out.println("File Name=" + str1); 
         	else {
         	    str1 = str1.substring(0, str1.lastIndexOf("."));
         	    // Because extension is always after the last '.'
         	    System.out.println("File Name=" + str1);
         	}
     		
     		nameMapping.put( str1,file.getPath());
		    
		}
     	}
   
	}
    
    
    /**
     * @return the textArea
     */
    public JTextArea getTextArea() {
        return display;
    }
    
}//fine classe Gui