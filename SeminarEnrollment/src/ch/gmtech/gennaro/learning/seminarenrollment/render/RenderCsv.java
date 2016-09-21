package ch.gmtech.gennaro.learning.seminarenrollment.render;

import java.util.Iterator;

import ch.gmtech.gennaro.learning.seminarenrollment.Seminar;

public class RenderCsv extends RenderSeminarAbstract {
		
		public RenderCsv(Seminar pseminar) {
		super(pseminar);
	}
	

	public String renderHeader(){
			String header = "";
			header += super.getSeminar().getCourse().getName() + ";" ;
			header += super.getSeminar().getCourse().getDescription() + ";" ;
			header += super.getSeminar().getCourse().getStartDate().toString() + ";" ;			
			header += super.getSeminar().getLocation() + ";" ;
			header += String.valueOf(super.getSeminar().getSeatsLeft()) + "\n";
			return header;
			
		}
		
		public String renderBody() {
			String body = "";
			 Iterator iter = super.getSeminar().getStudentList().listIterator();
	          
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
