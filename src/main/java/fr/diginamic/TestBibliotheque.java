package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;

public class TestBibliotheque {
    public static void main(String[] args) {
        EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("tp-livre");

        EntityManager et = entityManager.createEntityManager();

        et.getTransaction().begin();

         Livre livre = et.find(Livre.class, 1);
        System.out.println(livre);

        Client client  = et.find(Client.class, 1);

//        if (client != null) {
//            Emprunt emprunt = new Emprunt(LocalDateTime.now(), LocalDateTime.now().plusWeeks(2L), 10, client);
//            et.persist(emprunt);
//        }

        et.getTransaction().commit();


    }
}
