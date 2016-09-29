package ch.gmtech.gennaro.learning.randomannouncer.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MyButtonsAndPanels {

    public static JButton loadButton,loadButton2, lastButton,searchButton, saveButton,saveButton2;
	private ActionListener actionlistner;
	private JFrame container;
    
	public MyButtonsAndPanels (ActionListener actionlistner, JFrame container, MyDisplays mydisplays){
		this.actionlistner = actionlistner;
		this.container = container;
		setContent(mydisplays);
	}

	private void setContent(MyDisplays mydisplays) {
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
                                
        loadButton.addActionListener(actionlistner);
        loadButton2.addActionListener(actionlistner);
        saveButton.addActionListener(actionlistner);
        saveButton2.addActionListener(actionlistner);
        lastButton.addActionListener(actionlistner);
        searchButton.addActionListener(actionlistner);
        
        
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
                      
        JScrollPane scrollPane = new JScrollPane(mydisplays.getLeftDisplay());
        JScrollPane scrollPane2 = new JScrollPane(mydisplays.getRightDisplay());
        
           
        buttonPanel2.add(scrollPane2);
        buttonPanel2.add(loadButton2);
        buttonPanel2.add(saveButton2);
  
               
        container.add(scrollPane, BorderLayout.CENTER);
        container.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
        container.getContentPane().add(buttonPanel2, BorderLayout.EAST);
	} 
    
	
}
