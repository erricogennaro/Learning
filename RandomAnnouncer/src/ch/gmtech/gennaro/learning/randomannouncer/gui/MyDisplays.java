package ch.gmtech.gennaro.learning.randomannouncer.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class MyDisplays {

	private JTextArea leftDisplay, rightDisplay;
	final ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/announcer.png"));
	
	public MyDisplays() {
		setDisplays();
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
	
	public JTextArea getLeftDisplay (){
		return leftDisplay;
		
	}
	
	public JTextArea getRightDisplay (){
		return rightDisplay;
		
	}

}
