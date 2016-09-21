package ch.gmtech.gennaro.learning.seminarenrollment.render;

import java.util.Iterator;

import ch.gmtech.gennaro.learning.seminarenrollment.Seminar;

public class RenderCsv extends RenderAbstract implements Render_Interface {
		
		public RenderCsv(Seminar pseminar) {
		super(pseminar);
	}
	

	public String renderHeader(){
			String header = "";
			header += seminar.getName() + ";" ;
			header += seminar.getDescrition() + ";" ;
			header += seminar.getLocation() + ";" ;
			header += String.valueOf(seminar.getSeatsLeft()) + "\n";
			return header;
			
		}
		
		public String renderBody() {
			String body = "";
			 Iterator iter = seminar.getStudentList().listIterator();
	          
		         while (iter.hasNext()){
		        	 body +=  iter.next().toString().replaceAll(" ", ";") + "\n"; 
		         } 
	          
	         return body;
					
		}

		@Override
		public String renderFooter() {
			return super.renderFooter();
		}
		
	
	
	

}
