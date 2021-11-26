package fr.istic.taa.jaxrs.dao.generic;


import fr.istic.taa.jaxrs.domain.Appointment;
import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.domain.Worker;

public class JpaTest {
	
        /**
         * @param args
         */
        public static void main(String[] args) {
        	
            try {              
            	DaoUser user = new DaoUser();
          	  DaoWorker worker = new DaoWorker();
          	  DaoAppointment appoint = new DaoAppointment();
          	
          	  User client1 = new User();
                client1.setMail("arthur.lalande@wanadoo.fr");
                client1.setMdp("azerty");
                client1.setName("Arthur Lalande");                 
                user.save(client1);
                
                User client2 = new User();
                client2.setMail("curtis.klomegan@gmail.fr");
                client2.setMdp("123456");
                client2.setName("Curtis Klomegan");                 
                user.save(client2);
                
                User client3 = new User();
                client3.setMail("pierre.adrien@gmail.fr");
                client3.setMdp("azer123");
                client3.setName("Pierre Adrien");                 
                user.save(client3);
                
                Worker worker1 = new Worker();
                worker1.setMail("albert.pinol@medecin.fr");
                worker1.setMdp("abcdef");
                worker1.setName("Albert Pinol");
                worker1.setJob("Médecin");                  
                worker.save(worker1);
                
                Worker worker2 = new Worker();
                worker2.setMail("John.carter@hopitalrennes.fr");
                worker2.setMdp("abc978");
                worker2.setName("John Carter");
                worker2.setJob("Chirurgien");                  
                worker.save(worker2);
                
                Appointment app1 = new Appointment();
                app1.setLenght(30);
                app1.setUs(client1);
                app1.setWork(worker1);
                app1.setDate("12/06/21");
                app1.setCreneau(9.0);
                app1.setDescription("Ventre");                 
                appoint.save(app1);
                
                Appointment app2 = new Appointment();
                app2.setLenght(30);
                app2.setCreneau(10.0);
                app2.setUs(client2);
                app2.setWork(worker1);
                app2.setDate("16/06/21");
                app2.setDescription("Cheville");                 
                appoint.save(app2);
                
                Appointment app3 = new Appointment();
                app3.setLenght(30);
                app3.setCreneau(11.30);
                app3.setUs(client2);
                app3.setWork(worker2);
                app3.setDate("18/06/21");
                app3.setDescription("Cheville");                 
                appoint.save(app3);
                
                Appointment app4 = new Appointment();
                app4.setLenght(30);
                app4.setCreneau(14.0);
                app4.setUs(client3);
                app4.setWork(worker2);
                app4.setDate("20/06/21");
                app4.setDescription("Cerveau");                 
                appoint.save(app4);
            	
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	
     
                    
          
    
    
}
