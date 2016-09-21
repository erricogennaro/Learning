package ch.gmtech.gennaro.learning.seminarenrollment;
import java.util.Iterator;

import ch.gmtech.gennaro.learning.seminarenrollment.render.RenderAbstract;
import ch.gmtech.gennaro.learning.seminarenrollment.render.RenderCsv;
import ch.gmtech.gennaro.learning.seminarenrollment.render.RenderHtml;


public class MAIN {
	
	 public static void main(String[] args) {
	       
		 Seminar seminario1 = addCourseToSeminar();       
                  
         addEnrollment(seminario1);
                  
         Iterator iter = seminario1.getStudentList().listIterator();
              
         while (iter.hasNext()){
        	 System.out.println("Lista partecipanti Seminario: " + iter.next());
         }         
         
         removeEnrollment(seminario1);
                 
         RenderAbstract render = new RenderAbstract(seminario1);
         RenderAbstract renderHtml = new RenderHtml(seminario1);
         RenderAbstract renderCSV = new RenderCsv(seminario1);
             
         render.print("/home/dev/Desktop/"+seminario1.getName()+".txt");
         renderHtml.print("/home/dev/Desktop/"+seminario1.getName()+".csv");
         renderCSV.print("/home/dev/Desktop/"+seminario1.getName()+".html");
          

	 }

	 
	 

	private static Seminar addCourseToSeminar() {
		
		 Seminar seminario1 = new Seminar(new Course("JAVA", 5, "Java for dummies"), "Manno");
		 System.out.println("Nome Seminario: " + seminario1.getName());
         System.out.println("Descrizione Seminario: " + seminario1.getDescrition());
         System.out.println("Location Seminario: " + seminario1.getLocation());
         System.out.println("Posti disponibili Seminario: " + seminario1.getSeatsLeft());
		return seminario1;
	}
	
		
	private static void removeEnrollment(Seminar seminario1) {
		
        seminario1.removeEnrollment( (new Student("Diego", "Maradona")));
        System.out.println("Posti disponibili Seminario: " + seminario1.getSeatsLeft());
        
         seminario1.removeEnrollment( (new Student("Alina", "Kobler")));
         System.out.println("Posti disponibili Seminario: " + seminario1.getSeatsLeft());
         
         seminario1.removeEnrollment( (new Student("Diego", "Antonio")));
         System.out.println("Posti disponibili Seminario: " + seminario1.getSeatsLeft());
         
         seminario1.removeEnrollment( (new Student("Diego", "Maradona")));
         System.out.println("Posti disponibili Seminario: " + seminario1.getSeatsLeft());
	}

	private static void addEnrollment(Seminar seminario1) {

		 seminario1.addEnrollment( (new Student("Gennaro", "Errico")));
		 System.out.println("Posti disponibili Seminario: " + seminario1.getSeatsLeft());

         seminario1.addEnrollment( (new Student("Stefano", "Coluccia")));
         System.out.println("Posti disponibili Seminario: " + seminario1.getSeatsLeft());
         
         seminario1.addEnrollment( (new Student("Pippo", "Baudo")));
         System.out.println("Posti disponibili Seminario: " + seminario1.getSeatsLeft());
         
         seminario1.addEnrollment( (new Student("Diego", "Maradona")));
         System.out.println("Posti disponibili Seminario: " + seminario1.getSeatsLeft());
         
         seminario1.addEnrollment( (new Student("Antonio", "Conte")));
         System.out.println("Posti disponibili Seminario: " + seminario1.getSeatsLeft());
         
         seminario1.addEnrollment( (new Student("Alina", "Kobler")));
         System.out.println("Posti disponibili Seminario: " + seminario1.getSeatsLeft());
	}
	
	

}
