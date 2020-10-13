package be.intecbrussel.jpademo.app;
import javax.persistence.*;
import java.util.Scanner;

public class SaveMessage {

        public static void main(String[] args) {

            Message message = new Message();
            message.setText(readMessageFromKeyboard());

            EntityManagerFactory emf = null;
            EntityManager em = null;
            try {
                emf = Persistence.createEntityManagerFactory("mypersistenceunit");
                em = emf.createEntityManager();
                EntityTransaction transaction = em.getTransaction();
                System.out.println("id before persist " + message.getId());
                transaction.begin();
                em.persist(message);
                transaction.commit();
                System.out.println("Message saved");
                System.out.println("id after persist " + message.getId());

            } catch (Exception ex){
                ex.printStackTrace();
            } finally {
                if (em != null) {
                    em.close();
                }
                if (emf != null) {
                    emf.close();
                }
            }
        }

        private static String readMessageFromKeyboard(){
            System.out.println("Write the message you would like to save");
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            scanner.close();
            return message;
        }
    }


