package ch.gmtech.gennaro.learning.seminarenrollment.render;

import java.util.Iterator;

import ch.gmtech.gennaro.learning.seminarenrollment.Seminar;

public class RenderHtml extends RenderAbstract implements Render_Interface {
		
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
		header += "\t" + createHtmlOpenTagContentClosedTag("title" , seminar.getName() );
		header += createHtmlClosedTag("head");
		return header;
		
	}
	
	public String renderBody() {
		String body = "";
		body += createHtmlOpenTag("body");
		
		body += "\t" +createHtmlOpenTagContentClosedTag("div",seminar.getName() );
		body += "\t" +createHtmlOpenTag("ul");
		body += "\t" +"\t" +createHtmlOpenTagContentClosedTag("li",seminar.getDescrition() );
		body += "\t" +"\t" +createHtmlOpenTagContentClosedTag("li",seminar.getLocation() );
		body += "\t" +"\t" +createHtmlOpenTagContentClosedTag("li", String.valueOf(seminar.getSeatsLeft()));
		body += "\t" +createHtmlClosedTag("ul");
		
		body += "\t" +createHtmlOpenTagContentClosedTag("div","partecipanti:");
		
		body += "\t" +createHtmlOpenTag("ul");
		 Iterator iter = seminar.getStudentList().listIterator();
          
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
		return super.renderFooter();
	}
	
	
}
