import java.util.Iterator;


public class MAIN {
	
	 public static void main(String[] args) {
	       
		 //Aggiungi un corso e un Seminario
		 SEMINAR seminario1 = new SEMINAR(new COURSE("JAVA", "5", "Java for dummies"), "Manno");
		 System.out.println("Nome Seminario: " + seminario1.getName());
         System.out.println("Descrizione Seminario: " + seminario1.getDescrition());
         System.out.println("Location Seminario: " + seminario1.getLocation());
         System.out.println("Posti disponibili Seminario: " + seminario1.getSeatsLeft());
         
         //Aggiungi iscrizione
		 seminario1.addEnrollment(new ENROLLMENT(new STUDENT("Gennaro", "Errico")));
		 //Controlla posti disponibili
		 System.out.println("Posti disponibili Seminario: " + seminario1.getSeatsLeft());

         //Aggiungi iscrizione
         seminario1.addEnrollment(new ENROLLMENT(new STUDENT("Stefano", "Coluccia")));
		 //Controlla posti disponibili
         System.out.println("Posti disponibili Seminario: " + seminario1.getSeatsLeft());
         
       //Aggiungi iscrizione
         seminario1.addEnrollment(new ENROLLMENT(new STUDENT("Pippo", "Baudo")));
		 //Controlla posti disponibili
         System.out.println("Posti disponibili Seminario: " + seminario1.getSeatsLeft());
         
       //Aggiungi iscrizione
         seminario1.addEnrollment(new ENROLLMENT(new STUDENT("Diego", "Maradona")));
		 //Controlla posti disponibili
         System.out.println("Posti disponibili Seminario: " + seminario1.getSeatsLeft());
         
       //Aggiungi iscrizione
         seminario1.addEnrollment(new ENROLLMENT(new STUDENT("Antonio", "Conte")));
		 //Controlla posti disponibili
         System.out.println("Posti disponibili Seminario: " + seminario1.getSeatsLeft());
         
       //Aggiungi iscrizione
         seminario1.addEnrollment(new ENROLLMENT(new STUDENT("Alina", "Kobler")));
		 //Controlla posti disponibili
         System.out.println("Posti disponibili Seminario: " + seminario1.getSeatsLeft());
         
         
         Iterator iter = seminario1.getStudentList().listIterator();
              
         while (iter.hasNext()){
        	 System.out.println("Lista partecipanti Seminario: " + iter.next());
         }         
         
         
	    }//fine main
	
	

}
