package ch.gmtech.gennaro.learning.randomannouncer.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

public class PhotoMapping {
	
	private HashMap<String, String> nameMapping;
	
	public PhotoMapping (){
		photoMapping();
	}
	
	public File getPhotoToLoad(String winnerIs) throws IOException {
		File file;
		if ( nameMapping.containsKey( winnerIs.toLowerCase() )){      	        	        	
			file = new File( nameMapping.get( winnerIs.toLowerCase()));
		}
		else
			file = new File( nameMapping.get( "anonimo" ));
			      		 
		return file;
		
	}
	
	private void photoMapping() {
		
		File fileFoto = null;
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
	

}
