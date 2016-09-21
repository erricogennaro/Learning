package ch.gmtech.gennaro.learning.seminarenrollment.render;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import ch.gmtech.gennaro.learning.seminarenrollment.Seminar;
import ch.gmtech.gennaro.learning.seminarenrollment.WriteFile;

public class RenderAbstract implements Render_Interface {
	Seminar seminar;
	
	public RenderAbstract (Seminar pseminar){
		seminar = pseminar;
	}
	
	@Override
	public String renderHeader() {
		String header = "";
		header += "Nome del Seminario: " + seminar.getName() + "\n" ;
		header += "Descrizione: " + seminar.getDescrition() + "\n" ;
		header += "Luogo: " + seminar.getLocation() + "\n" ;
		header += "Posti rimanenti: " + String.valueOf(seminar.getSeatsLeft()) + "\n" ;
		return header;
	}

	@Override
	public String renderBody() {
		String body = "";
		 Iterator iter = seminar.getStudentList().listIterator();
		 body = "Lista partecipanti:\n";
	         while (iter.hasNext()){
	        	 body +=  iter.next().toString() + "\n"; 
	         } 
         
        return body;
	}

	@Override
	public String renderFooter() {
		String footer = "";
		return footer;
	}

	public void render(String path, Render_Interface render) {
				File f = new File(path);
		         try {
					f.createNewFile();
					 WriteFile writefile = new WriteFile();
					 if (writefile.CheckIfFileExist(path)){
						 writefile.DeleteFile(path);
					 }
					 writefile.WriteInAppendMode(f.getAbsolutePath(), render.renderHeader());
					 writefile.WriteInAppendMode(f.getAbsolutePath(), render.renderBody());
					 writefile.WriteInAppendMode(f.getAbsolutePath(), render.renderFooter());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}        
		    
		}
	 
	
	

}
