package ch.gmtech.gennaro.learning.seminarenrollment.render;

import java.util.Iterator;

import ch.gmtech.gennaro.learning.seminarenrollment.Seminar;

public class RenderHtml extends RenderSeminarAbstract {
			
		public RenderHtml(Seminar pseminar) {
			super(pseminar);	
	}

	public String createHtmlOpenTag (String tagName){
		return "<" + tagName + ">" + "\n";
	}
	
	public String createHtmlOpenTagContentClosedTag (String tagName, String content){
		return "<" + tagName + ">" + content + "</" + tagName + ">" + "\n";
	}
	
	public String createHtmlClosedTag (String tagName){
		return "</" + tagName + ">" + "\n";
	}
	
	public String renderHeader(){
		String header = "";
		header += createHtmlOpenTag("html");
		header += createHtmlOpenTag("head");
		header += "\t" + createHtmlOpenTagContentClosedTag("title" , super.getSeminar().getName() );
		header += createHtmlClosedTag("head");
		return header;
		
	}
	
	public String renderBody() {
		String body = "";
		body += createHtmlOpenTag("body");
		
		body += "\t" +createHtmlOpenTagContentClosedTag("div",super.getSeminar().getName() );
		body += "\t" +createHtmlOpenTag("ul");
		body += "\t" +"\t" +createHtmlOpenTagContentClosedTag("li",super.getSeminar().getDescrition() );
		body += "\t" +"\t" +createHtmlOpenTagContentClosedTag("li",super.getSeminar().getLocation() );
		body += "\t" +"\t" +createHtmlOpenTagContentClosedTag("li", String.valueOf(super.getSeminar().getSeatsLeft()));
		body += "\t" +createHtmlClosedTag("ul");
		
		body += "\t" +createHtmlOpenTagContentClosedTag("div","partecipanti:");
		
		body += "\t" +createHtmlOpenTag("ul");
		 Iterator iter = super.getSeminar().getStudentList().listIterator();
          
	         while (iter.hasNext()){
	        	 body +=  "\t" +"\t" +createHtmlOpenTagContentClosedTag("li",iter.next().toString()); 
	         } 
         body += "\t" +createHtmlClosedTag("ul");
        
         body += createHtmlClosedTag("body");
         
         body += createHtmlClosedTag("html");
         
         return body;
				
	}

	@Override
	public String renderFooter() {
		return "";
	}
	
	
}
